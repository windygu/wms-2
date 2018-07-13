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
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.order.*;

public interface OrdersClient {

    @Headers("Accept: application/json")
    @GET("Orders")
    Call<List<OrderStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Orders/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Orders/{id}")
    Call<OrderStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Orders/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Orders/{id}/_stateEvents/{version}")
    Call<OrderStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Orders/{id}/_historyStates/{version}")
    Call<OrderStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Orders/{orderId}/OrderRoles/{partyRoleId}")
    Call<OrderRoleStateDto> getOrderRole(@Path("orderId") String orderId, @Path("partyRoleId") String partyRoleId);
 
    @Headers("Accept: application/json")
    @GET("Orders/{orderId}/OrderItems/{orderItemSeqId}")
    Call<OrderItemStateDto> getOrderItem(@Path("orderId") String orderId, @Path("orderItemSeqId") String orderItemSeqId);
 
    @Headers("Accept: application/json")
    @GET("Orders/{orderId}/OrderShipGroups/{shipGroupSeqId}")
    Call<OrderShipGroupStateDto> getOrderShipGroup(@Path("orderId") String orderId, @Path("shipGroupSeqId") Long shipGroupSeqId);
 
    @Headers("Accept: application/json")
    @GET("Orders/{orderId}/OrderShipGroups/{orderShipGroupShipGroupSeqId}/OrderItemShipGroupAssociations/{orderItemSeqId}")
    Call<OrderItemShipGroupAssociationStateDto> getOrderItemShipGroupAssociation(@Path("orderId") String orderId, @Path("orderShipGroupShipGroupSeqId") Long orderShipGroupShipGroupSeqId, @Path("orderItemSeqId") String orderItemSeqId);
 
    @Headers("Accept: application/json")
    @PUT("Orders/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchOrderDto.CreateOrderDto value);

    @Headers("Accept: application/json")
    @POST("Orders")
    Call<String> post(@Body CreateOrMergePatchOrderDto.CreateOrderDto value);

    @Headers("Accept: application/json")
    @PATCH("Orders/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchOrderDto.MergePatchOrderDto value);

    @Headers("Accept: application/json")
    @DELETE("Orders/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

