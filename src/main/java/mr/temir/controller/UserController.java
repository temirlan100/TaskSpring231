package mr.temir.controller;

import mr.temir.model.Users;
import mr.temir.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UsersService userService;

    @Value("${msg.title}")
    private final String title = "Spring MVC + Hibernate CRUD";

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("title", title);
        return "index";
    }

    @GetMapping(value = "/users")
    public String getContacts(Model model) {
        model.addAttribute("users", userService.findAllUsers());

        return "users";
    }

    @GetMapping(value = {"/users/add"})
    public String showAddContact(Model model) {
        Users user = new Users();
        model.addAttribute("add", true);
        model.addAttribute("user", user);

        return "user-edit";
    }

    @PostMapping(value = "/users/add")
    public String addContact(Model model, @ModelAttribute("user") Users user) {
        try {
            Users newUser = userService.saveUser(user);

            return "redirect:/users/" + newUser.getId();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);

            return "user-edit";
        }
    }

    @GetMapping(value = {"/users/{userId}/edit"})
    public String showEditContact(Model model, @PathVariable long userId) {
        Users user = userService.findUserById(userId);
        model.addAttribute("add", false);
        model.addAttribute("user", user);
        return "user-edit";
    }

    @PostMapping(value = {"/users/{userId}/edit"})
    public String updateContact(Model model,
                                @PathVariable long userId,
                                @ModelAttribute("user") Users user) {
        try {
            user.setId(userId);
            userService.updateUser(user);

            return "redirect:/users/" + user.getId();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);

            return "user-edit";
        }
    }

    @GetMapping(value = "/users/{userId}")
    public String getContactById(Model model, @PathVariable long userId) {
        Users user = userService.findUserById(userId);
        model.addAttribute("user", user);

        return "user";
    }

    @GetMapping(value = {"/users/{userId}/delete"})
    public String showDeleteContactById(Model model, @PathVariable long userId) {
        Users user = userService.findUserById(userId);

        model.addAttribute("allowDelete", true);
        model.addAttribute("user", user);

        return "user";
    }

    @PostMapping(value = {"/users/{userId}/delete"})
    public String deleteContactById(Model model, @PathVariable long userId) {
        try {
            userService.deleteUserById(userId);

            return "redirect:/users";
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            model.addAttribute("errorMessage", errorMessage);

            return "user";
        }
    }
}
