package com.makenv.service;

import com.makenv.model.PolistUser;

import java.util.List;

/**
 * Created by wrx on 2017/8/9.
 */
public interface MongoDemoService {
    void insert();

    List<PolistUser> find();

    void remove();
}
