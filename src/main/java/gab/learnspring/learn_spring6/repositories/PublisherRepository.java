package gab.learnspring.learn_spring6.repositories;

import gab.learnspring.learn_spring6.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
