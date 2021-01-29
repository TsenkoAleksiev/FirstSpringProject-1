package bg.startit.spring.firstspringproject.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

  @Id
  @GeneratedValue
  private long id;
  private String title;
  private String author;
  private String genre;
  private String notes;
  private float price;
  private boolean available;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return id == book.id && Float.compare(book.price, price) == 0
        && available == book.available && Objects.equals(title, book.title)
        && Objects.equals(author, book.author) && Objects
        .equals(genre, book.genre) && Objects.equals(notes, book.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, author, genre, notes, price, available);
  }
}
