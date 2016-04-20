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

public class Selenium_List {
	
	public String yc[];
	public static final String sList="l";
	public static final String List="list";
	
	public static final String sHelp="h";
	public static final String Help="help";

	public String list[];

	Options option = new Options();
	
	public Selenium_List(String args[]){
		yc=args;
		
		option.addOption(sList, List, true, "Display list argument's");
		option.addOption(sHelp, Help, false, "Display Help");
	
	}
	
	public void cli(){	
		
		CommandLineParser parser = new DefaultParser();
				
		try {
		
			CommandLine cmd = parser.parse( option, this.yc);
	
					 	   
			 	  if ((cmd.hasOption(sList)) || (cmd.hasOption(List))) {
			 		list = cmd.getArgs();
			 	  }
			 	  
 
			 	  if ((cmd.hasOption(sHelp)) || (cmd.hasOption(Help))) {
			 		  help();
			 		  }

			 	   
		 } catch (ParseException e) {
			 help();
			 }
		
		WebDriver driver = new FirefoxDriver();    // Version 1.1 :: Firefox
		 
		for(int i=0;i<list.length;i++)
			{
				String test_case_id = "TC-003.0"+(i+1);
				String param[] = list[i].split("\\|");
				String url = param[0];
				String title_expected = param[1];
				
				
				driver.get(url);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				String title_actual = driver.getTitle();

				if (title_expected.equals(title_actual)) {
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
				
				 
				//Loop for
			}
		driver.quit();
			
	}

	private void help() {
		  
		// automatically generate the help statement
		 HelpFormatter formatter = new HelpFormatter();
		 formatter.printHelp( "Main", option );
		 System.exit(0);
	
	}

//Main
	public static void main(String[] yc) {
	// TODO Auto-generated method stub

		new Selenium_List (yc).cli();
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//END of Class
}
