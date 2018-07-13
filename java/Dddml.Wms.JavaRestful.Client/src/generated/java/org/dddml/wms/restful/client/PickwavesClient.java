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
import org.dddml.wms.domain.pickwave.*;

public interface PickwavesClient {

    @Headers("Accept: application/json")
    @GET("Pickwaves")
    Call<List<PickwaveStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Pickwaves/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Pickwaves/{id}")
    Call<PickwaveStateDto> get(@Path("id") Long id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Pickwaves/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Pickwaves/{id}/_stateEvents/{version}")
    Call<PickwaveStateEventDto> getStateEvent(@Path("id") Long id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Pickwaves/{id}/_historyStates/{version}")
    Call<PickwaveStateDto> getHistoryState(@Path("id") Long id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("Pickwaves/{id}")
    Call<String> put(@Path("id") Long id, @Body CreateOrMergePatchPickwaveDto.CreatePickwaveDto value);

    @Headers("Accept: application/json")
    @POST("Pickwaves")
    Call<Long> post(@Body CreateOrMergePatchPickwaveDto.CreatePickwaveDto value);

    @Headers("Accept: application/json")
    @PATCH("Pickwaves/{id}")
    Call<String> patch(@Path("id") Long id, @Body CreateOrMergePatchPickwaveDto.MergePatchPickwaveDto value);

    @Headers("Accept: application/json")
    @DELETE("Pickwaves/{id}")
    Call<String> delete(@Path("id") Long id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

