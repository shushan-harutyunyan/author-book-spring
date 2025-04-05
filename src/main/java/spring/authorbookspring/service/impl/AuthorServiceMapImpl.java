package spring.authorbookspring.service.impl;

import org.springframework.stereotype.Service;
import spring.authorbookspring.entity.Author;
import spring.authorbookspring.service.AuthorService;

import java.util.List;

@Service
public class AuthorServiceMapImpl implements AuthorService {
    @Override
    public List<Author> findAll() {
        return List.of();
    }

    @Override
    public void save(Author author) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Author findById(int id) {
        return null;
    }
}
