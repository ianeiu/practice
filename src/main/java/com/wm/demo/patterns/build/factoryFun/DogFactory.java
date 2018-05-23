package com.wm.demo.patterns.build.factoryFun;

public class DogFactory implements Factory {

	@Override
	public Animal createAnimal() {
		return new Dog();
	}

}
