package spring.authorbookspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.authorbookspring.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author findByName(String name);
}
