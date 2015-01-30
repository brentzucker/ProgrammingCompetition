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

import java.util.*;

public class marriageProblem
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Map <String, List<String>> proposers_map = new HashMap<String, List<String>>();
		Set <String> matches = new TreeSet<String>();
		ArrayList <String> men = new ArrayList<String>();

		String line = scan.nextLine();

		while(line.length() != 0)
		{	
			String[] raw_arr = line.split(":");
			String[] reviewers = raw_arr[1].split(",");

			//remove whitespace
			for(int i=0; i<reviewers.length; i++)
				reviewers[i] = reviewers[i].trim();

			proposers_map.put(raw_arr[0], Arrays.asList(reviewers));
			men.add(raw_arr[0]);
			line = scan.nextLine();
		}

		//remove everyone thats not a man
		while(men.size() != proposers_map.size()/2)
			men.remove(men.size()-1);

		//prepare map for iteration by creating entry set
		Set s = proposers_map.entrySet();

		//iterate through map to see if any 1st proposal matches 
		Iterator it = s.iterator();

		int count = 0;
		//only iterate through half the list
		while(it.hasNext())
		{
			Map.Entry me = (Map.Entry)it.next();

			List names = (List)me.getValue();
			String first = (String)names.get(0);

			//match equals - if they names and keys match 
			for(int j=0; j<names.size(); j++)
			{
				if(proposers_map.get(names.get(j)).get(j).equals(me.getKey()) && men.contains(me.getKey()))
				{
					//only add matches if they start with a mans name 
					matches.add(me.getKey() + " / " + names.get(j));
					break;
				}
			}
		}

		//print matches
		Iterator i = matches.iterator();
		while(i.hasNext())
			System.out.println(i.next());
		
	}
}