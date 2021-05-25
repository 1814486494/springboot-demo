package com.springboot.demo.service;

import com.springboot.demo.bean.Message;
import sun.applet.Main;

import java.util.List;
public interface MessageService{


    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    int updateBatch(List<Message> list);

    int updateBatchSelective(List<Message> list);

    int batchInsert(List<Message> list);

    List<Message> selectAll(Integer pageNum, Integer pageSize);

}
