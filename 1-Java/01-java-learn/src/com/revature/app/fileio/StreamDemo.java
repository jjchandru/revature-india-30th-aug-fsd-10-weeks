package com.revature.app.fileio;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileInputStream reader = new FileInputStream("D:\\googlelogo.png");
		FileOutputStream writer = new FileOutputStream("D:\\googlelogo-copy.png");
		
		int character = reader.read();
		
		while (character != -1) {
			System.out.print((char) character);
			writer.write(character);
			character = reader.read();
		}
		
		writer.close();
		reader.close();
	}

}
