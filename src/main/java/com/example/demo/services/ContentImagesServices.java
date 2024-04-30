/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.entity.Comics;
import com.example.demo.entity.ContentImages;
import com.example.demo.repository.ComicsRepository;
import com.example.demo.repository.ContentImagesRepository;
import com.example.demo.utils.Utils;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ContentImagesServices {

    @Autowired
    ContentImagesRepository contentImagesRepository;

    public Optional<ContentImages> findById(long id) {
        return contentImagesRepository.findById(id);
    }

    @Transactional
    public ContentImages update(com.example.demo.Pojo.ContentImage requestBody) throws IOException {
        Optional<ContentImages> optional = findById(Long.parseLong(requestBody.getId()));
        if (optional != null) {
            ContentImages contentImage = optional.orElse(null);

            String linkTmp = "";
            if (!Utils.isBlank(requestBody.getLink_img())) {
                linkTmp = GetRealImgLink.getRealLink(requestBody.getLink_img());
                if (!Utils.isBlank(linkTmp)) {
                    contentImage.setLinkImg(linkTmp);
                }
            }
            return contentImagesRepository.save(contentImage);
        }
        return null;
    }
}
