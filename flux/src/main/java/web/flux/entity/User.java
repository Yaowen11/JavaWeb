package web.flux.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import web.flux.config.JsonViewInterface;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * @author z
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViewInterface.Video.ViewHot.class)
    private BigInteger id;

    @Column
    @NotNull(message = "用户名不能为空")
    @JsonView(JsonViewInterface.Video.ViewHot.class)
    private String name;

    @Column
    @NotNull(message = "密码不能为空")
    @JsonView(JsonViewInterface.Video.ViewHot.class)
    private String password;

    @Column
    @NotNull(message = "请指定性别")
    @JsonView(JsonViewInterface.Video.ViewHot.class)
    private Integer gender;

    @Column
    @NotNull
    @JsonView(JsonViewInterface.Video.ViewHot.class)
    private Date birthday;

    @Column(unique = true)
    @NotNull
    @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号格式错误")
    @JsonView(JsonViewInterface.Video.All.class)
    private String phone;

    @Column
    @JsonView(JsonViewInterface.Video.All.class)
    private Integer state;

    @Column(unique = true)
    @Email
    @JsonView(JsonViewInterface.Video.All.class)
    private String email;

    @Column
    @JsonView(JsonViewInterface.Video.ViewHot.class)
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd H:i:s")
    private Timestamp createdAt;

    @Column
    @JsonView(JsonViewInterface.Video.ViewHot.class)
    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd H:i:s")
    private Timestamp updatedAt;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return name;
    }

}
