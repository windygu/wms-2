package org.dddml.wms.restful.client.rx;

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
import rx.Observable;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipment.*;

public interface RxShipmentsClient {

    @Headers("Accept: application/json")
    @GET("Shipments")
    Observable<List<ShipmentStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Shipments/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Shipments/{id}")
    Observable<ShipmentStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Shipments/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Shipments/{id}/_stateEvents/{version}")
    Observable<ShipmentStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Shipments/{id}/_historyStates/{version}")
    Observable<ShipmentStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ShipmentItems/{shipmentItemSeqId}")
    Observable<ShipmentItemStateDto> getShipmentItem(@Path("shipmentId") String shipmentId, @Path("shipmentItemSeqId") String shipmentItemSeqId);
 
    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ShipmentReceipts/{receiptSeqId}")
    Observable<ShipmentReceiptStateDto> getShipmentReceipt(@Path("shipmentId") String shipmentId, @Path("receiptSeqId") String receiptSeqId);
 
    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ItemIssuances/{itemIssuanceSeqId}")
    Observable<ItemIssuanceStateDto> getItemIssuance(@Path("shipmentId") String shipmentId, @Path("itemIssuanceSeqId") String itemIssuanceSeqId);
 
    @Headers("Accept: application/json")
    @PUT("Shipments/{id}")
    Observable<String> put(@Path("id") String id, @Body CreateOrMergePatchShipmentDto.CreateShipmentDto value);

    @Headers("Accept: application/json")
    @PATCH("Shipments/{id}")
    Observable<String> patch(@Path("id") String id, @Body CreateOrMergePatchShipmentDto.MergePatchShipmentDto value);

    @Headers("Accept: application/json")
    @DELETE("Shipments/{id}")
    Observable<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

    @Headers("Accept: application/json")
    @PUT("Shipments/{id}/_commands/Import")
    Observable<String> _import(@Path("id") String id, @Body ShipmentCommandDtos.ImportRequestContent content);

    @Headers("Accept: application/json")
    @PUT("Shipments/{id}/_commands/Ship")
    Observable<String> ship(@Path("id") String id, @Body ShipmentCommandDtos.ShipRequestContent content);

    @Headers("Accept: application/json")
    @PUT("Shipments/{id}/_commands/ReceiveItem")
    Observable<String> receiveItem(@Path("id") String id, @Body ShipmentCommandDtos.ReceiveItemRequestContent content);

    @Headers("Accept: application/json")
    @PUT("Shipments/{id}/_commands/ConfirmAllItemsReceived")
    Observable<String> confirmAllItemsReceived(@Path("id") String id, @Body ShipmentCommandDtos.ConfirmAllItemsReceivedRequestContent content);

}

