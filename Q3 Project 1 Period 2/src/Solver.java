import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    
        int[][] prevRow = new int[rows][cols];
		int[][] prevCol = new int[rows][cols];

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
        		  prevRow[nRow][nCol] = curr[0];
      		      prevCol[nRow][nCol] = curr[1];
        	  }

        	  // South
        	  int sRow = curr[0] + 1;
        	  int sCol = curr[1];
        	  if (sRow < rows && !map[sRow][sCol].equals("@") && !visited[sRow][sCol]) {
        		  queue.add(new int[]{sRow, sCol});
        		  visited[sRow][sCol] = true;
        		  prevRow[sRow][sCol] = curr[0];
     		     prevCol[sRow][sCol] = curr[1];
        	  }

        	  // East
        	  int eRow = curr[0];
        	  int eCol = curr[1] + 1;
        	  if (eCol < cols && !map[eRow][eCol].equals("@") && !visited[eRow][eCol]) {
        		  queue.add(new int[]{eRow, eCol});
        		  visited[eRow][eCol] = true;
        		  prevRow[eRow][eCol] = curr[0];
          		  prevCol[eRow][eCol] = curr[1];
        	  }

        	  // West
        	  int wRow = curr[0];
        	  int wCol = curr[1] - 1;
        	  if (wCol >= 0 && !map[wRow][wCol].equals("@") && !visited[wRow][wCol]) {
        		  queue.add(new int[]{wRow, wCol});
        		  visited[wRow][wCol] = true;
        		  prevRow[nRow][nCol] = curr[0];
         		  prevCol[nRow][nCol] = curr[1];
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
           	 int pr = prevRow[step[0]][step[1]];
           	    int pc = prevCol[step[0]][step[1]];
           	    if (!map[pr][pc].equals("W")) {
           	        map[pr][pc] = "+";
           	    }
           	    step = new int[]{pr, pc};
            }
              
        }
		
	
	public void printMap() {
		for(int row = 0; row < map.length; row++) {
			
			for(int col = 0; col < map[0].length; col++) {
				System.out.print(map[row][col]);
			}
			System.out.println();
		}
	}
	
	public void Stack() {
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

		    
		int[][] prevRow = new int[rows][cols];
		int[][] prevCol = new int[rows][cols];

		boolean[][] visited = new boolean[rows][cols];

		        
		Stack<int[]> stack = new Stack<>();
		stack.push(start);
		visited[start[0]][start[1]] = true;

		boolean found = false;

		// keep going until the queue is empty or we found the goal
		while (!stack.isEmpty()) {

		int[] curr = stack.pop();

		if (curr[0] == goal[0] && curr[1] == goal[1]) {
		     found = true;
		     break;
		}

		// North
		int nRow = curr[0] - 1;
		int nCol = curr[1];
		if (nRow >= 0 && !map[nRow][nCol].equals("@") && !visited[nRow][nCol]) {
		    stack.push(new int[]{nRow, nCol});
		    visited[nRow][nCol] = true;
		    prevRow[nRow][nCol] = curr[0];
		    prevCol[nRow][nCol] = curr[1];
		}

		// South
		int sRow = curr[0] + 1;
		int sCol = curr[1];
		if (sRow < rows && !map[sRow][sCol].equals("@") && !visited[sRow][sCol]) {
		     stack.push(new int[]{sRow, sCol});
		     visited[sRow][sCol] = true;
		     prevRow[sRow][sCol] = curr[0];
		     prevCol[sRow][sCol] = curr[1];
		}
		 // East
  	   int eRow = curr[0];
  	   int eCol = curr[1] + 1;
  	   if (eCol < cols && !map[eRow][eCol].equals("@") && !visited[eRow][eCol]) {
  		  stack.push(new int[]{eRow, eCol});
  		  visited[eRow][eCol] = true;
  		  prevRow[eRow][eCol] = curr[0];
  		  prevCol[eRow][eCol] = curr[1];
  	   }

 	  // West
 	  int wRow = curr[0];
 	  int wCol = curr[1] - 1;
 	  if (wCol >= 0 && !map[wRow][wCol].equals("@") && !visited[wRow][wCol]) {
 		  stack.push(new int[]{wRow, wCol});
 		  visited[wRow][wCol] = true;
 		  prevRow[nRow][nCol] = curr[0];
 		  prevCol[nRow][nCol] = curr[1];
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
    	 int pr = prevRow[step[0]][step[1]];
    	    int pc = prevCol[step[0]][step[1]];
    	    if (!map[pr][pc].equals("W")) {
    	        map[pr][pc] = "+";
    	    }
    	    step = new int[]{pr, pc};
     }
       	 
	}
	
	public void Opt() {
		
	}
	
	
}
