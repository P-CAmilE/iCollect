package com.webproject.icollect.mapper;

/**
 * Created by Wan Yu on 2020/5/18
 */
import com.webproject.icollect.pojo.CommentDO;
import com.webproject.icollect.pojo.TestDO;
<<<<<<< HEAD
import com.webproject.icollect.pojo.UserDO;
=======
>>>>>>> 161036aa6be2789df3ec10102fbe656a648337dc
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    @Select("select * from Comment where pid=#{pid}")
    List<CommentDO> getCommendByTime(String pid);

    @Insert("insert into Comment(cid,ctime,pid,uid,content) values(#{cid},#{ctime},#{pid},#{uid},#{content})")
    void addComment(CommentDO comment);

    @Delete("delete from Comment where cid=#{cid}")
    void deleteComment(String cid);

<<<<<<< HEAD
    @Select("select * from User where uid=#{id}")
    UserDO findUserById(int id);

=======
>>>>>>> 161036aa6be2789df3ec10102fbe656a648337dc
}
