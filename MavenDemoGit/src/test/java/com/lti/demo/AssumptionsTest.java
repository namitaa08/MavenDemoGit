package com.lti.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
//Additional support while executing
// a failed assumptions results in test being terminated
// when to use - if test

class AssumptionsTest {
	int num;
	 @Test
	    void testOnDev()
	    {
	        System.setProperty("ENV", "DEV");
	        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")), AssumptionsTest::message);
	        System.out.println(" continue execution");
	        num=1000;
	    }

	    @Test
	    void testOnProd()
	    {
	        System.setProperty("ENV", "PROD");
	        Assumptions.assumeFalse("PROD".equals(System.getProperty("ENV")),TestAssumptions::message);
	        System.out.println(" don't continue execution");
	        num=1000;
	    }

	
	}


