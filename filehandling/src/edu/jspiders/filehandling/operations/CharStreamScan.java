package edu.jspiders.filehandling.operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharStreamScan {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("E://eclipse-workspace/filehandling/demo.txt");
		
		if(file.exists()) {
			Scanner scanner = new Scanner(file);  // Scanner class can be used to take data dynamically from the user during the execution of a program
			while(scanner.hasNextLine()) { //  hasNextLine() method checks if there is another line in the input.
				System.out.println(scanner.nextLine()); // nextLine() reads the next line.
			}
			scanner.close(); // close the scanner class to avoid resource leakage.
			
		}else
			System.out.println("File does not exist");
	}

}
