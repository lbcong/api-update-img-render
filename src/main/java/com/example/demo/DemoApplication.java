package com.example.demo;

import com.example.demo.Pojo.Chapter;
import com.example.demo.Pojo.Comic;
import com.example.demo.entity.Chapters;
import com.example.demo.entity.Comics;
import com.example.demo.entity.ContentImages;
import com.example.demo.repository.ComicsRepository;
import com.example.demo.services.ChaptersServices;
import com.example.demo.services.ComicsServices;
import com.example.demo.services.ContentImagesServices;
import com.example.demo.services.GetRealImgLink;
import com.example.demo.utils.Utils;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @GetMapping("updateComic")
    @ResponseBody
    public String updateComic() throws Exception {
        Iterable<Comics> comics = comicsServices.findAll();

        Iterator<Comics> iterator = comics.iterator();
//         Duyệt qua các phần tử và hiển thị chúng
        while (iterator.hasNext()) {
            Comics element = iterator.next();
            new Thread() {
                public void run() {
                    try {
                        com.example.demo.Pojo.Comic requestBody = new Comic();
                        requestBody.setId(Long.toString(element.getId()));
                        requestBody.setLink_avatar(GetRealImgLink.getIdGG(element.getLinkAvatar()));
                        requestBody.setLink_banner(GetRealImgLink.getIdGG(element.getLinkBanner()));
                        requestBody.setLink_bg(GetRealImgLink.getIdGG(element.getLinkBg()));
                        requestBody.setLink_comic_name(GetRealImgLink.getIdGG(element.getLinkComicName()));
                        requestBody.setLink_comic_small_name(GetRealImgLink.getIdGG(element.getLinkComicSmallName()));
                        comicsServices.update(requestBody);
                    } catch (IOException ex) {
                        Logger.getLogger(DemoApplication.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
        return "ok";
    }

    @GetMapping("updateChapter")
    @ResponseBody
    public String updateChapter() throws Exception {
        Iterable<Chapters> comics = chaptersServices.findAll();

        Iterator<Chapters> iterator = comics.iterator();
//         Duyệt qua các phần tử và hiển thị chúng
        while (iterator.hasNext()) {
            Chapters element = iterator.next();
            new Thread() {
                public void run() {
                    try {
                        com.example.demo.Pojo.Chapter requestBody = new Chapter();
                        requestBody.setId(Long.toString(element.getId()));
                        requestBody.setLink_small_icon(GetRealImgLink.getIdGG(element.getLinkSmallIcon()));
                        chaptersServices.update(requestBody);
                    } catch (IOException ex) {
                        Logger.getLogger(DemoApplication.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
        return "ok";
    }

    @GetMapping("updateContentImage")
    @ResponseBody
    public String updateContentImage() throws Exception {
        Iterable<ContentImages> comics = contentImagesServices.findAll();

        Iterator<ContentImages> iterator = comics.iterator();
//         Duyệt qua các phần tử và hiển thị chúng
        while (iterator.hasNext()) {
            ContentImages element = iterator.next();
            com.example.demo.Pojo.ContentImage requestBody = new com.example.demo.Pojo.ContentImage();
            requestBody.setId(Long.toString(element.getId()));
            requestBody.setLink_img(GetRealImgLink.getIdGG(element.getLinkImg()));
            contentImagesServices.update(requestBody);
        }
        return "ok";
    }

    @PostMapping("save-comic")
    @ResponseBody
    public String saveComic(@RequestBody com.example.demo.Pojo.Comic requestBody) throws Exception {

        new Thread() {
            public void run() {
                if (!Utils.isBlank(requestBody.getId())) {
                    try {
                        comicsServices.update(requestBody);
                    } catch (IOException ex) {
                        Logger.getLogger(DemoApplication.class.getName()).log(Level.SEVERE, null, ex);
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
                    try {
                        chaptersServices.update(requestBody);
                    } catch (IOException ex) {
                        Logger.getLogger(DemoApplication.class.getName()).log(Level.SEVERE, null, ex);
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
                    try {
                        contentImagesServices.update(requestBody);
                    } catch (IOException ex) {
                        Logger.getLogger(DemoApplication.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();

        return "ok";
    }
}
