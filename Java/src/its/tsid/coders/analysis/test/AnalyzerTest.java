package its.tsid.coders.analysis.test;

import static org.junit.Assert.*;

import org.junit.Test;

import its.tsid.coders.analysis.Analyzer;

public class AnalyzerTest {

	@Test
	public void test() {
		Object input = new Object();
		
		
		Object expectedOutput = new Object();
		
		Analyzer checker = new Analyzer();
		Object output = checker.validator(input);

//		for(String s : output.keySet()){
//			assertEquals(expectedOutput.get(s), output.get(s));
//		}
	}

}
