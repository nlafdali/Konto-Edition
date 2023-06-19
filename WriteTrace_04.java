package Konto_04;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class WriteTrace_04{
	private File file = new File("C:\\Users\\Student\\eclipse-workspace\\Oop_Uebung\\src\\Konto_01\\LogeFile.txt");
	private String Zeitstempel;
	
	public WriteTrace_04(String mytext) {
		
		LocalDateTime now = LocalDateTime.now();
;
		Zeitstempel = (now.toString());
		String EntryText = Zeitstempel + ": " + mytext;
		WriteEntry(EntryText);
		}

	private void WriteEntry(String TextLine) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.newLine();
			writer.write(TextLine);
			writer.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
