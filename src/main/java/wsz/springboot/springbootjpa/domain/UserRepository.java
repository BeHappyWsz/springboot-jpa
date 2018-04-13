package wsz.springboot.springbootjpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wsz
 * date 2018/4/13
 */
public interface UserRepository extends JpaRepository<User,Long>{
}
