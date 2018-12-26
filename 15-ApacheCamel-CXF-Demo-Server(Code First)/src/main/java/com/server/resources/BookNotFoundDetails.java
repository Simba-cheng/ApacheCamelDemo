package com.server.resources;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author CYX
 * @create 2018-12-26-22:42
 */
@XmlRootElement
public class BookNotFoundDetails {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
