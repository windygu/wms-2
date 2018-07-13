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
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.sellableinventoryitem.*;

public interface SellableInventoryItemsClient {

    @Headers("Accept: application/json")
    @GET("SellableInventoryItems")
    Call<List<SellableInventoryItemStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("SellableInventoryItems/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("SellableInventoryItems/{id}")
    Call<SellableInventoryItemStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("SellableInventoryItems/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("SellableInventoryItems/{id}/_historyStates/{version}")
    Call<SellableInventoryItemStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("SellableInventoryItems/{sellableInventoryItemId}/SellableInventoryItemEntries/{entrySeqId}")
    Call<SellableInventoryItemEntryStateDto> getSellableInventoryItemEntry(@Path("sellableInventoryItemId") String sellableInventoryItemId, @Path("entrySeqId") Long entrySeqId);
 
    @Headers("Accept: application/json")
    @PUT("SellableInventoryItems/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchSellableInventoryItemDto.CreateSellableInventoryItemDto value);

    @Headers("Accept: application/json")
    @POST("SellableInventoryItems")
    Call<InventoryItemId> post(@Body CreateOrMergePatchSellableInventoryItemDto.CreateSellableInventoryItemDto value);

    @Headers("Accept: application/json")
    @PATCH("SellableInventoryItems/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchSellableInventoryItemDto.MergePatchSellableInventoryItemDto value);

    @Headers("Accept: application/json")
    @DELETE("SellableInventoryItems/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

