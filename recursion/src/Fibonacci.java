/**
 * Created by mircea on 22.05.17.
 */
public class Fibonacci {

    private static long fibonacciAcc(long prev, long curr, int n)
    {
        if (n == 1)
            return curr;

        return fibonacciAcc(curr, prev + curr, n - 1);
    }

    private static long fibonacciIterative(int n) {

        if ( n <= 1 )
            return n;

        long prev = 0;
        long curr = 1;
        long next;

        for (int i = 0; i <= n-2; i++) {
            next = curr + prev;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static long fibonacci(int n)
    {
        return (n < 2) ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long fasterFibonacci(final int n)
    {
        if ( n <= 1 )
            return n;

        return fibonacciAcc(0, 1, n);
    }

    public static void main(String[] args) {
        for ( int counter = 0; counter <= 50; counter++ )
            System.out.printf( "Fibo(%d) = %d\n", counter, fasterFibonacci(counter) );
    }
}
