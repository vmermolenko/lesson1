package by.htp.entity;

public class Father {
	private String name;
	private String surname;
	private int age;
	public Father() {
		// TODO Auto-generated constructor stub
	}
	public Father(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Father [name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}
	
	
}
