package com.example.demo.repository;

import com.example.demo.entity.Comics;
import com.example.demo.entity.ContentImages;
import java.util.Iterator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentImagesRepository extends JpaRepository <ContentImages, Long> {
//    public Page<Comics> findAll(Pageable pageable) throws Exception;
    
    
}
