package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		FileReader inputFile = new FileReader("C:\\inputFile.txt");
		BufferedReader bufferedReader = new BufferedReader(inputFile);
		String inputLine;
		while((inputLine = bufferedReader.readLine()) != null) {
			if(inputLine.startsWith("#")) {
				System.out.println(inputLine);
			}
			
		}
		inputFile.close();
		}catch(IOException ex) {
			
		}
	}

}
