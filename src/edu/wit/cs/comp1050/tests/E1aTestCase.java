
package edu.wit.cs.comp1050.tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.Permission;

import org.junit.Assert;

import edu.wit.cs.comp1050.E1a;
import junit.framework.TestCase;

public class E1aTestCase extends TestCase {
	
	private static final String ERR_USAGE = "Input any number of integers.";
	private static final String ERR_EMPTY = "No integers supplied.";
	
	private static final int BIG = Integer.MAX_VALUE;
	private static final String BIG_S = String.valueOf(BIG);
	private static final int SMALL = Integer.MIN_VALUE;
	private static final String SMALL_S = String.valueOf(SMALL);
	
	//
	
	@SuppressWarnings("serial")
	private static class ExitException extends SecurityException {}
	
	private static class NoExitSecurityManager extends SecurityManager 
    {
        @Override
        public void checkPermission(Permission perm) {}
        
        @Override
        public void checkPermission(Permission perm, Object context) {}
        
        @Override
        public void checkExit(int status) { super.checkExit(status); throw new ExitException(); }
    }
	
	@Override
    protected void setUp() throws Exception 
    {
        super.setUp();
        System.setSecurityManager(new NoExitSecurityManager());
    }
	
	@Override
    protected void tearDown() throws Exception 
    {
        System.setSecurityManager(null);
        super.tearDown();
    }
	
	private void _test(String[] a, String msg) {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		
		final String expected = TestSuite.stringOutput(new String[] {
			msg + "%n"
		}, new Object[] {});
		
		System.setIn(null);
		System.setOut(new PrintStream(outContent));
		try {
			E1a.main(a);
		} catch (ExitException e) {}
		
		assertEquals(expected, outContent.toString());
		
		System.setIn(null);
		System.setOut(null);
	}
	
	private void _testBiggestNum(int[] a, Integer expected) {
		Integer result = null;
		try {
			result = E1a.biggestNum(a);
		} catch (ExitException e) {}
		assertEquals(expected, result);
	}
	
	private void _testBiggest(int[] a, String expected) {
		String result = null;
		try {
			result = E1a.biggest(a);
		} catch (ExitException e) {}
		assertEquals(expected, result);
	}
	
	private void _testConvertToNums(String[] a, int[] expected) {
		int[] result = null;
		try {
			result = E1a.convertToNums(a);
		} catch (ExitException e) {}
		Assert.assertArrayEquals(expected, result);
	}
	
	public void testBiggestNum() {
		_testBiggestNum(new int[] {}, null);
		
		_testBiggestNum(new int[] {0}, 0);
		_testBiggestNum(new int[] {1}, 1);
		_testBiggestNum(new int[] {2}, 2);
		_testBiggestNum(new int[] {3}, 3);
		_testBiggestNum(new int[] {-10}, -10);
		_testBiggestNum(new int[] {SMALL}, SMALL);
		_testBiggestNum(new int[] {BIG}, BIG);
		
		_testBiggestNum(new int[] {1, 1, 1, 1}, 1);
		_testBiggestNum(new int[] {2, 2}, 2);
		_testBiggestNum(new int[] {3, 3, 3}, 3);
		
		_testBiggestNum(new int[] {-10, SMALL}, -10);
		_testBiggestNum(new int[] {-10, 0, SMALL}, 0);
		_testBiggestNum(new int[] {-10, SMALL, 0}, 0);
		_testBiggestNum(new int[] {0, -10, SMALL}, 0);
		_testBiggestNum(new int[] {1, -10, SMALL}, 1);
		
		_testBiggestNum(new int[] {-10, 0, BIG}, BIG);
		_testBiggestNum(new int[] {-10, 0, BIG, BIG, 0}, BIG);
		_testBiggestNum(new int[] {-10, 0, BIG, 1, 2, 3}, BIG);
		_testBiggestNum(new int[] {BIG, SMALL, -100, 100, 1, 0, 2, 3}, BIG);
	}
	
	public void testBiggest() {
		_testBiggest(new int[] {}, ERR_EMPTY);
		
		_testBiggest(new int[] {0}, "0");
		_testBiggest(new int[] {1}, "1");
		_testBiggest(new int[] {2}, "2");
		_testBiggest(new int[] {3}, "3");
		_testBiggest(new int[] {-10}, "-10");
		_testBiggest(new int[] {SMALL}, SMALL_S);
		_testBiggest(new int[] {BIG}, BIG_S);
		
		_testBiggest(new int[] {1, 1, 1, 1}, "1");
		_testBiggest(new int[] {2, 2}, "2");
		_testBiggest(new int[] {3, 3, 3}, "3");
		
		_testBiggest(new int[] {-10, SMALL}, "-10");
		_testBiggest(new int[] {-10, 0, SMALL}, "0");
		_testBiggest(new int[] {-10, SMALL, 0}, "0");
		_testBiggest(new int[] {0, -10, SMALL}, "0");
		_testBiggest(new int[] {1, -10, SMALL}, "1");
		
		_testBiggest(new int[] {-10, 0, BIG}, BIG_S);
		_testBiggest(new int[] {-10, 0, BIG, BIG, 0}, BIG_S);
		_testBiggest(new int[] {-10, 0, BIG, 1, 2, 3}, BIG_S);
		_testBiggest(new int[] {BIG, SMALL, -100, 100, 1, 0, 2, 3}, BIG_S);
	}
	
