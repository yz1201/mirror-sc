package cn.dbdj1201.sc.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-10 13:35
 * 用户登录DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsAdminInfo {
    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不可以为空")
    private String password;

}
