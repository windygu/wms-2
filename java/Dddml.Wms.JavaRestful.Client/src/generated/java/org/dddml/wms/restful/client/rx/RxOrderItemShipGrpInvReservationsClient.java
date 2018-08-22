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
import org.dddml.wms.domain.orderitemshipgrpinvreservation.*;

public interface RxOrderItemShipGrpInvReservationsClient {

    @Headers("Accept: application/json")
    @GET("OrderItemShipGrpInvReservations")
    Observable<List<OrderItemShipGrpInvReservationStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("OrderItemShipGrpInvReservations/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("OrderItemShipGrpInvReservations/{orderItemShipGrpInvResId}")
    Observable<OrderItemShipGrpInvReservationStateDto> get(@Path("orderItemShipGrpInvResId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("OrderItemShipGrpInvReservations/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("OrderItemShipGrpInvReservations/{orderItemShipGrpInvResId}/_stateEvents/{version}")
    Observable<OrderItemShipGrpInvReservationStateEventDto> getStateEvent(@Path("orderItemShipGrpInvResId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("OrderItemShipGrpInvReservations/{orderItemShipGrpInvResId}/_historyStates/{version}")
    Observable<OrderItemShipGrpInvReservationStateDto> getHistoryState(@Path("orderItemShipGrpInvResId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("OrderItemShipGrpInvReservations/{orderItemShipGrpInvResId}")
    Observable<String> put(@Path("orderItemShipGrpInvResId") String id, @Body CreateOrMergePatchOrderItemShipGrpInvReservationDto.CreateOrderItemShipGrpInvReservationDto value);

    @Headers("Accept: application/json")
    @POST("OrderItemShipGrpInvReservations")
    Observable<OrderItemShipGrpInvResId> post(@Body CreateOrMergePatchOrderItemShipGrpInvReservationDto.CreateOrderItemShipGrpInvReservationDto value);

    @Headers("Accept: application/json")
    @PATCH("OrderItemShipGrpInvReservations/{orderItemShipGrpInvResId}")
    Observable<String> patch(@Path("orderItemShipGrpInvResId") String id, @Body CreateOrMergePatchOrderItemShipGrpInvReservationDto.MergePatchOrderItemShipGrpInvReservationDto value);

    @Headers("Accept: application/json")
    @DELETE("OrderItemShipGrpInvReservations/{orderItemShipGrpInvResId}")
    Observable<String> delete(@Path("orderItemShipGrpInvResId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

