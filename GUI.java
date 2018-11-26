import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame
{


   private int[][] puzzle =
      {{5, 3, 4, 6, 7, 8, 9, 1, 2},
       {6, 7, 2, 1, 9, 5, 3, 4, 8},
       {1, 9, 8, 3, 4, 2, 5, 6, 7},
       {8, 5, 9, 7, 6, 1, 4, 2, 3},
       {4, 2, 6, 8, 5, 3, 7, 9, 1},
       {7, 1, 3, 9, 2, 4, 8, 5, 6},
       {9, 6, 1, 5, 3, 7, 2, 8, 4},
       {2, 8, 7, 4, 1, 9, 6, 3, 5},
       {3, 4, 5, 2, 8, 6, 1, 7, 9}};

      private JTextField[][] inputs = new JTextField[9][9];

public GUI()
{

	super();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new GridLayout(9,9));
	setSize(900,900);
	for(int i=0;i<9;i++)
		for(int j=0;j<9;j++)
		{
			inputs[i][j] = new JTextField();
			inputs[i][j].setText(puzzle[i][j]+"");
			inputs[i][j].addActionListener(new Listener(inputs[i][j]));
			inputs[i][j].addKeyListener(new keylistener());
			inputs[i][j].setName(i+""+j+"");
			add(inputs[i][j]);


		}




}




private class Listener implements ActionListener
{
	public Listener(JTextField input)
	{

			System.out.println(input.getText());
	}


	public void actionPerformed(ActionEvent e)
	{
		
		System.out.println("Something is happening");
		System.out.println(((JTextField) e.getSource()).getName());
		System.out.println(e.getActionCommand());
		
	}	


}


private class keylistener implements KeyListener
{

	   public void keyTyped(KeyEvent e) {
        //System.out.println(e);
    }

    /** Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        //System.out.println(e);
        System.out.println(((JTextField) e.getSource()).getName());
		//System.out.println(e.getActionCommand());

    }

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
        //System.out.println(e);
    }



}



}
