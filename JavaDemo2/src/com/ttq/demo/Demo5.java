package com.ttq.demo;

import java.util.Scanner;

/**
 * 在if语句中使用 return 代替 else
 * 			
 * 作者: ttq
 * 日期:	2020年10月10日 上午10:22:16
 */
public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("********欢迎你使用该系统********");
		System.out.println("请输入用户名:");
		String name = scanner.nextLine().trim();
		System.out.println("请输入密码:");
		String password = scanner.nextLine().trim();//trim 取消一前一后的空格

		//验证码 生成方式与js一样 Math.random()小数 double->String
		//截取六位数，不包含0.，下标从0开始
		String code = (Math.random() + "").substring(2, 8);//6位数 前包后不包
		System.out.println("验证码为" + code + ",请输入：");
		String code1 = scanner.nextLine().trim();

		//判断验证码
		if (code1.equals(code)) { //复杂类型，相等不能使用==，应该使用equals（）
			//正常开发不写true，省略
			//System.out.println("验证码正确！");
			//如果用户名和密码正确，显示登录成功，不正确显示不成功
			if (name.equals("admin") && password.equals("123456")) {
				System.out.println("登录成功！");
			} else {
				System.out.println("用户名或密码错误！");
			}
			return;//程序直接结束 不再往下执行
		}
		System.out.println("验证码不正确！");

	}

}
