package spring.authorbookspring.controller;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Controller
public class MainController {

    @Value("${author.book.upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @SneakyThrows
    @GetMapping(value = "/getImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@RequestParam("imageName") String imageName) {
        File file = new File(uploadPath + '/' + imageName);
        if (file.exists()) {
            try (InputStream inputStream = new FileInputStream(file)) {
                return IOUtils.toByteArray(inputStream);
            }
        }
        return null;
    }
}
