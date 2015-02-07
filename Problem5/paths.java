/*
Sub­Diagonal Paths (prob5)
The Problem
You are to find all of the paths on the bottom diagonal of a n x n grid. The path must only go
from left­to­right or bottom­to­top. Given a dimension of the grid (ex. n = 4), specify the number
of such paths (ex. solution = 14). (Image below is from Wikipedia):

Input
The input consists of a single integer n, the dimension of the square grid, 1 <= n <= 30, on each
line. A zero will indicate the end of the input and should not be processed.

Output
For each input n, you should output the number of paths, as described above, that exist in an nxn
grid, one per line.
Sample Input
1
2
3
4
0
Sample Output
1
2
5
14
*/
//combination: n!/(r!(n-r)!) - order doesnt matter
import java.util.Scanner; 
import java.math.BigInteger;

public class paths
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		/*
		BigInteger n = scan.nextBigInteger();

		while(!n.equals(new BigInteger("0")))
		{
			System.out.println(diagonal(n));

			n = scan.nextBigInteger();
		}
		*/

		BigInteger n = new BigInteger("4");
		BigInteger r = new BigInteger("2");

		System.out.println(combination(n,r));
	}

	public static BigInteger diagonal(BigInteger squares)
	{
		squares = squares.multiply(new BigInteger("2"));

		squares.subtract(new BigInteger("2"));

		if(squares.equals(BigInteger.ONE))
			return BigInteger.ONE; 

		return combination(squares, new BigInteger("2")).divide(new BigInteger("2")).add(new BigInteger("2"));
	}

	
	public static BigInteger combination(BigInteger n, BigInteger r)
	{
		if(n.equals(BigInteger.ONE) || n.equals(BigInteger.ZERO))
			return new BigInteger("1");

		BigInteger numerator = factorial(n);
		BigInteger denominator = factorial(r).multiply(factorial(n.subtract(r)));
		
		return numerator.divide(denominator);

		/*
		if(n-r == 0)//n=r
			return 1;

		if(n-r == n)//r = 0
			return 1;
		*/

	}
	
	public static BigInteger factorial(BigInteger n)
	{	
		if(n.equals(BigInteger.ZERO))
			return new BigInteger("1");
		if(n.equals(BigInteger.ONE))
			return n;
		else return n.multiply(factorial(n.subtract(BigInteger.ONE)));
	}
}