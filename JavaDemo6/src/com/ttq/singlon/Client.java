package com.ttq.singlon;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singlon s1 = Singlon.getS1();
		Singlon s2 = Singlon.getS1();
		Singlon s3 = Singlon.getS1();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s1 == s2);
	}

}
