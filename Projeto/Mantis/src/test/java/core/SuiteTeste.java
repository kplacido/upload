package core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.InicialTests;
import tests.LoginTests;
import tests.ReportTests;

@RunWith(Suite.class)
@SuiteClasses({
	LoginTests.class,
	InicialTests.class,
	ReportTests.class
	
	
})
public class SuiteTeste {

}
