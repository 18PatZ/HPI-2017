import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] coins = new int[n];
        int sum = 0;
        for(int i = 0; i<n; i++) {
            coins[i]=in.nextInt();
            sum += coins[i];
        }
        Arrays.sort(coins);
        in.close();
        int sub = 0;
        int index = n-1;
        while(sub<=sum/2) {
            sub += coins[index];
            index--;
        }
        System.out.println(n-1-index);
        System.exit(0);
    }
}