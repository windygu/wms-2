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
import org.dddml.wms.domain.inventoryprtriggered.*;

public interface InventoryPRTriggeredsClient {

    @Headers("Accept: application/json")
    @GET("InventoryPRTriggereds")
    Call<List<InventoryPRTriggeredStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InventoryPRTriggereds/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InventoryPRTriggereds/{inventoryPRTriggeredId}")
    Call<InventoryPRTriggeredStateDto> get(@Path("inventoryPRTriggeredId") String inventoryPRTriggeredId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("InventoryPRTriggereds/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("InventoryPRTriggereds/{inventoryPRTriggeredId}/_historyStates/{version}")
    Call<InventoryPRTriggeredStateDto> getHistoryState(@Path("inventoryPRTriggeredId") String inventoryPRTriggeredId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("InventoryPRTriggereds/{inventoryPRTriggeredId}")
    Call<String> put(@Path("inventoryPRTriggeredId") String inventoryPRTriggeredId, @Body CreateOrMergePatchInventoryPRTriggeredDto.CreateInventoryPRTriggeredDto value);

    @Headers("Accept: application/json")
    @POST("InventoryPRTriggereds")
    Call<InventoryPRTriggeredId> post(@Body CreateOrMergePatchInventoryPRTriggeredDto.CreateInventoryPRTriggeredDto value);

    @Headers("Accept: application/json")
    @PATCH("InventoryPRTriggereds/{inventoryPRTriggeredId}")
    Call<String> patch(@Path("inventoryPRTriggeredId") String inventoryPRTriggeredId, @Body CreateOrMergePatchInventoryPRTriggeredDto.MergePatchInventoryPRTriggeredDto value);

    @Headers("Accept: application/json")
    @DELETE("InventoryPRTriggereds/{inventoryPRTriggeredId}")
    Call<String> delete(@Path("inventoryPRTriggeredId") String inventoryPRTriggeredId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

