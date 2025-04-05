package spring.authorbookspring.service;

import org.springframework.web.multipart.MultipartFile;
import spring.authorbookspring.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book save(Book book, MultipartFile multipartFile);

    void deleteById(int id);

    Book findById(int id);
}
