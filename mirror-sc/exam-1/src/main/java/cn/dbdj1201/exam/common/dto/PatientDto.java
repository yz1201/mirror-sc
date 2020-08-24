package cn.dbdj1201.exam.common.dto;

import cn.dbdj1201.exam.entity.TbDept;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yz1201
 * @date 2020-08-24 18:15
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TbPatient运输对象")
public class PatientDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键，患者编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "患者姓名")
    private String name;

    @ApiModelProperty(value = "性别，0-女性，1-男性")
    private Integer gender;

    @ApiModelProperty(value = "所属科室编号")
    private String deptName;

    @ApiModelProperty(value = "医嘱内容")
    private String content;

}
