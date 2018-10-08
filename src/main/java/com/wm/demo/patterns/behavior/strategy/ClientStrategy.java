package com.wm.demo.patterns.behavior.strategy;
/**
 * 
 * @ClassName   : Strategy 
 * @Description : 运行环境类:Strategy    
 * @date        : 2017年12月9日 上午11:43:58
 * https://www.cnblogs.com/MrRightZhao/p/8000421.html
 * 
 * 
 * 针对同一类型操作，将复杂多样的处理方式分别开来，有选择的实现各自特有的操作
	 优点：
	结构清晰明了、使用简单直观。
	耦合度相对而言较低，扩展方便。
	操作封装也更为彻底，数据更为安全。
	缺点：
	随着策略的增加，子类也会变得繁多。
 */
public class ClientStrategy {
    public static void main(String[] args) {
        Car smallCar = new SmallCar("路虎","黑色");
        Car bussCar = new BussCar("公交车","白色");
        Person p1 = new Person("小明", 20);
        p1.driver(smallCar);
        p1.driver(bussCar);
    }
}
