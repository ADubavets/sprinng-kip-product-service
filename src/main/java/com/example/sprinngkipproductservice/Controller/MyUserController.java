package com.example.sprinngkipproductservice.Controller;

import com.example.sprinngkipproductservice.Model.MyUser;
import com.example.sprinngkipproductservice.Model.Role;
import com.example.sprinngkipproductservice.Service.MyUserService;
import com.example.sprinngkipproductservice.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class MyUserController {
    @Autowired
    private MyUserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = {"/index","/"})
    public String index(){
        return "index";
    }

    @GetMapping(value ="/users" )
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping(value = "/edit_user")
    public String editUser(Model model, @RequestParam(name="id") Long id){
        Optional<MyUser> user = userService.userFindById(id);
        model.addAttribute("user",user.get());
        model.addAttribute("roles",roleService.findAll());
        return "edit_user";
    }

    @PutMapping(value = "/edit_user")
    public String editUser(MyUser newUser,
                           Model model,
                           @RequestParam(value = "role", required = true) long[] roles) {

        Set<Role> rolesNew = new HashSet<>();
        if (roles!=null){
            for (int i=0; i<roles.length; i++) {
                System.out.println(roleService.findById(roles[i]));
                rolesNew.add(roleService.findById(roles[i]).get());
            }
        }

        return userService.userFindById(newUser.getId()).map(user -> {
            user.setEnabled(newUser.isEnabled());
            user.setRoles(rolesNew);
            userService.save(user);
            model.addAttribute("users", userService.findAll());
            return "redirect:/users";
        }).orElseGet(() -> {
            userService.save(newUser);
            model.addAttribute("users", userService.findAll());
            return "redirect:/users";
        });
    }

    //Регистрация
    @GetMapping(value ="/signup")
    public String signup(Model model) {
        model.addAttribute("user",new MyUser());
        //Если не добавить, то не будет выполняться парсинг шаблона исходной страницы
        return "signup";
    }

    @PostMapping(value="/signup")
    public String saveUser(MyUser user,
                           HttpServletResponse response,
                           @RequestParam(value = "password2", required = true) String password2) {
        System.out.println(user);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Fill all fields");
        }
        if (userService.getUserByUserName(user.getUsername()) != null ||
                userService.getUserByEmail(user.getEmail()) != null ) {
            throw new ResponseStatusException(HttpStatus.FOUND,
                    "User with this username or email already exists");
        }
        if (!user.getPassword().equals(password2)){
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Passwords do not match");
        }
        Set<Role> rolesNew = new HashSet<>();
        rolesNew.add(roleService.findById(3L).get());
        user.setRoles(rolesNew);
        user.setEnabled(true);
        //Передать id в заголовке ответа
        MyUser newUser = userService.save(user);

        long id = newUser.getId();
        response.addHeader("id", String.valueOf(id));
        return "index";
    }

    @GetMapping(value = "/delete_user")
    public String deleteUser(@RequestParam(name="id")Long id) { userService.deleteById(id);
        return "redirect:/users";
    }

    //вход
    @GetMapping(value ="/signin")
    public String signIn() {
        return "signin";
    }

    @GetMapping(value ="/signin-error")
    public String signInError(Model model) {
        model.addAttribute("loginError",true);
        return "signin";
    }

    @PostMapping(value="/signin")
    public String saveInUser(@RequestParam(name = "username") String username,
                             @RequestParam(name = "password") String password) {
        MyUser user = userService.getUserByUserName(username);
        if (user==null || !user.getPassword().equals(password)) return "redirect:/signin-error";
        else return "index";

    }
}
