import java.io.*;
import java.util.Scanner;

class Program
{
	public static void main(String args[])
	{
		try {
			Scanner input = new Scanner(System.in);
			ft_check_arg(args);
			System.out.print("-> ");
			String raw = input.nextLine();
			ft_isprime(ft_isstrnum(raw));
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}
	private static void ft_check_arg(String args[]) throws IllegalArgumentException
	{
		if (args.length != 0)
			throw new IllegalArgumentException("Please do not input any argument");
	}
	private static int ft_isstrnum(String s) throws IllegalArgumentException
	{
		try 
		{
			int i = Integer.parseInt(s);
			if (i <= 1)
				throw new IllegalArgumentException("Please input positive number above 1");
			return (i);
		}
		catch (NumberFormatException e)
		{
			throw new IllegalArgumentException("Not a number format or too large number");
		}
	}
	private static void ft_isprime(int n)
	{
		int i = 5;
		while (i <= Math.sqrt(n))
		{
			if (n % i == 0 || n % (i + 2) == 0 || n % 2 == 0 || n % 3 == 0)
			{
				System.out.println(i + " false");
				return ;
			}
			i += 6;
		}
		System.out.println((i - 6) + " true");
	}
}
