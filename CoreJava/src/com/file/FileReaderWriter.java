package com.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {

	public static void main(String[] args) throws IOException {
		FileWriter fw=new FileWriter("tops2.txt");
		String s="This is file reader/writer demo";
		fw.write(s);
		fw.flush();
		fw.close();
		System.out.println("File Writen");
		
		FileReader fr=new FileReader("tops2.txt");
		int i;
		while((i=fr.read())!=-1)
		{
			System.out.print((char)i);
		}
		fr.close();
	}
}
