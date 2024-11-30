package com.qa.util;

import java.time.Duration;

import com.qa.testbase.TestBase;

public class TestUtil extends TestBase{
	public static Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(120);
    public static Duration IMPLICIT_WAIT = Duration.ofSeconds(10);

}
