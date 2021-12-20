package cn.dbdj1201.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author dbdj1201
 * @since 2020-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "TbPatient对象", description = "")
public class TbPatient implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键，患者编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "患者姓名")
    private String name;

    @ApiModelProperty(value = "性别，0-女性，1-男性")
    private Integer gender;

    @ApiModelProperty(value = "所属科室编号")
    private Long deptId;

    @ApiModelProperty(value = "医嘱内容")
    private String content;


}
