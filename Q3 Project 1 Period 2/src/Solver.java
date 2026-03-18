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
		
		 
        // safety checks first
        if (start == null) {
            System.out.println("Can't find Start");
            return;
        }
        if (goal == null) {
            System.out.println("Can't find Start");
            return;
        }

    
        int[][][] cameFrom = new int[rows][cols][];

        boolean[][] visited = new boolean[rows][cols];

        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

            boolean found = false;

            // keep going until the queue is empty or we found the goal
          while (!queue.isEmpty()) {

        	  int[] curr = queue.remove();

        	  if (curr[0] == goal[0] && curr[1] == goal[1]) {
        		  found = true;
        		  break;
        	  }

        	  // North
        	  int nRow = curr[0] - 1;
        	  int nCol = curr[1];
        	  if (nRow >= 0 && !map[nRow][nCol].equals("@") && !visited[nRow][nCol]) {
        		  queue.add(new int[]{nRow, nCol});
        		  visited[nRow][nCol] = true;
        		  cameFrom[nRow][nCol] = curr;
        	  }

        	  // South
        	  int sRow = curr[0] + 1;
        	  int sCol = curr[1];
        	  if (sRow < rows && !map[sRow][sCol].equals("@") && !visited[sRow][sCol]) {
        		  queue.add(new int[]{sRow, sCol});
        		  visited[sRow][sCol] = true;
        		  cameFrom[sRow][sCol] = curr;
        	  }

        	  // East
        	  int eRow = curr[0];
        	  int eCol = curr[1] + 1;
        	  if (eCol < cols && !map[eRow][eCol].equals("@") && !visited[eRow][eCol]) {
        		  queue.add(new int[]{eRow, eCol});
        		  visited[eRow][eCol] = true;
        		  cameFrom[eRow][eCol] = curr;
        	  }

        	  // West
        	  int wRow = curr[0];
        	  int wCol = curr[1] - 1;
        	  if (wCol >= 0 && !map[wRow][wCol].equals("@") && !visited[wRow][wCol]) {
        		  queue.add(new int[]{wRow, wCol});
        		  visited[wRow][wCol] = true;
        		  cameFrom[wRow][wCol] = curr;
        	  }
          }

            if (!found) {
                System.out.println("doesnt work");
                return;
            }

            // Now trace back the path from goal to start using cameFrom
            // Start at the goal and keep jumping to "where did I come from"
            int[] step = goal;
            while (step[0] != start[0] || step[1] != start[1]) {
                int[] prev = cameFrom[step[0]][step[1]];

                // mark the step BEFORE the goal with +
                // (we don't overwrite W or $)
                if (!map[prev[0]][prev[1]].equals("W")) {
                    map[prev[0]][prev[1]] = "+";
                }

                step = prev; // walk backwards
            }
        }





		/*Queue<int[]> enQueue = new LinkedList<>();
		Queue<int[]> deQueue = new LinkedList<>();
		enQueue.add(start);
		deQueue.add(start);
		
		
		
		if(start == null) {
			System.out.println("Starting position not found");
			return enQueue;
		}
		if(goal == null) {
			System.out.println("Goal position not found");
			return enQueue;
		}
		
		//map[start[0]][start[1]] = "+";
		int[] curr = start;
		
		while(curr[0] != goal[0] || curr[1] != goal[1]) {
			int[] N = {curr[0]-1, curr[1]};
			int[] S = {curr[0]+1, curr[1]};
			int[] E =  {curr[0], curr[1]+1};
			int[] W =  {curr[0], curr[1]-1};
			
			if(N[0] == goal[0] && N[1] == goal[1]) {
				enQueue.add(N);
				//map[N[0]][N[1]] = "%";
				return enQueue;
			}
			//N[0] != goal[0] && N[1] != goal[1]
			else if(N[0] >= 0 && N[1] >= 0 && !map[N[0]][N[1]].equals("+") && !map[N[0]][N[1]].equals("@")&& !map[N[0]][N[1]].equals("W") ) {
				deQueue.add(N);
				map[N[0]][N[1]] = "+";
			}
			
			if(S[0] == goal[0] && S[1] == goal[1]) {
				enQueue.add(S);
				//map[S[0]][S[1]] = "%";
				return enQueue;
			}
			else if(S[0] >= 0 && S[1] >= 0 && !map[S[0]][S[1]].equals("+") && !map[S[0]][S[1]].equals("@") && !map[S[0]][S[1]].equals("W") ) {
				deQueue.add(S);
				map[S[0]][S[1]] = "+";
			}
			if(E[0] == goal[0] && E[1] == goal[1]) {
				enQueue.add(E);
				//map[E[0]][E[1]] = "%";
				return enQueue;
			}
			else if(E[0] >= 0 && E[1] >= 0 && !map[E[0]][E[1]].equals("+") && !map[E[0]][E[1]].equals("@") && !map[E[0]][E[1]].equals("W") ) {
				deQueue.add(E);
				map[E[0]][E[1]] = "+";
			}
			if(W[0] == goal[0] && W[1] == goal[1]) {
				enQueue.add(W);
				//map[W[0]][W[1]] = "%";
				return enQueue;
			}
			else if(W[0] >= 0 && W[1] >= 0 && !map[W[0]][W[1]].equals("+") && !map[W[0]][W[1]].equals("@") && !map[W[0]][W[1]].equals("W") ) {
				deQueue.add(W);
				map[W[0]][W[1]] = "+";
			}
			
			
			
			curr = deQueue.remove();
			
			enQueue.add(curr);
			
			if(deQueue.isEmpty()) {
				System.out.println("no path");
				return enQueue;
			}
			
		}
		return enQueue;
		*/
		
	
	public void printMap() {
		for(int row = 0; row < map.length; row++) {
			
			for(int col = 0; col < map[0].length; col++) {
				System.out.print(map[row][col]);
			}
			System.out.println();
		}
	}
	
	public void Stack() {
		
	}
	
	public void Opt() {
		
	}
	
	
}
