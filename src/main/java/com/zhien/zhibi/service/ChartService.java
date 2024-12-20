package com.zhien.zhibi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhien.zhibi.model.dto.chart.ChartQueryRequest;
import com.zhien.zhibi.model.dto.user.UserQueryRequest;
import com.zhien.zhibi.model.entity.Chart;

/**
* @author zhien
* @description 针对表【chart(图表信息表)】的数据库操作Service
* @createDate 2024-12-18 17:27:36
*/
public interface ChartService extends IService<Chart> {
    /**
     * 获取查询条件
     *
     * @param chartQueryRequest 查询条件
     * @return Chart
     */
    QueryWrapper<Chart> getQueryWrapper(ChartQueryRequest chartQueryRequest);
}
