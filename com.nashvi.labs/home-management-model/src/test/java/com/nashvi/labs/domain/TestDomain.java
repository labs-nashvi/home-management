package com.nashvi.labs.domain;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDomain {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createNewUser() {
		User avinash = new User();
		avinash.setUserName("labs.nashvi");
		avinash.setPassword("password");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		avinash.setCreateTimestamp(timestamp);
		avinash.setLastLoginTimestamp(timestamp);
		avinash.setStatus("A");
		avinash.setInvalidAttempts(0);
		
	}

}
