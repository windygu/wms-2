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
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.order.*;

public interface RxOrdersClient {

    @Headers("Accept: application/json")
    @GET("Orders")
    Observable<List<OrderStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Orders/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Orders/{orderId}")
    Observable<OrderStateDto> get(@Path("orderId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Orders/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Orders/{orderId}/_stateEvents/{version}")
    Observable<OrderStateEventDto> getStateEvent(@Path("orderId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Orders/{orderId}/_historyStates/{version}")
    Observable<OrderStateDto> getHistoryState(@Path("orderId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Orders/{orderId}/OrderRoles/{partyRoleId}")
    Observable<OrderRoleStateDto> getOrderRole(@Path("orderId") String orderId, @Path("partyRoleId") String partyRoleId);
 
    @Headers("Accept: application/json")
    @GET("Orders/{orderId}/OrderRoles")
    Observable<List<OrderRoleStateDto>> getOrderRoles(@Path("orderId") String orderId);

    @Headers("Accept: application/json")
    @GET("Orders/{orderId}/OrderItems/{orderItemSeqId}")
    Observable<OrderItemStateDto> getOrderItem(@Path("orderId") String orderId, @Path("orderItemSeqId") String orderItemSeqId);
 
    @Headers("Accept: application/json")
    @GET("Orders/{orderId}/OrderItems")
    Observable<List<OrderItemStateDto>> getOrderItems(@Path("orderId") String orderId);

    @Headers("Accept: application/json")
    @GET("Orders/{orderId}/OrderShipGroups/{shipGroupSeqId}")
    Observable<OrderShipGroupStateDto> getOrderShipGroup(@Path("orderId") String orderId, @Path("shipGroupSeqId") Long shipGroupSeqId);
 
    @Headers("Accept: application/json")
    @PUT("Orders/{orderId}/OrderShipGroups/{shipGroupSeqId}/_commands/OrderShipGroupAction")
    Observable<String> orderShipGroupAction(@Path("orderId") String orderId, @Path("shipGroupSeqId") Long shipGroupSeqId, @Body OrderCommandDtos.OrderShipGroupActionRequestContent content);

    @Headers("Accept: application/json")
    @GET("Orders/{orderId}/OrderShipGroups")
    Observable<List<OrderShipGroupStateDto>> getOrderShipGroups(@Path("orderId") String orderId);

    @Headers("Accept: application/json")
    @GET("Orders/{orderId}/OrderShipGroups/{orderShipGroupShipGroupSeqId}/OrderItemShipGroupAssociations/{orderItemSeqId}")
    Observable<OrderItemShipGroupAssociationStateDto> getOrderItemShipGroupAssociation(@Path("orderId") String orderId, @Path("orderShipGroupShipGroupSeqId") Long orderShipGroupShipGroupSeqId, @Path("orderItemSeqId") String orderItemSeqId);
 
    @Headers("Accept: application/json")
    @GET("Orders/{orderId}/OrderShipGroups/{orderShipGroupShipGroupSeqId}/OrderItemShipGroupAssociations")
    Observable<List<OrderItemShipGroupAssociationStateDto>> getOrderItemShipGroupAssociations(@Path("orderId") String orderId, @Path("orderShipGroupShipGroupSeqId") Long orderShipGroupShipGroupSeqId);

    @Headers("Accept: application/json")
    @PUT("Orders/{orderId}")
    Observable<String> put(@Path("orderId") String id, @Body CreateOrMergePatchOrderDto.CreateOrderDto value);

    @Headers("Accept: application/json")
    @POST("Orders")
    Observable<String> post(@Body CreateOrMergePatchOrderDto.CreateOrderDto value);

    @Headers("Accept: application/json")
    @PATCH("Orders/{orderId}")
    Observable<String> patch(@Path("orderId") String id, @Body CreateOrMergePatchOrderDto.MergePatchOrderDto value);

    @Headers("Accept: application/json")
    @DELETE("Orders/{orderId}")
    Observable<String> delete(@Path("orderId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

