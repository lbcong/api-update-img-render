/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.entity.Chapters;
import com.example.demo.entity.Comics;
import com.example.demo.repository.ChaptersRepository;
import com.example.demo.repository.ComicsRepository;
import com.example.demo.utils.Utils;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ChaptersServices {

    @Autowired
    ChaptersRepository chaptersRepository;

    public Optional<Chapters> findById(long id) {
        return chaptersRepository.findById(id);
    }

      public Iterable<Chapters> findAll(){
        return chaptersRepository.findAll();
    }
    @Transactional
    public Chapters update(com.example.demo.Pojo.Chapter requestBody) throws IOException {
        Optional<Chapters> optional = findById(Long.parseLong(requestBody.getId()));
        if (optional != null) {
            Chapters chapter = optional.orElse(null);

            String linkTmp = "";
            if (!Utils.isBlank(requestBody.getLink_small_icon())) {
                linkTmp = GetRealImgLink.getRealLink(requestBody.getLink_small_icon());
                if (!Utils.isBlank(linkTmp)) {
                    chapter.setLinkSmallIcon(linkTmp);
                }
            }
            return chaptersRepository.save(chapter);
        }
        return null;
    }
}
