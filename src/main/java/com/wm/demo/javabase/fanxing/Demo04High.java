package com.wm.demo.javabase.fanxing;

import java.util.ArrayList;
import java.util.List;

import com.wm.demo.javabase.fanxing.vo.Person;
import com.wm.demo.javabase.fanxing.vo.Student;
import com.wm.demo.javabase.fanxing.vo.Teacher;

public class Demo04High {
	public static void main(String[] args) {
		List<?> list = new ArrayList<Person>();
		List<?> list2 = new ArrayList<Student>();
		List<?> list3 = new ArrayList<Teacher>();
		
		List<? extends Person> list4 = new ArrayList<Student>();
		List<? extends Person> list5 = new ArrayList<Teacher>();
		//List<? extends Person> list6 = new ArrayList<String>(); //error
		
//		List<? super Person> list7 = new ArrayList<Student>();//error
//		List<? super Person> list8 = new ArrayList<Teacher>();//error
		List<? super Person> list9 = new ArrayList<Person>();
		List<? super Person> list10 = new ArrayList<Object>();
	}
}
