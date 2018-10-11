package com.wm.demo.patterns.build.factoryFun;

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
  
  
//抽象工厂  
abstract class Driver{  
    public abstract Car createCar(String car) throws Exception;  
}  
//具体工厂（每个具体工厂负责一个具体产品）  
class BenzDriver extends Driver{  
    public Car createCar(String car) throws Exception {  
        return new Benz();  
    }  
}  
class BmwDriver extends Driver{  
    public Car createCar(String car) throws Exception {  
        return new Bmw();  
    }  
}  
  
//老板  
//不需要在负责对象的创建，从而明确了各个类的职责.如果有新的对象增加，只需要增加一个具体的类和具体的工厂类即可，不影响已有的代码，后期维护容易，增强了系统的扩展性
public class BossFactoryFun{  
  
    public static void main(String[] args) throws Exception {  
        Driver d = new BenzDriver();  
        Car c = d.createCar("benz");   
        c.setName("benz");  
        c.drive();  
    }  
}  