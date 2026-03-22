
public class MazeException {
	//exceptions
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
