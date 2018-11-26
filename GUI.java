import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame
{


   private int[][] puzzle =
      {{5, 3, 4, 6, 7, 8, 9, 1, 2},
       {6, 7, 2, -1, 9, 5, 3, 4, 8},
       {-1, 9, 8, 3, 4, 2, -1, 6, 7},
       {8, 5, -1, 7, 6, 1, 4, 2, 3},
       {4, 2, 6, -1, 5, 3, 7, 9, 1},
       {7, 1, 3, 9, 2, 4, 8, 5, 6},
       {9, 6, 1, 5, 3, 7, 2, 8, 4},
       {2, 8, 7, 4, 1, -1, 6, 3, 5},
       {3, 4, 5, 2, 8, 6, -1, 7, 9}};

      private JTextField[][] inputs = new JTextField[9][9];
      private JPanel[][] borders = new JPanel[3][3];
      private JPanel center_grid;
      private JPanel resetbutton;
      private JTextField reset;
public GUI()
{

	super();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//setLayout(new GridLayout(3,3));
	setLayout(new BorderLayout());
	setSize(900,900);	
	center_grid=new JPanel();
	center_grid.setLayout(new GridLayout(3,3));
	add(center_grid,BorderLayout.CENTER);
	resetbutton = new JPanel();
	add(resetbutton,BorderLayout.SOUTH);	
	reset = new JTextField("Type 'c' to Check work");
	reset.addKeyListener(new keylistener());
	reset.setName("taher");
	resetbutton.add(reset);
	

//	JPanel pane = new JPanel();
//	pane.setBorder(BorderFactory.createLineBorder(Color.black));

for(int i=0;i<3;i++)
	for(int j=0;j<3;j++)
	{
		borders[i][j] = new JPanel();
		borders[i][j].setLayout(new GridLayout(3,3));
		borders[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
		center_grid.add(borders[i][j]);
	}


	for(int i=0;i<9;i++)
		for(int j=0;j<9;j++)
		{
			

			

			inputs[i][j] = new JTextField();
			inputs[i][j].setBorder(BorderFactory.createLineBorder(new Color(214,212,247)));
			inputs[i][j].setBackground(new Color(240,240,240));
			inputs[i][j].setHorizontalAlignment(JTextField.CENTER);
			inputs[i][j].setFont(new Font("Monospaced",Font.BOLD,21));
			inputs[i][j].setFocusable(true);
			inputs[i][j].addActionListener(new Listener(inputs[i][j]));
			inputs[i][j].addKeyListener(new keylistener());
			inputs[i][j].setName(i+""+j+"");
			if(puzzle[i][j]<0)
			{
				inputs[i][j].setText("");
				inputs[i][j].setEditable(true);			
			}
			else{


			inputs[i][j].setText(puzzle[i][j]+"");
			inputs[i][j].setEditable(false);
				}
			
			//borders[(i)%3][(j)%3].add(inputs[i][j]);


		}


for(int i=0;i<9;i++)
	for(int j=0;j<9;j++)
	{
		
		
		if(i>=0 && i<3 && j>=0 && j<3)
			borders[0][0].add(inputs[i][j]);
		if(i>=0 && i<3 && j>=3 && j<6)
			borders[0][1].add(inputs[i][j]);
		if(i>=0 && i<3 && j>=6 && j<9)
			borders[0][2].add(inputs[i][j]);



		if(i>=3 && i<6 && j>=0 && j<3)
			borders[1][0].add(inputs[i][j]);
		if(i>=3 && i<6 && j>=3 && j<6)
			borders[1][1].add(inputs[i][j]);
		if(i>=3 && i<6 && j>=6 && j<9)
			borders[1][2].add(inputs[i][j]);



		if(i>=6 && i<9 && j>=0 && j<3)
			borders[2][0].add(inputs[i][j]);
		if(i>=6 && i<9 && j>=3 && j<6)
			borders[2][1].add(inputs[i][j]);
		if(i>=6 && i<9 && j>=6 && j<9)
			borders[2][2].add(inputs[i][j]);
	}




//add(pane);
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
//    	inputs[2][6].requestFocusInWindow();

        //System.out.println(e);
        System.out.println(e);
          if(e.getKeyChar() == 'a')
        {
        	inputs[2][6].requestFocusInWindow();
        	//e.consume();
        }
    }

    /** Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
    //   inputs[2][6].requestFocusInWindow();

        String index=((JTextField) e.getSource()).getName();
        System.out.println(index.charAt(0)+"_"+index.charAt(1));
        System.out.println(((JTextField) e.getSource()).getName());
        int i = (int) index.charAt(0);
        int j = (int) index.charAt(1);
      
    }

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
       // inputs[2][6].requestFocusInWindow();
    }



}



}
