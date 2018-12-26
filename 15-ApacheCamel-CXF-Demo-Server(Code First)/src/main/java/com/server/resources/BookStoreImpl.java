package com.server.resources;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CYX
 * @create 2018-12-26-22:44
 */

public class BookStoreImpl implements BookStore {

    private Map<Long, Book> books = new HashMap<>();
    private boolean isRest;

    public BookStoreImpl(boolean restFlag) {
        isRest = restFlag;
        init();
    }

    public BookStoreImpl() {
        init();
    }

    @Override
    public Book getBook(Long id) throws BookNotFoundFault {

        if (books.get(id) == null) {
            BookNotFoundDetails details = new BookNotFoundDetails();
            details.setId(id);
            if (!isRest) {
                throw new BookNotFoundFault("Can't find the Book with id " + id, details);
            } else {
                Response r = Response.status(404).header("BOOK-HEADER",
                        "No Book with id " + id + " is available").entity(details).build();
                throw new WebApplicationException(r);
            }
        }

        return books.get(id);
    }

    @Override
    public Book addBook(Book book) {
        books.put(book.getId(), book);
        return books.get(book.getId());
    }

    private void init() {
        Book book = new Book();
        book.setId(101);
        book.setName("CXF User Guide");
        books.put(book.getId(), book);
    }

}