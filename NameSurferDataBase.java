import java.io.*;

/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

public class NameSurferDataBase implements NameSurferConstants {
	String Filename;
	/* Constructor: NameSurferDataBase(filename) */
	/**
	 * Creates a new NameSurferDataBase and initializes it using the
	 * data in the specified file.  The constructor throws an error
	 * exception if the requested file does not exist or if an error
	 * occurs as the file is being read.
	 */
	public NameSurferDataBase(String filename) {
		Filename = filename;
	}
	
	/* Method: findEntry(name) */
	/**
	 * Returns the NameSurferEntry associated with this name, if one
	 * exists.  If the name does not appear in the database, this
	 * method returns null.
	 */
	public NameSurferEntry findEntry(String name) {
		BufferedReader NameFinder;
		String Line = null;
		try {
			NameFinder = new BufferedReader(new FileReader(Filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
		try {
			Line = NameFinder.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Line reading failed");
		}
		while(Line != null) {
			if(firstWordEqualsName(Line, name)) {
				return (new NameSurferEntry(Line));
			}
			try {
				Line = NameFinder.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Line reading failed");
			}
		}
		return null;
	}
	
	
	 private boolean firstWordEqualsName(String Line, String Name) {
		 for(int Character = 0; Character < Name.length(); Character++) {
			 if(Line.charAt(Character) != Name.charAt(Character)) {
				 return false;
			 }
		 }
		 return true;
	 }
}

