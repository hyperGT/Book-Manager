package gab.learnspring.learn_spring6.services;

import gab.learnspring.learn_spring6.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
