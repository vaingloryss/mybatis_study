package com.vainglory.mapper;

import com.vainglory.domain.Member;
import org.apache.ibatis.annotations.Param;



public interface IMemberDao {
    Member findByUidAndAid(@Param("id") Integer id);
    Member findByUid(@Param("id") Integer id);
}
