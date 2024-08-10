import java.io.*;
import java.util.Scanner;

class Program
{

	public static String raw = " ";
	public static void main(String[] args)
	{
		if (args.length > 0)
		{
			System.err.println("Execute java only");
			System.exit(1);
		}
		try
		{
			ft_run();
		}
		catch (IllegalArgumentException e)
		{
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}

	public static boolean ft_scan()
	{
		Scanner input = new Scanner(System.in);

		System.out.print("-> ");
		raw = input.nextLine();
		if (raw.equals("42"))
			return (false);
		return (true);
	}

	public static void ft_run() throws IllegalArgumentException
	{
		int max_week = 18, week_no = 0, m = 0, p = 0;
		int[] min_box = new int[18];
		int[] wk = new int[18];

		while (max_week > 0)
		{
			if (!ft_scan())
				break;
			wk[p] = ft_isWeek(raw);
			if (week_no > wk[p])
				 throw new IllegalArgumentException("Error: Wrong data input order!");
			week_no = wk[p++];

			if (!ft_scan())
				break;
			min_box[m++] = ft_isFiveTest(raw);

			max_week--;
		}
		ft_stat(min_box, wk, 18 - max_week);
	}

	public static int ft_isFiveTest(String s) throws IllegalArgumentException
	{
		String[] sp = s.split(" ", -2);
		int min = 10;
		int tmp = 0;
		if (sp.length != 5)
			throw new IllegalArgumentException("Error: Please input five tests only on row!");
		for (String a : sp)
		{
			ft_isNumber(a);
			tmp = Integer.parseInt(a);
			if (tmp == 0 || tmp > 9)
				throw new IllegalArgumentException("Error: Please input range 1 ~ 9 each on row only");
			min = min > tmp ? tmp : min;
		}
		return (min);
	}

	public static int ft_isNumber(String s) throws IllegalArgumentException
	{
		int i;
		try
		{
			i = Integer.parseInt(s);
			if (i < 0)
				throw new IllegalArgumentException("Negative number! Please input positive number");
		}
		catch (NumberFormatException e)
		{
			throw new IllegalArgumentException("Not a number! Please input only positive number");
		}
		return (i);
	}

	public static int ft_isWeek(String s) throws IllegalArgumentException
	{
		String[] sp = s.split(" ", -2);
		if (!sp[0].toUpperCase().equals("WEEK"))
			throw new IllegalArgumentException("Error \"Week\" spelling!");
		if (sp.length != 2)
			throw new IllegalArgumentException("Error: Please input \"Week X\" only");
		return ft_isNumber(sp[1]);
	}

	public static void ft_stat(int[] m, int[] w, int max)
	{
		int i = 0;
		while (i < max)
		{
			System.out.print("Week " + w[i] + " ");
			for (int k = 0; k < m[i]; k++)
				System.out.print("=");
			System.out.println(">");
			i++;
		}
	}
}
