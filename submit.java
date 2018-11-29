import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class submit extends JFrame
{

	private static final int WIDTH = 200;
	private static final int HEIGHT = 600;


	public submit()
	{
		
		JOptionPane.showMessageDialog(this, "You Pressed Button FOUR",  
                                          "INFORMATION",  
                                          JOptionPane.INFORMATION_MESSAGE);


	}

	public static void main(String args[])
	{
		submit window = new submit();
		window.setVisible(true);

	}
}