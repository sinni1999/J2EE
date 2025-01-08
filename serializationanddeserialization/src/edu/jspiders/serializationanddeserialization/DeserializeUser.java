package edu.jspiders.serializationanddeserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeUser {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		File file = new File("E://eclipse-workspace/demo2.txt");
		FileInputStream fileInputStream = new FileInputStream(file); // A FileInputStream object is created to read the bytes from the file
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream); // An ObjectInputStream is created using the FileInputStream to read objects from the byte stream (deserialization)
		User user = (User) objectInputStream.readObject(); // The readObject() method is used to read the serialized object from the input stream and cast it back to a User object
		objectInputStream.close();
		fileInputStream.close();
		System.out.println(user);
		

	}

}
