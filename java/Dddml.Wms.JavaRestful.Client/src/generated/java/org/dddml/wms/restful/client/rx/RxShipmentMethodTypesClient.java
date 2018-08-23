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
import org.dddml.wms.domain.shipmentmethodtype.*;

public interface RxShipmentMethodTypesClient {

    @Headers("Accept: application/json")
    @GET("ShipmentMethodTypes")
    Observable<List<ShipmentMethodTypeStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("ShipmentMethodTypes/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("ShipmentMethodTypes/{shipmentMethodTypeId}")
    Observable<ShipmentMethodTypeStateDto> get(@Path("shipmentMethodTypeId") String shipmentMethodTypeId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("ShipmentMethodTypes/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("ShipmentMethodTypes/{shipmentMethodTypeId}/_stateEvents/{version}")
    Observable<ShipmentMethodTypeStateEventDto> getStateEvent(@Path("shipmentMethodTypeId") String shipmentMethodTypeId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("ShipmentMethodTypes/{shipmentMethodTypeId}/_historyStates/{version}")
    Observable<ShipmentMethodTypeStateDto> getHistoryState(@Path("shipmentMethodTypeId") String shipmentMethodTypeId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("ShipmentMethodTypes/{shipmentMethodTypeId}")
    Observable<String> put(@Path("shipmentMethodTypeId") String shipmentMethodTypeId, @Body CreateOrMergePatchShipmentMethodTypeDto.CreateShipmentMethodTypeDto value);

    @Headers("Accept: application/json")
    @POST("ShipmentMethodTypes")
    Observable<String> post(@Body CreateOrMergePatchShipmentMethodTypeDto.CreateShipmentMethodTypeDto value);

    @Headers("Accept: application/json")
    @PATCH("ShipmentMethodTypes/{shipmentMethodTypeId}")
    Observable<String> patch(@Path("shipmentMethodTypeId") String shipmentMethodTypeId, @Body CreateOrMergePatchShipmentMethodTypeDto.MergePatchShipmentMethodTypeDto value);

    @Headers("Accept: application/json")
    @DELETE("ShipmentMethodTypes/{shipmentMethodTypeId}")
    Observable<String> delete(@Path("shipmentMethodTypeId") String shipmentMethodTypeId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

