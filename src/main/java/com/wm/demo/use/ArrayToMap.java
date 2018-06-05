package com.wm.demo.use;

import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

/**
 * 二维数组转Map
 * @author admin
 *
 */
public class ArrayToMap {
	public static void main(String[] args) {
		String[][] countries = { { "United States", "New York" }, { "United Kingdom", "London" },
				{ "Netherland", "Amsterdam" }, { "Japan", "Tokyo" }, { "France", "Paris" } };

		Map countryCapitals = ArrayUtils.toMap(countries);

		System.out.println("Capital of Japan is " + countryCapitals.get("Japan"));
		System.out.println("Capital of France is " + countryCapitals.get("France"));
	}
}
