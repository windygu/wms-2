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
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.sellableinventoryitem.*;

public interface RxSellableInventoryItemsClient {

    @Headers("Accept: application/json")
    @GET("SellableInventoryItems")
    Observable<List<SellableInventoryItemStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("SellableInventoryItems/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("SellableInventoryItems/{sellableInventoryItemId}")
    Observable<SellableInventoryItemStateDto> get(@Path("sellableInventoryItemId") String sellableInventoryItemId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("SellableInventoryItems/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("SellableInventoryItems/{sellableInventoryItemId}/_historyStates/{version}")
    Observable<SellableInventoryItemStateDto> getHistoryState(@Path("sellableInventoryItemId") String sellableInventoryItemId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("SellableInventoryItems/{sellableInventoryItemId}/SellableInventoryItemEntries/{entrySeqId}")
    Observable<SellableInventoryItemEntryStateDto> getSellableInventoryItemEntry(@Path("sellableInventoryItemId") String sellableInventoryItemId, @Path("entrySeqId") Long entrySeqId);
 
    @Headers("Accept: application/json")
    @GET("SellableInventoryItems/{sellableInventoryItemId}/SellableInventoryItemEntries")
    Observable<List<SellableInventoryItemEntryStateDto>> getSellableInventoryItemEntries(@Path("sellableInventoryItemId") String sellableInventoryItemId);

    @Headers("Accept: application/json")
    @PUT("SellableInventoryItems/{sellableInventoryItemId}")
    Observable<String> put(@Path("sellableInventoryItemId") String sellableInventoryItemId, @Body CreateOrMergePatchSellableInventoryItemDto.CreateSellableInventoryItemDto value);

    @Headers("Accept: application/json")
    @POST("SellableInventoryItems")
    Observable<InventoryItemId> post(@Body CreateOrMergePatchSellableInventoryItemDto.CreateSellableInventoryItemDto value);

    @Headers("Accept: application/json")
    @PATCH("SellableInventoryItems/{sellableInventoryItemId}")
    Observable<String> patch(@Path("sellableInventoryItemId") String sellableInventoryItemId, @Body CreateOrMergePatchSellableInventoryItemDto.MergePatchSellableInventoryItemDto value);

    @Headers("Accept: application/json")
    @DELETE("SellableInventoryItems/{sellableInventoryItemId}")
    Observable<String> delete(@Path("sellableInventoryItemId") String sellableInventoryItemId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

