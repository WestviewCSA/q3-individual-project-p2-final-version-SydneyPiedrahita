import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadMap {
	
	public static void main(String[] arg) throws IllegalCommandLineInputsException {
		ReadMap m = new ReadMap();
	}
	
	public ReadMap() throws IllegalCommandLineInputsException {
		
		readFile("easyMap1");
		System.out.println();
		readFile("easyMap2");
		System.out.println();
		readFile("medMap2");
		System.out.println();
		readCoordinateFile("easyMap1c");
	}
	
	public void readFile(String name) throws ReadMap.IllegalCommandLineInputsException {
		try {
			File file = new File(name);
			Scanner scanner = new Scanner(file);
			int rows = 0;
			int cols = 0;
			int rooms = 0;
			for(int i = 0; i < 3; i++) {
				if(!scanner.hasNextInt()) {
					throw new IllegalCommandLineInputsException("invalid map");
				}
				if(i == 0) {
					 rows = scanner.nextInt();
					
				}
				else if(i == 1) {
					 cols = scanner.nextInt();
				}
				else {
					 rooms = scanner.nextInt();
				}
				
			}
			
			//text based one
			//int rows = scanner.nextInt();
			//int cols = scanner.nextInt();
			//int rooms = scanner.nextInt();
			
				String[][] map = new String[rows*rooms][cols];
				
				for(int row = 0; row < map.length; row++) {
					String str = scanner.next();
					for(int col = 0; col < map[0].length; col++) {
						map[row][col] = String.valueOf(str.charAt(col));
					}
				}
				for(int row = 0; row < map.length; row++) {
					
					for(int col = 0; col < map[0].length; col++) {
						System.out.print(map[row][col]);
					}
					System.out.println();
				}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readCoordinateFile(String name) throws IllegalCommandLineInputsException {
		try {
			File file = new File(name);
			Scanner scanner = new Scanner(file);
			int rows = 0;
			int cols = 0;
			int rooms = 0;
			for(int i = 0; i < 3; i++) {
				if(!scanner.hasNextInt()) {
					throw new IllegalCommandLineInputsException("invalid map");
				}
				if(i == 0) {
					 rows = scanner.nextInt();
					
				}
				else if(i == 1) {
					 cols = scanner.nextInt();
				}
				else {
					 rooms = scanner.nextInt();
				}
				
			}
			
			//coord based one
			//int rows = scanner.nextInt();
			//int cols = scanner.nextInt();
			//int rooms = scanner.nextInt();
			
				String[][] map = new String[rows*rooms][cols];
				
				for(int row = 0; row < map.length; row++) {
					while(scanner.hasNext()) {
					String str = scanner.next();
					int r = scanner.nextInt();
					int c = scanner.nextInt();
					int room = scanner.nextInt();
					if((r+r*room) < map.length && c < map[0].length) {
						map[r+(r*room)][c] = str;
					}
					
					
				}
				}
				for(int row = 0; row < map.length; row++) {
					
					for(int col = 0; col < map[0].length; col++) {
						if(map[row][col]== null) {
							map[row][col] = ".";
						}
						System.out.print(map[row][col]);
					}
					System.out.println();
				}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	//exceptions
	public class IllegalCommandLineInputsException extends Exception {
			public IllegalCommandLineInputsException(String message) {
				super(message);
			}
	}
	
	
	
	
	
	
}









