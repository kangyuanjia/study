package com.kyj.mapper;

import com.kyj.po.EchartMap4;
import com.kyj.po.EchartMap4Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EchartMap4Mapper {
    int countByExample(EchartMap4Example example);

    int deleteByExample(EchartMap4Example example);

    int insert(EchartMap4 record);

    int insertSelective(EchartMap4 record);

    List<EchartMap4> selectByExample(EchartMap4Example example);

    int updateByExampleSelective(@Param("record") EchartMap4 record, @Param("example") EchartMap4Example example);

    int updateByExample(@Param("record") EchartMap4 record, @Param("example") EchartMap4Example example);
}