package edu.jspiders.filehandling.operations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamWrite {

	public static void main(String[] args) throws IOException {


		File file = new File("E://eclipse-workspace/filehandling/demo.txt");
		
		if(file.exists()) { // check if file is exist or not if exist then write the data into the file.
			FileWriter fileWriter = new FileWriter(file); //  Provides a convenient way to write character data to the file.
			fileWriter.write("File Handling is the concept in java"); // The write() method of FileWriter is used to write the string to the file.
			fileWriter.close(); // The close() method is called to close the FileWriter and release system resources.
			System.out.println("Data is written to a file");
		}else {
			file.createNewFile(); // if file is not exist then create a new file.
			System.out.println("File is created Sucessfully");
			FileWriter fileWriter = new FileWriter(file);
			
			fileWriter.write("File Handling is the concept in java");
			fileWriter.close(); 
			System.out.println("Data is written to a file");
		}

	}

}
