package spring.authorbookspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import spring.authorbookspring.entity.Author;
import spring.authorbookspring.entity.Book;
import spring.authorbookspring.repository.BookRepository;

import java.util.List;

@Controller
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public String bookPage() {
        List<Book> books = bookRepository.findAll();
        return "books";
    }
}
