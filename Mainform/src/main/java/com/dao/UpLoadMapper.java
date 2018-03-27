package com.dao;

import com.models.UpLoadArticle;
import com.models.UpLoadFiles;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

@Mapper
public interface UpLoadMapper {

//   @Select("SELECT mnt.find_shortest_round(#{p_node_begin_id_list,typeHandler=com.dao.StringListHandler})")
//   @Options(useCache = false, statementType = StatementType.CALLABLE)
//   List<Integer> getRoundNodesId(@Param("p_node_begin_id_list") List<Integer> nodeBeginIdList,
//       @Param("p_node_end_id_list") List<Integer> nodeEndIdList);


   @Select("select public.save_upload_article(#{names,typeHandler=com.dao.StringListHandler}"
       + ",#{files,typeHandler=com.dao.StringListHandler},#{description},#{jotting})")
   @Options(useCache = false, statementType = StatementType.CALLABLE)
   String saveUpLoadArticle(
       @Param("names") List<String> names,
       @Param("files") List<String> files,
       @Param("description") String description,
       @Param("jotting") String jotting);

   @Delete("delete from public.up_load_article u where u.id = #{id}")
   void remooveById(@Param("id") int id);

   @Select("select * from public.up_load_article")
   @Results({
       @Result(property = "upLoadArticleId", column = "up_load_article_id"),
       @Result(property = "description", column = "description"),
       @Result(property = "jotting", column = "jotting")
   })
   ArrayList<UpLoadArticle> getUpLoadArticle();


   @Select("select ai.file,ai.name from public.article_images ai where ai.up_load_article_id=#{upLoadArticleId}")
   @Results({
       @Result(property = "image", column = "file"),
       @Result(property = "name", column = "name")
   })
   ArrayList<UpLoadFiles> getArticleImages(@Param("upLoadArticleId") int upLoadArticleId);


}
