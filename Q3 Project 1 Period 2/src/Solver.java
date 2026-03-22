import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solver {
	
	private String[][] map;
	private int row;
	private int col;
	private int[] firstRow;
	
	
	public Solver(String[][] map, int[] firstRow) {
	    this.map = map;
	    this.firstRow = firstRow;
	    
	}
	
	public int[] findStart() {
		if(firstRow[2] >= 1) {
			for(int row = 0; row < firstRow[0]; row++) {
				for(int col = 0; col < firstRow[1]; col++) {
					if(map[row][col].equals("W")) {
						return new int[] {row, col};
					}
				}
			}
		}
		else {
			for(int row = 0; row < map.length; row++) {
				for(int col = 0; col < map[0].length; col++) {
					if(map[row][col].equals("W")) {
						return new int[] {row, col};
					}
				}
			}
		}
		//if not found:
		return null;
	}
	
	public int[] findGoal() {
		   for(int row = 0; row < map.length; row++) {
		        for(int col = 0; col < map[0].length; col++) {
		            if(map[row][col].equals("|")) {
		                return new int[] {row, col};
		            }
		        }
		    }
		    // if no walkway
		    for(int row = 0; row < map.length; row++) {
		        for(int col = 0; col < map[0].length; col++) {
		            if(map[row][col].equals("$")) {
		                return new int[] {row, col};
		            }
		        }
		    }
		    return null;
	}
	
	public int[] findNextW(int[] pipe) {
	    for (int row = pipe[0] + 1; row < map.length; row++) {
	        for (int col = 0; col < map[0].length; col++) {
	            if (map[row][col].equals("W")) {
	                return new int[]{row, col};
	            }
	        }
	    }
	    return null;
	}

	public int[] findGoalFrom(int[] from) {
	    for (int row = from[0] + 1; row < map.length; row++) {
	        for (int col = 0; col < map[0].length; col++) {
	            if (map[row][col].equals("|")) {
	                return new int[]{row, col};
	            }
	        }
	    }
	    for (int row = from[0] + 1; row < map.length; row++) {
	        for (int col = 0; col < map[0].length; col++) {
	            if (map[row][col].equals("$")) {
	                return new int[]{row, col};
	            }
	        }
	    }
	    return null;
	}
	
	public void Queue() {
		//FIFO
		int rows = map.length;
		int cols = map[0].length;
		int[] start = findStart();
		int[] goal = findGoal();
		
		
        if (start == null) {
            System.out.println("Can't find Start");
            return;
        }
        if (goal == null) {
            System.out.println("Can't find Start");
            return;
        }

    
        int[][] prevRow = new int[rows][cols];
        //for curr[0]
        
		int[][] prevCol = new int[rows][cols];
		//for curr[1]

        boolean[][] visited = new boolean[rows][cols];

        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

            boolean found = false;

          while(true) { 
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
        		  prevRow[wRow][wCol] = curr[0];
         		  prevCol[wRow][wCol] = curr[1];
        	  }
          }
          

            if (!found) {
                System.out.println("doesnt work");
                return;
            }

            int[] step = goal;
            while (step[0] != start[0] || step[1] != start[1]) {
                int pr = prevRow[step[0]][step[1]];
                int pc = prevCol[step[0]][step[1]];
                if (!map[pr][pc].equals("W")) {
                    map[pr][pc] = "+";
                }
                step = new int[]{pr, pc};
            }
            
            if (map[goal[0]][goal[1]].equals("$")) {
                break;
            }
            
           

            start = findNextW(goal);
            goal = findGoalFrom(start);
            queue = new LinkedList<>();
            visited = new boolean[rows][cols];
            prevRow = new int[rows][cols];
            prevCol = new int[rows][cols];
            queue.add(start);
            visited[start[0]][start[1]] = true;
            found = false;
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
		//FILO
		int rows = map.length;
		int cols = map[0].length;
		int[] start = findStart();
		int[] goal = findGoal();
				
				 
		
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


        while(true) { 
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
 		  prevRow[wRow][wCol] = curr[0];
 		  prevCol[wRow][wCol] = curr[1];
 	  }
		}



        if (!found) {
            System.out.println("doesnt work");
            return;
        }

        int[] step = goal;
        while (step[0] != start[0] || step[1] != start[1]) {
            int pr = prevRow[step[0]][step[1]];
            int pc = prevCol[step[0]][step[1]];
            if (!map[pr][pc].equals("W")) {
                map[pr][pc] = "+";
            }
            step = new int[]{pr, pc};
        }
        
        if (map[goal[0]][goal[1]].equals("$")) {
            break;
        }
        
       

        start = findNextW(goal);
        goal = findGoalFrom(start);
        stack = new Stack<>();
        visited = new boolean[rows][cols];
        prevRow = new int[rows][cols];
        prevCol = new int[rows][cols];
        stack.add(start);
        visited[start[0]][start[1]] = true;
        found = false;
      }
    
       	 
	}
	
	public void Opt() {
		
	}
	
	
}
