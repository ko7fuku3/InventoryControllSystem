package com.fukushima.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fukushima.controll.entity.User;
import com.fukushima.controll.repository.UserRepository;
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
    public ModelAndView send(@RequestParam("name")String name,  String password,
            ModelAndView mav) {
    	// Userテーブル取得
		List<User> users = userService.serch();
		System.out.println(users.get(0).getUserName());
    	mav.setViewName("Login");
    	mav.addObject("value",users.get(0).getUserName());
    	mav.addObject("value2",users.get(0).getPassword());
    	
        return mav;
    }
}
