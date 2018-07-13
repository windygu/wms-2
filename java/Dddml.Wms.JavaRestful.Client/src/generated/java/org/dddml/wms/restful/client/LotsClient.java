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
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.lot.*;

public interface LotsClient {

    @Headers("Accept: application/json")
    @GET("Lots")
    Call<List<LotStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Lots/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Lots/{id}")
    Call<LotStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Lots/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Lots/{id}/_stateEvents/{version}")
    Call<LotStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Lots/{id}/_historyStates/{version}")
    Call<LotStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("Lots/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchLotDto.CreateLotDto value);

    @Headers("Accept: application/json")
    @POST("Lots")
    Call<String> post(@Body CreateOrMergePatchLotDto.CreateLotDto value);

    @Headers("Accept: application/json")
    @PATCH("Lots/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchLotDto.MergePatchLotDto value);

    @Headers("Accept: application/json")
    @DELETE("Lots/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

