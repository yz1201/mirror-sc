package cn.dbdj1201.sc.common.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-09 10:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "CommonPage", description = "分页VO")
public class CommonPage<T> {
    //每页条数
    @ApiModelProperty("每页条数")
    private Integer pageSize;
    //当前页码
    @ApiModelProperty("当前页码")
    private Integer currentPage;
    //总页数
    @ApiModelProperty("总页数")
    private Integer totalPage;
    //当前页数据
    @ApiModelProperty("当前页数据")
    private List<T> data;
    //总记录数
    @ApiModelProperty("总记录数")
    private Long total;

    /**
     * 转换为分页VO
     *
     * @param pageInfo
     * @return
     */
    public static <T> CommonPage<T> restPage(Page<T> pageInfo) {
        CommonPage<T> commonPage = new CommonPage<>();
        commonPage.setPageSize(pageInfo.getSize());
        commonPage.setCurrentPage(pageInfo.getNumber());
        commonPage.setTotalPage(pageInfo.getTotalPages());
        commonPage.setData(pageInfo.getContent());
        commonPage.setTotal(pageInfo.getTotalElements());
        return commonPage;
    }

}
