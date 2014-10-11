package com.phoenixjcam.threads.join;

class ConsolePrinter
{
	public void print(String threadName)
	{
		for (int i = 0; i < 10; i++)
		{
			System.out.println(threadName + " -> " + i);

			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class ThreadFactory implements Runnable
{
	private Thread thread;
	private ConsolePrinter consolePrinter;
	private String threadName;

	public ThreadFactory(String threadName, ConsolePrinter consolePrinter)
	{
		this.consolePrinter = consolePrinter;
		this.threadName = threadName;
		Runnable runnable = this;

		this.thread = new Thread(runnable, threadName);
		// this.thread.start();

	}

	public Thread getThread()
	{
		return thread;
	}

	@Override
	public void run()
	{
		synchronized (consolePrinter)
		{
			consolePrinter.print(threadName);
		}
	}
}

public class ThreadJoin
{

	public static void main(String[] args)
	{
		ConsolePrinter consolePrinter = new ConsolePrinter();


		ThreadFactory thrFactory = new ThreadFactory("1-king", consolePrinter);
		thrFactory.getThread().start();
		try
		{
			thrFactory.getThread().join(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		ThreadFactory thrFactory2 = new ThreadFactory("2-master", consolePrinter);
		thrFactory2.getThread().start();
		try
		{
			thrFactory2.getThread().join(2000);
			
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		ThreadFactory thrFactory3 = new ThreadFactory("3-elder", consolePrinter);
		thrFactory3.getThread().start();
		try
		{
			thrFactory3.getThread().join(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}

}
