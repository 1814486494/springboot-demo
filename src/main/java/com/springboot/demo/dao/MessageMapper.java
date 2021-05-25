package com.springboot.demo.dao;

import com.springboot.demo.bean.Message;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    int updateBatch(List<Message> list);

    int updateBatchSelective(List<Message> list);

    int batchInsert(@Param("list") List<Message> list);

    List<Message> selectAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
}