package com.mycompany.app;

import com.mycompany.app.Car;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.query.parser.sql.SQLParser;
import com.googlecode.cqengine.query.parser.cqn.CQNParser;
import com.googlecode.cqengine.resultset.ResultSet;
import static com.googlecode.cqengine.codegen.AttributeBytecodeGenerator.createAttributes;
import com.googlecode.cqengine.index.hash.HashIndex;
import com.googlecode.cqengine.query.Query;
import static com.googlecode.cqengine.query.QueryFactory.*;
import com.googlecode.cqengine.attribute.Attribute;

public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        //SQLParser<Car> parser = SQLParser.forPojoWithAttributes(Car.class, createAttributes(Car.class));
		//CQNParser<Car> parser = CQNParser.forPojoWithAttributes(Car.class, createAttributes(Car.class));
    	IndexedCollection<Car> cars = new ConcurrentIndexedCollection<Car>();
    	
    	Attribute test = Car.DIRTY;
    	
    	//ResultSet<Car> results = cars.retrieve(query, queryOptions(orderBy(descending(Car.PRICE))));

    	cars.addIndex(HashIndex.onAttribute(Car.DIRTY));
    	
    	cars.add(new Car("Ford Focus", "black"));
		cars.add(new Car("Ford Taurus", "blue"));

	    //ResultSet<Car> results = parser.retrieve(cars, "SELECT * FROM cars WHERE (Car.DIRTY='sdf')");
	    ResultSet<Car> results = cars.retrieve(contains(test, "s"));
	    //ResultSet<Car> results = parser.retrieve(cars, "contains(DIRTY, \"s\")");

	    for (Car car : results) {
	        System.out.println(car.model);
	    }			

    }
}
