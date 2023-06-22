package com.example.util;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BeanCovertUtils extends BeanUtils {

    public static <S, T> T covertTo(S source, Supplier<T> targetSupplier) {
        return covertTo(source, targetSupplier, null);
    }

    public static <S, T> List<T> covertListTo(List<S> sourceList, Supplier<T> targetSupplier) {
        return covertListTo(sourceList, targetSupplier, null);
    }

    public static <S, T> T deepCovertTo(S source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        String json = JSON.toJSONString(source);
        return JSON.parseObject(json, targetClass);
    }

    public static <S, T> List<T> deepCovertListTo(List<S> sources, Class<T> targetClass) {
        if (sources == null) {
            return null;
        }
        String json = JSON.toJSONString(sources);
        return JSON.parseArray(json, targetClass);
    }

    public static <S, T> T covertTo(S source, Supplier<T> targetSupplier, ConvertCallBack<S, T> callBack) {
        if (null == source || targetSupplier == null) {
            return null;
        }
        T target = targetSupplier.get();
        copyProperties(source, target);
        if (callBack != null) {
            callBack.callBack(source, target);
        }
        return target;
    }

    public static <S, T> List<T> covertListTo(List<S> sources, Supplier<T> targetSupplier, ConvertCallBack<S, T> callBack) {
        if (null == sources || null == targetSupplier) {
            return null;
        }
        List<T> targets = new ArrayList<>(sources.size());
        for(S source : sources) {
            T target = targetSupplier.get();
            copyProperties(source, target);
            if (callBack != null) {
                callBack.callBack(source, target);
            }
            targets.add(target);
        }
        return targets;
    }


    /**
     * 回调接口
     *
     * @param <S> 源对象类型
     * @param <T> 目标对象类型
     */
    @FunctionalInterface
    public interface ConvertCallBack<S, T> {
        void callBack(S t, T s);
    }
}
