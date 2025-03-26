package spring.authorbookspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import spring.authorbookspring.entity.Author;
import spring.authorbookspring.repository.AuthorRepository;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;
    @GetMapping("/authors")
    public String authorPage() {
        List<Author> authors = authorRepository.findAll();
        return "authors";
    }
}
