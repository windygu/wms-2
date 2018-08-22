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
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventorypostingrule.*;

public interface InventoryPostingRulesClient {

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules")
    Call<List<InventoryPostingRuleStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules/{inventoryPostingRuleId}")
    Call<InventoryPostingRuleStateDto> get(@Path("inventoryPostingRuleId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules/{inventoryPostingRuleId}/_stateEvents/{version}")
    Call<InventoryPostingRuleStateEventDto> getStateEvent(@Path("inventoryPostingRuleId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules/{inventoryPostingRuleId}/_historyStates/{version}")
    Call<InventoryPostingRuleStateDto> getHistoryState(@Path("inventoryPostingRuleId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("InventoryPostingRules/{inventoryPostingRuleId}")
    Call<String> put(@Path("inventoryPostingRuleId") String id, @Body CreateOrMergePatchInventoryPostingRuleDto.CreateInventoryPostingRuleDto value);

    @Headers("Accept: application/json")
    @POST("InventoryPostingRules")
    Call<String> post(@Body CreateOrMergePatchInventoryPostingRuleDto.CreateInventoryPostingRuleDto value);

    @Headers("Accept: application/json")
    @PATCH("InventoryPostingRules/{inventoryPostingRuleId}")
    Call<String> patch(@Path("inventoryPostingRuleId") String id, @Body CreateOrMergePatchInventoryPostingRuleDto.MergePatchInventoryPostingRuleDto value);

    @Headers("Accept: application/json")
    @DELETE("InventoryPostingRules/{inventoryPostingRuleId}")
    Call<String> delete(@Path("inventoryPostingRuleId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

