package com.wm.demo.patterns.build.factoryAbstract.yh;

abstract class BenzCar{  
    private String name;  
      
    public abstract void drive();  
      
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
}  
class BenzSportCar extends BenzCar{  
    public void drive(){  
        System.out.println(this.getName()+"----BenzSportCar-----------------------");  
    }  
}  
class BenzBusinessCar extends BenzCar{  
    public void drive(){  
        System.out.println(this.getName()+"----BenzBusinessCar-----------------------");  
    }  
}  
  
abstract class BmwCar{  
    private String name;  
      
    public abstract void drive();  
      
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
}  
class BmwSportCar extends BmwCar{  
    public void drive(){  
        System.out.println(this.getName()+"----BmwSportCar-----------------------");  
    }  
}  
class BmwBusinessCar extends BmwCar{  
    public void drive(){  
        System.out.println(this.getName()+"----BmwBusinessCar-----------------------");  
    }  
}  
  
abstract class AudiCar{  
    private String name;  
      
    public abstract void drive();  
      
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
}  
class AudiSportCar extends AudiCar{  
    public void drive(){  
        System.out.println(this.getName()+"----AudiSportCar-----------------------");  
    }  
}  
class AudiBusinessCar extends AudiCar{  
    public void drive(){  
        System.out.println(this.getName()+"----AudiBusinessCar-----------------------");  
    }  
} 
  
  
/** 
 * 简单工厂通过反射改进抽象工厂及其子工厂 
 * @author Administrator 
 * 
 */  
class Driver4{  
    public static BenzCar createBenzCar(String car) throws Exception {  
        return (BenzCar) Class.forName(car).newInstance();  
    }  
      
    public static BmwCar createBmwCar(String car) throws Exception {  
        return (BmwCar) Class.forName(car).newInstance();  
    }  
      
    public static AudiCar createAudiCar(String car) throws Exception {  
        return (AudiCar) Class.forName(car).newInstance();  
    }  
}  
//客户端  
public class SimpleAndAbstractFactory {  
  
    public static void main(String[] args) throws Exception {  
  
        AudiCar car = Driver4.createAudiCar("com.wm.demo.patterns.build.factoryAbstractYH.AudiSportCar");  
        car.drive();  
    }  
}  