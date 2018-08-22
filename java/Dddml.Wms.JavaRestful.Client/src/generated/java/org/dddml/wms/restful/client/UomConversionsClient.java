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
import org.dddml.wms.domain.uomconversion.*;

public interface UomConversionsClient {

    @Headers("Accept: application/json")
    @GET("UomConversions")
    Call<List<UomConversionStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("UomConversions/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("UomConversions/{uomConversionId}")
    Call<UomConversionStateDto> get(@Path("uomConversionId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("UomConversions/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("UomConversions/{uomConversionId}/_stateEvents/{version}")
    Call<UomConversionStateEventDto> getStateEvent(@Path("uomConversionId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("UomConversions/{uomConversionId}/_historyStates/{version}")
    Call<UomConversionStateDto> getHistoryState(@Path("uomConversionId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("UomConversions/{uomConversionId}")
    Call<String> put(@Path("uomConversionId") String id, @Body CreateOrMergePatchUomConversionDto.CreateUomConversionDto value);

    @Headers("Accept: application/json")
    @POST("UomConversions")
    Call<UomConversionId> post(@Body CreateOrMergePatchUomConversionDto.CreateUomConversionDto value);

    @Headers("Accept: application/json")
    @PATCH("UomConversions/{uomConversionId}")
    Call<String> patch(@Path("uomConversionId") String id, @Body CreateOrMergePatchUomConversionDto.MergePatchUomConversionDto value);

    @Headers("Accept: application/json")
    @DELETE("UomConversions/{uomConversionId}")
    Call<String> delete(@Path("uomConversionId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

