package com.dao;

import com.entity.ChayeCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChayeCollectionView;

/**
 * 茶叶收藏 Dao 接口
 *
 * @author 
 */
public interface ChayeCollectionDao extends BaseMapper<ChayeCollectionEntity> {

   List<ChayeCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
