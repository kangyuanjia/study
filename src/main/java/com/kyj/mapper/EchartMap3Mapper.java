package com.kyj.mapper;

import com.kyj.po.EchartMap3;
import com.kyj.po.EchartMap3Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EchartMap3Mapper {
    int countByExample(EchartMap3Example example);

    int deleteByExample(EchartMap3Example example);

    int insert(EchartMap3 record);

    int insertSelective(EchartMap3 record);

    List<EchartMap3> selectByExample(EchartMap3Example example);

    int updateByExampleSelective(@Param("record") EchartMap3 record, @Param("example") EchartMap3Example example);

    int updateByExample(@Param("record") EchartMap3 record, @Param("example") EchartMap3Example example);
}