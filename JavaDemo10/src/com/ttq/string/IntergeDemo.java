package com.ttq.string;

public class IntergeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//手动 jdk1.4之前的代码
		Integer i1 = Integer.valueOf(10);//将10 int类型转成包装类 常量池
		Integer i2 = Integer.valueOf(10);//将10 int类型转成包装类 常量池
		System.out.println(i1 == i2);//true

		Integer i3 = Integer.valueOf(128);//new 在堆里 一个对象
		Integer i4 = Integer.valueOf(128);//new 在堆里 一个对象
		System.out.println(i3 == i4);//false

		//整形常量池，如果数在byte界-128～127 ，则在常量池中
		//如果这个值超过这个范围，则存在堆里
		//		 public static Integer valueOf(int i) {
		//		        if (i >= IntegerCache.low && i <= IntegerCache.high)
		//		            return IntegerCache.cache[i + (-IntegerCache.low)];
		//		        return new Integer(i);
		//		    }

		//将int 转成包装类 手动转，jdk1.5之后，自动转型

		Integer i11 = 10;
		Integer i12 = 10;
		System.out.println(i11 == i12);
		Integer i13 = 128;
		Integer i14 = 128;
		System.out.println(i13 == i14);

		//拆箱 包装类->基本数据类型
		int num = i11.intValue();//手动
		int num1 = i11;//自动拆箱

	}

}
