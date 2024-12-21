import java.io.*;
import java.util.*;

public class Book {
    private int id;
    private String name;
    private int idd;
    private String author;
    private Genre genre;

    private boolean isAvailable;
private int count;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


public Book(){

}
    public Book(String name, String author, Genre genre,int id,boolean isAvailable,int count) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.id=id;
this.isAvailable=isAvailable;
this.count=count;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isAvailable=" + isAvailable +
                ", count=" + count +
                ", author='" + author + '\'' +
                ", genre=" + genre ;
    }
}
