package gab.learnspring.learn_spring6.repositories;

import gab.learnspring.learn_spring6.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
