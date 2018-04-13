package wsz.springboot.springbootjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wsz.springboot.springbootjpa.domain.User;
import wsz.springboot.springbootjpa.service.UserService;

import java.util.List;

/**
 * Created by wsz
 * date 2018/4/13
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * http://localhost:8080/
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll(){
        return userService.findAll();
    }

    /**
     * http://localhost:8080/user?username=haha&password=123456&age=22
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User insertUser(User user){
        return userService.insertByUser(user);
    }
}
