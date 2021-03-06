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
import org.dddml.wms.domain.damagetype.*;

public interface DamageTypesClient {

    @Headers("Accept: application/json")
    @GET("DamageTypes")
    Call<List<DamageTypeStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("DamageTypes/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("DamageTypes/{damageTypeId}")
    Call<DamageTypeStateDto> get(@Path("damageTypeId") String damageTypeId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("DamageTypes/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("DamageTypes/{damageTypeId}/_historyStates/{version}")
    Call<DamageTypeStateDto> getHistoryState(@Path("damageTypeId") String damageTypeId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("DamageTypes/{damageTypeId}")
    Call<String> put(@Path("damageTypeId") String damageTypeId, @Body CreateOrMergePatchDamageTypeDto.CreateDamageTypeDto value);

    @Headers("Accept: application/json")
    @POST("DamageTypes")
    Call<String> post(@Body CreateOrMergePatchDamageTypeDto.CreateDamageTypeDto value);

    @Headers("Accept: application/json")
    @PATCH("DamageTypes/{damageTypeId}")
    Call<String> patch(@Path("damageTypeId") String damageTypeId, @Body CreateOrMergePatchDamageTypeDto.MergePatchDamageTypeDto value);

    @Headers("Accept: application/json")
    @DELETE("DamageTypes/{damageTypeId}")
    Call<String> delete(@Path("damageTypeId") String damageTypeId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

