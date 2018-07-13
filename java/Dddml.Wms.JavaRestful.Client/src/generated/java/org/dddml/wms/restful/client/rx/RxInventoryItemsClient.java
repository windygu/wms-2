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
    @GET("InventoryItems/{id}")
    Observable<InventoryItemStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("InventoryItems/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("InventoryItems/{id}/_stateEvents/{version}")
    Observable<InventoryItemStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InventoryItems/{id}/_historyStates/{version}")
    Observable<InventoryItemStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InventoryItems/{inventoryItemId}/InventoryItemEntries/{entrySeqId}")
    Observable<InventoryItemEntryStateDto> getInventoryItemEntry(@Path("inventoryItemId") String inventoryItemId, @Path("entrySeqId") Long entrySeqId);
 
    @Headers("Accept: application/json")
    @PUT("InventoryItems/{id}")
    Observable<String> put(@Path("id") String id, @Body CreateOrMergePatchInventoryItemDto.CreateInventoryItemDto value);

    @Headers("Accept: application/json")
    @PATCH("InventoryItems/{id}")
    Observable<String> patch(@Path("id") String id, @Body CreateOrMergePatchInventoryItemDto.MergePatchInventoryItemDto value);

    @Headers("Accept: application/json")
    @DELETE("InventoryItems/{id}")
    Observable<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

