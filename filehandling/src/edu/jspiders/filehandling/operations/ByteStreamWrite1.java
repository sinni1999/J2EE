package edu.jspiders.filehandling.operations;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamWrite1 {

	public static void main(String[] args) throws IOException {
		// A byte array email is initialized with the characters of an email address. 
		//The byte array contains each character as its corresponding byte value.
		byte[] email = {'s','i','n','n','i','@','g','m','a','i','l','.','c','o','m'};
		
		File file = new File("E://eclipse-workspace/filehandling/demo2.txt");
		if (file.exists()) {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			// writes a portion of the email byte array to the file, starting from index 5 (the @ symbol) and writing a total of 10 bytes
			fileOutputStream.write(email, 5, 10);
			fileOutputStream.close();
			System.out.println("Data is written to a file");
		} else {
			file.createNewFile();
			System.out.println("File is created");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(email, 5, 10);
			fileOutputStream.close();
			System.out.println("Data is written to a file");
		}

	}

}
