package com.ttq.studentSystem;

//管理员
public interface AdminService {
	//注册
	boolean register(Admin admin);

	//登录
	Admin login(String username, String password);
}
