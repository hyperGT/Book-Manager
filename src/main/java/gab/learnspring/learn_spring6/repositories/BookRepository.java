package gab.learnspring.learn_spring6.repositories;

import gab.learnspring.learn_spring6.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
