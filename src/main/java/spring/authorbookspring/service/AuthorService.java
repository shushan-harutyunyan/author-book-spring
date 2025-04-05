package spring.authorbookspring.service;

import org.springframework.stereotype.Service;
import spring.authorbookspring.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    void save(Author author);

    void deleteById(int id);

    Author findById(int id);
}
