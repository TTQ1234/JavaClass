package com.ttq.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Dept {
	private Integer did;
	private String dname;
	private String loc;

	@Override
	public String toString() {
		return did + "\t" + dname + "\t" + loc;
	}

}
