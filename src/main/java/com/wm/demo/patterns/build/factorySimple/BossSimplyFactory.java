package com.wm.demo.patterns.build.factorySimple;
//抽象产品  
abstract class Car{  
    private String name;  
      
    public abstract void drive();  
      
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
}  
//具体产品  
class Benz extends Car{  
    public void drive(){  
        System.out.println(this.getName()+"----go-----------------------");  
    }  
}  
  
class Bmw extends Car{  
    public void drive(){  
        System.out.println(this.getName()+"----go-----------------------");  
    }  
}  
  
//简单工厂  
class Driver{  
    public static Car createCar(String car){  
        Car c = null;  
        if("Benz".equalsIgnoreCase(car))  
            c = new Benz();  
        else if("Bmw".equalsIgnoreCase(car))  
            c = new Bmw();  
        return c;  
    }  
}  
  
//老板  
public class BossSimplyFactory {  
  
    public static void main(String[] args){  
        //老板告诉司机我今天坐奔驰  
        Car car = Driver.createCar("benz");  
        car.setName("benz");  
         //司机开着奔驰出发  
        car.drive();  
    }  
}