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
import org.dddml.wms.domain.productcategorymember.*;

public interface ProductCategoryMembersClient {

    @Headers("Accept: application/json")
    @GET("ProductCategoryMembers")
    Call<List<ProductCategoryMemberStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("ProductCategoryMembers/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("ProductCategoryMembers/{productCategoryMemberId}")
    Call<ProductCategoryMemberStateDto> get(@Path("productCategoryMemberId") String productCategoryMemberId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("ProductCategoryMembers/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("ProductCategoryMembers/{productCategoryMemberId}/_stateEvents/{version}")
    Call<ProductCategoryMemberStateEventDto> getStateEvent(@Path("productCategoryMemberId") String productCategoryMemberId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("ProductCategoryMembers/{productCategoryMemberId}/_historyStates/{version}")
    Call<ProductCategoryMemberStateDto> getHistoryState(@Path("productCategoryMemberId") String productCategoryMemberId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("ProductCategoryMembers/{productCategoryMemberId}")
    Call<String> put(@Path("productCategoryMemberId") String productCategoryMemberId, @Body CreateOrMergePatchProductCategoryMemberDto.CreateProductCategoryMemberDto value);

    @Headers("Accept: application/json")
    @POST("ProductCategoryMembers")
    Call<ProductCategoryMemberId> post(@Body CreateOrMergePatchProductCategoryMemberDto.CreateProductCategoryMemberDto value);

    @Headers("Accept: application/json")
    @PATCH("ProductCategoryMembers/{productCategoryMemberId}")
    Call<String> patch(@Path("productCategoryMemberId") String productCategoryMemberId, @Body CreateOrMergePatchProductCategoryMemberDto.MergePatchProductCategoryMemberDto value);

    @Headers("Accept: application/json")
    @DELETE("ProductCategoryMembers/{productCategoryMemberId}")
    Call<String> delete(@Path("productCategoryMemberId") String productCategoryMemberId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

