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
import org.dddml.wms.domain.lot.*;

public interface LotsClient {

    @Headers("Accept: application/json")
    @GET("Lots")
    Call<List<LotStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Lots/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Lots/{lotId}")
    Call<LotStateDto> get(@Path("lotId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Lots/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Lots/{lotId}/_stateEvents/{version}")
    Call<LotStateEventDto> getStateEvent(@Path("lotId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Lots/{lotId}/_historyStates/{version}")
    Call<LotStateDto> getHistoryState(@Path("lotId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("Lots/{lotId}")
    Call<String> put(@Path("lotId") String id, @Body CreateOrMergePatchLotDto.CreateLotDto value);

    @Headers("Accept: application/json")
    @POST("Lots")
    Call<String> post(@Body CreateOrMergePatchLotDto.CreateLotDto value);

    @Headers("Accept: application/json")
    @PATCH("Lots/{lotId}")
    Call<String> patch(@Path("lotId") String id, @Body CreateOrMergePatchLotDto.MergePatchLotDto value);

    @Headers("Accept: application/json")
    @DELETE("Lots/{lotId}")
    Call<String> delete(@Path("lotId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

