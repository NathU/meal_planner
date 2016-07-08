/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LibraryTester {
   public static void main(String[] args) {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryJpa");
      EntityManager em = emf.createEntityManager();
      
      displayBooksByAuthor(em);
      
      System.out.println("\nAdding author and book..");
      
      String newAuthor = "Edgar Allan Poe";
      String newBook = "The Raven";
      String newBook2 = "The Oval Portrait";
      addAuthor(em, newAuthor);
      addBook(em, newBook, 3);
      addBook(em, newBook2, 3);
      
      displayBooksByAuthor(em);
      
      em.close();
   }
   
   public static void displayBooksByAuthor(EntityManager em) {
      em.clear();
      Query query = em.createQuery("SELECT a FROM Author a");
      List<Author> authors = query.getResultList(); 

      for (Author author : authors) {
         System.out.println("Author: " + author.getName());

         for (Book book : author.getBooks()) { 
            System.out.println("\tBook: " + book.getTitle());
         }
      }
   }
   
   public static void addAuthor(EntityManager em, String author) {
      em.getTransaction().begin(); 

      Author newAuthor = new Author();
      newAuthor.setName(author);

      em.persist(newAuthor);

      em.getTransaction().commit();
   }
   
   public static void addBook(EntityManager em, String title, int author_id) {
      em.getTransaction().begin();

      Book newBook = new Book();
      newBook.setTitle(title); 

      Author searchAuthor = em.find(Author.class, author_id);
      newBook.setAuthor(searchAuthor); 

      em.persist(newBook);

      em.getTransaction().commit();
   }
}
