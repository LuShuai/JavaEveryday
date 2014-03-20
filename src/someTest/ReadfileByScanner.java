package someTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadfileByScanner
{

	
	public static void main(String[] args)
	{
		File f = new File("data/two_numbers");
		
		try
		{
			Scanner s = new Scanner(f);
			while(s.hasNextInt())
			{
				int i = s.nextInt();
				System.out.println("" + i);
				
			}
		} 
		catch (FileNotFoundException e)
		{
		
			e.printStackTrace();
		}

	}

}
