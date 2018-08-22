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
import org.dddml.wms.domain.damagereason.*;

public interface DamageReasonsClient {

    @Headers("Accept: application/json")
    @GET("DamageReasons")
    Call<List<DamageReasonStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("DamageReasons/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("DamageReasons/{damageReasonId}")
    Call<DamageReasonStateDto> get(@Path("damageReasonId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("DamageReasons/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("DamageReasons/{damageReasonId}/_stateEvents/{version}")
    Call<DamageReasonStateEventDto> getStateEvent(@Path("damageReasonId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("DamageReasons/{damageReasonId}/_historyStates/{version}")
    Call<DamageReasonStateDto> getHistoryState(@Path("damageReasonId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("DamageReasons/{damageReasonId}")
    Call<String> put(@Path("damageReasonId") String id, @Body CreateOrMergePatchDamageReasonDto.CreateDamageReasonDto value);

    @Headers("Accept: application/json")
    @POST("DamageReasons")
    Call<String> post(@Body CreateOrMergePatchDamageReasonDto.CreateDamageReasonDto value);

    @Headers("Accept: application/json")
    @PATCH("DamageReasons/{damageReasonId}")
    Call<String> patch(@Path("damageReasonId") String id, @Body CreateOrMergePatchDamageReasonDto.MergePatchDamageReasonDto value);

    @Headers("Accept: application/json")
    @DELETE("DamageReasons/{damageReasonId}")
    Call<String> delete(@Path("damageReasonId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

