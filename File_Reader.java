import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class File_Reader
{

private int[][] puzzle ;
private int[][] solution;
private Scanner reader;
 
	
	public File_Reader(String filename)
	{
				puzzle = new int[9][9];
				solution = new int[9][9];


				try{
					readInput(filename);

				}
				catch(FileNotFoundException e)
				{
					System.out.println(e.getMessage());
				}



	}


	public void readInput(String filename) throws FileNotFoundException
	{
		reader = new Scanner(new FileInputStream(filename));


		//System.out.println(reader.nextLine());
	
					
			
				for(int j = 0; j < 9; j++)
					for(int i = 0; i < 9; i++)
					{
						puzzle[i][j] = reader.nextInt();
					}
			


				for(int j = 0; j < 9; j++)
					{System.out.println();
					for(int i = 0; i < 9; i++)
					{
						System.out.print(puzzle[i][j]+"");
					}
}
		reader.close();

	}



public static void main(String args[])
{
	File_Reader puzzle = new File_Reader("samplesudoku1.txt");
	
}

}
