/*
Social Pairings (prob3)
The Problem
John is the CEO of a company. He recently organized a social event for two branches of his
company. In order to encourage the attendees to socialize with people from the other branch,
John gave each employee a required task at the gathering: have a conversation with exactly 2
people from the other branch. He emphasized exactly 2 people, since if it was more than 2
people, the conversations may not be as meaningful. Thankfully, each of the branches had the
same number of employees, otherwise it would be impossible for his requirement to be satisfied.
As John sits and watches his employees socialize, being a curious man, he wonders how many
different possible ways there are of the employees conversing given his requirement. John
assigns this question to you, his trusted technical advisor. Since John is the CEO, you do not
want to disappoint him. Can you figure out how many ways there are and satisfy John's
curiosity?
Input
The first line of input will be a single integer t, representing the number of test cases. Then, t
lines follow, each containing a single integer n, 1<=n<=2000, the number of employees at each
branch of the company
Output
For each test case, output the number of possible distinct ways that the two branches can
socialize under the restriction that each employee must socialize with exactly 2 employees from
the other branch. Since this number may be very large, output it modulo 10^8+7.
Sample Input 
5
1 
2 
3 
4 
1932

Sample Output
0
1
6
90
87032144
*/

import java.lang.Math.*;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;
import java.util.Collections;
import java.util.ArrayList;

public class socialPairings
{
	public static DecimalFormat df; 
	public static void main(String[] args)
	{
		TreeMap<String, Integer> person_count = new TreeMap<String, Integer>();
		TreeSet<String> choice_set = new TreeSet<String>();

		int choices = 7;
		String zeros = "";

		for(int i=0; i<choices; i++)
			zeros += "0";

		df = new DecimalFormat(zeros);

		//System.out.println(df.format(1));

		int num_of_possibilities = (int)Math.pow(2, choices);

		for(int i = 0; i< num_of_possibilities; i++)
		{
			//generate choice map, to count how many times each person has been chosen
			if(Integer.bitCount(i) == 1)
			{
				person_count.put(df.format(Integer.parseInt(Integer.toBinaryString(i))), 0);
			}

			//generate possible choices (only 2 per choice)
			if(Integer.bitCount(i) == 2)
			{
				String binary_string = Integer.toBinaryString(i);
				choice_set.add(""+df.format(Integer.parseInt(binary_string)));
			}
		}

		int count_how_many_choices = 1;

		//pick one then remove it from the list
		for(int i=0; i<choices; i++)
		{
			System.out.println(choice_set);
			//make a choice
			count_how_many_choices *= choice_set.size();

			String choice = validChoice(person_count, choice_set);
			choice_set.remove(choice);
			System.out.println("Choice: "+choice);

			//count how many times that person has been chosen
			personCount(person_count, choice);

			removePersonFromChoices(person_count, choice_set);
			
			System.out.println(person_count);
			
		}

		System.out.println("Number of choices "+count_how_many_choices);

		System.out.println(person_count);
		System.out.println(choice_set);
	}

	public static String validChoice(TreeMap<String, Integer> person_count, TreeSet<String> choice_set)
	{
		//a valid choice returns a choice that has zero persons chosen 
		//return last entry will return zero
		if(person_count.size() > 0)
		{
			//if 2 unique 0's
			if((!getFirstKeyByValue(0, person_count).equals("") && !getLastKeyByValue(0, person_count).equals("")) && !getFirstKeyByValue(0, person_count).equals(getLastKeyByValue(0, person_count)))
			{
				String index1 = getFirstKeyByValue(0, person_count);
				String index2 = getLastKeyByValue(0, person_count);

				return selectChoice(index1.indexOf('1'), index2.indexOf('1'), choice_set);
			}
			else if(!getFirstKeyByValue(0, person_count).equals("")) //1 zero
			{
				String index1 = getFirstKeyByValue(0, person_count);
				return selectChoice(index1.indexOf('1'), choice_set);
			}
			else 
			{
				String index1 = getFirstKeyByValue(1, person_count);
				return selectChoice(index1.indexOf('1'), choice_set);
			}
		}
		else
			return "";

	}

	public static void personCount(TreeMap<String, Integer> person_count, String choice)
	{
		while(choice.indexOf('1') != -1)
		{
			int index = choice.indexOf('1');

			StringBuilder replace1 = new StringBuilder(choice);
			replace1.setCharAt(index, '0');
			choice = replace1.toString();

			String zero_string = ""+df.format(0);

			StringBuilder makeKey = new StringBuilder(zero_string);
			makeKey.setCharAt(index, '1');
			String person_key = makeKey.toString();

			int new_count = person_count.get(person_key);
			new_count++;
			person_count.put(person_key, new_count);
		}
	}

	public static void removePersonFromChoices(TreeMap<String, Integer> person_count, TreeSet<String> choice_set)
	{
		//remove person from choice if they have been accounted for twice
		Set set = person_count.entrySet();
		Iterator <Map.Entry> entry_it = set.iterator();

		while(entry_it.hasNext())
		{
			Map.Entry me = entry_it.next();

			if(me.getValue() == 2)
			{
				//remove from choice set
				removeChoice(""+me.getKey(), choice_set);
			}
		}
	}

	public static void removeChoice(String person, TreeSet<String> choice_set)
	{
		//remove the choice from choice set if it has a 1 where the persons index of 1 is
		int indexOf1 = person.indexOf("1");

		Iterator<String> choice_set_it = choice_set.iterator();

		while(choice_set_it.hasNext())
		{	
			String choice = choice_set_it.next();
			
			if(choice.charAt(indexOf1) == '1')
			{
				//remove from iterator and it will remove from set
				choice_set_it.remove();
			}
		}
	}

	public static String selectChoice(int index, int index2, TreeSet<String> choice_set)
	{
		Iterator<String> choice_set_it = choice_set.iterator();
		String ret =""; 

		while(choice_set_it.hasNext())
		{	
			String choice = choice_set_it.next();
			
			if(choice.charAt(index) == '1' && choice.charAt(index2) == '1')
			{
				//remove from iterator and it will remove from set
				ret = choice;
			}
		}

		return ret; 
	}

	public static String selectChoice(int index, TreeSet<String> choice_set)
	{
		Iterator<String> choice_set_it = choice_set.iterator();
		String ret =""; 

		while(choice_set_it.hasNext())
		{	
			String choice = choice_set_it.next();
			
			if(choice.charAt(index) == '1')
			{
				//remove from iterator and it will remove from set
				ret = choice;
			}
		}

		return ret; 
	}

	public static String getFirstKeyByValue(int value, TreeMap<String, Integer> person_count)
	{
		Set set = person_count.entrySet();
		Iterator <Map.Entry> entry_it = set.iterator();

		while(entry_it.hasNext())
		{
			Map.Entry me = entry_it.next();

			if(me.getValue() == value)
			{
				return ""+me.getKey();
			}
		}

		return "";
	}

	public static String getLastKeyByValue(int value, TreeMap<String, Integer> person_count)
	{
		ArrayList<String> keys = new ArrayList<String>(person_count.keySet());

		for(int i=keys.size()-1; i>=0; i--)
		{
			if(person_count.get(keys.get(i)) == value)
			{
				return keys.get(i);
			}
		}

		return "";
	}
}