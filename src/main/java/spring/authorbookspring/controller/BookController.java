package spring.authorbookspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.authorbookspring.entity.Author;
import spring.authorbookspring.entity.Book;
import spring.authorbookspring.repository.BookRepository;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public String bookPage(ModelMap modelMap) {
        List<Book> books = bookRepository.findAll();
        modelMap.put("books", books);
        return "book/books";
    }
}