	public void testConvertToNums() {
		_testConvertToNums(new String[] {"a"}, null);
		_testConvertToNums(new String[] {"B", "1"}, null);
		_testConvertToNums(new String[] {"2", "c"}, null);
		_testConvertToNums(new String[] {"3", "2", BIG_S, SMALL_S, ":("}, null);
		
		_testConvertToNums(new String[] {}, new int[] {});
		
		_testConvertToNums(new String[] {"0"}, new int[] {0});
		_testConvertToNums(new String[] {"1"}, new int[] {1});
		_testConvertToNums(new String[] {"2"}, new int[] {2});
		_testConvertToNums(new String[] {"3"}, new int[] {3});
		_testConvertToNums(new String[] {"-10"}, new int[] {-10});
		_testConvertToNums(new String[] {SMALL_S}, new int[] {SMALL});
		_testConvertToNums(new String[] {BIG_S}, new int[] {BIG});
		
		_testConvertToNums(new String[] {"1", "1", "1", "1"}, new int[] {1, 1, 1, 1});
		_testConvertToNums(new String[] {"2", "2"}, new int[] {2, 2});
		_testConvertToNums(new String[] {"3", "3", "3"}, new int[] {3, 3, 3});
		
		_testConvertToNums(new String[] {"-10", SMALL_S}, new int[] {-10, SMALL});
		_testConvertToNums(new String[] {"-10", "0", SMALL_S}, new int[] {-10, 0, SMALL});
		_testConvertToNums(new String[] {"-10", SMALL_S, "0"}, new int[] {-10, SMALL, 0});
		_testConvertToNums(new String[] {"0", "-10", SMALL_S}, new int[] {0, -10, SMALL});
		_testConvertToNums(new String[] {"1", "-10", SMALL_S}, new int[] {1, -10, SMALL});
		
		_testConvertToNums(new String[] {"-10", "0", BIG_S}, new int[] {-10, 0, BIG});
		_testConvertToNums(new String[] {"-10", "0", BIG_S, BIG_S, "0"}, new int[] {-10, 0, BIG, BIG, 0});
		_testConvertToNums(new String[] {"-10", "0", BIG_S, "1", "2", "3"}, new int[] {-10, 0, BIG, 1, 2, 3});
		_testConvertToNums(new String[] {BIG_S, SMALL_S, "-100", "100", "1", "0", "2", "3"}, new int[] {BIG, SMALL, -100, 100, 1, 0, 2, 3});
	}
	
	public void testProgram() {
		_test(new String[] {"a"}, ERR_USAGE);
		_test(new String[] {"B", "1"}, ERR_USAGE);
		_test(new String[] {"2", "c"}, ERR_USAGE);
		_test(new String[] {"3", "2", BIG_S, SMALL_S, ":("}, ERR_USAGE);
		
		_test(new String[] {}, ERR_EMPTY);
		
		_test(new String[] {"0"}, "0");
		_test(new String[] {"1"}, "1");
		_test(new String[] {"2"}, "2");
		_test(new String[] {"3"}, "3");
		_test(new String[] {"-10"}, "-10");
		_test(new String[] {SMALL_S}, SMALL_S);
		_test(new String[] {BIG_S}, BIG_S);
		
		_test(new String[] {"1", "1", "1", "1"}, "1");
		_test(new String[] {"2", "2"}, "2");
		_test(new String[] {"3", "3", "3"}, "3");
		
		_test(new String[] {"-10", SMALL_S}, "-10");
		_test(new String[] {"-10", "0", SMALL_S}, "0");
		_test(new String[] {"-10", SMALL_S, "0"}, "0");
		_test(new String[] {"0", "-10", SMALL_S}, "0");
		_test(new String[] {"1", "-10", SMALL_S}, "1");
		
		_test(new String[] {"-10", "0", BIG_S}, BIG_S);
		_test(new String[] {"-10", "0", BIG_S, BIG_S, "0"}, BIG_S);
		_test(new String[] {"-10", "0", BIG_S, "1", "2", "3"}, BIG_S);
		_test(new String[] {BIG_S, SMALL_S, "-100", "100", "1", "0", "2", "3"}, BIG_S);
	}
}
