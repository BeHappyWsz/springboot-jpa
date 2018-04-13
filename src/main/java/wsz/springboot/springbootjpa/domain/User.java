package wsz.springboot.springbootjpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by wsz
 * date 2018/4/13
 */
@Entity
@Table(name = "s_user")
public class User implements Serializable{

    @Id
    @Setter
    @Getter
    @GeneratedValue
    private Long id;

    @Setter
    @Getter
    @NotNull(message = "用户名不能为空")
    @Size(min = 3, max = 16, message = "用户名长度大于3小于16字")
    private String username;

    @Setter
    @Getter
    @NotNull(message = "密码不能为空")
    @Size(min = 6, max = 16, message = "密码长度大于6小于16字")
    private String password;

    @Setter
    @Getter
    @NotNull(message = "年龄不能为空")
    @Min(value = 0, message = "年龄不能小于0")
    @Max(value = 100, message = "年龄不能大于100")
    private Integer age;
}
