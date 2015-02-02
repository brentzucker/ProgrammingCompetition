
import java.util.Scanner;
import java.math.BigInteger;

public class PowerNumber
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		String num_str = scan.next();

		while(!num_str.equals("0"))
		{
			BigInteger num = new BigInteger(num_str);

			BigInteger f_num = new BigInteger("0");
			for(int i=0; i<num_str.length(); i++)
			{
				BigInteger this_digit = new BigInteger(""+num_str.charAt(i));
				BigInteger this_operand = this_digit.pow(i+1);
				f_num = f_num.add(this_operand);
			}

			System.out.println(num.toString() + " is "+((num.equals(f_num) ? "" :  "not ")+" a powerful number"));

			num_str = scan.next();
		}
	}
}