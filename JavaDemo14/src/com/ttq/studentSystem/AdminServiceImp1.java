package com.ttq.studentSystem;

import java.util.ArrayList;

import com.ttq.util.ObjectIOUtil;

public class AdminServiceImp1 implements AdminService {
	//管理员列表从文件中读取
	private ArrayList<Admin> adminList = null;

	/**
	 * 文件什么读取：
	 * 		项目启动读取文件，将文件的信息存到adminList列表中，然后注册的时候只要更新文件，保证结合和文件一致
	 * */
	private static final AdminServiceImp1 adminService = new AdminServiceImp1();

	public static AdminServiceImp1 getAdminServiceImp1() {
		return adminService;
	}

	private AdminServiceImp1() {
		// TODO Auto-generated constructor stub
		//读取文件成集合
		adminList = ObjectIOUtil.fileToObject("admin.txt");
	}

	@Override
	public boolean register(Admin admin) {
		// TODO Auto-generated method stub
		adminList.add(admin);
		ObjectIOUtil.ObjectToFile(adminList, "admin.txt");
		return false;
	}

	@Override
	public Admin login(String username, String password) {//集合和文件同步，登录只要查询集合就行
		// TODO Auto-generated method stub
		for (Admin admin : adminList) {
			if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
				return admin;
			}
		}
		return null;
	}

}
