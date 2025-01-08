package edu.jspiders.filehandling.operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamRead {

	public static void main(String[] args) throws IOException {
	
		File file = new File("E://eclipse-workspace/filehandling/demo2.txt");
		String data = "";
		if(file.exists()) {
			// This initializes the ascii variable with the value -1 because -1used to represent the end of the file (EOF) when using the read() method of FileReader.
			int ascii = -1;
			FileInputStream fileInputStream = new FileInputStream(file);
			while((ascii = fileInputStream.read()) != -1) {
				data += (char) ascii;
			}
			fileInputStream.close();
			System.out.println(data);	
		}else {
			System.out.println("File does not exist");
		}

	}

}
