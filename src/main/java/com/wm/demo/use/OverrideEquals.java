package com.wm.demo.use;

import java.lang.reflect.Field;


/**
 * 
 * object对象中的 public boolean equals(Object obj)，指示其他某个对象是否与此对象“相等”。这里的相等指的是比较的两方指向同一个对象
对于任何非空引用值 x 和 y，当且仅当 x 和 y 引用同一个对象（就是同一块内存地址），此方法才返回 true；
但是这一性质并不符合我们生活所需，比如一个不允许有重复值的对象数组，我们的规定，保存的数据相同的对象就属于重复对象，当我们往数组内插入对象时，数组必然要先判断插入的对象是否存在，如果存在就替换，不存在就插入，但是用equals方法显然判断不出，因为new出来的对象的内存地址永远不同，所以数组中就会出现重复值。这时候显然就要重写数组类的equals方法了，在其中加入我们自己的逻辑。

Jdk的api建议：当此方法被重写时，通常有必要重写 hashCode 方法，以维护 hashCode 方法的常规协定，该协定声明相等对象必须具有相等的哈希码。
hashCode 方法的常规协定是指：
(1)当obj1.equals(obj2)为true时，obj1.hashCode() == obj2.hashCode()必须为true 
(2)当obj1.hashCode() == obj2.hashCode()为false时，obj1.equals(obj2)必须为false

所以当我们重写了equals方法之后，我们的加入了自己的逻辑。还是上面那个数组的例子，我们重写了equals方法，并规定只要对象的所有属性值相同，两个对象就相等，很显然我们的目的可以轻松达到。但是我们的没有重写hashCode方法。hashCode方法仍然返回的对象的内存地址，所以两个对象的hashCode值还是不相等，这就违反了hashCode 方法的常规协定。
违反这个协定有什么后果呢，在某些利用对象hashCode值做索引的情况下，这样会造成混乱。相当于你没重写equals方法。
 * @author admin
 *
 */
public class OverrideEquals {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Person p = new Person("fanjie", 23);
		Person p2 = new Person("fanjie", 23);

		System.out.println(p.equals(p2));
		System.out.println(p.hashCode() == p2.hashCode());
	}
}

class Person {
	public String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 这里我重写equals方法，规定只要Person的所有属性值相等。两个对象就相等
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj instanceof Person) {
			try {
				Boolean check = true;
				Field[] objectFields = obj.getClass().getDeclaredFields();
				Field[] PersonFields = obj.getClass().getDeclaredFields();
				for (int i = 0; i < objectFields.length; i++) {
					if (!objectFields[i].get(obj).equals(PersonFields[i].get(this))) {
						check = false;
						break;
					}
				}
				return check;

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	// 重写hashCode方法，把对象的name和age属性转为一个字符串，返回次字符串的hashCode值
	@Override
	public int hashCode() {
		String id = this.name + this.age + "";
		return id.hashCode();
	}

}
