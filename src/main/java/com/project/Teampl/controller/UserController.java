package com.project.Teampl.controller;

import com.project.Teampl.model.User;
import com.project.Teampl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;
import java.util.List;

//@RestController
//@RequestMapping("user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String getMessage(){
        return "home";
    }

    @GetMapping("/user/signIn")
    public String signInForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "/user/userSignForm";
    }

    @PostMapping("/user/signIn")
    public String signIn(@Valid UserForm userForm, BindingResult result) {

        if(result.hasErrors()) {
            return "/user/userSignForm";
        }

        User user = new User();
        user.setUsername(userForm.getUsername());
        user.setUserid(userForm.getUserid());
        user.setUserpw(userForm.getUserpw());

        userService.signIn(user);

        return "redirect:/";
    }

//    @GetMapping(value="/all", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<List<User>> getAllUsers(){
    @GetMapping("/user/all")
    public String getAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);

//        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        return "/user/userList";
    }
}
