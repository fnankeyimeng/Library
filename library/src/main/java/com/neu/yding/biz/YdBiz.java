package com.neu.yding.biz;

import com.neu.yding.entity.Yding;

import java.util.List;
import java.util.Map;

public interface YdBiz {
    public boolean addYD(Yding yDing);
    public List<Yding> findYD(int uid);
    public boolean delYD(int b_id);
    public List<Yding> findAllYD(int index, int size);

}
