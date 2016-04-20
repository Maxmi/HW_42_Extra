package comm_cli;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Comm_CLI
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Selenium_Single {

	public String yc[];
	public static final String sURL="u";
	public static final String URL="url";
	
	public static final String sTitle="t";
	public static final String TitleExpected="title";
	
	public static final String sTest_case_id="c";
	public static final String Test_case_id="tcase";
	
	public static final String sHelp="h";
	public static final String Help="help";

	Options option = new Options();
	
	
	public Selenium_Single(String args[]){
		yc=args;

		option.addOption(sTitle, TitleExpected,  true, "Display expected title");
		option.addOption(sURL, URL, true, "Display url");
		option.addOption(sTest_case_id, Test_case_id, true, "Display text case id");
		option.addOption(sHelp, Help, false, "Display Help");
	
	}
	
	String test_case_id = null;
	String title_expected = null;
	String url = null;
	
	
	public void cli(){	
	
	CommandLineParser parser = new DefaultParser();
	
	try {
		
		CommandLine cmd = parser.parse( option, yc);
				 	   
		 	  if ((cmd.hasOption(sTitle)) || (cmd.hasOption(TitleExpected))) {
		 		 title_expected =  cmd.getOptionValue(sTitle);
		 	  }
		 	  
		 	  
		 	  
		 	 if ((cmd.hasOption(sURL)) || (cmd.hasOption(URL))) {
		 		url =  cmd.getOptionValue(sURL);
		 		}
		 	 
		 	 
		 	if ((cmd.hasOption(sTest_case_id)) || (cmd.hasOption(Test_case_id))) {
		 		test_case_id = cmd.getOptionValue(sTest_case_id);
		 		 }
		 	
		 	 
		 	  if ((cmd.hasOption(sHelp)) || (cmd.hasOption(Help))) {
		 		  help();
		 		  }

		 	   
	 } catch (ParseException e) {
		 help();
		 }
	
	WebDriver driver = new FirefoxDriver();    // Version 1.1 :: Firefox
	
	driver.get(url);
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	String title_actual = driver.getTitle();
	if (title_expected.equals(title_actual)) {
		System.out.println();
		System.out.println(">>>>....");
		System.out.println("Test Case ID: \t\t" + test_case_id);
		System.out.println("URL: \t\t\t" + url);
		System.out.println("Title Expected: \t" + title_expected);
		System.out.println("Title Actual: \t\t" + title_actual);
		System.out.println("Test Case Result: \t" + "PASSED");
		System.out.println("....<<<<");
		System.out.println();
	} else {
		System.out.println(">>>>....");
		System.out.println("Test Case ID: \t\t" + test_case_id);
		System.out.println("URL: \t\t\t" + url);
		System.out.println("Title Expected: \t" + title_expected);
		System.out.println("Title Actual: \t\t" + title_actual);
		System.out.println("Test Case Result: \t" + "FAILED");
		System.out.println("....<<<<");
		System.out.println();
	}
	
	driver.quit();
	
	}
	
	private void help() {
		  
		// automatically generate the help statement
		 HelpFormatter formatter = new HelpFormatter();
		 formatter.printHelp( "Main", option );
		 System.exit(0);
 	
	}

	public static void main(String yc[]) {
		
		new Selenium_Single (yc).cli();
	}
	
//END Class	
}
