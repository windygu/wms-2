package org.dddml.wms.restful.client;

import java.util.List;

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
import org.dddml.wms.domain.statusitem.*;

public interface StatusItemsClient {

    @Headers("Accept: application/json")
    @GET("StatusItems")
    Call<List<StatusItemStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("StatusItems/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("StatusItems/{id}")
    Call<StatusItemStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("StatusItems/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("StatusItems/{id}/_historyStates/{version}")
    Call<StatusItemStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("StatusItems/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchStatusItemDto.CreateStatusItemDto value);

    @Headers("Accept: application/json")
    @POST("StatusItems")
    Call<String> post(@Body CreateOrMergePatchStatusItemDto.CreateStatusItemDto value);

    @Headers("Accept: application/json")
    @PATCH("StatusItems/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchStatusItemDto.MergePatchStatusItemDto value);

    @Headers("Accept: application/json")
    @DELETE("StatusItems/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

