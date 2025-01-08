package edu.jspiders.filehandling.operations;

import java.io.File;
import java.io.IOException;

public class CreateFile {
	
	//It is the entry point of the Java application. 
	//It throws an IOException to handle any file input/output errors that may occur during the execution.
	public static void main(String[] args) throws IOException {
		
		// In order to perform any operation on the File we need File object.
		File file = new File("E://eclipse-workspace/filehandling/demo.txt");
		boolean fileIsCreated = file.createNewFile(); // createNewFile() is created on File object , it creates new file at specified location.
		if(fileIsCreated) {
			System.out.println("File is created successfully");
		}else
			System.out.println("File already exists");
	}
	
}
