package com.karpinskiy.andrew.diplom.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class TestSecurityController {

    @RequestMapping(value = "/admin/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map getAdmin() {
        return Collections.singletonMap("response", "Hello User!");
    }

    @RequestMapping(value = "/user/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map getUser() {
        return Collections.singletonMap("response", "Hello User!");
    }
}
