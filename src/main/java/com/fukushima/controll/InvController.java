package com.fukushima.controll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fukushima.controll.dto.ProducutListDto;
import com.fukushima.controll.entity.ProductList;
import com.fukushima.controll.entity.User;
import com.fukushima.controll.service.InventoryControllService;

@Controller
public class InvController {

	@Autowired
	InventoryControllService service;

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
		List<User> user = service.serchUser(name);

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

	/**
	 * 各画面へ遷移
	 * 
	 * @param menuValue ボタンの値
	 * @param mavAction 
	 * @return 
	 */
	@RequestMapping(value="/sendAction", method=RequestMethod.POST)
	public ModelAndView sendAction(@RequestParam("menu")String menuValue, ModelAndView mavAction) {

		String viewName = null;

		// 商品一覧画面へ遷移
		if (menuValue.equals("一覧")) {
			viewName = "Select";

			// 商品一覧を取得
			List<ProductList> productList = service.serchAllProduct();
			
			// ProducutListDtoのListを作成
			ArrayList<ProducutListDto> arrProducutListDto = new ArrayList<ProducutListDto>();
			
			for (int i = 0; i<productList.size(); i++) {
				ProducutListDto dto = new ProducutListDto();
				dto.copyPropertys(productList.get(i));
				arrProducutListDto.add(dto);
			}
			mavAction.addObject("productListDto",arrProducutListDto);
		// 商品登録画面へ遷移
		} else if (menuValue.equals("登録")) {
			viewName = "Insert";
		// 商品更新画面へ遷移
		} else if (menuValue.equals("更新")) {
			viewName = "Update";
		// 商品削除画面へ
		} else {
			viewName = "Delete";
		}

		mavAction.setViewName(viewName);
		return mavAction;
	}
	
	@RequestMapping(value="/backMenu", method=RequestMethod.POST)
	public ModelAndView backMenu(@RequestParam("back")String menuValue, ModelAndView mavBack) {
		mavBack.setViewName("Menu");
		return mavBack;
	}
}
