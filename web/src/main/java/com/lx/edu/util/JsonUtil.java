package com.lx.edu.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lx.edu.domain.ListJsonBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述: json工具类
 *
 * @author liaox
 * @create 2019-05-04 10:36
 */
public class JsonUtil {
    /**
     * json格式为 result:要返回的数据
     * @return
     */
    public static String toJson(Object object){
        Map<String,Object> map = new HashMap<>();
        if (object == null){
            map.put("result","");
        }else {
            map.put("result",object);
        }
        return JSONObject.toJSONString(map);
    }

    /**
     * json格式为 result:要返回的数据
     * @return
     */
    public static String toJsonList(ListJsonBean jsonBean){
        Map<String,Object> map = new HashMap<>();
        if (jsonBean == null){
            throw new RuntimeException("json数据出错");
        }
        map.put("rows",jsonBean.getList());
        map.put("total",jsonBean.getTotal());
        return JSONArray.toJSONString(map);
    }

    public static String toJsonPureList(List jsonList){
        return JSONArray.toJSONString(jsonList);
    }

    public static String toJsonPure(Object object){
        return JSONObject.toJSONString(object);
    }

}
