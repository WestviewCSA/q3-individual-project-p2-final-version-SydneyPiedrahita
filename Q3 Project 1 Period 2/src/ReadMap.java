import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadMap {
	
	public static void main(String[] arg) {
		ReadMap m = new ReadMap();
	}
	
	public ReadMap() {
		
		readFile("easyMap1");
		
		readFile("easyMap2");
		readFile("medMap2");
	}
	
	public void readFile(String name) {
		try {
			File file = new File(name);
			Scanner scanner = new Scanner(file);
			/*for(int i = 0; i < 3; i++) {
				if(!scanner.hasNextInt()) {
					System.out.println("Invalid Map Characters");
					return;
				}
				scanner.nextInt();
			}
			*/
			int rows = scanner.nextInt();
			int cols = scanner.nextInt();
			int rooms = scanner.nextInt();
			
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
	
	
}
