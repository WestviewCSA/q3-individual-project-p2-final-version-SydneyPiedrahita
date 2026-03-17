
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
		int rows = map.length;
		int cols = map[0].length;
		Queue enqueue = new Queue();
		
	}
	
	public void Stack() {
		
	}
	
	public void Opt() {
		
	}
	
	
}
