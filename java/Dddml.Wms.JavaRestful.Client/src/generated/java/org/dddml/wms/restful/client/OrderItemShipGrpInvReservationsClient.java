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
    @GET("OrderItemShipGrpInvReservations/{id}")
    Call<OrderItemShipGrpInvReservationStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("OrderItemShipGrpInvReservations/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("OrderItemShipGrpInvReservations/{id}/_stateEvents/{version}")
    Call<OrderItemShipGrpInvReservationStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("OrderItemShipGrpInvReservations/{id}/_historyStates/{version}")
    Call<OrderItemShipGrpInvReservationStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("OrderItemShipGrpInvReservations/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchOrderItemShipGrpInvReservationDto.CreateOrderItemShipGrpInvReservationDto value);

    @Headers("Accept: application/json")
    @POST("OrderItemShipGrpInvReservations")
    Call<OrderItemShipGrpInvResId> post(@Body CreateOrMergePatchOrderItemShipGrpInvReservationDto.CreateOrderItemShipGrpInvReservationDto value);

    @Headers("Accept: application/json")
    @PATCH("OrderItemShipGrpInvReservations/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchOrderItemShipGrpInvReservationDto.MergePatchOrderItemShipGrpInvReservationDto value);

    @Headers("Accept: application/json")
    @DELETE("OrderItemShipGrpInvReservations/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

