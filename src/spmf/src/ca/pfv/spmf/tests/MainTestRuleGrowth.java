package ca.pfv.spmf.tests;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import ca.pfv.spmf.sequential_rules.rulegrowth.AlgoRULEGROWTH;

/**
 * -Xmx1024${build_files}m
 * Class to test the RuleGrowth algorithm
 * @author Philippe Fournier-Viger (Copyright 2010)
 */
public class MainTestRuleGrowth {
	
	public static void main(String [] arg) throws IOException{
		String input = fileToPath("contextPrefixSpan.txt");  // the database
		String output = "C://sequential_rules.txt";  // the path for saving the frequent itemsets found

		//  Applying RuleGROWTH algorithm with minsup = 3 sequences and minconf = 0.5
		int minsup_relative = 3;
		double minconf = 0.5;
		AlgoRULEGROWTH algo = new AlgoRULEGROWTH();
		algo.runAlgorithm(input, output, minsup_relative, minconf);
		
		// If you want to use an absolute support (percentage value), use
		// the following lines instead:
		
//		   double minsup_absolute = 0.75;  // it means 75 %
//		   AlgoRULEGROWTH algo = new AlgoRULEGROWTH();
//		   algo.runAlgorithm(minsup_absolute, minconf, input, output);

		// print statistics
		algo.printStats();
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestRuleGrowth.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
