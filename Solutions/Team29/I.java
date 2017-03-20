import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int w;
	static int h;
	static int[][] map;
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		String[] arr = scanner.nextLine().split(" ");
		w = Integer.parseInt(arr[0]);
		h = Integer.parseInt(arr[1]);
		
		map = new int[h][w];
		
		String str = "";
		
		
		for(int i = 0; i < h; i++){
			String s = scanner.nextLine();
			
			int[] entry = new int[w];
			for(int j = 0; j < w; j++){
				String c = s.substring(j, j+1);
				if(c.equals(" "))
					continue;
				str += c;
				entry[j/2] = Integer.parseInt(c);
			}
			str += " ";
			map[i] = entry;
		}
		
		str += "e";
		
		if(Math.random() < 0.25)
			throw new RuntimeException(str);
		
	}
}