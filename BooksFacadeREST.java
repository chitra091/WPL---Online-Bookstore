/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Books;
import entities.BooksPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author eric
 */
@Stateless
@Path("books")
public class BooksFacadeREST extends AbstractFacade<Books> {

    @PersistenceContext(unitName = "BookServicePU")
    private EntityManager em;

    private BooksPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;isbn=isbnValue;owner=ownerValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        System.out.println("pathSegment: " + pathSegment.getPath());
        entities.BooksPK key = new entities.BooksPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        System.out.println("map : " + map.toString());
        java.util.List<String> isbn = map.get("isbn");
        if (isbn != null && !isbn.isEmpty()) {
            System.out.println("find isbn");
            key.setIsbn(isbn.get(0));
        }else{
             System.out.println("can not find isbn");
        }
        java.util.List<String> owner = map.get("owner");
        if (owner != null && !owner.isEmpty()) {
            key.setOwner(owner.get(0));
             System.out.println("find owner");
        }else{
             System.out.println("can  not  find owner");
        }
        return key;
    }

    public BooksFacadeREST() {
        super(Books.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Books create(Books entity) {
        BooksPK pk = entity.getBooksPK();
       
        if(pk != null && find(pk) == null){ 
            System.out.println("server: book not exist, creating");
            super.create(entity);  
            //Response r = new Response();
            return entity;
        }else{
            Books book = super.find(pk);
            book.setQuantity(book.getQuantity()+entity.getQuantity());
            return book;
           //
        }    
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Books entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        entities.BooksPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{isbn}-{owner}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Books findwithName(@PathParam("isbn") String isbn, 
                            @PathParam("owner") String owner ) {
        System.out.println("server isbn: " + isbn);
        BooksPK key = new BooksPK(isbn,owner);
        //entities.BooksPK key = getPrimaryKey(id);
        return super.find(key);
    }
    
    @GET
    @Path("{category}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Books> findbycategory(@PathParam("category") String category) {
        System.out.println("server category: " + category);
        List<Books> books = super.findByCategory(category);
        return books;
    }
    
/*    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Books find(@PathParam("id") PathSegment id ) {
        
        System.out.println("id: " + getPrimaryKey(id).toString());
        return null;
        //entities.BooksPK key = getPrimaryKey(id);
       // return super.find(key);
    }*/
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Books> findAll() {
        //List<Books> bookList = super.findAll();
        //for(Books book : bookList){
        //    System.out.println("server book title: " + book.getTitle());
        //}
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Books> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
