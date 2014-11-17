package maxThread;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

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
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		scrollPane = new JScrollPane(textArea);

		frame.add(scrollPane, BorderLayout.CENTER);

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

		for (int i = 0; i < 10000; i++)
		{
			new Thread(new Runnable()
			{

				@Override
				public void run()
				{
					// for (int j = 0; j < 100000; j++)
					// {

					while (true)
					{
						try
						{
							maxThreadAmount.getTextArea().append("test -> " + Thread.currentThread().getId() + "\n");
							Thread.sleep(1000);
							
							
						}
						catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
					// }
				}
			}).start();
		}

	}
}
