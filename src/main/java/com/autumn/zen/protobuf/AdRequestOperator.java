package com.autumn.zen.protobuf;

/**
 * 操作
 *
 * @since 2022-08-24
 */
public class AdRequestOperator {

    public static void main(String[] args) {


        AdRequestPb.AdRequest request=  AdRequestPb.AdRequest.newBuilder().setArticleResponse(AdRequestPb.ArticleResponse.newBuilder().setAuthor("xxx")).build();

        System.out.println(request.hasArticleResponse());
        System.out.println(request.getArticleResponse());

    }
}
