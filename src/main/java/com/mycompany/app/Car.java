package com.mycompany.app;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;


public class Car {

	public String model;

	public String color;


	public Car(String mod, String col) {
		model = mod;
		color = col;
	}

	public static final Attribute<Car, String> DIRTY = new SimpleAttribute<Car, String>("dirty") {
	    public String getValue(Car car, QueryOptions queryOptions) { return "sdf"; }
	};
}
