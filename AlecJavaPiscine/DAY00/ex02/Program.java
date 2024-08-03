import java.io.*;
import java.util.Scanner;

class Program
{
	public static void main(String args[])
	{
		try {
			ft_check_arg(args);
			ft_run();
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
	private static boolean ft_isprime(int n)
	{
		int i = 3;
		int tmp = n;
		if (n == 2 || n == 3)
			return true;
		n = n < 10 ? n : (int)Math.sqrt(n);
		n = n % 2 == tmp % 2 ? n : tmp;
		while (i <= n)
		{
			if (n % i == 0 || n % 2 == 0)
			{
				return false;
			}
			i += 3;
		}
		return true;
	}

	private static void ft_run() throws IllegalArgumentException
	{
		Scanner input = new Scanner(System.in);
		int count = 0;
		int sum;
		String four2 = "start";

		while (!four2.equals("42"))
		{
			System.out.print("-> ");
			String raw = input.nextLine();
			sum = ft_sumdigit(raw);
			if (sum < 2)
				continue;
			if (ft_isprime(sum) == true)
				count++;
			if (raw.length() > 1)
				four2 = raw.substring(raw.length() - 2);
		}
		System.out.println("Count of coffee-request - " + count);
	}

	private static int ft_sumdigit(String str)
	{
		int total = 0;
		try
		{
			Integer.parseInt(str);
			String[] myChar = str.split("");
			for (String s : myChar)
				total += Integer.parseInt(s);
		}
		catch (NumberFormatException e)
		{
			throw new IllegalArgumentException("Not a number format or too large number");
		}
		return (total);
	}
}
