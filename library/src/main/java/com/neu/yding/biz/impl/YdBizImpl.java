package com.neu.yding.biz.impl;

import com.neu.yding.biz.YdBiz;
import com.neu.yding.entity.Yding;
import com.neu.yding.mapper.YdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ydBiz")
public class YdBizImpl implements YdBiz {
    @Autowired
    private YdMapper ydMapper;
    @Override
    public boolean addYD(Yding yDing) {
        return ydMapper.addYD(yDing);
    }

    @Override
    public List<Yding> findYD(int uid) {
        return ydMapper.findYD(uid);
    }

    @Override
    public boolean delYD(int b_id) {
        return ydMapper.delYD(b_id);
    }

    @Override
    public List<Yding> findAllYD(int index, int size) {
        //创建map将参数存入map集合中
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("index",index);
        map.put("size", size);
        List<Yding> list= ydMapper.findAllYD(map);
        return list;
    }
}
