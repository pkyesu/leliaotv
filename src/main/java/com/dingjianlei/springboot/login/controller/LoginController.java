package com.dingjianlei.springboot.login.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dingjianlei.springboot.constants.Constant;
import com.dingjianlei.springboot.dto.ResultObject;
import com.dingjianlei.springboot.service.ChatUserService;

/**
 * 注册controller
 * 
 * @author Zlyj
 *
 */
@Controller("loginController")
public class LoginController {
	@Autowired
	private ChatUserService chatUserService;

	@RequestMapping("login")
	public String getLogin(String username, String password) {
        
		return "login";
	}

	@RequestMapping("register")
	public String getRegister(@RequestParam String username, @RequestParam String email,
			@RequestParam String password) {

		return "register";
	}

	/**
	 * @param userName
	 * @param type
	 *            1 用户名校验 0 邮箱校验
	 * @return
	 */
	@RequestMapping("/checkInfo/{type}")
	@ResponseBody
	public ResultObject getCheckInfo(String username, @PathVariable String type, String email) {
		ResultObject resultObject = null;
		try {
			// false表示不存在这个邮箱或者用户名，表示可以使用
			resultObject = chatUserService.checkChatUser(type, username, email);
		} catch (Exception e) {
			// TODO: handle exception
               e.printStackTrace();
		}
		return resultObject;
	}
}