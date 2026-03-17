
public class Runner {

	public static void main(String[] args) throws ReadMap.IllegalCharactersFirstLineException {
		// TODO Auto-generated method stub
		ReadMap m = new ReadMap();
		String[][] map = m.readFile("easyMap2");
		Solver s = new Solver(map);
		s.Queue();
		s.printMap();
	}

}
