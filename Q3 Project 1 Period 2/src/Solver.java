import java.util.LinkedList;
import java.util.Queue;

public class Solver {
	
	private String[][] map;
	private int row;
	private int col;
	
	
	public Solver(String[][] map) {
	    this.map = map;
	    
	}
	
	public int[] findStart() {
		for(int row = 0; row < map.length; row++) {
			for(int col = 0; col < map[0].length; col++) {
				if(map[row][col].equals("W")) {
					return new int[] {row, col};
				}
			}
		}
		//if not found:
		return null;
	}
	
	public int[] findGoal() {
		for(int row = 0; row < map.length; row++) {
			for(int col = 0; col < map[0].length; col++) {
				if(map[row][col].equals("$")) {
					return new int[] {row, col};
				}
			}
		}
		//if not found:
		return null;
	}
	
	public void Queue() {
		//FIFO
		int rows = map.length;
		int cols = map[0].length;
		int[] start = findStart();
		int[] goal = findGoal();
		if(start == null) {
			System.out.println("Starting position not found");
			return;
		}
		
		Queue<int[]> enQueue = new LinkedList<>();
		Queue<int[]> deQueue = new LinkedList<>();
		enQueue.add(start);
		
		map[start[0]][start[1]] = "+";
		
		int[] curr = start;
		int i = 0;
		while(curr[i] != goal[0] && curr[i+1] != goal[1]) {
			int[] N = {curr[i]-1, curr[i+1]};
			int[] S = {curr[i]+1, curr[i+1]};
			int[] E =  {curr[i], curr[i+1]+1};
			int[] W =  {curr[i], curr[i+1]-1};
			if(N[0] != goal[0] && N[1] != goal[1]) {
				deQueue.add(N);
			}
			else if(N[0] == goal[0] && N[1] == goal[1]) {
				curr = N;
				enQueue.add(curr);
				map[N[0]][N[1]] = "+";
				return;
			}
			if(S[0] != goal[0] && S[1] != goal[1]) {
				deQueue.add(S);
			}
			else if(S[0] == goal[0] && S[1] == goal[1]) {
				curr = S;
				enQueue.add(curr);
				map[S[0]][S[1]] = "+";
				return;
			}
			if(E[0] != goal[0] && E[1] != goal[1]) {
				deQueue.add(E);
			}
			else if(E[0] == goal[0] && E[1] == goal[1]) {
				curr = E;
				enQueue.add(curr);
				map[E[0]][E[1]] = "+";
				return;
			}
			if(W[0] != goal[0] && W[1] != goal[1]) {
				deQueue.add(W);
			}
			else if(W[0] == goal[0] && W[1] == goal[1]) {
				curr = W;
				enQueue.add(curr);
				map[W[0]][W[1]] = "+";
				return;
			}
			
			i+=2;
			curr = deQueue.remove();
			enQueue.add(curr);
			map[curr[i]][curr[i+1]] = "+";
		}
		map[curr[i]][curr[i+1]]	= "+";
		return;
	}
	
	public void printMap() {
		for(int row = 0; row < map.length; row++) {
			for(int col = 0; col < map[0].length; col++) {
				System.out.println(map[row][col]==null ? "." : map[row][col]);
			}
			System.out.println();
		}
	}
	
	public void Stack() {
		
	}
	
	public void Opt() {
		
	}
	
	
}
