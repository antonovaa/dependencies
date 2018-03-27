package com.controller;


import com.dao.UpLoadDao;
import com.models.UpLoadArticle;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralController {


   private final UpLoadDao upLoadDao;

   public GeneralController(UpLoadDao upLoadDao) {
      this.upLoadDao = upLoadDao;
   }

   @RequestMapping(value="/drop", method= RequestMethod.POST)
   public Model greetingSubmit1(Model model) {
      model.addAttribute("greeting", "test");
      return model;
   }

   @RequestMapping(value="/drop", method= RequestMethod.GET)
   @ResponseBody
   public Model greetingSubmit2(Model model) {
      model.addAttribute("greeting", "test");
      return model;
   }

   @RequestMapping(value="/sendTo", method= RequestMethod.POST)
   public String sendTo1() {
      return "model";
   }

   @RequestMapping(value="/sendTo", method= RequestMethod.GET)
   @ResponseBody
   public String sendTo2() {
      return "model";
   }
   @RequestMapping(value="/sendTo3", method= RequestMethod.GET)
   @ResponseBody
   public ModelAndView sendTo3() {
      ModelAndView modelAndView = new ModelAndView("index.html");
      modelAndView.addObject("message", "Baeldung");
      return modelAndView;
   }

   @RequestMapping(value="/upload", method= RequestMethod.POST)
   @ResponseBody
   public String upload(@RequestBody UpLoadArticle article,HttpServletRequest request
//       @RequestParam UpLoadFiles[] files,HttpServletResponse response
   ) {

      upLoadDao.saveUpLoad(article.getJotting(),article.getDescription(),article.getFiles());

      return "upload";
   }

   @RequestMapping(value="/testarray", method= RequestMethod.POST)
   @ResponseBody
   public ArrayList<UpLoadArticle> testarray() {

      return upLoadDao.getUpLoadMap();
   }




}
