package com.wm.demo.patterns.build.factoryFun;

public class CatFactory implements Factory {

	@Override
	public Animal createAnimal() {
		return new Cat();
	}

}
