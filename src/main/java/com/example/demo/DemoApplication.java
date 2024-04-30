package com.example.demo;

import com.example.demo.entity.Chapters;
import com.example.demo.entity.Comics;
import com.example.demo.entity.ContentImages;
import com.example.demo.repository.ComicsRepository;
import com.example.demo.services.ChaptersServices;
import com.example.demo.services.ComicsServices;
import com.example.demo.services.ContentImagesServices;
import com.example.demo.utils.Utils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    @Autowired
    ComicsServices comicsServices;

    @Autowired
    ChaptersServices chaptersServices;

    @Autowired
    ContentImagesServices contentImagesServices;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @PostMapping("githook")
    @ResponseBody
    public String githook() throws Exception {
        return "ok";
    }

    @PostMapping("save-comic")
    @ResponseBody
    public String saveComic(@RequestBody com.example.demo.Pojo.Comic requestBody) throws Exception {
//        Iterable<Comics> comics = comicsRepository.findAll();

//        Iterator<Comics> iterator = comics.iterator();
        // Duyệt qua các phần tử và hiển thị chúng
//        while (iterator.hasNext()) {
//            Comics element = iterator.next();
//            System.out.println(element);
//        }
        new Thread() {
            public void run() {
                if (!Utils.isBlank(requestBody.getId())) {
                    Optional<Comics> optional = comicsServices.findById(Long.parseLong(requestBody.getId()));
                    if (optional != null) {
                        Comics c = optional.orElse(null);
                        comicsServices.update(c, requestBody);
                    }
                }
            }
        }.start();

        return "ok";
    }

    @PostMapping("save-chapter")
    @ResponseBody
    public String saveChapter(@RequestBody com.example.demo.Pojo.Chapter requestBody) throws Exception {
        new Thread() {
            public void run() {
                if (!Utils.isBlank(requestBody.getId())) {
                    Optional<Chapters> optional = chaptersServices.findById(Long.parseLong(requestBody.getId()));
                    if (optional != null) {
                        Chapters c = optional.orElse(null);
                        chaptersServices.update(c, requestBody);
                    }
                }
            }
        }.start();

        return "ok";
    }

    @PostMapping("save-content-image")
    @ResponseBody
    public String saveContentImage(@RequestBody com.example.demo.Pojo.ContentImage requestBody) throws Exception {
        new Thread() {
            public void run() {
                if (!Utils.isBlank(requestBody.getId())) {
                    Optional<ContentImages> optional = contentImagesServices.findById(Long.parseLong(requestBody.getId()));
                    if (optional != null) {
                        ContentImages c = optional.orElse(null);
                        contentImagesServices.update(c, requestBody);
                    }
                }
            }
        }.start();

        return "ok";
    }
}
