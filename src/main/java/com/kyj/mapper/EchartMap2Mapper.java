package com.kyj.mapper;

import com.kyj.po.EchartMap2;
import com.kyj.po.EchartMap2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EchartMap2Mapper {
    int countByExample(EchartMap2Example example);

    int deleteByExample(EchartMap2Example example);

    int insert(EchartMap2 record);

    int insertSelective(EchartMap2 record);

    List<EchartMap2> selectByExample(EchartMap2Example example);

    int updateByExampleSelective(@Param("record") EchartMap2 record, @Param("example") EchartMap2Example example);

    int updateByExample(@Param("record") EchartMap2 record, @Param("example") EchartMap2Example example);
}