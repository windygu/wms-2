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
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.orderitemshipgroupassociationmvo.*;

public interface OrderItemShipGroupAssociationMvosClient {

    @Headers("Accept: application/json")
    @GET("OrderItemShipGroupAssociationMvos")
    Call<List<OrderItemShipGroupAssociationMvoStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("OrderItemShipGroupAssociationMvos/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("OrderItemShipGroupAssociationMvos/{id}")
    Call<OrderItemShipGroupAssociationMvoStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("OrderItemShipGroupAssociationMvos/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("OrderItemShipGroupAssociationMvos/{id}/_stateEvents/{version}")
    Call<OrderItemShipGroupAssociationMvoStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("OrderItemShipGroupAssociationMvos/{id}/_historyStates/{version}")
    Call<OrderItemShipGroupAssociationMvoStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("OrderItemShipGroupAssociationMvos/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchOrderItemShipGroupAssociationMvoDto.CreateOrderItemShipGroupAssociationMvoDto value);

    @Headers("Accept: application/json")
    @PATCH("OrderItemShipGroupAssociationMvos/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchOrderItemShipGroupAssociationMvoDto.MergePatchOrderItemShipGroupAssociationMvoDto value);

    @Headers("Accept: application/json")
    @DELETE("OrderItemShipGroupAssociationMvos/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

