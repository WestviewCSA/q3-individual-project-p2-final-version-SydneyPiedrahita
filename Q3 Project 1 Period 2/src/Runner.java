import java.util.Queue;

public class Runner {

	public static void main(String[] args) throws ReadMap.IllegalCharactersFirstLineException {
		// TODO Auto-generated method stub
		ReadMap m = new ReadMap();
		String[][] map = m.readFile("easyMap2");
		int[] firstLine = m.firstLine("easyMap2");
		for(int i = 0; i < firstLine.length; i++) {
			System.out.print(firstLine[i] + " ");
		}
		Solver s = new Solver(map, firstLine);

		s.Queue();
		System.out.println();
		s.printMap();
		System.out.println();
		System.out.println();

		String[][] map2 = m.readFile("medMap2");
		int[] firstLine2 = m.firstLine("medMap2");
		for(int i = 0; i < firstLine2.length; i++) {
			System.out.print(firstLine2[i] + " ");
		}
		System.out.println();
		Solver s2 = new Solver(map2, firstLine2);
		s2.Stack();
		System.out.println();
		s2.printMap();
		
		System.out.println();
		System.out.println();

		String[][] map3 = m.readFile("medMap1");
		int[] firstLine3 = m.firstLine("medMap1");
		for(int i = 0; i < firstLine3.length; i++) {
			System.out.print(firstLine3[i] + " ");
		}
		
		Solver s3 = new Solver(map3, firstLine3);
		
		System.out.println();
		s3.Stack();
		System.out.println();
		s3.printMap();
	}


	
}
