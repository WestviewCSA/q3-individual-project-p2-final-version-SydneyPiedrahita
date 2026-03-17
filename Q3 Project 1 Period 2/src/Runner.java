import java.util.Queue;

public class Runner {

	public static void main(String[] args) throws ReadMap.IllegalCharactersFirstLineException {
		// TODO Auto-generated method stub
		ReadMap m = new ReadMap();
		String[][] map = m.readFile("easyMap2");
		Solver s = new Solver(map);
		s.Queue();
		System.out.println(s.findStart());
		s.printMap();
		Queue<int[]> path = s.Queue();
		while(!path.isEmpty()) {
			int[] cell = path.remove();
			System.out.println("[" + cell[0] + ", " + cell[1] + "]");
		}
	}


	
}
