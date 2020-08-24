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
@ApiModel(value="TbDeptPatient对象", description="")
public class TbDeptPatient implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "不赚差价")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "科室id")
    private Long deptId;

    @ApiModelProperty(value = "患者id")
    private Long patientId;


}
