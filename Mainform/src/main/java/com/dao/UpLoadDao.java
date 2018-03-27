package com.dao;

import com.models.UpLoadArticle;
import com.models.UpLoadFiles;
import java.util.ArrayList;

public interface UpLoadDao {

   void saveUpLoad(String jotting,String description,ArrayList<UpLoadFiles> files);

   ArrayList<UpLoadArticle> getUpLoadMap();


   void remooveById(int id);

}
