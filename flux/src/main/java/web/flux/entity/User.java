package web.flux.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author z
 */
@Entity
@Data
public class User {
    @Id
    private Long id;
    @Column
    @NotNull(message = "用户名不能为空")
    private String name;
    @Column
    @NotNull(message = "密码不能为空")
    private String password;
    @Column
    @NotNull(message = "请指定性别")
    private Byte gender;
    @Column
    @NotNull
    private Date birthday;
    @Column(unique = true)
    @NotNull
    @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号格式错误")
    private String phone;
    @Column
    private byte state;
    @Column(unique = true)
    @Email
    private String email;
    @Column
    private Timestamp createdAt;
    @Column
    private Timestamp updatedAt;
}
