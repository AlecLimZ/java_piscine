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
			if (index < 10)
				total[index++] = tmp;
			else
			{
				sf = ft_assign(sf, tmp, s[i]);
			}
		}
		sf = ft_comb_sort(sf);
		ft_check(-1, sf);
	}

	public static int getNextGap(int gap)
	{
		gap = (gap * 10) / 13;
		if (gap < 1)
			return (1);
		return (gap);
	}

	public static char[] ft_comb_sort(char[] sf)
	{
		int len = total.length;
		int gap = len;
		boolean swap = true;
		int ntmp;
		char ctmp;

		while (gap != 1 || swap)
		{
			gap = getNextGap(gap);
			swap = false;
			for (int i = 0; i < len - gap; i++)
			{
				if (total[i] < total[i + gap])
				{
					ntmp = total[i];
					ctmp = sf[i];
					total[i] = total[i + gap];
					sf[i] = sf[i + gap];
					total[i + gap] = ntmp;
					sf[i + gap] = ctmp;
					swap = true;
				}
			}
		}
		return (sf);
	}

	public static char[] ft_assign(char[] sf, int tmp, char c)
	{
		int i;
		int min = ft_getmin();
		String str = String.valueOf(sf);
		if (tmp > min)
		{
			i = 10;
			while (--i >= 0)
			{
				if (min == total[i])
				{
					total[i] = tmp;
					str = str.replace(String.valueOf(c), "");
					str = str.replace(sf[i], c);
					sf = str.toCharArray();
					break ;
				}
			}
		}
		return (sf);
	}

	public static void ft_check(int i, char[] s)
	{
		double ns = total[0] / 10.0;
		double height = total[0] / ns;
		int h = (int)height;
		if (++i < 10 && i < s.length)
		{
			System.out.println(" " + total[i]);
			int j = -1;
			while (++j < h)
			{
				System.out.print(" #");
				ft_check(i, s);
			}
		}
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
