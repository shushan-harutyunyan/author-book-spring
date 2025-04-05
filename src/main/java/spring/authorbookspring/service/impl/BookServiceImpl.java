package spring.authorbookspring.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.authorbookspring.entity.Book;
import spring.authorbookspring.repository.BookRepository;
import spring.authorbookspring.service.BookService;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    @Value("${author.book.upload.path}")
    private String uploadPath;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @SneakyThrows
    @Override
    public Book save(Book book, MultipartFile multipartFile) {
        String fileName;
        if(!multipartFile.isEmpty()) {
            fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
            File file = new File(uploadPath, fileName);
            multipartFile.transferTo(file);
            book.setImageName(fileName);
        }
        book.setCreatedAt(new Date());
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(int id) {
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
}
