package org.dddml.wms.restful.client;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.productcategory.*;

public interface ProductCategoriesClient {

    @Headers("Accept: application/json")
    @GET("ProductCategories")
    Call<List<ProductCategoryStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("ProductCategories/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("ProductCategories/{productCategoryId}")
    Call<ProductCategoryStateDto> get(@Path("productCategoryId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("ProductCategories/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("ProductCategories/{productCategoryId}/_stateEvents/{version}")
    Call<ProductCategoryStateEventDto> getStateEvent(@Path("productCategoryId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("ProductCategories/{productCategoryId}/_historyStates/{version}")
    Call<ProductCategoryStateDto> getHistoryState(@Path("productCategoryId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("ProductCategories/{productCategoryId}")
    Call<String> put(@Path("productCategoryId") String id, @Body CreateOrMergePatchProductCategoryDto.CreateProductCategoryDto value);

    @Headers("Accept: application/json")
    @POST("ProductCategories")
    Call<String> post(@Body CreateOrMergePatchProductCategoryDto.CreateProductCategoryDto value);

    @Headers("Accept: application/json")
    @PATCH("ProductCategories/{productCategoryId}")
    Call<String> patch(@Path("productCategoryId") String id, @Body CreateOrMergePatchProductCategoryDto.MergePatchProductCategoryDto value);

    @Headers("Accept: application/json")
    @DELETE("ProductCategories/{productCategoryId}")
    Call<String> delete(@Path("productCategoryId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

