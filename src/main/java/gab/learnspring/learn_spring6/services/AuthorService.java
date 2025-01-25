package gab.learnspring.learn_spring6.services;

import gab.learnspring.learn_spring6.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
