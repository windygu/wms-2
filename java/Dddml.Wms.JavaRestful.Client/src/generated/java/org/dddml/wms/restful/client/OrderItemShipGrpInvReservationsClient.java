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
import org.dddml.wms.domain.orderitemshipgrpinvreservation.*;

public interface OrderItemShipGrpInvReservationsClient {

    @Headers("Accept: application/json")
    @GET("OrderItemShipGrpInvReservations")
    Call<List<OrderItemShipGrpInvReservationStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("OrderItemShipGrpInvReservations/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("OrderItemShipGrpInvReservations/{orderItemShipGrpInvResId}")
    Call<OrderItemShipGrpInvReservationStateDto> get(@Path("orderItemShipGrpInvResId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("OrderItemShipGrpInvReservations/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("OrderItemShipGrpInvReservations/{orderItemShipGrpInvResId}/_stateEvents/{version}")
    Call<OrderItemShipGrpInvReservationStateEventDto> getStateEvent(@Path("orderItemShipGrpInvResId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("OrderItemShipGrpInvReservations/{orderItemShipGrpInvResId}/_historyStates/{version}")
    Call<OrderItemShipGrpInvReservationStateDto> getHistoryState(@Path("orderItemShipGrpInvResId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("OrderItemShipGrpInvReservations/{orderItemShipGrpInvResId}")
    Call<String> put(@Path("orderItemShipGrpInvResId") String id, @Body CreateOrMergePatchOrderItemShipGrpInvReservationDto.CreateOrderItemShipGrpInvReservationDto value);

    @Headers("Accept: application/json")
    @POST("OrderItemShipGrpInvReservations")
    Call<OrderItemShipGrpInvResId> post(@Body CreateOrMergePatchOrderItemShipGrpInvReservationDto.CreateOrderItemShipGrpInvReservationDto value);

    @Headers("Accept: application/json")
    @PATCH("OrderItemShipGrpInvReservations/{orderItemShipGrpInvResId}")
    Call<String> patch(@Path("orderItemShipGrpInvResId") String id, @Body CreateOrMergePatchOrderItemShipGrpInvReservationDto.MergePatchOrderItemShipGrpInvReservationDto value);

    @Headers("Accept: application/json")
    @DELETE("OrderItemShipGrpInvReservations/{orderItemShipGrpInvResId}")
    Call<String> delete(@Path("orderItemShipGrpInvResId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

