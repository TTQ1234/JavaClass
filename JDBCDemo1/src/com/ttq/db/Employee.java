package com.ttq.db;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 实体类->DO（和数据库对象的 一张对应一个实体类，列->属性 类名和属性名一致）
 * 实体类的属性不要用基本数据类型，全部用包装类
 * */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee {
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hireDate;
	private Double sal;
	private Double comm;
	private Integer did;

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String shiredate = "";
		if (hireDate != null) {
			shiredate = format.format(hireDate);
		}
		return empno + "\t" + ename + "\t" + job + "\t" + mgr + "\t" + shiredate + "\t" + sal + "\t" + comm + "\t"
				+ did;
	}

}
