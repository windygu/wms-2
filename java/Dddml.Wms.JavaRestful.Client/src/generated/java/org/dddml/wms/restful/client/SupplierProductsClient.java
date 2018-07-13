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
import org.dddml.wms.domain.supplierproduct.*;

public interface SupplierProductsClient {

    @Headers("Accept: application/json")
    @GET("SupplierProducts")
    Call<List<SupplierProductStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("SupplierProducts/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("SupplierProducts/{id}")
    Call<SupplierProductStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("SupplierProducts/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("SupplierProducts/{id}/_stateEvents/{version}")
    Call<SupplierProductStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("SupplierProducts/{id}/_historyStates/{version}")
    Call<SupplierProductStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("SupplierProducts/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchSupplierProductDto.CreateSupplierProductDto value);

    @Headers("Accept: application/json")
    @POST("SupplierProducts")
    Call<SupplierProductId> post(@Body CreateOrMergePatchSupplierProductDto.CreateSupplierProductDto value);

    @Headers("Accept: application/json")
    @PATCH("SupplierProducts/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchSupplierProductDto.MergePatchSupplierProductDto value);

    @Headers("Accept: application/json")
    @DELETE("SupplierProducts/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

