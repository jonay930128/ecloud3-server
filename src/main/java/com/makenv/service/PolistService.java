package com.makenv.service;

import com.makenv.model.PolistUser;

import java.util.List;

/**
 * Created by wrx on 2017/8/8.
 */
public interface PolistService {
    List<PolistUser> findAll();

    List<PolistUser> select();
}
