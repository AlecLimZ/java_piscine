import java.io.*;

class Program
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("Please input only one argument number type");
			return ;
		}
		try
		{
			int total = 0;
			Integer.parseInt(args[0]);
			String[] myChar = args[0].split("");
			for (String s : myChar)
				total += Integer.parseInt(s);
			System.out.println(total);
		}
		catch (Exception e)
		{
			System.out.println("Please input number");
		}
	}
}
