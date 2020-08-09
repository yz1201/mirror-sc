package cn.dbdj1201.sc.common.dto;

import cn.dbdj1201.sc.entity.UmsAdmin;
import cn.dbdj1201.sc.entity.UmsPermission;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-09 18:32
 */
@Data
@NoArgsConstructor
public class AdminUserDetails implements UserDetails {

    private UmsAdmin umsAdmin;

    private List<UmsPermission> umsPermissions;

    public AdminUserDetails(UmsAdmin umsAdmin, List<UmsPermission> umsPermissions) {
        this.umsAdmin = umsAdmin;
        this.umsPermissions = umsPermissions;
    }

    /**
     * 返回当前用户持有的权限
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return umsPermissions.stream()
                .filter(umsPermission -> umsPermission.getValue() != null)
                .map(umsPermission -> new SimpleGrantedAuthority(umsPermission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
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
        return umsAdmin.getStatus().equals(1);
    }
}
