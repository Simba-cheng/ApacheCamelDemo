package com.server.resources;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author CYX
 * @create 2018-12-26-22:41
 */
@XmlRootElement(name = "Book")
public class Book {

    private String name;
    private long id;

    public Book() {
    }

    public Book(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setId(long i) {
        id = i;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
