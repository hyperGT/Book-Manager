package gab.learnspring.learn_spring6.bootstrap;

import gab.learnspring.learn_spring6.domain.Author;
import gab.learnspring.learn_spring6.domain.Book;
import gab.learnspring.learn_spring6.domain.Publisher;
import gab.learnspring.learn_spring6.repositories.AuthorRepository;
import gab.learnspring.learn_spring6.repositories.BookRepository;
import gab.learnspring.learn_spring6.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        /*
         * Setting all the authors
         *
         */
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Author john = new Author();
        john.setFirstName("John");
        john.setLastName("Doe");

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        /*
         * Creating a new publisher
         *
         */
        Publisher Oreilly = new Publisher();
        Oreilly.setPublisherName("O'Reilly");
        Oreilly.setAddress("123 Main St.");
        Oreilly.setCity("Any town");
        Oreilly.setState("NY");
        Oreilly.setZip("12345");
        Publisher savedPublisher = publisherRepository.save(Oreilly);

        /*
         * Creating new Books
         *
         */
        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("1234567890");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("3241221");

        /*
        * Saving books in a publisher
        *
        */
        ddd.setPublisher(savedPublisher);
        noEJB.setPublisher(savedPublisher);

        /*
         * Saving everything in their own repositories
         *
         */
        Author ericSaved = authorRepository.save(eric);
        Author johnSaved = authorRepository.save(john);
        Author rodSaved = authorRepository.save(rod);

        Book dddSaved = bookRepository.save(ddd);
        Book noEJBSaved = bookRepository.save(noEJB);


        /*
        * Relating/Adding the books to their respective authors and doing the reverse
        *
        * */
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        johnSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);
        noEJBSaved.getAuthors().add(johnSaved);



        /*
        * Updating the authors in the repository
        *
        * */
        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        authorRepository.save(johnSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        /*
         * Showing some info
         *
         * */
        System.out.println("In BootstrapData");
        System.out.println("Authors count: " + authorRepository.count());
        System.out.println("Books count: " + bookRepository.count());
        System.out.println("Publishers count: " + publisherRepository.count());
        System.out.println("---------------------------------------");

    }
}
