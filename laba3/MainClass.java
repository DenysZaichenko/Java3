import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClass{
    private static final Logger logger = Logger.getLogger(MainClass.class.getName());
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the sequence number of the Fibonacci number: ");
        int n = scanner.nextInt();
        scanner.close();

        CompletableFuture<Integer> futureResult = CompletableFuture.supplyAsync(() -> {
            return fibonacci(n);
        });

        logger.log(Level.INFO, "We are waiting for the result of the calculation...");
        int result = futureResult.join();

        logger.log(Level.INFO, "{0}th Fibonacci number = {1}", new Object[]{n, result});
    }
    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }    
}