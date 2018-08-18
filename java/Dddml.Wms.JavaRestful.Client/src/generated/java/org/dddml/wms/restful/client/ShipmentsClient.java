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
import org.dddml.wms.domain.shipment.*;

public interface ShipmentsClient {

    @Headers("Accept: application/json")
    @GET("Shipments")
    Call<List<ShipmentStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Shipments/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Shipments/{id}")
    Call<ShipmentStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Shipments/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Shipments/{id}/_stateEvents/{version}")
    Call<ShipmentStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Shipments/{id}/_historyStates/{version}")
    Call<ShipmentStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ShipmentImages/{sequenceId}")
    Call<ShipmentImageStateDto> getShipmentImage(@Path("shipmentId") String shipmentId, @Path("sequenceId") String sequenceId);
 
    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ShipmentItems/{shipmentItemSeqId}")
    Call<ShipmentItemStateDto> getShipmentItem(@Path("shipmentId") String shipmentId, @Path("shipmentItemSeqId") String shipmentItemSeqId);
 
    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ShipmentReceipts/{receiptSeqId}")
    Call<ShipmentReceiptStateDto> getShipmentReceipt(@Path("shipmentId") String shipmentId, @Path("receiptSeqId") String receiptSeqId);
 
    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ShipmentReceipts/{shipmentReceiptReceiptSeqId}/ShipmentReceiptImages/{sequenceId}")
    Call<ShipmentReceiptImageStateDto> getShipmentReceiptImage(@Path("shipmentId") String shipmentId, @Path("shipmentReceiptReceiptSeqId") String shipmentReceiptReceiptSeqId, @Path("sequenceId") String sequenceId);
 
    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ItemIssuances/{itemIssuanceSeqId}")
    Call<ItemIssuanceStateDto> getItemIssuance(@Path("shipmentId") String shipmentId, @Path("itemIssuanceSeqId") String itemIssuanceSeqId);
 
    @Headers("Accept: application/json")
    @PUT("Shipments/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchShipmentDto.CreateShipmentDto value);

    @Headers("Accept: application/json")
    @POST("Shipments")
    Call<String> post(@Body CreateOrMergePatchShipmentDto.CreateShipmentDto value);

    @Headers("Accept: application/json")
    @PATCH("Shipments/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchShipmentDto.MergePatchShipmentDto value);

    @Headers("Accept: application/json")
    @DELETE("Shipments/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

    @Headers("Accept: application/json")
    @PUT("Shipments/{id}/_commands/Import")
    Call<String> _import(@Path("id") String id, @Body ShipmentCommandDtos.ImportRequestContent content);

    @Headers("Accept: application/json")
    @PUT("Shipments/{id}/_commands/Ship")
    Call<String> ship(@Path("id") String id, @Body ShipmentCommandDtos.ShipRequestContent content);

    @Headers("Accept: application/json")
    @PUT("Shipments/{id}/_commands/ReceiveItem")
    Call<String> receiveItem(@Path("id") String id, @Body ShipmentCommandDtos.ReceiveItemRequestContent content);

    @Headers("Accept: application/json")
    @PUT("Shipments/{id}/_commands/AddItemAndReceipt")
    Call<String> addItemAndReceipt(@Path("id") String id, @Body ShipmentCommandDtos.AddItemAndReceiptRequestContent content);

    @Headers("Accept: application/json")
    @PUT("Shipments/{id}/_commands/AddItemAndIssuance")
    Call<String> addItemAndIssuance(@Path("id") String id, @Body ShipmentCommandDtos.AddItemAndIssuanceRequestContent content);

    @Headers("Accept: application/json")
    @PUT("Shipments/{id}/_commands/ConfirmAllItemsReceived")
    Call<String> confirmAllItemsReceived(@Path("id") String id, @Body ShipmentCommandDtos.ConfirmAllItemsReceivedRequestContent content);

    @Headers("Accept: application/json")
    @PUT("Shipments/{id}/_commands/ConfirmAllItemsIssued")
    Call<String> confirmAllItemsIssued(@Path("id") String id, @Body ShipmentCommandDtos.ConfirmAllItemsIssuedRequestContent content);

}

