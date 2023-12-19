package Entity;

import java.util.Objects;

public class LibraryEntity {

    private int isbn;
    private String title;
    private String author;
    private int countPage;

    public LibraryEntity(int isbn, String title, String author, int countPage) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.countPage = countPage;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
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

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryEntity that = (LibraryEntity) o;
        return isbn == that.isbn && countPage == that.countPage && Objects.equals(title, that.title) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author, countPage);
    }

    public int compareTo(LibraryEntity other)
    {
        return this.isbn - other.isbn;
    }
}
