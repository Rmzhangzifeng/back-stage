package org.lenovo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.lenovo.pojo.Tree;
import org.springframework.context.annotation.Bean;

import java.util.List;


@Mapper
public interface UserDao{

    @Select("select * from enj_tree where pid=#{pid}")
    List<Tree> queryByPid(String pid);

}
