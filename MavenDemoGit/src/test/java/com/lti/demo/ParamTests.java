package com.lti.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

public class ParamTests {
	
	@ParameterizedTest    
    @ValueSource(ints= {8,12,20,50,100})
    public void testArrays(int arg)
    {
        System.out.println(" arg :" +arg);
        Assertions.assertTrue(arg%2==0);
    }
	
	@ParameterizedTest
	@DisplayName("Should pass all non-null arguments to method")
    @ValueSource(strings= {"Hello","World"})
    public void testParam1(String msg)
	{
		Assertions.assertNotNull(msg);
	}
	
	
	//@Disabled
	@ParameterizedTest(name="#{index} = {0}")
	@DisplayName("Should Pass all non-null arguments to method")
	//@ValueSource(strings= {"Hello","World","Hello World", " Hi", "Hello GET1024"})	
	@ValueSource(strings= {"Hello","Hello World",  "Hello GET1024"})	
	public void testParam(String msg)
	{
		String searchKey="Hello";		
		Assertions.assertTrue(msg.contains(searchKey));		
	}
	
	
	//login 3 attempts the same code
	@RepeatedTest(3)
	public void shouldRepeat()
	{
		int x=10, y=20;
		assertEquals(200,x*y);
	}
    
	//Junit 5 supports Lambda
	
	@Test
	public void testLambda()
	{
		Integer[] intAry= {2,3,7,5,10};
		
		List<Integer> numbers= Arrays.asList(intAry);
		
		Assertions.assertAll(
				() -> assertEquals(2,numbers.get(0)) ,				
				() -> assertEquals(3,numbers.get(1)) ,
				() -> assertEquals(7,numbers.get(2)) ,
				() -> assertEquals(5,numbers.get(3)) ,
				() -> assertEquals(10,numbers.get(4)) 				
				);	
	}
	
	
	
	
	
  
	
	
	

}