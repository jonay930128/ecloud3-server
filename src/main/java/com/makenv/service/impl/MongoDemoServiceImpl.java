package com.makenv.service.impl;

import com.makenv.model.PolistUser;
import com.makenv.service.MongoDemoService;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wrx on 2017/8/9.
 */
@Service
@Transactional
public class MongoDemoServiceImpl implements MongoDemoService{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insert() {
        List<PolistUser> polistUsers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            PolistUser user = new PolistUser();
            user.setUserName("wang0" + i);
            user.setPassword("123456");
            user.setRegion("130100" + i);
            polistUsers.add(user);
        }
//        mongoTemplate.save(user);
        mongoTemplate.insert(polistUsers,PolistUser.class);
    }

    @Override
    public List<PolistUser> find() {
        PolistUser user = new PolistUser();
        user.setId(10L);
        user.setUserName("wang0");
        user.setPassword("123456");
        user.setRegion("130100");
//        List<PolistUser> all = mongoTemplate.findAll(PolistUser.class);
        Query query = new Query();
        query.addCriteria(Criteria.byExample(Example.of(user)));
        List<PolistUser> all = mongoTemplate.find(query, PolistUser.class);
        return all;
    }

    @Override
    public void remove() {
        Query query = new Query(Criteria.where("userName").is("wang0"));
        WriteResult remove = mongoTemplate.remove(query, PolistUser.class);
        System.out.println(remove);
    }
}
