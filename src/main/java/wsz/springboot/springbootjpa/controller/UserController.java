package wsz.springboot.springbootjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    /**
     * http://localhost:8080/user/getMaxId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/getMaxId", method = RequestMethod.GET)
    public User getMaxId(){
        return userService.getMaxId();
    }

    /**
     * ?index 传参数
     * http://localhost:8080/user/findByUserid?id=9
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/findByUserid", method = RequestMethod.GET)
    public User findByUserid(@RequestParam(value = "id",  required = true)Long id){
        return userService.findByUserid(id);
    }

    /**
     * like 查询
     * http://localhost:8080/user/like/haha
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/like/{username}", method = RequestMethod.GET)
    public List<User> findsByUsername(@PathVariable("username")String username){
        return userService.findsByUsername(username);
    }

    /**
     * 相等查询
     * http://localhost:8080/user/findByUsername?username=haha
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/findByUsername", method = RequestMethod.GET)
    public User findByUsername(@RequestParam(value = "username", defaultValue = "a", required = true) String username){
        return userService.findByUsername(username);
    }


    /**
     * 多条件查询
     * http://localhost:8080/user/findByUsernameAndPassword?password=123456&username=hhh
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/findByUsernameAndPassword", method = RequestMethod.GET)
    public User findByUsernameAndPassword(String username, String password){
        return userService.findByUsernameAndPassword(username, password);
    }

    /**
     * http://localhost:8080/user/findByPage?size=2&page=1
     * @param page 当前页
     * @param size 每页数据数量
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/findByPage", method = RequestMethod.GET)
    public Page<User> findByPage(@RequestParam(value = "page", defaultValue ="0") int page, @RequestParam(value = "size", defaultValue = "20") int size){
       //根据id，倒序
        Pageable pageable = new PageRequest(page, size, new Sort(new Sort.Order(Sort.Direction.DESC,"id")));
        return userService.findByPage(pageable);
    }
}
