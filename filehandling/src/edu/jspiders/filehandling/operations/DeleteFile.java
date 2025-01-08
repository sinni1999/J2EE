package edu.jspiders.filehandling.operations;

import java.io.File;

public class DeleteFile {

	public static void main(String[] args) {
		
		File file = new File("E://eclipse-workspace/demo.txt");
		boolean fileIsDeleted = file.delete(); // delete() - present inside File object used to delete a file.
		if(fileIsDeleted) {
			System.out.println("File is deleted sucessfully");
		}else
			System.out.println("File does not exist or Something went wrong");
	}

}
