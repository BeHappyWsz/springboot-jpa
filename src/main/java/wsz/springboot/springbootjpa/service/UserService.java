package wsz.springboot.springbootjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wsz.springboot.springbootjpa.domain.User;
import wsz.springboot.springbootjpa.domain.UserRepository;

import java.util.List;

/**
 * Created by wsz
 * date 2018/4/13
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User insertByUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User getMaxId(){
        return userRepository.getMaxId();
    }

    public User findByUserid(Long id){
        return userRepository.findByUserid(id);
    }

    /**
     * like查询
     * @param username
     * @return
     */
    public List<User> findsByUsername(String username){
        return userRepository.findsByUsername(username);
    }

    /**
     * 相等查询
     * @param username
     * @return
     */
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    /**
     * 多条件查询
     * @param username
     * @param password
     * @return
     */
    public User findByUsernameAndPassword(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password);
    }

    /**
     * 分页
     * @param pageable
     * @return
     */
    public Page<User> findByPage(Pageable pageable){
        return userRepository.findAll(pageable);
    }
}
