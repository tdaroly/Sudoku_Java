import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame
{


   private int[][] puzzle =
      {{9, 0, 0, 1, 0, 0, 0, 0, 5},
       {0, 0, 5, 0, 9, 0, 2, 0, 1},
       {8, 0, 0, 0, 4, 0, 0, 0, 0},
       {0, 0, 0, 0, 8, 0, 0, 0, 0},
       {0, 0, 0, 7, 0, 0, 0, 0, 0},
       {0, 0, 0, 0, 2, 6, 0, 0, 9},
       {2, 0, 0, 3, 0, 0, 0, 0, 6},
       {0, 0, 0, 2, 0, 0, 9, 0, 0},
       {0, 0, 1, 9, 0, 4, 5, 7, 0}};
   private int [][] solution =
  																																																																																																																																											{{ 9, 3, 4, 1, 7, 2, 6, 8, 5},
 {7, 6, 5, 8, 9, 3, 2, 4, 1},
 {8, 1, 2, 6, 4, 5, 3, 9, 7},
 {4, 2, 9, 5, 8, 1, 7, 6, 3},
 {6, 5, 8, 7, 3, 9, 1, 2, 4},
 {1, 7, 3, 4, 2, 6, 8, 5, 9},
 {2, 9, 7, 3, 5, 8, 4, 1, 6} ,
 {5, 4, 6, 2, 1, 7, 9, 3, 8},
 {3, 8, 1, 9, 6, 4, 5, 7, 2}};
	private boolean[][] empty =new boolean[9][9];

      private JTextField[][] inputs = new JTextField[9][9];
      private JPanel[][] borders = new JPanel[3][3];
      private JPanel center_grid;
      private JPanel resetbutton;
	  private JTextField reset;
	  private JButton submit;
	  private JButton give_up;
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
	reset.addMouseListener(new mouselistener());
	reset.setName("taher");
	resetbutton.add(reset);
	submit = new JButton("Submit Solution");
	submit.setName("Solution Button");
	submit.addMouseListener(new mouselistener());
	resetbutton.add(submit);
	empty = mask(empty);

	give_up = new JButton("Give Up");
	give_up.addMouseListener(new mouselistener());
	give_up.setName("Give Up Button");
	resetbutton.add(give_up);



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
			inputs[i][j].setForeground(Color.GREEN);
			inputs[i][j].setFont(new Font("Monospaced",Font.BOLD,21));
			inputs[i][j].setFocusable(true);
			inputs[i][j].addActionListener(new Listener(inputs[i][j]));
			inputs[i][j].addKeyListener(new keylistener());
			inputs[i][j].setName(i+""+j+"");
			if(puzzle[i][j]<=0)
			{
				inputs[i][j].setText("");
				inputs[i][j].setEditable(true);			
			}
			else{


			inputs[i][j].setText(puzzle[i][j]+"");
			inputs[i][j].setEditable(false);
				}				
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

private boolean[][] mask(boolean[][] arr)
{
	for(int i=0;i<9;i++)
		for(int j=0;j<9;j++)
		{
			if (puzzle[i][j]<=0)
				arr[i][j]=false;
			else
				arr[i][j]=true;
		}

		return arr;
}


private class mouselistener implements MouseListener
{
	public void mouseClicked(MouseEvent e)
	{
		
		reset.setText("");
		
		String button;
		System.out.println( (e.getSource()).getClass().getSimpleName());
		if((e.getSource()).getClass().getSimpleName().equals("JButton"))
			 button = ((JButton) e.getSource()).getName();		
		else
			button="";
			
        if(button.equals("Give Up Button"))
        {
        	for(int i=0;i<9;i++)
        		for(int j=0;j<9;j++)
        		{
        			inputs[i][j].setText(solution[i][j]+"");
        			inputs[i][j].setEditable(false);
        			if(!empty[i][j])
 						inputs[i][j].setForeground(Color.MAGENTA);
        		}
        }
       
	}
	    
	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}




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
	   	reset.setText("");
        //System.out.println(e);
        System.out.println(e);
         
        
        
        	//e.consume();
        
    }

    /** Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
    
    	int i=0,j=0;
    	String result;
        String index=((JTextField) e.getSource()).getName();

        i = (int) index.charAt(0);
        j = (int) index.charAt(1);

        if(e.getKeyChar()=='c' && index.equals("taher"))
        {
        	
        //System.out.println("This is the start of how it ever ends"+ inputs[i][j].getText());
        for( i=0;i<9;i++)
        	for( j=0;j<9;j++)
        	{
        	

        			result=inputs[i][j].getText();
if(!result.equals("")){
        		if( Integer.parseInt(result) == solution[i][j] )
        		{
        			inputs[i][j].setEditable(false);
        			inputs[i][j].setForeground(Color.GREEN);
        			empty[i][j]=true;
        			
        			
        		}
        		else{
        			inputs[i][j].setForeground(Color.BLUE);
        		}

        	}
					}	


        }
        

if(!index.equals("taher")){
    //    System.out.println(i+"_"+j);
      	int arrow= e.getKeyCode();
      	        //System.out.println(e.getName());
      System.out.println(Integer.parseInt(index.substring(1,2)));
      i = Integer.parseInt(index.substring(0,1));
      j=Integer.parseInt(index.substring(1,2));
          System.out.println(i+"_"+j);
      	switch(arrow)
      	{
      		case 38:
      			for(int k=i-1;k>=0;k--)
      			{	System.out.println("hahah"+"_"+inputs[k][j].getText());
      				System.out.println(k+"____"+j);
      				if(inputs[k][j].getText().equals(""))
      					{	System.out.println("This is the start of how it ever ends");
      						inputs[k][j].requestFocusInWindow();
      						break;
      					}
      			}
      			break;

			case 40:
      			for(int k=i+1;k<=8;k++)
      			{	System.out.println("hahah"+"_"+inputs[k][j].getText());
      				System.out.println(k+"____"+j);
      				if(inputs[k][j].getText().equals(""))
      					{	System.out.println("This is the start of how it ever ends");
      						inputs[k][j].requestFocusInWindow();
      						break;
      					}
      			}
      			break;      	


      		case 39:
      				for(int k=j+1;k<=8;k++)
      			{	System.out.println("hahah"+"_"+inputs[i][k].getText());
      				System.out.println(k+"____"+j);
      				if(inputs[i][k].getText().equals(""))
      					{	System.out.println("This is the start of how it ever ends");
      						inputs[i][k].requestFocusInWindow();
      						break;
      					}
      			}


      			break;

      	
      		case 37:
      				for(int k=j-1;k>=0;k--)
      			{	System.out.println("hahah"+"_"+inputs[i][k].getText());
      				System.out.println(k+"____"+j);
      				if(inputs[i][k].getText().equals(""))
      					{	System.out.println("This is the start of how it ever ends");
      						inputs[i][k].requestFocusInWindow();
      						break;
      					}
      			}


      			break;



      	}



        
        }
      
    }

    
    public void keyReleased(KeyEvent e){}



}



}
