import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class DataHandler
{
	public static void addToList(LinkedList<String> list, String filepath, String newListItem)
	{
		list.clear();
		BufferedReader br = null;
		
		if(newListItem != null) //writing to file
		{
			PrintWriter pw = null;
			try
			{
				pw = new PrintWriter(new BufferedWriter(new FileWriter(filepath, true)));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			pw.println(newListItem);
			pw.close();
			addToList(list, filepath, null);
		}
		else //reading file to linkedlist
		{
			try
			{
				br = new BufferedReader(new FileReader(new File(filepath)));
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			
			String url = null;
			
			do
			{
				try
				{
					url = br.readLine();
					if(url != null)
						list.add(url);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			} while(url != null);
		}
		
	}
	
	public static void removeFromList(LinkedList<String> list, String filepath, int entryno)
	{
		list.remove(entryno - 1); //minus 1 because entries actually start at 0
		
		//write updated list to file
		PrintWriter pw = null;
		try
		{
			pw = new PrintWriter(filepath);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		for(int i = 0; i < list.size(); i++)
			pw.println(list.get(i));
		
		pw.close();
	}
	
	public static void updateEntry(LinkedList<String> list, String filepath, int entryno, String newEntry)
	{
		list.set(entryno - 1, newEntry); //replacing list entry
		
		//write updated list to file
		PrintWriter pw = null;
		try
		{
			pw = new PrintWriter(filepath);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		for(int i = 0; i < list.size(); i++)
			pw.println(list.get(i));
		
		pw.close();
	}
}
