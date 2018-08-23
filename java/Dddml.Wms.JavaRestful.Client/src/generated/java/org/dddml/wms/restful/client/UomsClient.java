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
import org.dddml.wms.domain.uom.*;

public interface UomsClient {

    @Headers("Accept: application/json")
    @GET("Uoms")
    Call<List<UomStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Uoms/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Uoms/{uomId}")
    Call<UomStateDto> get(@Path("uomId") String uomId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Uoms/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Uoms/{uomId}/_stateEvents/{version}")
    Call<UomStateEventDto> getStateEvent(@Path("uomId") String uomId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Uoms/{uomId}/_historyStates/{version}")
    Call<UomStateDto> getHistoryState(@Path("uomId") String uomId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("Uoms/{uomId}")
    Call<String> put(@Path("uomId") String uomId, @Body CreateOrMergePatchUomDto.CreateUomDto value);

    @Headers("Accept: application/json")
    @POST("Uoms")
    Call<String> post(@Body CreateOrMergePatchUomDto.CreateUomDto value);

    @Headers("Accept: application/json")
    @PATCH("Uoms/{uomId}")
    Call<String> patch(@Path("uomId") String uomId, @Body CreateOrMergePatchUomDto.MergePatchUomDto value);

    @Headers("Accept: application/json")
    @DELETE("Uoms/{uomId}")
    Call<String> delete(@Path("uomId") String uomId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

