/*
Given input on standard input in the following format, solve the stable marriage problem using the traditional algorithm.

Input format:

You may assume there are an equal number of men and women in the problem.

Input will be:
- List of all proposers ("men"), one name per line, followed by a ":", followed by a comma-separated list of proposal reviewers ("women"), which is that man's ranked preference order for marriage partners, most preferred first.
- List of all women, one name per line, followed by a ":", followed by a comma-separated list of men which is that woman's ranked preference order for marriage partners, most preferred first.

You may assume the names contain only capital letters and spaces.  Example input follows:

Conor Marsden: Charlene Fairbairn, Maelys Renaud, Kerri Varley
Neely Albero: Maelys Renaud, Charlene Fairbairn, Kerri Varley
Murray Balboni: Kerri Varley, Charlene Fairbairn, Maelys Renaud
Charlene Fairbairn: Conor Marsden, Neely Albero, Murray Balboni
Maelys Renaud: Neely Albero, Murray Balboni, Conor Marsden
Kerri Varley: Murray Balboni, Neely Albero, Conor Marsden

Output format: list of pairings that form a solution to the stable marriage problem.  Format is "Man / Woman".

Expected output for example input:

Conor Marsden / Charlene Fairbairn
Neely Albero / Maelys Renaud
Murray Balboni / Kerri Varley
*/

import java.util.Scanner;
import java.util.TreeMap; 
import java.util.ArrayList;

public class marriageProblem
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		TreeMap <String, String[]> proposers_map = new TreeMap<String, String[]>();

		String line = scan.nextLine();

		while(line.length() != 0)
		{
			String[] raw_arr = line.split(":");
			String[] reviewers = raw_arr[1].split(",");

			System.out.println(raw_arr[0] + " "+ reviewers[0]);

			proposers_map.put(raw_arr[0], reviewers);
			line = scan.nextLine();
		}
	}
}