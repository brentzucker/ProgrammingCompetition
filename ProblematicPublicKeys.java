import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Set; 
import java.util.TreeSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class ProblematicPublicKeys
{
	public static class DataSet
	{
		public int num;
		public int num_of_data_values; 
		public ArrayList <PublicKey> public_keys = new ArrayList<PublicKey>();
		public Set<Integer> private_keys = new TreeSet<Integer>();
	}

	public static class PublicKey
	{
		public int value;
		public ArrayList <Integer> private_key = new ArrayList<Integer>();
	}

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		int data_sets = scan.nextInt();
		List<DataSet> data_sets_list = new LinkedList<DataSet>();

		//read in data
		for(int i=0; i<data_sets; i++)
		{
			DataSet current_data_set = new DataSet();
			current_data_set.num = scan.nextInt();
			current_data_set.num_of_data_values = scan.nextInt();

			//read in each public key
			while(current_data_set.public_keys.size() < current_data_set.num_of_data_values)
			{
				int raw_public_key = scan.nextInt(); 

				PublicKey current_key = new PublicKey();
				current_key.value = raw_public_key;

				//find the private keys and assign them to the current key
				divisiblePrime(current_key);

				//add the private keys to the datasets treeset of private_keys
				current_data_set.private_keys.add(current_key.private_key.get(0));
				current_data_set.private_keys.add(current_key.private_key.get(1));

				//add the public key to the current data set
				current_data_set.public_keys.add(current_key);
			}

			//add the current data set to the list of data sets
			data_sets_list.add(current_data_set);
		}

		//output data
		Iterator it = data_sets_list.iterator();

		while(it.hasNext())
		{
			DataSet current_data_set = (DataSet)it.next();

			//print data set number
			System.out.println(current_data_set.num);

			//print private keys
			printKeys(current_data_set.private_keys);
		}
	}

	public static boolean isPrime(int num)
	{
		if(num%2 == 0)
			return false;
		for(int i=3; i*i <= num; i+=2)
			if(num%i == 0)
				return false; 

		return true; 
	}

	public static void divisiblePrime(PublicKey pk)
	{
		for(int i=3; i*i <= pk.value; i+=2)
		{
			//if the number is prime and its divided evenly into the public key then it must be a private key and the other dividend must be a private key
			if(isPrime(i) && pk.value % i == 0)
			{
				pk.private_key.add(i);
				pk.private_key.add(pk.value/i);
			}
		}
	}

	//prints at most 5 keys per line
	public static void printKeys(Set<Integer> pk)
	{
		Iterator it = pk.iterator();
		ArrayList<String> output = new ArrayList<String>(); 
		String line = "";
		int count = 0;

		while(it.hasNext())
		{
			int key = (int)it.next();
			count++;

			if((count-1) % 5 == 0 && (count-1) != 0 )
			{
				//new line
				output.add(line.trim());
				line = ""+key;
			}
			else
			{
				line += key + " ";
			}
		}

		//add the last line if it hasnt been added
		if((output.size() == 0) || !(output.get(output.size()-1).equals(line.trim())))
			output.add(line.trim());

		//prints out output
		Iterator i = output.iterator();
		while(i.hasNext())
			System.out.println(i.next());
	}
}