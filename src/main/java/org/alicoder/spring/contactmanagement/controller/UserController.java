package org.alicoder.spring.contactmanagement.controller;

import org.alicoder.spring.contactmanagement.model.Users;
import org.alicoder.spring.contactmanagement.payload.UserPayload;
import org.alicoder.spring.contactmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired UserService service;

    @GetMapping(value = "/users")
    public ModelAndView listUser(ModelMap model) {
        List<Users> usersList = service.listUser();
        model.addAttribute("users", usersList);
        return new ModelAndView("pages/list_user", model);
    }
    @GetMapping(value = "/users/{id}/delete")
    public String deleteUser(@PathVariable(value = "id") int id) {
        service.delete(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/addNew")
    public ModelAndView register(ModelMap model) {
        UserPayload user = new UserPayload();
        model.addAttribute("userFormAdd", user);
        return new ModelAndView("pages/addNew", model);
    }

    @GetMapping(value ="/{id}")
    public ModelAndView editUser(@PathVariable(value = "id") int id,ModelMap model){
        Users userAll = service.edit(id);
        model.addAttribute("userFormEdit", userAll);
        return new ModelAndView("pages/edit", model);
    }


}
