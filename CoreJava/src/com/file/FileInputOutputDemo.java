package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileInputOutputDemo {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos=new FileOutputStream("../CoreJava\\src\\myfile\\tops1.txt",true);
		String s="\nઆ ફાઇલ ડેમો છે";
		byte b[]=s.getBytes();
		fos.write(b);
		fos.flush();
		fos.close();
		System.out.println("File Written Successfully");
		
		FileInputStream fis=new FileInputStream("../CoreJava\\src\\myfile\\tops1.txt");
		Reader _file = new InputStreamReader(fis, "UTF-8");
		int i;
		while((i=_file.read())!=-1)
		{
			System.out.print((char)i);
		}
		fis.close();
	}
}
