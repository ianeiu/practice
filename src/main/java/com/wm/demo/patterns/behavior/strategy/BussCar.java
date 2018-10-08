package com.wm.demo.patterns.behavior.strategy;

public class BussCar extends Car{

    public BussCar(String name, String color) {
        super(name, color);
    }
    
    public void run() {
        System.out.println(color +" " + name  +"在缓慢的行驶。。。");
    }
}