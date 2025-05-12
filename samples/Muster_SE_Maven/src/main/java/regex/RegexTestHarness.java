package regex;
//import java.io.Console;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarness {

    public static void main(String[] args){
        /*Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }*/
    	
    	Scanner s = new Scanner(System.in);
      	
    	 while (true) {
        	
        	System.out.println("Enter your regex: ");
            Pattern pattern = 
            Pattern.compile(s.nextLine());

            System.out.println("Enter input string to search: ");
            Matcher matcher = 
            pattern.matcher(s.nextLine());

            boolean found = false;
            while (matcher.find()) {
                System.out.format("I found the text \"%s\" starting at " +
                   "index %d and ending at index %d.%n",
                    matcher.group(), matcher.start(), matcher.end());
                found = true;
            }
            if(!found){
                System.out.format("No match found.%n");
            }
        }
    }
}


