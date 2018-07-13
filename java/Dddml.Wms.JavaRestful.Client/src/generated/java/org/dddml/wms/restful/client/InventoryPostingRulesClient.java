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
    @GET("InventoryPostingRules/{id}")
    Call<InventoryPostingRuleStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules/{id}/_stateEvents/{version}")
    Call<InventoryPostingRuleStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules/{id}/_historyStates/{version}")
    Call<InventoryPostingRuleStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("InventoryPostingRules/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchInventoryPostingRuleDto.CreateInventoryPostingRuleDto value);

    @Headers("Accept: application/json")
    @POST("InventoryPostingRules")
    Call<String> post(@Body CreateOrMergePatchInventoryPostingRuleDto.CreateInventoryPostingRuleDto value);

    @Headers("Accept: application/json")
    @PATCH("InventoryPostingRules/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchInventoryPostingRuleDto.MergePatchInventoryPostingRuleDto value);

    @Headers("Accept: application/json")
    @DELETE("InventoryPostingRules/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

