package com.ttq.demo;

/**
 * 本类用来演示
 * 作者: ttq
 * 
 * 
 * 日期:	2020年10月12日 下午2:32:01
 */
public class Demo7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[50];
		int curLength = 0;
		//		for (int i = 0; i < arr.length; i++) {
		//			arr[i] = i;
		//			curLength++;
		//		}
		showList(arr, curLength);
		curLength = append(arr, curLength, 520);//形参改变 被穿出来之后 需要接收才可以！
		showList(arr, curLength);
		curLength = insertData(arr, 0, curLength, 12);
		showList(arr, curLength);
		curLength = deleteDataByIndex(arr, 0, curLength);
		showList(arr, curLength);
		int index = findData(arr, curLength, 520);
		if (index != -1) {
			System.out.println("找到了，在" + (index + 1) + "位");
		} else {
			System.out.println("没有该数据");
		}
	}

	//查询数组里面的数据元素
	//arr是操作的数组
	//curLength：当前数组里面存了多少个元素 
	//功能：控制台输出已经存放的数据元素
	public static void showList(int[] arr, int curLength) {
		if (curLength == 0) {
			System.out.println("数组为空");
			return;//函数到此结束
		}
		System.out.println("数组里面的数据元素为：");
		for (int i = 0; i < curLength; i++) {
			System.out.println("arr[" + i + "]=" + arr[i]);
		}
	}

	//往数组里面追加一个数据
	//输入：操作的数组，当前长度（如果使用void 形参改变，实参没有变），追加的数据
	//输出：把curLength输出
	//
	public static int append(int[] arr, int curLength, int data) {
		//判断数组是否已满
		if (curLength == arr.length) {
			System.out.println("数组已满，无法存储");
			return curLength;
		}
		//追加
		arr[curLength++] = data;
		System.out.println("追加成功");
		return curLength;
	}

	//插入
	//输入：操作的数组，index插入的位置，当前长度，data输入的数据
	//输出：操作后的长度

	public static int insertData(int[] arr, int index, int curLength, int data) {
		//数组是否已满
		if (curLength == arr.length) {
			System.out.println("数组已满，无法存储");
			return curLength;
		}
		//插入的条件
		if (index < 0 || index > curLength) {
			System.out.println("插入的位置不正确");
			return curLength;
		}

		//插入操作
		for (int i = curLength - 1; i >= index; i--) {
			arr[i + 1] = arr[i];
		}
		arr[index] = data;
		curLength++;
		return curLength;
	}

	//删除数据
	//输入：操作的数组，删除的位置，当前长度
	//输出：删除后的长度
	public static int deleteDataByIndex(int[] arr, int index, int curLength) {
		//数组为空
		if (curLength == 0) {
			System.out.println("数组为空");
			return curLength;
		}
		//删除位置不正确
		if (index < 0 || index >= curLength) {
			System.out.println("删除的位置不正确");
			return curLength;
		}
		//删除操作
		for (int i = index; i < curLength - 1; i++) {
			arr[i] = arr[i + 1];
		}
		curLength--;
		return curLength;
	}

	//查询某个数字是否存在在数组里，存在返回下标，不存在返回-1
	public static int findData(int[] arr, int curLength, int data) {
		for (int i = 0; i < curLength; i++) {
			if (arr[i] == data) {
				return i;
			}
		}
		return -1;
	}

}
