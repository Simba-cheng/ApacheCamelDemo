package com.server.resources;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * @author CYX
 * @create 2018-12-26-22:43
 */
@WebService
@Path("/bookstore")
@Consumes("application/xml")
@Produces("application/xml")
public interface BookStore {

    @WebMethod
    @GET
    @Path("/{id}")
    @Consumes("*/*")
    Book getBook(@PathParam("id") @WebParam(name = "id") Long id) throws BookNotFoundFault;

    @WebMethod
    @POST
    @Path("/books")
    Book addBook(@WebParam(name = "book") Book book);

}

