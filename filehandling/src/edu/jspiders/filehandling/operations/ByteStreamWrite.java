package edu.jspiders.filehandling.operations;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamWrite {

	public static void main(String[] args) throws IOException {

		File file = new File("E://eclipse-workspace/filehandling/demo1.txt");
		if(file.exists()) {
			FileOutputStream fileOutputStream = new FileOutputStream(file); // FileOutputStream object is created to write binary data to the file.
			fileOutputStream.write(25); // write the specified byte to the file.
			fileOutputStream.close(); // used to release the resources.
			System.out.println("Data is written to a file");
		}else {
			file.createNewFile(); // if file does not exist then create new file.
			System.out.println("File is created Successfully");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(20);
			fileOutputStream.close();
			System.out.println("Data is written to a file");
			
		}

	}

}
