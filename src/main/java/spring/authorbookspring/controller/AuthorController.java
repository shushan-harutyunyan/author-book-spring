package spring.authorbookspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import spring.authorbookspring.entity.Author;
import spring.authorbookspring.repository.AuthorRepository;
import spring.authorbookspring.service.AuthorService;
import spring.authorbookspring.util.DateUtil;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/authors")
@RequiredArgsConstructor

public class AuthorController {

    private final AuthorService authorService;
    //private final List<AuthorService> authorServices;

    @GetMapping
    public String authorPage(ModelMap modelMap) {
        List<Author> authors = authorService.findAll();
        modelMap.put("authors", authors);
        return "/author/authors";
    }

    @GetMapping("/add")
    public String addAuthor() {
        return "/author/addAuthor";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Author author) {
        authorService.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/delete")
    public String deleteAuthor(@RequestParam("id") int id) {
        authorService.deleteById(id);
        return "redirect:/authors";
    }

    @GetMapping("/editAuthor")
    public String editAuthorPage(@RequestParam("id") int id, ModelMap modelMap) {
        Author author = authorService.findById(id);
        if(author != null){
            modelMap.put("author", author);
                return "/author/editAuthor";
            }
        return "redirect:/authors";
    }

    @PostMapping("/editAuthor")
    public String editAuthor(@ModelAttribute Author author) {
        authorService.save(author);
        return "redirect:/authors";
    }
}
