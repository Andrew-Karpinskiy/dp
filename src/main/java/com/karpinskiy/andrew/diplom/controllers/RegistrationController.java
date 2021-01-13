package com.karpinskiy.andrew.diplom.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class RegistrationController {
    // private UserService service;

//    @Autowired
//    public void setService(UserService service) {
//        this.service = service;
//    }

//    @GetMapping("/registration")
//    public String registration() {
//        return "registration";
//    }
//

//    @RequestMapping(value = "/registration/{em}/{pa}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Map addUser(@PathVariable("em") String email, @PathVariable("pa") String password) {
//        System.out.println("CONNECTED!!!!!!!!!!!!!!!");
//        UserEntity user = new UserEntity(email, password);
//        UserEntity userFromDb = service.getUserByEmail(user.getUsername());
//        if (userFromDb != null) {
//            return Collections.singletonMap("response", "exist");
//        }
//        user.setRoles(Collections.singleton(Roles.USER));
//        service.saveUser(user);
//        return Collections.singletonMap("response", "correct");
//    }
}
