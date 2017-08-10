package com.makenv.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.makenv.mapper.PolistUserMapper;
import com.makenv.model.PolistUser;
import com.makenv.service.PolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by wrx on 2017/8/8.
 */
@Service
@Transactional
public class PolistServiceImpl implements PolistService {

    @Autowired
    private PolistUserMapper polistUserMapper;

    @Override
    public List<PolistUser> findAll() {
        Page<Object> objects = PageHelper.startPage(1, 10);
        List<PolistUser> list = polistUserMapper.selectAll();
        long total = objects.getTotal();
        return list;
    }

    @Override
    public List<PolistUser> select() {
        PageHelper.startPage(1,10);
        Example example = new Example(PolistUser.class);
        example.selectProperties("userName","sole");
        example.createCriteria()
                .andLike("region","1301%");
        List<PolistUser> list = polistUserMapper.selectByExample(example);
        return list;

    }
}
