package com.immoc.mapper;

import com.immoc.pojo.SysUser;

import java.util.List;

public interface SysUserMapperCustom {

    List<SysUser> queryUserSimplyInfoById(String id);
}
