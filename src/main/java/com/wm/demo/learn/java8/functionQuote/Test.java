package com.wm.demo.learn.java8.functionQuote;

import java.util.Arrays;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		final Car car = Car.create( Car::new );
		final List< Car > cars = Arrays.asList( car );
		
		cars.forEach( Car::collide );
		cars.forEach( Car::repair );
		
		final Car police = Car.create( Car::new );
		
		cars.forEach( police::follow );
		
	}
}
