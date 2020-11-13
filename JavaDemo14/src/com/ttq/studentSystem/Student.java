package com.ttq.studentSystem;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Gender gender;
	private int age;
	private Date registerTime;

	@Override
	public String toString() {
		String sex = Gender.MAN == gender ? "男" : "女";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String stime = simpleDateFormat.format(registerTime);
		return id + "\t" + name + "\t" + sex + "\t" + age + "\t" + stime;
	}

}
