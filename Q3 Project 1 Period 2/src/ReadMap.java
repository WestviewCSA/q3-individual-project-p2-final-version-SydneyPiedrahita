import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class ReadMap {
	private String[][] map;
	private static final String LEGAL_CHARS = "W$.|@";

	/*public static void main(String[] arg) throws IllegalCharactersFirstLineException {
		
		if(arg.length > 0) {
			System.out.println("yay");
		}
		if(arg[0].equals("--Stack")) {
			
		}
		
		ReadMap m = new ReadMap();
	}
	*/
	public ReadMap(String name, boolean coord) /*throws IllegalFirstLineException,
    IllegalCommandLineInputsException,
    IncompleteMapException */{
		
		/*if(filename.endsWith("c")) {
			readCoordinateFile(filename);
		}
		else {
			readFile(filename);
		}
		*/
		this.map = map;
		if(coord == true) {
			readCoordinateFile(name);
		}else {
			readFile(name);
		}
			
		
	}
	
	public void readFile(String name) /*throws IllegalFirstLineException,
    IllegalMapCharacterException,
    IncompleteMapException */ {
		try {
			File file = new File(name);
			Scanner scanner = new Scanner(file);

			int rows = 0;
			int cols = 0;
			int rooms = 0;
			for(int j = 0; j < 3; j++) {
				/*if(!scanner.hasNextInt()) {
					throw new IllegalFirstLineException("invalid map");
				}
			*/
				if(j == 0) {
					 rows = scanner.nextInt();
					
				}
				else if(j == 1) {
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
			
			Scanner counter = new Scanner(file);
			counter.nextLine(); // skip the first line with the numbers
			int actualRows = 0;
			while (counter.hasNextLine()) {
			    String line = counter.nextLine();
			    if (!line.trim().isEmpty()) {  // only count lines that actually have stuff
			        actualRows++;
			    }
			}
			counter.close();
			// now make the array with the real size
			map = new String[actualRows][cols];
			for(int r = 0; r<map.length; r++) {
               /* if (!scanner.hasNext()) {
                    throw new IncompleteMapException(
                        "Map is incomplete");
                }
                
                
 
                if (line.length() < cols) {
                    throw new IncompleteMapException(
                        "Row is too short");
                }
                */
				String line = scanner.next();
                for (int c = 0; c < cols; c++) {
                    String ch = String.valueOf(line.charAt(c));
                   /* if (LEGAL_CHARS.indexOf(ch) == -1) {
                        throw new IllegalMapCharacterException(
                            "Illegal character");
                    }
                    */
                    map[r][c] = ch;
                }
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void readCoordinateFile(String name) /*throws IllegalFirstLineException */ {
		try {
			File file = new File(name);
			Scanner scanner = new Scanner(file);
			int rows = 0;
			int cols = 0;
			int rooms = 0;
			for(int i = 0; i < 3; i++) {
				/*if(!scanner.hasNextInt()) {
					throw new IllegalFirstLineException("invalid map");
				}\*/
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
	
	public int[] firstLine(String name) {
		int[] firstLineIndexes = new int[3];
		try {
			File file = new File(name);
			Scanner scanner = new Scanner(file);
			for(int i = 0; i < 3; i++) {
				if(i == 0) {
					 firstLineIndexes[0] = scanner.nextInt();
					
				}
				else if(i == 1) {
					 firstLineIndexes[1] = scanner.nextInt();
				}
				else {
					 firstLineIndexes[2] = scanner.nextInt();
				}
				
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return firstLineIndexes;
	}
	
	public String[][] getMap(){
		return map;
	}

	public class IllegalFirstLineException extends Exception {
		public IllegalFirstLineException(String message) {
			super(message);
		}
}

public class IllegalCommandLineInputsException extends Exception {
	public IllegalCommandLineInputsException (String message) {
		super(message);
	}
}

public class IllegalMapCharacterException extends Exception {
	public IllegalMapCharacterException(String message) {
		super(message);
	}
}

public class IncompleteMapException extends Exception {
	public IncompleteMapException(String message) {
		super(message);
	}
}

public class IncorrectMapFormatException extends Exception {
	public IncorrectMapFormatException(String message) {
		super(message);
	}
}
}









