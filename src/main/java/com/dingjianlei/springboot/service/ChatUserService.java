package com.dingjianlei.springboot.service;

import com.dingjianlei.springboot.dto.ResultObject;
import com.dingjianlei.springboot.entity.ChatUser;

public interface ChatUserService {
/**检查邮箱 用户名false 没有 true**/
public ResultObject checkChatUser(String type,String username,String email);
/**插入一个chatUser对象，返回影响的行数**/
public int insertChatUser(ChatUser chatUser);
/**根据用户名和密码登录**/
public boolean login(String username, String password);
}
