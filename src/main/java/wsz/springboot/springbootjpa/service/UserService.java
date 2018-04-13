package wsz.springboot.springbootjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
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
}
