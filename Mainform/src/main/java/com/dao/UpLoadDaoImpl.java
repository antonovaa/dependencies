package com.dao;

import com.models.UpLoadArticle;
import com.models.UpLoadFiles;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UpLoadDaoImpl implements UpLoadDao{



   private final UpLoadMapper upLoadMapper;

   @Autowired
   public UpLoadDaoImpl(UpLoadMapper upLoadMapper) {
      this.upLoadMapper = upLoadMapper;
   }

   @Override
   public void saveUpLoad(String jotting,String description, ArrayList<UpLoadFiles> files) {

     List<String> name=files.stream().map(UpLoadFiles::getName).collect(Collectors.toList());
     List<String> file=files.stream().map(UpLoadFiles::getImage).collect(Collectors.toList());

//         .flatMap(x -> x.getName())
//         .collect(Collectors.toList());

      String s=upLoadMapper.saveUpLoadArticle(name,file,description,jotting);
   }

   @Override
   public ArrayList<UpLoadArticle> getUpLoadMap() {

      ArrayList<UpLoadArticle> articles=upLoadMapper.getUpLoadArticle();
      articles.forEach(article ->article.setFiles(upLoadMapper.getArticleImages(article.getUpLoadArticleId())));
      return articles;
//          .stream().collect(
//          Collectors.toMap(x -> x.getId(), x -> x.getFiles()));
   }

   @Override
   public void remooveById(int id) {

      upLoadMapper.remooveById(id);
   }
}
