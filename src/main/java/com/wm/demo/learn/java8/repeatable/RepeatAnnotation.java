package com.wm.demo.learn.java8.repeatable;

import java.lang.annotation.Repeatable;

@Repeatable(Test.class)
public @interface RepeatAnnotation {
	String role() default "";
}

@interface Test {
	RepeatAnnotation[]  value();
}

