package edu.jspiders.serializationanddeserialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeUser {

	public static void main(String[] args) throws IOException {
	
		// User Object: The object being serialized. This class should implement the Serializable interface to allow serialization.
		User user = new User("Sinni","sinni@gmail.com",9878897867l,"Pune");
		
		File file = new File("E://eclipse-workspace/demo2.txt");
		FileOutputStream fileOutputStream = new FileOutputStream(file); // A FileOutputStream object is created to handle the actual writing to the file
		ObjectOutputStream objectOutputStream  =new ObjectOutputStream(fileOutputStream); // Converts the User object into a byte stream and writes it to the file.
		objectOutputStream.writeObject(user); // The writeObject() method of ObjectOutputStream is used to serialize the user object and write it to the file
		objectOutputStream.close(); // release the resource or prevent from resource leakage
		fileOutputStream.close();
		System.out.println("User is serialized");
	}

}
