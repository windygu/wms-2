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
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventorypostingrule.*;

public interface RxInventoryPostingRulesClient {

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules")
    Observable<List<InventoryPostingRuleStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules/{inventoryPostingRuleId}")
    Observable<InventoryPostingRuleStateDto> get(@Path("inventoryPostingRuleId") String inventoryPostingRuleId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules/{inventoryPostingRuleId}/_stateEvents/{version}")
    Observable<InventoryPostingRuleStateEventDto> getStateEvent(@Path("inventoryPostingRuleId") String inventoryPostingRuleId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules/{inventoryPostingRuleId}/_historyStates/{version}")
    Observable<InventoryPostingRuleStateDto> getHistoryState(@Path("inventoryPostingRuleId") String inventoryPostingRuleId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("InventoryPostingRules/{inventoryPostingRuleId}")
    Observable<String> put(@Path("inventoryPostingRuleId") String inventoryPostingRuleId, @Body CreateOrMergePatchInventoryPostingRuleDto.CreateInventoryPostingRuleDto value);

    @Headers("Accept: application/json")
    @POST("InventoryPostingRules")
    Observable<String> post(@Body CreateOrMergePatchInventoryPostingRuleDto.CreateInventoryPostingRuleDto value);

    @Headers("Accept: application/json")
    @PATCH("InventoryPostingRules/{inventoryPostingRuleId}")
    Observable<String> patch(@Path("inventoryPostingRuleId") String inventoryPostingRuleId, @Body CreateOrMergePatchInventoryPostingRuleDto.MergePatchInventoryPostingRuleDto value);

    @Headers("Accept: application/json")
    @DELETE("InventoryPostingRules/{inventoryPostingRuleId}")
    Observable<String> delete(@Path("inventoryPostingRuleId") String inventoryPostingRuleId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

