package com.kyj.mapper;

import com.kyj.po.LoginUser;
import com.kyj.po.LoginUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginUserMapper {
    int countByExample(LoginUserExample example);

    int deleteByExample(LoginUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(LoginUser record);

    int insertSelective(LoginUser record);

    List<LoginUser> selectByExample(LoginUserExample example);

    LoginUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") LoginUser record, @Param("example") LoginUserExample example);

    int updateByExample(@Param("record") LoginUser record, @Param("example") LoginUserExample example);

    int updateByPrimaryKeySelective(LoginUser record);

    int updateByPrimaryKey(LoginUser record);
}