package com.dao;

import com.entity.ChayeCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChayeCommentbackView;

/**
 * 茶叶评价 Dao 接口
 *
 * @author 
 */
public interface ChayeCommentbackDao extends BaseMapper<ChayeCommentbackEntity> {

   List<ChayeCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
