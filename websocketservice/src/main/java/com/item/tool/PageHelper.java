package com.item.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * 分页助手
 * @param <T>
 */

public class PageHelper <T>{



    @Value("${pageHelper.count}")
    private int count;

    @Value("${pageHelper.soncount")
    private int soncount;

//    public T get_data(int page,Class<T> tClass){
//
//
//    }
}
