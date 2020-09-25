package com.ncst2.sort;

public class Student implements Comparable<Student> {
	public int score;
	public int age;
	
	public Student(int score, int age) {
		this.score = score;
		this.age = age;
	}
	
	@Override
	public int compareTo(Student o) {
		return age - o.age;
	}
}
