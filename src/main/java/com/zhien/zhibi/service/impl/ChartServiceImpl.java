package com.zhien.zhibi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhien.zhibi.common.ErrorCode;
import com.zhien.zhibi.constant.CommonConstant;
import com.zhien.zhibi.exception.BusinessException;
import com.zhien.zhibi.mapper.ChartMapper;
import com.zhien.zhibi.model.dto.chart.ChartQueryRequest;
import com.zhien.zhibi.model.entity.Chart;
import com.zhien.zhibi.model.entity.User;
import com.zhien.zhibi.service.ChartService;
import com.zhien.zhibi.utils.SqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author zhien
 * @description 针对表【chart(图表信息表)】的数据库操作Service实现
 * @createDate 2024-12-18 17:27:36
 */
@Service
public class ChartServiceImpl extends ServiceImpl<ChartMapper, Chart>
        implements ChartService {

    /**
     * 获取查询条件
     *
     * @param chartQueryRequest 查询条件
     * @return
     */
    @Override
    public QueryWrapper<Chart> getQueryWrapper(ChartQueryRequest chartQueryRequest) {
        if (chartQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        Long id = chartQueryRequest.getId();
        String name = chartQueryRequest.getName();
        String goal = chartQueryRequest.getGoal();
        String chartType = chartQueryRequest.getChartType();
        String genChart = chartQueryRequest.getGenChart();
        String genResult = chartQueryRequest.getGenResult();
        Long userId = chartQueryRequest.getUserId();
        String sortField = chartQueryRequest.getSortField();
        String sortOrder = chartQueryRequest.getSortOrder();


        QueryWrapper<Chart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(id != null && id > 0, "id", id);
        queryWrapper.eq(userId != null && userId > 0, "userId", userId);
        queryWrapper.eq(StringUtils.isNotBlank(goal), "goal", goal);
        queryWrapper.eq(StringUtils.isNotBlank(chartType), "chartType", chartType);
        queryWrapper.like(StringUtils.isNotBlank(name), "name", name);
        queryWrapper.like(StringUtils.isNotBlank(genChart), "genChart", genChart);
        queryWrapper.like(StringUtils.isNotBlank(genResult), "genResult", genResult);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;

    }
}




