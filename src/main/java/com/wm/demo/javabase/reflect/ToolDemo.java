package com.wm.demo.javabase.reflect;

public class ToolDemo {
	public static void main(String[] args) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		Person p = new Person();
		Tool t = new Tool();
		t.setProperty(p, "name", "林青霞");
		t.setProperty(p, "age", 27);
		System.out.println(p);
		System.out.println("-----------");

		Dog d = new Dog();

		t.setProperty(d, "sex", '男');
		t.setProperty(d, "price", 12.34f);

		System.out.println(d);
	}
}

class Dog {
	char sex;
	float price;

	@Override
	public String toString() {
		return sex + "---" + price;
	}
}
