package com.makenv.controller;

import com.makenv.model.PolistUser;
import com.makenv.response.IResponse;
import com.makenv.response.SuccessResponse;
import com.makenv.service.PolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wrx on 2017/8/8.
 */
@RestController
@RequestMapping(value = "polistUser",method = RequestMethod.GET)
public class PolistUserController {
    @Autowired
    private PolistService polistService;

    @RequestMapping("findAll")
    public IResponse findAll(){
        List<PolistUser> list = polistService.findAll();
        return new SuccessResponse(list);
    }

    @RequestMapping("select")
    public IResponse select(){
        List<PolistUser> list = polistService.select();
        return new SuccessResponse(list);
    }
}
