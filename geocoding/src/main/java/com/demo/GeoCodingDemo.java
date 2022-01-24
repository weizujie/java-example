package com.demo;

import io.patamon.geocoding.Geocoding;
import io.patamon.geocoding.model.Address;
import io.patamon.geocoding.similarity.Document;
import io.patamon.geocoding.similarity.MatchedResult;

/**
 * @author weizujie
 * @date 2022/1/20
 */
public class GeoCodingDemo {

    public static void main(String[] args) {
        String address1 = "浙江金华义乌市南陈小区8幢2号";
        String address2 = "浙江金华义乌市稠城街道浙江省义乌市宾王路99号后面南陈小区8栋2号";

        // 标准化
        Address normalizing = Geocoding.normalizing(address1);
        System.out.println("标准化：" + normalizing);

        // 解析成分词文档
        Document analyze = Geocoding.analyze(address1);
        System.out.println("解析成分词文档：" + analyze);

        // 相似度计算
        double similarity = Geocoding.similarity(address1, address2);
        System.out.println("相似度计算：" + similarity);

        // 相似度计算, 返回包含更多丰富的数据
        MatchedResult matchedResult = Geocoding.similarityWithResult(address1, address2);
        System.out.println("相似度计算(更多数据)：" + matchedResult);
    }
}
