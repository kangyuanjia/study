package com.kyj.mapper;

import com.kyj.po.EchartMap1;
import com.kyj.po.EchartMap1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EchartMap1Mapper {
    int countByExample(EchartMap1Example example);

    int deleteByExample(EchartMap1Example example);

    int insert(EchartMap1 record);

    int insertSelective(EchartMap1 record);

    List<EchartMap1> selectByExample(EchartMap1Example example);

    int updateByExampleSelective(@Param("record") EchartMap1 record, @Param("example") EchartMap1Example example);

    int updateByExample(@Param("record") EchartMap1 record, @Param("example") EchartMap1Example example);
}