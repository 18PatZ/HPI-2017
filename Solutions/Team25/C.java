import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] locs = new int[n];
        int[] vals = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++) {
            locs[i]=in.nextInt();
            vals[i]=in.nextInt();
            max = Math.max(max,vals[i]);
        }
        Queue<Integer> q = new PriorityQueue<Integer>();
        for(int i = 0; i<n; i++) {
            if(vals[i]==max) {
                q.add(locs[i]);
            }
        }
        in.close();
        while(!q.isEmpty()) {
            System.out.println(q.remove());
        }
        System.exit(0);
    }
}