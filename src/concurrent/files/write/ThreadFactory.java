package concurrent.files.write;

import java.io.IOException;

public class ThreadFactory implements Runnable
{
	private Runnable runnable;
	private Thread thread;
	private String threadName;
	private FileWriter fileWriter;

	public ThreadFactory(String threadName, FileWriter fileWriter)
	{
		this.fileWriter = fileWriter;
		this.threadName = threadName;
		runnable = this;
		thread = new Thread(runnable, threadName);
		thread.start();
	}

	@Override
	public void run()
	{
		synchronized (fileWriter)
		{
			while (FileWriter.currentLine < FileWriter.size)
			{

				try
				{
					fileWriter.getOutWriter().write(threadName + " --> " + FileWriter.currentLine + System.lineSeparator());
					FileWriter.currentLine++;

					if (threadName == "master" && FileWriter.currentLine == 50)
						return;

				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		ensureFlush();
	}

	private void ensureFlush()
	{
		try
		{
			fileWriter.getOutWriter().flush();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Thread getThread()
	{
		return thread;
	}

}