package concurrent.files.write;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;

public class FileWriter
{
	private final static String filename = "src/com/phoenixjcam/concurrent/files/write/test.txt";
	private File file;
	private Writer outWriter;

	// this two static files only for this packet
	static int currentLine = 0; // current number - each thread need to update it by his own
	static int size = 100; // number of lines in file

	// Writer out = new BufferedWriter(new OutputStreamWriter(System.out));

	public FileWriter()
	{
		initWriter();
		initFileStructure();
	}

	public Writer getOutWriter()
	{
		return outWriter;
	}

	// can't close in the middle of threads work
	private void closeStream()
	{
		try
		{
			outWriter.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void initWriter()
	{
		file = new File(filename);
		try
		{
			outWriter = new BufferedWriter(new java.io.FileWriter(file));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void initFileStructure()
	{
		try
		{
			outWriter.write(String.valueOf(size) + System.lineSeparator());
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}