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
import org.dddml.wms.domain.shipment.*;

public interface RxSalesShipmentsClient {

    @Headers("Accept: application/json")
    @GET("SalesShipments")
    Observable<List<ShipmentStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("SalesShipments/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("SalesShipments/{shipmentId}")
    Observable<ShipmentStateDto> get(@Path("shipmentId") String shipmentId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("SalesShipments/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("SalesShipments/{shipmentId}/_stateEvents/{version}")
    Observable<ShipmentStateEventDto> getStateEvent(@Path("shipmentId") String shipmentId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("SalesShipments/{shipmentId}/_historyStates/{version}")
    Observable<ShipmentStateDto> getHistoryState(@Path("shipmentId") String shipmentId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("SalesShipments/{shipmentId}/ShipmentImages/{sequenceId}")
    Observable<ShipmentImageStateDto> getShipmentImage(@Path("shipmentId") String shipmentId, @Path("sequenceId") String sequenceId);
 
    @Headers("Accept: application/json")
    @GET("SalesShipments/{shipmentId}/ShipmentImages")
    Observable<List<ShipmentImageStateDto>> getShipmentImages(@Path("shipmentId") String shipmentId, @Query("sort") String sort, @Query("fields") String fields, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("SalesShipments/{shipmentId}/ShipmentItems/{shipmentItemSeqId}")
    Observable<ShipmentItemStateDto> getShipmentItem(@Path("shipmentId") String shipmentId, @Path("shipmentItemSeqId") String shipmentItemSeqId);
 
    @Headers("Accept: application/json")
    @GET("SalesShipments/{shipmentId}/ShipmentItems")
    Observable<List<ShipmentItemStateDto>> getShipmentItems(@Path("shipmentId") String shipmentId, @Query("sort") String sort, @Query("fields") String fields, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("SalesShipments/{shipmentId}/ShipmentReceipts/{receiptSeqId}")
    Observable<ShipmentReceiptStateDto> getShipmentReceipt(@Path("shipmentId") String shipmentId, @Path("receiptSeqId") String receiptSeqId);
 
    @Headers("Accept: application/json")
    @GET("SalesShipments/{shipmentId}/ShipmentReceipts")
    Observable<List<ShipmentReceiptStateDto>> getShipmentReceipts(@Path("shipmentId") String shipmentId, @Query("sort") String sort, @Query("fields") String fields, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("SalesShipments/{shipmentId}/ShipmentReceipts/{shipmentReceiptReceiptSeqId}/ShipmentReceiptImages/{sequenceId}")
    Observable<ShipmentReceiptImageStateDto> getShipmentReceiptImage(@Path("shipmentId") String shipmentId, @Path("shipmentReceiptReceiptSeqId") String shipmentReceiptReceiptSeqId, @Path("sequenceId") String sequenceId);
 
    @Headers("Accept: application/json")
    @GET("SalesShipments/{shipmentId}/ShipmentReceipts/{shipmentReceiptReceiptSeqId}/ShipmentReceiptImages")
    Observable<List<ShipmentReceiptImageStateDto>> getShipmentReceiptImages(@Path("shipmentId") String shipmentId, @Path("shipmentReceiptReceiptSeqId") String shipmentReceiptReceiptSeqId, @Query("sort") String sort, @Query("fields") String fields, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("SalesShipments/{shipmentId}/ItemIssuances/{itemIssuanceSeqId}")
    Observable<ItemIssuanceStateDto> getItemIssuance(@Path("shipmentId") String shipmentId, @Path("itemIssuanceSeqId") String itemIssuanceSeqId);
 
    @Headers("Accept: application/json")
    @GET("SalesShipments/{shipmentId}/ItemIssuances")
    Observable<List<ItemIssuanceStateDto>> getItemIssuances(@Path("shipmentId") String shipmentId, @Query("sort") String sort, @Query("fields") String fields, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @PUT("SalesShipments/{shipmentId}")
    Observable<String> put(@Path("shipmentId") String shipmentId, @Body CreateOrMergePatchShipmentDto.CreateShipmentDto value);

    @Headers("Accept: application/json")
    @POST("SalesShipments")
    Observable<String> post(@Body CreateOrMergePatchShipmentDto.CreateShipmentDto value);

    @Headers("Accept: application/json")
    @PATCH("SalesShipments/{shipmentId}")
    Observable<String> patch(@Path("shipmentId") String shipmentId, @Body CreateOrMergePatchShipmentDto.MergePatchShipmentDto value);

    @Headers("Accept: application/json")
    @DELETE("SalesShipments/{shipmentId}")
    Observable<String> delete(@Path("shipmentId") String shipmentId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

    @Headers("Accept: application/json")
    @PUT("SalesShipments/{shipmentId}/_commands/Import")
    Observable<String> _import(@Path("shipmentId") String shipmentId, @Body ShipmentCommandDtos.ImportRequestContent content);

    @Headers("Accept: application/json")
    @PUT("SalesShipments/{shipmentId}/_commands/ReceiveItem")
    Observable<String> receiveItem(@Path("shipmentId") String shipmentId, @Body ShipmentCommandDtos.ReceiveItemRequestContent content);

    @Headers("Accept: application/json")
    @PUT("SalesShipments/{shipmentId}/_commands/IssueItem")
    Observable<String> issueItem(@Path("shipmentId") String shipmentId, @Body ShipmentCommandDtos.IssueItemRequestContent content);

    @Headers("Accept: application/json")
    @PUT("SalesShipments/{shipmentId}/_commands/ConfirmAllItemsReceived")
    Observable<String> confirmAllItemsReceived(@Path("shipmentId") String shipmentId, @Body ShipmentCommandDtos.ConfirmAllItemsReceivedRequestContent content);

    @Headers("Accept: application/json")
    @PUT("SalesShipments/{shipmentId}/_commands/ConfirmAllItemsIssued")
    Observable<String> confirmAllItemsIssued(@Path("shipmentId") String shipmentId, @Body ShipmentCommandDtos.ConfirmAllItemsIssuedRequestContent content);

    @Headers("Accept: application/json")
    @PUT("SalesShipments/{shipmentId}/_commands/PurchaseShipmentAction")
    Observable<String> purchaseShipmentAction(@Path("shipmentId") String shipmentId, @Body ShipmentCommandDtos.PurchaseShipmentActionRequestContent content);

    @Headers("Accept: application/json")
    @PUT("SalesShipments/{shipmentId}/_commands/SalesShipmentAction")
    Observable<String> salesShipmentAction(@Path("shipmentId") String shipmentId, @Body ShipmentCommandDtos.SalesShipmentActionRequestContent content);

}

