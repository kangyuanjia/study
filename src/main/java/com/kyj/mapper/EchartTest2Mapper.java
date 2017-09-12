package com.kyj.mapper;

import com.kyj.po.EchartTest2;
import com.kyj.po.EchartTest2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EchartTest2Mapper {
    int countByExample(EchartTest2Example example);

    int deleteByExample(EchartTest2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(EchartTest2 record);

    int insertSelective(EchartTest2 record);

    List<EchartTest2> selectByExample(EchartTest2Example example);

    EchartTest2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EchartTest2 record, @Param("example") EchartTest2Example example);

    int updateByExample(@Param("record") EchartTest2 record, @Param("example") EchartTest2Example example);

    int updateByPrimaryKeySelective(EchartTest2 record);

    int updateByPrimaryKey(EchartTest2 record);
}