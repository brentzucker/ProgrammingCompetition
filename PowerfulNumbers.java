import java.util.*;
import java.math.BigInteger;
public class Problem1 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String input;
		
		while(!((input = scanner.nextLine()).equals("0")))
		{
			BigInteger total = new BigInteger("0");
			double add;
			
			for(int i = 0; i < input.length(); i++)
			{
				add = (Math.pow(Double.parseDouble(Character.toString(input.charAt(i))), i + 1));
				total = total.add(new BigInteger(Integer.toString((int)add)));
			}
			
			if(total.intValue() == (new BigInteger(input).intValue()))
				System.out.print(input + " is a powerful number.");
			else
				System.out.print(input + " is not a powerful number.");
		}
	}
}
