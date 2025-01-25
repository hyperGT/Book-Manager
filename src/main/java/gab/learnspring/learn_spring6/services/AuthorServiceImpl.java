package gab.learnspring.learn_spring6.services;

import gab.learnspring.learn_spring6.domain.Author;
import gab.learnspring.learn_spring6.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll(){
        return authorRepository.findAll();
    }
}
