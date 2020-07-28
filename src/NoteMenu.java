import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class NoteMenu {

	public ArrayList<Note> listOfNotes() {
		
		ArrayList<Note> list = new ArrayList<Note>();
		
		try {
			File myFile = new File("notnote.txt");
			FileReader fileReader = new FileReader(myFile);
			String line = null;
			BufferedReader reader = new BufferedReader(fileReader);
			while((line = reader.readLine()) != null){
				
				String[] elements = line.split("\\|");
				
				int id = Integer.parseInt(elements[0]);
				String content = elements[1];
				LocalDate dateCreated = LocalDate.parse(elements[2]);
				
				Note note = new Note(id, content, dateCreated);								
				list.add(note);
			}
			reader.close();
			
		}catch(NullPointerException e){
			e.printStackTrace();
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
	}
	
	public void showListOfNotes() {
		System.out.println("Here is your list of notes");
		ArrayList<Note> list = listOfNotes();
		for(Note note : list) {
			System.out.println(note);
		}
	}
	
	public void saveNote(Note note) {
		try {
			
			FileWriter fileWriter = new FileWriter("notnote.txt", true);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			ArrayList<Note> list = listOfNotes();
			int id = list.get(list.size()-1).getId() + 1;
			note.setId(id);
			writer.write(note.getId()+ "|" + note.getContent() + "|" + note.getDateCreated()+"\n");	
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void changeNote(int id, String content) {
		
		try {
			File originalFile = new File("notnote.txt");
			BufferedReader reader = new BufferedReader(new FileReader(originalFile));
			
			File tempFile = new File("tempfile.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			
			String line = null;
			
			while((line = reader.readLine())!=null) {
				
				if(line.contains(String.valueOf(id))) {
					
					String[] elements = line.split("\\|");
					
					if(elements[0].equals(String.valueOf(id))){
						elements[1] = content;
					}
					
					line = elements[0]+ "|" + elements[1] + "|" + elements[2];
				}
				
				writer.write(line + "\n");
				writer.flush();
				
			}
			
			reader.close();
			writer.close();
			
			if (!originalFile.delete()) {
				
	            System.out.println("Could not delete file");	            
	        }
			if (!tempFile.renameTo(originalFile)) {
				
	            System.out.println("Could not rename file");
	    	}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
				
	}
	
	public void deleteNote(int id) {
		
		try {
			File originalFile = new File("notnote.txt");
			BufferedReader reader = new BufferedReader(new FileReader(originalFile));
			
			File tempFile = new File("tempfile.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			
			String line = null;
			
			while((line = reader.readLine())!=null) {
				
				if(line.contains(String.valueOf(id))) {
					
					String[] elements = line.split("\\|");
					
					if(elements[0].equals(String.valueOf(id))){
						
						continue;
					}
				}
				
				writer.write(line + "\n");
				writer.flush();
				
			}
			
			reader.close();
			writer.close();
			
			if (!originalFile.delete()) {
				
	            System.out.println("Could not delete file");	            
	        }
			if (!tempFile.renameTo(originalFile)) {
				
	            System.out.println("Could not rename file");
	    	}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
				
				
				
			
	}
	
	
}
