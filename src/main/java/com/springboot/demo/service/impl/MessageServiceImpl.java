package com.springboot.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.springboot.demo.bean.Message;
import java.util.List;
import com.springboot.demo.dao.MessageMapper;
import com.springboot.demo.service.MessageService;
@Service
public class MessageServiceImpl implements MessageService{

    @Resource
    private MessageMapper messageMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return messageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Message record) {
        return messageMapper.insert(record);
    }

    @Override
    public int insertSelective(Message record) {
        return messageMapper.insertSelective(record);
    }

    @Override
    public Message selectByPrimaryKey(Integer id) {
        return messageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Message record) {
        return messageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Message record) {
        return messageMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Message> list) {
        return messageMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Message> list) {
        return messageMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Message> list) {
        return messageMapper.batchInsert(list);
    }

    @Override
    public List<Message> selectAll(Integer pageNum, Integer pageSize) {
        return messageMapper.selectAll(pageNum,pageSize);
    }

}
