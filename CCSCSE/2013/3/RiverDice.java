// http://www.ccscse.org/programming_contest/problems/progcont_2013.pdf
import java.util.Scanner;

public class RiverDice {

    static int[][] dynamic = new int[17][13];

    public static int f(int n, int k) {
        if(dynamic[n][k] != -1) {
            return dynamic[n][k];
        }
        if(k == 0) {
            return 0;
        }
        if(k == 1) {
            return n;
        }

        int sum = 0;
        for(int x = 0; x <= n-1; x++) {
            sum += f(n-x, k-1);
        }

        dynamic[n][k] = sum;
        return sum;
    }

    public static void main(String[] args) {

        for (int i = 0; i < dynamic.length; i++) {
            for(int j = 0; j < dynamic[0].length; j++) {
                dynamic[i][j] = -1;
            }
        }

        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        
        // river role possibliity
        // f(n,k) = sum x=0 to n-1 f(n-x0 * k-1)
        // f(n, 2) = sum from x=1 to n of x
        // f(n, 1) = n
        // f(n, 0) = 0


        for (int c = 0; c < cases; c++) {
            int n = scan.nextInt(), 
                k = scan.nextInt();
            
            int numerator = f(k,n);
            int denominator = (int) Math.pow(k,n);
            boolean done = false;

            while(!done) {
                done = true;
                for(int i = 2; i <= Math.min(numerator,denominator); i++) {
                    if(numerator%i == 0 && denominator%i == 0) {
                        numerator /= i;
                        denominator /= i;
                        done = false;
                    }
                }
            }
            System.out.println(""+numerator+" / "+denominator);
        }
    }
}