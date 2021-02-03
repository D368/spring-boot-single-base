package com.tse.cost.common.result;

import com.tse.cost.common.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页结果
 * @author liangw
 * @since 2020/8/21 8:41
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@ApiModel("分页结果")
public class PageResult<T> extends PageParam<T> {
    @ApiModelProperty("总记录数")
    private long total;

    @ApiModelProperty("数据")
    private List<T> records;

    @ApiModelProperty("总页数")
    private long pages;

}
