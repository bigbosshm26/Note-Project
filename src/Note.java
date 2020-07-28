import java.io.Serializable;
import java.time.LocalDate;

public class Note implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static int currentId = 0;
	
	private int id;
	
	private String content;
	
	private LocalDate dateCreated;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Note(String content, LocalDate dateCreated) {
		super();
		currentId++;
		this.id = currentId;
		this.content = content;
		this.dateCreated = dateCreated;
	}
	
	public Note(int id, String content, LocalDate dateCreated) {
		this.id = id ;
		this.content = content;
		this.dateCreated = dateCreated;
	}
	@Override
	public String toString() {
		return "Note: " + id + " " + content + " " + dateCreated;
	}
	
	
	
}
