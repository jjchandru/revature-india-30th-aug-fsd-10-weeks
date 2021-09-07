package com.revature.app.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileReader reader = new FileReader("D:\\file.txt");
		FileWriter writer = new FileWriter("D:\\file-copy.txt");
		
		
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
