package com.wm.demo.patterns.strut.decorate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * 基本思想是俄罗斯套娃一样层层包裹，层层装饰，每套一层就会多出一些功能出来，我们更可以自由搭配，实现不同的组合功能。
 */
public class PhoneDemo {
	public static void main(String[] args) {
		Phone p = new IPhone();
		p.call();
		System.out.println("------------");

		// 需求：我想在接电话前，听彩铃
		PhoneDecorate pd = new RingPhoneDecorate(p);
		pd.call();
		System.out.println("------------");

		// 需求：我想在接电话后，听音乐
		pd = new MusicPhoneDecorate(p);
		pd.call();
		System.out.println("------------");

		// 需求：我要想手机在接前听彩铃，接后听音乐
		// 自己提供装饰类，在打电话前听彩铃，打电话后听音乐
		pd = new RingPhoneDecorate(new MusicPhoneDecorate(p));
		pd.call();
		System.out.println("----------");
		
		// 想想我们在IO流中的使用
		// InputStream is = System.in;
		// InputStreamReader isr = new InputStreamReader(is);
		// BufferedReader br = new BufferedReader(isr);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(
				System.out)));

		Scanner sc = new Scanner(System.in);
	}
}