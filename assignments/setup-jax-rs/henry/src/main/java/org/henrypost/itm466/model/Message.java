package org.henrypost.itm466.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Message {

    private long id;
    private String message;
    private String author;
    private Date created;

    public Message() {

    }

    public Message(long _id, String _message, String _author) {
        id = _id;
        message = _message;
        author = _author;
        created = new Date();
    }

    public Message(long _id, String _message, String _author, Date _created) {
        id = _id;
        message = _message;
        author = _author;
        created = _created;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
