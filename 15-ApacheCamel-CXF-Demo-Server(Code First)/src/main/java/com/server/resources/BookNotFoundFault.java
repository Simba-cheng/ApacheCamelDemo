package com.server.resources;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.WebFault;

/**
 * @author CYX
 * @create 2018-12-26-22:43
 */
@WebFault
public class BookNotFoundFault extends Exception {
    private static final long serialVersionUID = 1L;

    @XmlElement
    private BookNotFoundDetails details;

    public BookNotFoundFault(String errorMessage) {
        super(errorMessage);
    }

    public BookNotFoundFault(String errorMessage, BookNotFoundDetails details) {
        super(errorMessage);
        this.details = details;
    }

    public BookNotFoundDetails getFaultInfo() {
        return details;
    }
}
