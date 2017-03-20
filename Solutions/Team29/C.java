import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());
		
		List<Pair> list = new ArrayList<Pair>();
		for(int i = 0; i < n; i++){
			String[] arr = scanner.nextLine().split(" ");
			list.add(new Pair(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
		}
		
		Collections.sort(list);
		
		int max = list.get(list.size()-1).v;
		
		
		List<Integer> out = new ArrayList<Integer>();
		
		
		for(int i = n-1; i >= 0; i--)
			if(list.get(i).v == max)
				out.add(list.get(i).l);
		
		Collections.sort(out);
		
		for(int i : out)
			System.out.println(i);
	}

}


class Pair implements Comparable<Pair> {
	int l;
	Integer v;
	
	public Pair(int l, int v){
		this.l = l;
		this.v = v;
	}

	@Override
	public int compareTo(Pair o) {
		return v.compareTo(o.v);
	}
}