package wsz.springboot.springbootjpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 注意=/:param 不需要空格,要跟紧
 * Created by wsz
 * date 2018/4/13
 */
public interface UserRepository extends JpaRepository<User,Long>{

    /**
     * 无参数查询
     * @return
     */
    @Query("select u from User u where id =(select max(id) from User)")
    User getMaxId();

    /**
     * ?index 方法传参数
     * @param id
     * @return
     */
    @Query("select u from User  u where id =?1")
    User findByUserid(Long id);

    /**
     * like 查询
     * @param username
     * @return
     */
    @Query("select u from User u where u.username like %:username%")
    List<User> findsByUsername(@Param("username") String username);

    /**
     * 相等查询
     * @param username
     * @return
     */
    @Query("select u from User u where u.username = :username")
    User findByUsername(@Param("username")String username);

    /**
     * 多条件查询
     * @param username
     * @param password
     * @return
     */
    @Query("select u from User u where u.username=:username and u.password=:password")
    User findByUsernameAndPassword(@Param("username")String username, @Param("password")String password);
}
