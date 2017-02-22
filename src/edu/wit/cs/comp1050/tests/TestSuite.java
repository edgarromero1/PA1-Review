package edu.wit.cs.comp1050.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	E1aTestCase.class,
	E1bTestCase.class,
})

public class TestSuite {
	static String stringOutput(String[] lines, Object[] values) {
		return String.format(String.join("", lines), values);
	}
	
	static String terminalOutput(String[] lines) {
		return String.join(String.format("%n"), lines);
	}
}
