package com.mine.docdemo.mapper;

import com.mine.docdemo.entity.Supplier;
import com.mine.docdemo.entity.SupplierExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author weapon
* Created 2020-05-07 14:13:50
*/
@Mapper
public interface SupplierMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Supplier record);

    List<Supplier> selectByExample(SupplierExample example);

    Supplier selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Supplier record);
}