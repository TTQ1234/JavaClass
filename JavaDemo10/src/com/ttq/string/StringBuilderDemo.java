package com.ttq.string;

/**
 * 可变字符串序列，为了解决字符串之间的运算问题
 *   String s1=“a”；
 *   s1+="b";
 *   s1+="c";
 *   做运算，那么开的空间太多，因为string是字符串常量，浪费资源，string不能使用做运算，如果要做运算
 *   转成StringBuilder来完成运算
 * */
public class StringBuilderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Hello";//字符串常量，做运算，先追加一个“world”，然后在第二个位置插入“今天”，然后在将world删除
		//转换 StringBuilder（String str）
		StringBuilder builder = new StringBuilder(s1);//字符串常量->字符串可变序列
		StringBuilder b1 = builder.append("world");//只有一个空间
		//		builder.append("world");
		System.out.println(builder == b1);
		builder.insert(1, "今天");
		builder.delete(builder.indexOf("world"), builder.length());//字符串的长度
		s1 = builder.toString();
		System.out.println(s1);
	}

}
