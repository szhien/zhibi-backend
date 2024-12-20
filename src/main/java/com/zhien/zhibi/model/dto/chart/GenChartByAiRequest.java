package com.zhien.zhibi.model.dto.chart;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Zhien
 * @version 1.0
 * @name GenChartByAiRequest
 * @description 通过Ai接口生成图表信息的请求参数
 * @createDate 2024/12/20 14:33
 */
@Data
public class GenChartByAiRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 图表名称
     */
    private String name;

    private static final long serialVersionUID = -3315816485905421456L;
}
