package org.dddml.wms.restful.client;

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
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import org.dddml.support.criterion.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitem.*;

public interface InventoryItemsClient {

    @Headers("Accept: application/json")
    @GET("InventoryItems")
    Call<List<InventoryItemStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InventoryItems/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InventoryItems/{id}")
    Call<InventoryItemStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("InventoryItems/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("InventoryItems/{id}/_stateEvents/{version}")
    Call<InventoryItemStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InventoryItems/{id}/_historyStates/{version}")
    Call<InventoryItemStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InventoryItems/{inventoryItemId}/InventoryItemEntries/{entrySeqId}")
    Call<InventoryItemEntryStateDto> getInventoryItemEntry(@Path("inventoryItemId") String inventoryItemId, @Path("entrySeqId") Long entrySeqId);
 
    @Headers("Accept: application/json")
    @PUT("InventoryItems/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchInventoryItemDto.CreateInventoryItemDto value);

    @Headers("Accept: application/json")
    @PATCH("InventoryItems/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchInventoryItemDto.MergePatchInventoryItemDto value);

    @Headers("Accept: application/json")
    @DELETE("InventoryItems/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

