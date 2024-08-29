package cc.phos.atom.domain.po;

import cc.phos.atom.domain.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.io.Serial;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 
 * </p>
 *
 * @author 骸
 * @since 2024-08-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class UserEntity extends BaseEntity implements UserDetails, Serializable {

    @Serial
    private static final long serialVersionUID = -1880948205856092621L;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 性别; 1 男; 2 女
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 账户状态; 0 正常; 1 临时封禁; 2 永久封禁
     */
    @TableField("status")
    private Integer status;

    /**
     * 封禁截止时间
     */
    @TableField("ban_end_time")
    private LocalDateTime banEndTime;

    /**
     * 角色 ID
     */
    @TableField("role_id")
    private Long roleId;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }

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
}
