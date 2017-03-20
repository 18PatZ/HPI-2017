import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		int total = 0;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			int v = Integer.parseInt(scanner.nextLine());
			total += v;
			arr[i] = v;
		}
		Arrays.sort(arr);
		int min = (int)Math.ceil(total / 2.0);
		int curr = 0;
		for(int i = n-1; i >= 0; i--){
			curr += arr[i];
			if(curr >= min){
				System.out.println(n - i);
				return;
			}
				
		}
	}

}