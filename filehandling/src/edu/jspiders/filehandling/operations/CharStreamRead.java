package edu.jspiders.filehandling.operations;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CharStreamRead {

	public static void main(String[] args) throws IOException {


		File file  = new File("E://eclipse-workspace/filehandling/demo.txt");
		String data = "";
		if(file.exists()) {
			int ascii = -1;
			FileReader fileReader = new FileReader(file); // FileReader: Used to read characters from the file.
			while((ascii = fileReader.read()) != -1) { // The read() method of FileReader reads one character at a time, returning its ASCII value.
				
				data += (char) ascii; // Each character read is cast to a char and concatenated to the data string.
			}
			fileReader.close(); // used for release resources.
			System.out.println(data);
		}else
			System.out.println("File does not exist");

	}

}
