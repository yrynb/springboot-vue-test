package com.southwind.springboottest.controller;

import com.southwind.springboottest.entity.USERKS;
import com.southwind.springboottest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login/{name}/{password}")
    public String userLogin(@PathVariable("name") String name, @PathVariable("password") String password){
        if (name.isEmpty()) {
            return "name null error";
        }
        USERKS userFromDB = userRepository.findOneByKNAME(name);
        if (userFromDB == null) {
            return "user not exist error";
        }

        if (password.isEmpty()) {
            return "password null error";
        }
        if(!password.equals(userFromDB.getKPASSWORD())){
            return "password not error";
        }

        return "success";
    }

    @GetMapping("/changepwd/{name}/{newPassword}")
    public String changepwd(@PathVariable("name") String name, @PathVariable("newPassword") String newPassword){
        USERKS userFromDB = userRepository.findOneByKNAME(name);
        if (userFromDB == null){
            return "error";
        }
        userFromDB.setKPASSWORD(newPassword);
        USERKS userks = userRepository.save(userFromDB);
        if (userks == null){
            return "error";
        }

        return "success";
    }
}
