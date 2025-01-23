package gab.learnspring.learn_spring6.bootstrap;

import gab.learnspring.learn_spring6.domain.Author;
import gab.learnspring.learn_spring6.domain.Book;
import gab.learnspring.learn_spring6.repositories.AuthorRepository;
import gab.learnspring.learn_spring6.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Author john = new Author();
        john.setFirstName("John");
        john.setLastName("Doe");

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("1234567890");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("3241221");


        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author johnSaved = authorRepository.save(john);

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        johnSaved.getBooks().add(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        authorRepository.save(johnSaved);

        System.out.println("In BootstrapData");
        System.out.println("Authors count: " + authorRepository.count());
        System.out.println("Books count: " + bookRepository.count());
    }
}
