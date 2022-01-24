package com.example;

import org.apache.commons.collections4.SetUtils;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author weizujie
 * @date 2022/1/24
 */
public class JaccardDemo {

    public static void main(String[] args) {
        String address1 = "浙江金华义乌市南陈小区8幢2号";
        String address2 = "浙江金华义乌市稠城街道浙江省义乌市宾王路99号后面南陈小区8栋2号";


        double jaccard = jaccard(address1, address2);
        System.out.println("相似度：" + jaccard);
    }

    public static double jaccard(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return 1L;
        }

        if (str1 == null || str2 == null) {
            return 0L;
        }

        Set<Integer> str1Char = str1.chars().boxed().collect(Collectors.toSet());
        System.out.println("str1Char：" + str1Char);

        Set<Integer> str2Char = str2.chars().boxed().collect(Collectors.toSet());
        System.out.println("str2Char：" + str2Char);

        // 交集数量
        int intersectionSize = SetUtils.intersection(str1Char, str2Char).size();
        System.out.println("交集数量：" + intersectionSize);

        // 并集数量
        int unionSize = SetUtils.union(str1Char, str2Char).size();
        System.out.println("并集数量：" + intersectionSize);

        return (double) intersectionSize / (double) unionSize;
    }

}
