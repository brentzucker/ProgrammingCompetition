import java.util.*;

public class ProblematicKeys
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		int num_data_sets = scan.nextInt();
		for(int i=0; i<num_data_sets; i++)
		{
			//outputs dataset number
			System.out.println(scan.nextInt());

			int num_ds_values = scan.nextInt();

			TreeSet<Integer> factors = new TreeSet<Integer>();
			for(int j=0; j<num_ds_values; j++)
			{
				int num_to_factor = scan.nextInt();
				for(int k = 2; k < num_to_factor; k++)
				{
					if(num_to_factor % k == 0)
					{
						factors.add(k);
						factors.add(num_to_factor/k);
						break;
					}
				}
			}

			int p=0;
			for(Iterator<Integer> it = factors.iterator(); it.hasNext(); p++)
			{	
				System.out.print(it.next() + " ");

				if(p==4)
				{
					System.out.println();
					p=0;
				}
			}
			
			if(p!=0)
				System.out.println();

		}
	}
}