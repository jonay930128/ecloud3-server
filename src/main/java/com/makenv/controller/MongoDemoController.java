package com.makenv.controller;

import com.makenv.model.PolistUser;
import com.makenv.response.IResponse;
import com.makenv.response.SuccessResponse;
import com.makenv.service.MongoDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wrx on 2017/8/9.
 */
@RestController
@RequestMapping(value = "mongoDemo",method = RequestMethod.GET)
public class MongoDemoController {

    @Autowired
    private MongoDemoService mongoDemoService;

    @RequestMapping("insert")
    public IResponse insert(){
        mongoDemoService.insert();
        return new SuccessResponse();
    }

    @RequestMapping("find")
    public IResponse find(){
        List<PolistUser> list = mongoDemoService.find();
        return new SuccessResponse(list);
    }

    @RequestMapping("remove")
    public IResponse remove(){
        mongoDemoService.remove();
        return new SuccessResponse();
    }
}
