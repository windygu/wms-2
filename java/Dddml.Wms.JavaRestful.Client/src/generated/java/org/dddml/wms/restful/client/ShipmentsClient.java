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
    @GET("Shipments/{shipmentId}")
    Call<ShipmentStateDto> get(@Path("shipmentId") String shipmentId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Shipments/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/_stateEvents/{version}")
    Call<ShipmentStateEventDto> getStateEvent(@Path("shipmentId") String shipmentId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/_historyStates/{version}")
    Call<ShipmentStateDto> getHistoryState(@Path("shipmentId") String shipmentId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ShipmentImages/{sequenceId}")
    Call<ShipmentImageStateDto> getShipmentImage(@Path("shipmentId") String shipmentId, @Path("sequenceId") String sequenceId);
 
    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ShipmentImages")
    Call<List<ShipmentImageStateDto>> getShipmentImages(@Path("shipmentId") String shipmentId, @Query("sort") String sort, @Query("fields") String fields, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ShipmentItems/{shipmentItemSeqId}")
    Call<ShipmentItemStateDto> getShipmentItem(@Path("shipmentId") String shipmentId, @Path("shipmentItemSeqId") String shipmentItemSeqId);
 
    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ShipmentItems")
    Call<List<ShipmentItemStateDto>> getShipmentItems(@Path("shipmentId") String shipmentId, @Query("sort") String sort, @Query("fields") String fields, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ShipmentReceipts/{receiptSeqId}")
    Call<ShipmentReceiptStateDto> getShipmentReceipt(@Path("shipmentId") String shipmentId, @Path("receiptSeqId") String receiptSeqId);
 
    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ShipmentReceipts")
    Call<List<ShipmentReceiptStateDto>> getShipmentReceipts(@Path("shipmentId") String shipmentId, @Query("sort") String sort, @Query("fields") String fields, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ShipmentReceipts/{shipmentReceiptReceiptSeqId}/ShipmentReceiptImages/{sequenceId}")
    Call<ShipmentReceiptImageStateDto> getShipmentReceiptImage(@Path("shipmentId") String shipmentId, @Path("shipmentReceiptReceiptSeqId") String shipmentReceiptReceiptSeqId, @Path("sequenceId") String sequenceId);
 
    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ShipmentReceipts/{shipmentReceiptReceiptSeqId}/ShipmentReceiptImages")
    Call<List<ShipmentReceiptImageStateDto>> getShipmentReceiptImages(@Path("shipmentId") String shipmentId, @Path("shipmentReceiptReceiptSeqId") String shipmentReceiptReceiptSeqId, @Query("sort") String sort, @Query("fields") String fields, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ItemIssuances/{itemIssuanceSeqId}")
    Call<ItemIssuanceStateDto> getItemIssuance(@Path("shipmentId") String shipmentId, @Path("itemIssuanceSeqId") String itemIssuanceSeqId);
 
    @Headers("Accept: application/json")
    @GET("Shipments/{shipmentId}/ItemIssuances")
    Call<List<ItemIssuanceStateDto>> getItemIssuances(@Path("shipmentId") String shipmentId, @Query("sort") String sort, @Query("fields") String fields, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @PUT("Shipments/{shipmentId}")
    Call<String> put(@Path("shipmentId") String shipmentId, @Body CreateOrMergePatchShipmentDto.CreateShipmentDto value);

    @Headers("Accept: application/json")
    @POST("Shipments")
    Call<String> post(@Body CreateOrMergePatchShipmentDto.CreateShipmentDto value);

    @Headers("Accept: application/json")
    @PATCH("Shipments/{shipmentId}")
    Call<String> patch(@Path("shipmentId") String shipmentId, @Body CreateOrMergePatchShipmentDto.MergePatchShipmentDto value);

    @Headers("Accept: application/json")
    @DELETE("Shipments/{shipmentId}")
    Call<String> delete(@Path("shipmentId") String shipmentId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

    @Headers("Accept: application/json")
    @PUT("Shipments/{shipmentId}/_commands/Import")
    Call<String> _import(@Path("shipmentId") String shipmentId, @Body ShipmentCommandDtos.ImportRequestContent content);

    @Headers("Accept: application/json")
    @PUT("Shipments/{shipmentId}/_commands/ReceiveItem")
    Call<String> receiveItem(@Path("shipmentId") String shipmentId, @Body ShipmentCommandDtos.ReceiveItemRequestContent content);

    @Headers("Accept: application/json")
    @PUT("Shipments/{shipmentId}/_commands/IssueItem")
    Call<String> issueItem(@Path("shipmentId") String shipmentId, @Body ShipmentCommandDtos.IssueItemRequestContent content);

    @Headers("Accept: application/json")
    @PUT("Shipments/{shipmentId}/_commands/ConfirmAllItemsReceived")
    Call<String> confirmAllItemsReceived(@Path("shipmentId") String shipmentId, @Body ShipmentCommandDtos.ConfirmAllItemsReceivedRequestContent content);

    @Headers("Accept: application/json")
    @PUT("Shipments/{shipmentId}/_commands/ConfirmAllItemsIssued")
    Call<String> confirmAllItemsIssued(@Path("shipmentId") String shipmentId, @Body ShipmentCommandDtos.ConfirmAllItemsIssuedRequestContent content);

    @Headers("Accept: application/json")
    @PUT("Shipments/{shipmentId}/_commands/PurchaseShipmentAction")
    Call<String> purchaseShipmentAction(@Path("shipmentId") String shipmentId, @Body ShipmentCommandDtos.PurchaseShipmentActionRequestContent content);

    @Headers("Accept: application/json")
    @PUT("Shipments/{shipmentId}/_commands/SalesShipmentAction")
    Call<String> salesShipmentAction(@Path("shipmentId") String shipmentId, @Body ShipmentCommandDtos.SalesShipmentActionRequestContent content);

}

