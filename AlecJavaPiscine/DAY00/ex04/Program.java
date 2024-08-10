import java.io.*;
import java.util.*;

class Program
{
	public static int[] total = new int[10];

	public static void main(String[] args)
	{
		if (args.length != 0)
		{
			System.err.println("Error! Execute without arguments!\n");
		}
		ft_scanner();
	}

	public static char[] ft_getUniqueStr(String input)
	{
		char[] s = input.toCharArray();
		int i = -1;
		int index = 0;
		int len = s.length;
		Arrays.sort(s);
		while (++i < len)
		{
			int j = -1;
			while (++j < i)
				if (s[i] == s[j])
					break;
			if (j == i)
				s[index++] = s[i];
		}
		return (Arrays.copyOf(s, index));
	}

	public static void ft_scanner()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("-> ");
		String input = sc.nextLine().toUpperCase();
		System.out.println(input.replaceAll("$", ""));
		char[] s = ft_getUniqueStr(input);
		ft_run(s, input);
	}

	public static void ft_run(char[] s, String input)
	{
		int i = -1;
		int len = s.length;
		int llen = input.length();
		int tmp, index = 0;
		char[] sf = s;
		while (++i < len)
		{
			tmp = llen - input.replaceAll(String.valueOf(s[i]), "").length();
			System.out.println(s[i] + " len: " + tmp);
			if (index < 10)
				total[index++] = tmp;
			else
			{
				sf = ft_assign(sf, tmp, s[i]);
			}
		}
	}

	public static char[] ft_assign(char[] sf, int tmp, char c)
	{
		int i = -1;
		int min = ft_getmin();
		System.out.println("min: " + min);
		return (sf);
	}

	public static int ft_getmin()
	{
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 10; i++)
			if (min > total[i])
				min = total[i];
		return (min);
	}
}
