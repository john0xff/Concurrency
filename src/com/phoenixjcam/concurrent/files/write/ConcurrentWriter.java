package com.phoenixjcam.concurrent.files.write;

public class ConcurrentWriter
{
	// write some random tex to file with 2 - 5 thread at the same time without synchronization and locks
	// the same with synchro and locks

	public static void main(String[] args)
	{
		FileWriter fileWriter = new FileWriter();

		ThreadFactory threadFactory = new ThreadFactory("master", fileWriter);
		try
		{
			threadFactory.getThread().join();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * First thread already have made all work :)
		 * <p>
		 * All methods to write into the files in Writer class has synchronized (lock) methods. It's impossible to use 2
		 * threads in the same operation on this class.
		 * 
		 */
		ThreadFactory threadFactory2 = new ThreadFactory("king", fileWriter);
	}
}
