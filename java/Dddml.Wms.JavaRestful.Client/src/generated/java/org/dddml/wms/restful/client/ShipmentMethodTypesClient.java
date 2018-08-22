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
import org.dddml.wms.domain.shipmentmethodtype.*;

public interface ShipmentMethodTypesClient {

    @Headers("Accept: application/json")
    @GET("ShipmentMethodTypes")
    Call<List<ShipmentMethodTypeStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("ShipmentMethodTypes/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("ShipmentMethodTypes/{shipmentMethodTypeId}")
    Call<ShipmentMethodTypeStateDto> get(@Path("shipmentMethodTypeId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("ShipmentMethodTypes/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("ShipmentMethodTypes/{shipmentMethodTypeId}/_stateEvents/{version}")
    Call<ShipmentMethodTypeStateEventDto> getStateEvent(@Path("shipmentMethodTypeId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("ShipmentMethodTypes/{shipmentMethodTypeId}/_historyStates/{version}")
    Call<ShipmentMethodTypeStateDto> getHistoryState(@Path("shipmentMethodTypeId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("ShipmentMethodTypes/{shipmentMethodTypeId}")
    Call<String> put(@Path("shipmentMethodTypeId") String id, @Body CreateOrMergePatchShipmentMethodTypeDto.CreateShipmentMethodTypeDto value);

    @Headers("Accept: application/json")
    @POST("ShipmentMethodTypes")
    Call<String> post(@Body CreateOrMergePatchShipmentMethodTypeDto.CreateShipmentMethodTypeDto value);

    @Headers("Accept: application/json")
    @PATCH("ShipmentMethodTypes/{shipmentMethodTypeId}")
    Call<String> patch(@Path("shipmentMethodTypeId") String id, @Body CreateOrMergePatchShipmentMethodTypeDto.MergePatchShipmentMethodTypeDto value);

    @Headers("Accept: application/json")
    @DELETE("ShipmentMethodTypes/{shipmentMethodTypeId}")
    Call<String> delete(@Path("shipmentMethodTypeId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

