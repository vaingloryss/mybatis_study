package com.vainglory.mapper;

import com.vainglory.domain.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAddressDao {
    List<Address> findByUid(@Param("uid") Integer uid);
}
