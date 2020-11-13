package com.ttq.objectIO;

import java.io.Serializable;

import lombok.*;

/**
 * User类：写到文件中保存，那么这个类必须支持序列化，和克隆一样
 * Serializable 就是一个标识，证明该类的对象可以序列化
 * 			对象->保存文件
 * 				张三 123 20 ->文件，以后我对于这个类发生修改
 * 				加个属性 性别，那么文件和类的内容有冲突了，为了保证之间不影响，反序列化成功，需要加个标识
 * 在序列化过程中，部分属性不想序列化，属性值不想写到文件中永久保存，可以用transient短暂，不保存，不序列
 * */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User implements Serializable {//打标示

	/**
	 * 为了防止类在序列化过程中修改而反序列化失败的问题
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private transient String password;
	private int age;
	//	private String sex;

}
