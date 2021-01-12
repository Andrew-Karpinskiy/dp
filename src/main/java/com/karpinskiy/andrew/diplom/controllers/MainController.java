package com.karpinskiy.andrew.diplom.controllers;

import com.karpinskiy.andrew.diplom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @Autowired
    UserService service;

//    @PostMapping("/getById")
//    public String getUser(@RequestParam Long id, Model model) {
//        model.addAttribute("id", id);
//        return "result";
//    }
//
//    @GetMapping("/")
//    public String main() {
//        return "main";
//    }

//    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Map test() {
//        System.out.println("CONNNNNECTTTTTTED!!!!!!!!!!!!!!!!!!!!!!!!");
//        return Collections.singletonMap("response", "Hello World");
//    }
//
//    @RequestMapping(value = "/test/{name}/{surname}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Map test1(@PathVariable("name") String name, @PathVariable("surname") String surname) {
//        System.out.println("Name " + name + "Surname " + surname);
//        System.out.println("CONNNNNECTTTTTTED!!!!!!!!!!!!!!!!!!!!!!!!");
//        return Collections.singletonMap("response", "CORRECT!");
//    }
}
