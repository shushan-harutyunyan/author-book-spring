package spring.authorbookspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.authorbookspring.entity.Book;
public interface BookRepository extends JpaRepository <Book, Integer>{
    Book findByTitle(String name);
}
