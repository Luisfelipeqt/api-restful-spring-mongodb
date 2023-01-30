package com.feliperodrigues.workshopmongo.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(value = "comment")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    private String text;
    private Date date;

    private User author;

    public Comment(){
    }

    public Comment(String text, Date date, User author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(text, comment.text) && Objects.equals(date, comment.date) && Objects.equals(author, comment.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, date, author);
    }
}
