/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.entity.Comics;
import com.example.demo.repository.ComicsRepository;
import com.example.demo.utils.Utils;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ComicsServices {

    @Autowired
    ComicsRepository comicsRepository;

    public Optional<Comics> findById(long id) {
        return comicsRepository.findById(id);
    }

    @Transactional
    public Comics update(Comics comic, com.example.demo.Pojo.Comic requestBody) {
        if (!Utils.isBlank(requestBody.getLink_avatar())) {
            comic.setLinkAvatar(requestBody.getLink_avatar());
        }
        if (!Utils.isBlank(requestBody.getLink_banner())) {
            comic.setLinkBanner(requestBody.getLink_banner());
        }
        if (!Utils.isBlank(requestBody.getLink_comic_name())) {
            comic.setLinkComicName(requestBody.getLink_comic_name());
        }
        if (!Utils.isBlank(requestBody.getLink_comic_small_name())) {
            comic.setLinkComicSmallName(requestBody.getLink_comic_small_name());
        }
        if (!Utils.isBlank(requestBody.getLink_video_banner())) {
            comic.setLinkVideoBanner(requestBody.getLink_video_banner());
        }
        if (!Utils.isBlank(requestBody.getLink_video_banner_2())) {
            comic.setLinkVideoBanner2(requestBody.getLink_video_banner_2());
        }
        return comicsRepository.save(comic);
    }
}
