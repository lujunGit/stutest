package demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import demo.model.User;

@RestController
@RequestMapping("/v1")
@ResponseBody
public class UserController {

    private static Map<String,User> userMap = new ConcurrentHashMap<String, User>();

    static{
        for(int i=0;i<10;i++) {
            userMap.put(String.valueOf(i),new User(Long.valueOf(i),"a"+i,"a"+i));
        }
    }

    @RequestMapping("/getUserById/{id}")
    public User getUserById(@PathVariable String id){
        if(userMap.containsKey(id)) {
            return userMap.get(id);
        }else{
            return userMap.get(0);
        }
    }

}
