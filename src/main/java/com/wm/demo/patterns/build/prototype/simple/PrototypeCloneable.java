package com.wm.demo.patterns.build.prototype.simple;


public interface PrototypeCloneable extends Cloneable {

    public Object clone() throws CloneNotSupportedException;
}