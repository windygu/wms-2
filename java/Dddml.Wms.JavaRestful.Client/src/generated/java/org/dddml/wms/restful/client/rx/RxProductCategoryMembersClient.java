package org.dddml.wms.restful.client.rx;

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
import rx.Observable;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.productcategorymember.*;

public interface RxProductCategoryMembersClient {

    @Headers("Accept: application/json")
    @GET("ProductCategoryMembers")
    Observable<List<ProductCategoryMemberStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("ProductCategoryMembers/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("ProductCategoryMembers/{productCategoryMemberId}")
    Observable<ProductCategoryMemberStateDto> get(@Path("productCategoryMemberId") String productCategoryMemberId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("ProductCategoryMembers/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("ProductCategoryMembers/{productCategoryMemberId}/_stateEvents/{version}")
    Observable<ProductCategoryMemberStateEventDto> getStateEvent(@Path("productCategoryMemberId") String productCategoryMemberId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("ProductCategoryMembers/{productCategoryMemberId}/_historyStates/{version}")
    Observable<ProductCategoryMemberStateDto> getHistoryState(@Path("productCategoryMemberId") String productCategoryMemberId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("ProductCategoryMembers/{productCategoryMemberId}")
    Observable<String> put(@Path("productCategoryMemberId") String productCategoryMemberId, @Body CreateOrMergePatchProductCategoryMemberDto.CreateProductCategoryMemberDto value);

    @Headers("Accept: application/json")
    @POST("ProductCategoryMembers")
    Observable<ProductCategoryMemberId> post(@Body CreateOrMergePatchProductCategoryMemberDto.CreateProductCategoryMemberDto value);

    @Headers("Accept: application/json")
    @PATCH("ProductCategoryMembers/{productCategoryMemberId}")
    Observable<String> patch(@Path("productCategoryMemberId") String productCategoryMemberId, @Body CreateOrMergePatchProductCategoryMemberDto.MergePatchProductCategoryMemberDto value);

    @Headers("Accept: application/json")
    @DELETE("ProductCategoryMembers/{productCategoryMemberId}")
    Observable<String> delete(@Path("productCategoryMemberId") String productCategoryMemberId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

