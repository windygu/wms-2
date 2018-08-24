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
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitem.*;

public interface RxInventoryItemsClient {

    @Headers("Accept: application/json")
    @GET("InventoryItems")
    Observable<List<InventoryItemStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InventoryItems/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InventoryItems/{inventoryItemId}")
    Observable<InventoryItemStateDto> get(@Path("inventoryItemId") String inventoryItemId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("InventoryItems/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("InventoryItems/{inventoryItemId}/_stateEvents/{version}")
    Observable<InventoryItemStateEventDto> getStateEvent(@Path("inventoryItemId") String inventoryItemId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InventoryItems/{inventoryItemId}/_historyStates/{version}")
    Observable<InventoryItemStateDto> getHistoryState(@Path("inventoryItemId") String inventoryItemId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InventoryItems/{inventoryItemId}/InventoryItemEntries/{entrySeqId}")
    Observable<InventoryItemEntryStateDto> getInventoryItemEntry(@Path("inventoryItemId") String inventoryItemId, @Path("entrySeqId") Long entrySeqId);
 
    @Headers("Accept: application/json")
    @GET("InventoryItems/{inventoryItemId}/InventoryItemEntries")
    Observable<List<InventoryItemEntryStateDto>> getInventoryItemEntries(@Path("inventoryItemId") String inventoryItemId, @Query("sort") String sort, @Query("fields") String fields, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @PUT("InventoryItems/{inventoryItemId}")
    Observable<String> put(@Path("inventoryItemId") String inventoryItemId, @Body CreateOrMergePatchInventoryItemDto.CreateInventoryItemDto value);

    @Headers("Accept: application/json")
    @PATCH("InventoryItems/{inventoryItemId}")
    Observable<String> patch(@Path("inventoryItemId") String inventoryItemId, @Body CreateOrMergePatchInventoryItemDto.MergePatchInventoryItemDto value);

    @Headers("Accept: application/json")
    @DELETE("InventoryItems/{inventoryItemId}")
    Observable<String> delete(@Path("inventoryItemId") String inventoryItemId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

