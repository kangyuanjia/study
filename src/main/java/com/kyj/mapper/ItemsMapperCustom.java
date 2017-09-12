package com.kyj.mapper;

import java.util.List;

import com.kyj.po.ItemsCustom;
import com.kyj.po.ItemsQueryVo;

public interface ItemsMapperCustom {
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}