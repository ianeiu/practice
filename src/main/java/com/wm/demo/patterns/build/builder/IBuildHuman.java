package com.wm.demo.patterns.build.builder;

public interface IBuildHuman {
	public void buildHead();

	public void buildBody();

	public void buildHand();

	public void buildFoot();

	public Human createHuman();
}
