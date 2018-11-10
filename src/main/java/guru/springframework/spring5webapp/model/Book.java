package guru.springframework.spring5webapp.model;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.ManyToMany;
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String title;
	private String isbn;
	private String publisher;
	
	@ManyToMany
	@JoinTable(name="author_book", joinColumns=@JoinColumn(name="book_id"),inverseJoinColumns=@JoinColumn(name="author_id"))
	private Set<Author> authors = new HashSet<>();

	public Book() {
		
	}
	public Book(String title, String isbn, String publisher) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
	}
	public Book(String title, String isbn, String publisher, Set<Author> authors) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
		this.authors = authors;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + "]";
	}
	
	

}
