package demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import demo.model.User;

@RestController
@ResponseBody
public class Controller {

    @RequestMapping("/api/get/{name}")
    public List<User> get(@PathVariable("name") String name) {
        User user = null;
        List<User> users = new ArrayList<User>();
        for(int i=0;i<10;i++){
            user = new User(Long.valueOf(i),"dajun"+i,"password"+i);
            users.add(user);
        }
        return users;
    }

    @RequestMapping("/api/post")
    public String post() {
        return "POST process has finished.";
    }

    @RequestMapping("/api/user")
    public Object get(HttpServletRequest req) {
        SecurityContextImpl sci = (SecurityContextImpl) req.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        if (sci != null) {
            Authentication authentication = sci.getAuthentication();
            if (authentication != null) {
                return authentication.getPrincipal();
            }
        }
        return "none";
    }
}
