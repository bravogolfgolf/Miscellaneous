package sis.studentinfo;

import java.io.Serializable;

public class Course implements Serializable {
	private String department;
	private String number;
	public static final long serialVersionUID = 10L;


	public Course(String department, String number) {
		this.department = department;
		this.number = number;
	}

	public String getDepartment() {
		return department;
	}

	public String getNumber() {
		return number;
	}
	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		if(this.getClass() != object.getClass()) return false;
		Course that = (Course)object;
		return this.department.equals(that.department) && this.number.equals(that.number);
	}
}
