package com.wm.demo.patterns.build.prototype.simple;

public class People {

    private String name;

    public People(String _name) {
        this.name = _name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}