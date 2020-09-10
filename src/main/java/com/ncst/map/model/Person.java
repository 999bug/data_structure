package com.ncst.map.model;

public class Person implements Comparable<Person> {
	private int age;   // 10  20
	private float height; // 1.55 1.67
	private String name; // "jack" "rose"
	
	public Person(int age, float height, String name) {
		this.age = age;
		this.height = height;
		this.name = name;
	}
	
	@Override
	/**
	 * 用来比较2个对象是否相等
	 */
	public boolean equals(Object obj) {
		// 内存地址
		if (this == obj) return true;
		if (obj == null || obj.getClass() != getClass()) return false;
		// if (obj == null || !(obj instanceof Person)) return false;
		
		// 比较成员变量
		Person person = (Person) obj;
		return person.age == age
				&& person.height == height
				&& (person.name == null ? name == null : person.name.equals(name));
	}
	
	@Override
	public int hashCode() {
		int hashCode = Integer.hashCode(age);
		hashCode = hashCode * 31 + Float.hashCode(height);
		hashCode = hashCode * 31 + (name != null ? name.hashCode() : 0);
		return hashCode;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" +
				"age=" + age +
				", height=" + height +
				", name='" + name + '\'' +
				'}';
	}

	@Override
	public int compareTo(Person o) {
		return age - o.age;
	}
}
