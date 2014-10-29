package maxThread;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class MaxThreadAmount
{
	private JFrame frame;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	
	public MaxThreadAmount()
	{
		frame = new JFrame("max thread amount");
		frame.setSize(600, 400);
		frame.setLocation(200, 200);
		
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		
		frame.add(scrollPane,  BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public JTextArea getTextArea()
	{
		return this.textArea;
	}
	
	public static void main(String[] args)
	{
		MaxThreadAmount maxThreadAmount = new MaxThreadAmount();
		
		for (int i = 0; i < 1000; i++)
		{
			new Thread(new Runnable()
			{
				
				@Override
				public void run()
				{
					for (int j = 0; j < 100000; j++)
					{
						try
						{
							maxThreadAmount.getTextArea().append("test -> " + Thread.currentThread().getId() + "\n");
							Thread.sleep(10);
						}
						catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
		
	}
}
