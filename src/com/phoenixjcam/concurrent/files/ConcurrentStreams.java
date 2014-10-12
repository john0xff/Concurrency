package com.phoenixjcam.concurrent.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;

class ThreadFactory implements Runnable
{
	private Runnable runnable;
	private Thread thread;
	private String threadName;

	public ThreadFactory(String threadName)
	{
		this.runnable = this;
		this.threadName = threadName;
		this.thread = new Thread(runnable, threadName);
	}

	public Thread getThread()
	{
		return this.thread;
	}

	@Override
	public void run()
	{
		// for now it's impossible, cuz this class has only static fields and methods
		// synchronized (instance of ConcurrentFileReader as lock object)
		// {
		//
		// }

		while (ConcurrentFileReader.currentLine < ConcurrentFileReader.size)
		{
			ConcurrentFileReader.readFile();
		}
	}
}

class ConcurrentFileReader
{
	public static int currentLine = 0;
	public static int size = 0;

	private final static String fileName = "src/com/phoenixjcam/concurrent/files/test.txt";
	private static java.io.File file = new File(fileName);
	private static BufferedReader buffReader = null;
	private static String readLine = null;

	public static void init()
	{
		try
		{
			buffReader = new BufferedReader(new FileReader(file));
			readLine = buffReader.readLine();

			System.out.println(readLine);

			size = Integer.parseInt(readLine);
			currentLine++;
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} // throws FileNotFoundException
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	// to improve work of concurrency uncomment synchronized below and comment normal way
	// public synchronized static void readFile()
	public static void readFile()
	{
		try
		{
			readLine = buffReader.readLine();
			System.out.println(readLine + " --- " + currentLine);
			currentLine++;
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

public class ConcurrentStreams
{
	public static void main(String[] args)
	{
		ConcurrentFileReader.init();

		ThreadFactory master = new ThreadFactory("master of threading");
		master.getThread().start();

		ThreadFactory king = new ThreadFactory("king of threading");
		king.getThread().start();

		ThreadFactory elder = new ThreadFactory("elder of threading");
		elder.getThread().start();
	}
}
