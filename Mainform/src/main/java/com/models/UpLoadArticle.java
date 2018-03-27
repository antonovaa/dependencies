package com.models;

import java.io.Serializable;
import java.util.ArrayList;


public class UpLoadArticle implements Serializable {


   private int upLoadArticleId;

   private ArrayList<UpLoadFiles> files;

   private String description;

   private String jotting;

   public int getUpLoadArticleId() {
      return upLoadArticleId;
   }

   public void setUpLoadArticleId(int upLoadArticleId) {
      this.upLoadArticleId = upLoadArticleId;
   }

   public String getJotting() {
      return jotting;
   }

   public void setJotting(String jotting) {
      this.jotting = jotting;
   }

   public ArrayList<UpLoadFiles> getFiles() {
      return files;
   }

   public void setFiles(ArrayList<UpLoadFiles> files) {
      this.files = files;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }
}
