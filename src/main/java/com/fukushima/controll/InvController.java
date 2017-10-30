package com.fukushima.controll;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class InvController {

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
 
    @RequestMapping(value="/", method=RequestMethod.POST)
    public ModelAndView send(@RequestParam("name")String name, 
            ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("msg", "Hello " + name + " !");    // 表示メッセージ
        mav.addObject("value", name);                    // 入力テキストに入力値を表示
        return mav;
    }
}
