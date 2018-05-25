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
import retrofit2.http.Path;
import retrofit2.http.Query;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.sellableinventoryitementrymvo.*;

public interface SellableInventoryItemEntryMvosClient {

    @Headers("Accept: application/json")
    @GET("SellableInventoryItemEntryMvos")
    Call<List<SellableInventoryItemEntryMvoStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("SellableInventoryItemEntryMvos/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("SellableInventoryItemEntryMvos/{id}")
    Call<SellableInventoryItemEntryMvoStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("SellableInventoryItemEntryMvos/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("SellableInventoryItemEntryMvos/{id}/_stateEvents/{version}")
    Call<SellableInventoryItemEntryMvoStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("SellableInventoryItemEntryMvos/{id}/_historyStates/{version}")
    Call<SellableInventoryItemEntryMvoStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("SellableInventoryItemEntryMvos/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchSellableInventoryItemEntryMvoDto.CreateSellableInventoryItemEntryMvoDto value);

    @Headers("Accept: application/json")
    @PATCH("SellableInventoryItemEntryMvos/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchSellableInventoryItemEntryMvoDto.MergePatchSellableInventoryItemEntryMvoDto value);

    @Headers("Accept: application/json")
    @DELETE("SellableInventoryItemEntryMvos/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}
