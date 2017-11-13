package com.fukushima.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fukushima.controll.entity.User;
import com.fukushima.controll.service.UserService;

@Controller
public class InvController {

	@Autowired
	UserService userService;

	/**
	 * ログイン画面遷移
	 * @param mav
	 * @return
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView login(ModelAndView mav) {
		mav.setViewName("Login");
		mav.addObject("userMsg", "ユーザー名");    // 表示メッセージ
		mav.addObject("passwordMsg", "パスワード");    // 表示メッセージ
		return mav;
	}
 
	/**
	 * メニュー画面へ遷移 
	 * @param namen
	 * @param password
	 * @param mav
	 * @return
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("name")String name,  String password, ModelAndView mav) {

		String userErroeMsg = null;
		String passwordErrorMsg = null;
		String viewName = null;

		// Userテーブル取得
		List<User> user = userService.serchUser(name);

		// ユーザー存在チェック
		if (user.isEmpty()) {
			userErroeMsg = "ユーザー名が間違っています";
			viewName = "Login";
		// パスワードと照合
		} else if (!(password.equals(user.get(0).getPassword()))) {
			passwordErrorMsg = "パスワードが間違っています";
			viewName = "Login";
		} else {
			mav.setViewName("Menu");
			return mav;
		}

		mav.addObject("userMsg",userErroeMsg);
		mav.addObject("passwordMsg",passwordErrorMsg);
		mav.setViewName(viewName);
		mav.addObject("inputUser",name);
		mav.addObject("inputPassword", password);

		return mav;
	}
}
