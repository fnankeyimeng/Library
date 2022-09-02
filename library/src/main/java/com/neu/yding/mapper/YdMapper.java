package com.neu.yding.mapper;

import com.neu.yding.entity.Yding;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface YdMapper {
    public boolean addYD(Yding yDing);
    public List<Yding> findYD(int uid);
    public boolean delYD(int b_id);
    public List<Yding> findAllYD(Map<String,Object> map);
}
