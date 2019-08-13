package com.dreamingCourse.service.impl;

import com.dreamingCourse.entity.Tag;
import com.dreamingCourse.mapper.TagMapper;
import com.dreamingCourse.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public Tag deleteByPrimaryKey(Integer id) {
        return tagMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Tag insert(Tag record) {
        return tagMapper.insert(record);
    }

    @Override
    public Tag selectByPrimaryKey(Integer id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Tag> selectAll() {
        return tagMapper.selectAll();
    }

    @Override
    public Tag updateByPrimaryKey(Tag record) {
        return tagMapper.updateByPrimaryKey(record);
    }
}
