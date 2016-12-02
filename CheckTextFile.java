package project4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CheckTextFile {
	
	   public static void main(String[] args) throws IOException {
	     

		       String text = "";
		       Scanner in = new Scanner(System.in);
		       System.out.println("Please enter the input file ");
		       String inputFile = in.next();
		       System.out.println("Please enter output file");
		       String outputFile = in.next();
		       File input = new File(inputFile);
		       BufferedReader br = null;
			try {
				//BufferedReader br;
				br = new BufferedReader(new FileReader(input));
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		       String sCurrentLine;
		       if(input.exists()){
		     
		    	   try {
		    		  // BufferedReader br;
					while ((sCurrentLine = br.readLine()) != null) {
					   text = text + sCurrentLine + "\n";
      }
				} catch (IOException e) {
					
					e.printStackTrace();
				}


		   
		   System.out.println("-----------Input file content--------------");
	       System.out.println(text);
	       text = text.replaceAll("\\s+", " ").trim();//remove leading and trailing white space omitted
	      // This method replaces each substring of this string that matches the given regular expression with the given replacement.
	       int pos = 0;
	       boolean capitalize = true;
	       StringBuilder sb = new StringBuilder(text);
	      
	       while (pos < sb.length()) {
	       if (sb.charAt(pos) == '.' || sb.charAt(pos) == '?' || sb.charAt(pos) == '!') {
	       capitalize = true;
	       } else if (capitalize && !Character.isWhitespace(sb.charAt(pos))) {
	           sb.setCharAt(pos, Character.toUpperCase(sb.charAt(pos)));
	       capitalize = false;
	          
	       }
	       pos++;
	       }
	      
	FileWriter writer = new FileWriter(outputFile);
	writer.write(sb.toString());
	writer.close();
	br.close();
	    System.out.println("-------------Output File Content---------------------");
	   
	        System.out.println(sb.toString());
		   }
//else{
          // System.out.println("Input file does not exist");
       }
}  

	
//}



