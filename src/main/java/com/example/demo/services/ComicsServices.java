/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.entity.Comics;
import com.example.demo.repository.ComicsRepository;
import com.example.demo.utils.Utils;
import java.io.IOException;
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
    public Comics update(com.example.demo.Pojo.Comic requestBody) throws IOException {
        Optional<Comics> optional = findById(Long.parseLong(requestBody.getId()));
        if (optional != null) {
            Comics comic = optional.orElse(null);
            if (comic != null) {
                String linkTmp = "";
                if (!Utils.isBlank(requestBody.getLink_bg())) {
                    linkTmp = GetRealImgLink.getRealLink(requestBody.getLink_bg());
                    if (!Utils.isBlank(linkTmp)) {
                        comic.setLinkBg(linkTmp);
                    }
                }
                linkTmp = "";
                if (!Utils.isBlank(requestBody.getLink_avatar())) {
                    linkTmp = GetRealImgLink.getRealLink(requestBody.getLink_avatar());
                    if (!Utils.isBlank(linkTmp)) {
                        comic.setLinkAvatar(linkTmp);
                    }
                }
                linkTmp = "";
                if (!Utils.isBlank(requestBody.getLink_banner())) {
                    linkTmp = GetRealImgLink.getRealLink(requestBody.getLink_banner());
                    if (!Utils.isBlank(linkTmp)) {
                        comic.setLinkBanner(linkTmp);
                    }
                }
                if (!Utils.isBlank(requestBody.getLink_comic_name())) {
                    linkTmp = GetRealImgLink.getRealLink(requestBody.getLink_comic_name());
                    if (!Utils.isBlank(linkTmp)) {
                        comic.setLinkComicName(linkTmp);
                    }
                }
                if (!Utils.isBlank(requestBody.getLink_comic_small_name())) {
                    linkTmp = GetRealImgLink.getRealLink(requestBody.getLink_comic_small_name());
                    if (!Utils.isBlank(linkTmp)) {
                        comic.setLinkComicSmallName(linkTmp);
                    }
                }

                return comicsRepository.save(comic);
            }
        }
        return null;
    }
}
