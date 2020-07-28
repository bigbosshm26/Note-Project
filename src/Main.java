import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NoteMenu noteMenu2 = new NoteMenu();
		
		boolean bool = true;
		
		while(bool) {
			
			System.out.println("Choose 0 to display all of your notes;"
					+ "\nChoose 1 to note;"
					+ "\nChoose 2 to delete note"
					+ "\nChoose 3 to change your note"				
					+ "\nChoose 4 to exit");
			Scanner scanner = new Scanner(System.in);		
			
			int x = Integer.parseInt(scanner.nextLine());
			if(x==0) {
				
				noteMenu2.showListOfNotes();
			}
			
			if(x==1) {
				
				System.out.println("Fill in your note!");
				String content = scanner.nextLine();
				Note note = new Note(content, LocalDate.now());
				
				noteMenu2.saveNote(note);
			}
			if(x==2) {
				System.out.println("Fill in the id of the note you want to delete!");
				int id = Integer.parseInt(scanner.nextLine());

				noteMenu2.deleteNote(id);
			}
			if(x==3) {
				
				System.out.println("Fill in the id of the note you want to change!");
				int id = Integer.parseInt(scanner.nextLine());
				System.out.println("Fill in the content you want to change!");
				String content = scanner.nextLine();
				
				noteMenu2.changeNote(id, content);
			}
			if(x==4) {
				
				System.out.println("Exit");
				bool = false;
				scanner.close();
				
			}
		}
		
			
	}

}
