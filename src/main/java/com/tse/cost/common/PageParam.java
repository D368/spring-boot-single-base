package com.tse.cost.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 分页参数
 * @author liangw
 * @since 2020/8/20 18:29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("分页参数")
public class PageParam<T> implements Serializable {
    @ApiModelProperty(value = "当前页数", name = "current")
    private Long current;
    @ApiModelProperty(value = "每页条数", name = "size")
     private Long size;

    public PageParam() {
        this.current = 1L;
        this.size = 10L;
    }
    public PageParam(Long current,Long size) {
        if (current==null){
            current = 1L;
        }
        this.current = current;
        if (size==null){
            size = 10L;
        }
        this.size = size;
    }



    public Page<T> createPage() {

        return new Page<T>(current,size);
    }
}
