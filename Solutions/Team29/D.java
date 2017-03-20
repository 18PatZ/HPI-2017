import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int w;
	static int h;
	static boolean[][] map;
	static List<Gold> golds;
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		String[] arr = scanner.nextLine().split(" ");
		w = Integer.parseInt(arr[0]);
		h = Integer.parseInt(arr[1]);
		
		map = new boolean[h][w];
		
		String str = "";
		
		
		for(int i = 0; i < h; i++){
			String s = scanner.nextLine();
			boolean[] entry = new boolean[w];
			for(int j = 0; j < w; j++){
				String c = s.substring(j, j+1);
				str += (c.equals("x") ? "y" : "n");
				entry[j] = c.equals("x");
			}
			str += " ";
			map[i] = entry;
		}
		
		str += "e";
		
		//if(Math.random() < 0.25)
		//	throw new RuntimeException(str);
		
		golds = new ArrayList<Gold>();
		
		List<Integer> sizes = new ArrayList<Integer>();
		
		for(int x = 0; x < w; x++){
			for(int y = 0; y < h; y++){
				int size = check(x, y);
				if(size > 0)
					sizes.add(size);
			}
		}
			
		System.out.println(sizes.size());
		Collections.sort(sizes);
		for(int i = sizes.size()-1; i >= 0; i--)
			System.out.println(sizes.get(i));
		
		System.out.println("");
	}
	
	private static int check(int x, int y){
		if(x >= w || x < 0 || y >= h || y < 0)
			return 0;
		
		if(map[y][x]){
			Gold g = new Gold(x, y);
			if(golds.contains(g))
				return 0; 
			golds.add(g);
			return 1 + check(x+1, y+1) + check(x+1, y) + check(x+1, y-1) + check(x, y-1) + check(x, y+1) + check(x-1, y+1) + check(x-1, y) + check(x-1, y-1);
		}
		else
			return 0;
	}

}

class Gold {
	int x;
	int y;
	
	public Gold(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o){
		return x == ((Gold)o).x && y == ((Gold)o).y;
	}
	
	@Override
	public int hashCode(){
		return 0;
	}
}