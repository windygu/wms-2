package org.dddml.wms.restful.client.rx;

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
    @GET("InventoryPostingRules/{id}")
    Observable<InventoryPostingRuleStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules/{id}/_stateEvents/{version}")
    Observable<InventoryPostingRuleStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InventoryPostingRules/{id}/_historyStates/{version}")
    Observable<InventoryPostingRuleStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("InventoryPostingRules/{id}")
    Observable<String> put(@Path("id") String id, @Body CreateOrMergePatchInventoryPostingRuleDto.CreateInventoryPostingRuleDto value);

    @Headers("Accept: application/json")
    @POST("InventoryPostingRules")
    Observable<String> post(@Body CreateOrMergePatchInventoryPostingRuleDto.CreateInventoryPostingRuleDto value);

    @Headers("Accept: application/json")
    @PATCH("InventoryPostingRules/{id}")
    Observable<String> patch(@Path("id") String id, @Body CreateOrMergePatchInventoryPostingRuleDto.MergePatchInventoryPostingRuleDto value);

    @Headers("Accept: application/json")
    @DELETE("InventoryPostingRules/{id}")
    Observable<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

