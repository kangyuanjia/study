package com.kyj.mapper;

import com.kyj.po.EchartTest1;
import com.kyj.po.EchartTest1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EchartTest1Mapper {
    int countByExample(EchartTest1Example example);

    int deleteByExample(EchartTest1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(EchartTest1 record);

    int insertSelective(EchartTest1 record);

    List<EchartTest1> selectByExample(EchartTest1Example example);

    EchartTest1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EchartTest1 record, @Param("example") EchartTest1Example example);

    int updateByExample(@Param("record") EchartTest1 record, @Param("example") EchartTest1Example example);

    int updateByPrimaryKeySelective(EchartTest1 record);

    int updateByPrimaryKey(EchartTest1 record);
}