package com.varxyz.jv200.mod006;

public class Employee {
	protected String name;
	protected double salary;
	public MyDate birthDate;
	
	public String getDetails() {
		return "Name: " + name + "\nSalary: " + salary;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		
	}

	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
		
	}

	public MyDate getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(MyDate myDate) {
		this.birthDate = myDate;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee e = (Employee) obj;
			if(e.getName().equals(name) && e.getBirthDate().equals(birthDate)) {
				return true;
			}
		}
		return false;
	}
}
