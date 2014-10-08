package com.phoenixjcam.threads.create.practice;

/**
 * Unsynchronized method to print stuff from different thread. It means that each instance of thread need to implement
 * synchronized block with their own mutex.
 * 
 * @author BartBien
 *
 */
class ConsolePrinter
{
	public void print(String threadName) throws InterruptedException
	{
		for (int i = 0; i < 10; i++)
		{
			System.out.println(threadName + " --> " + i);

			Thread.sleep(10);
		}
	}
}

/**
 * Extends - we need to extends api classes if we'll be adding some new functionality. In other cases there is no need
 * to extends. Better way to make it with interface or lambda expression.
 */
class ThreadExtended extends Thread
{
	private ConsolePrinter consolePrinter;

	public ThreadExtended()
	{
		
	}

	@Override
	public void run()
	{
		synchronized (consolePrinter)
		{
			try
			{
				consolePrinter.print(this.getName());
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public synchronized void start()
	{
		super.start();
	}

	public void setConsolePrinter(ConsolePrinter consolePrinter)
	{
		this.consolePrinter = consolePrinter;
	}
}

/**
 * Need to pass Runnable instance to constructor.
 *
 */
class ThreadRunnable implements Runnable
{
	private Thread thread;
	private ConsolePrinter consolePrinter;

	public ThreadRunnable(ConsolePrinter consolePrinter)
	{
		this.consolePrinter = consolePrinter;
		Runnable runnable = this;

		thread = new Thread(runnable, "runnableThrMaster");
		thread.start();
	}

	@Override
	public void run()
	{
		synchronized (consolePrinter)
		{
			try
			{
				consolePrinter.print(this.thread.getName());
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

/**
 * Example shows how to create new thread in 4 different ways (slightly different but different)
 *
 * @author BartBien
 */
public class CreatingThreadsIn4Ways
{
	public static void main(String[] args)
	{
		ConsolePrinter consolePrinter = new ConsolePrinter();

		// Extends way
		ThreadExtended thr1 = new ThreadExtended();
		thr1.setConsolePrinter(consolePrinter);
		thr1.start();

		// Runnable way
		ThreadRunnable thr2 = new ThreadRunnable(consolePrinter);

		// ANONYMOUS  way
		Thread thr3 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				synchronized (consolePrinter)
				{
					try
					{
						consolePrinter.print("anonymousThr");
					}
					catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		thr3.start();

		// LAMBDA expression way
		Thread thr4 = new Thread(() ->
		{
			synchronized (consolePrinter)
			{
				try
				{
					consolePrinter.print("lambdaThr");
				}
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		thr4.start();
	}
}
