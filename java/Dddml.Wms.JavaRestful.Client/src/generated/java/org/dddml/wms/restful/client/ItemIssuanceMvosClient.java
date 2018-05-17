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
import retrofit2.http.Path;
import retrofit2.http.Query;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.itemissuancemvo.*;

public interface ItemIssuanceMvosClient {

    @Headers("Accept: application/json")
    @GET("ItemIssuanceMvos")
    Call<List<ItemIssuanceMvoStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("ItemIssuanceMvos/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("ItemIssuanceMvos/{id}")
    Call<ItemIssuanceMvoStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("ItemIssuanceMvos/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("ItemIssuanceMvos/{id}/_stateEvents/{version}")
    Call<ItemIssuanceMvoStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("ItemIssuanceMvos/{id}/_historyStates/{version}")
    Call<ItemIssuanceMvoStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("ItemIssuanceMvos/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchItemIssuanceMvoDto.CreateItemIssuanceMvoDto value);

    @Headers("Accept: application/json")
    @PATCH("ItemIssuanceMvos/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchItemIssuanceMvoDto.MergePatchItemIssuanceMvoDto value);

    @Headers("Accept: application/json")
    @DELETE("ItemIssuanceMvos/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

