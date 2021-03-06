package com.webproject.icollect.mapper;

import com.webproject.icollect.pojo.ProjectDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Wan Yu on 2020/5/19
 */

@Mapper
@Repository
public interface ProjectMapper {


    @Insert("insert into Project(pid,authorID,author,name,introduction,startTime,endTime,targetMoney,currentMoney,isFinished,isChecked,isEnded,category) " +
            "values(#{pid},#{authorID},#{author},#{name},#{introduction},#{startTime},#{endTime},#{targetMoney},#{currentMoney},#{isFinished},#{isChecked},#{isEnded},#{category})")
    void addProject(ProjectDO projectDO);

    @Delete("delete from Project where pid=#{pid}")
    void deleteProject(String pid);

    @Update("update Project set name=#{name}, introduction=#{introduction}, startTime=#{startTime}, endTime=#{endTime}," +
            " targetMoney=#{targetMoney}, isEnded=#{isEnded},category=#{category} where pid=#{pid}")
    void updateProject(ProjectDO projectDO);

    @Update("update Project set isChecked=#{isChecked} where pid=#{pid}")
    void checkProject(@Param("isChecked")boolean isChecked, @Param("pid")String pid);

    @Update("update Project set isFinished=#{isFinished} where pid=#{pid}")
    void finishProject(@Param("isFinished")boolean isFinished, @Param("pid")String pid);

    @Update("update Project set isEnded=#{isEnded} where pid=#{pid}")
    void endProject(@Param("isEnded")boolean isEnded, @Param("pid")String pid);

    @Update("update Project set currentMoney=#{currentMoney} where pid=#{pid}")
    void updateMoney(@Param("currentMoney")double currentMoney, @Param("pid")String pid);

    @Update("update Project set image=#{image} where pid=#{pid}")
    void setImage(String image, String pid);

    @Update("update Project set qrCode=#{qrCode} where pid=#{pid}")
    void setQrCode(String qrCode, String pid);

    @Select("select * from Project NATURAL JOIN (select id as authorID, username as author from User) as User")
    List<ProjectDO> getProject();

    @Select("select * from Project NATURAL JOIN (select id as authorID, username as author from User) as User where isChecked=false")
    List<ProjectDO> getProjectUnchecked();

    @Select("select * from Project NATURAL JOIN (select id as authorID, username as author from User) as User where isChecked=true")
    List<ProjectDO> getProjectChecked();

    @Select("select * from Project NATURAL JOIN (select id as authorID, username as author from User) as User where pid=#{pid}")
    ProjectDO getProjectInfo(String pid);

    @Select("select * from Project NATURAL JOIN (select id as authorID, username as author from User) as User where author=#{author}")
    List<ProjectDO> getProjectByAuthor(String author);

    @Select("select * from Project NATURAL JOIN (select id as authorID, username as author from User) as User where name like #{name}")
    List<ProjectDO> getProjectByName(String name);

    @Select("select * from Project NATURAL JOIN (select id as authorID, username as author from User) as User where category like #{category}")
    List<ProjectDO> getProjectByCategory(String category);

    @Select("select * from Project NATURAL JOIN (select id as authorID, username as author from User) as User NATURAL JOIN (select pid, donor from Donate where donor=#{donor}) as Donate")
    List<ProjectDO> getProjectDonated(int donor);
}
