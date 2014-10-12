package com.phoenixjcam.concurrent.files.write;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

class ThreadFactory
{
	private Thread thread;
	private String threadName;

	public ThreadFactory()
	{

	}
}

class FileWriter
{
	private final static String filename = "src/com/phoenixjcam/concurrent/files/write/test.txt";
	private File file;
	private Writer out;

	// Writer out = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public FileWriter()
	{
		
	}
	
	public void initWriter()
	{
		file = new File(filename);
		try
		{
			out = new BufferedWriter(new java.io.FileWriter(file));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class ConcurrentWriter
{
	// write some random tex to file with 2 - 5 thread at the same time without synchronization and locks
	// the same with synchro and locks

	public static void main(String[] args)
	{
		
	}
}
