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
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.uomconversion.*;

public interface RxUomConversionsClient {

    @Headers("Accept: application/json")
    @GET("UomConversions")
    Observable<List<UomConversionStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("UomConversions/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("UomConversions/{id}")
    Observable<UomConversionStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("UomConversions/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("UomConversions/{id}/_stateEvents/{version}")
    Observable<UomConversionStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("UomConversions/{id}/_historyStates/{version}")
    Observable<UomConversionStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("UomConversions/{id}")
    Observable<String> put(@Path("id") String id, @Body CreateOrMergePatchUomConversionDto.CreateUomConversionDto value);

    @Headers("Accept: application/json")
    @POST("UomConversions")
    Observable<UomConversionId> post(@Body CreateOrMergePatchUomConversionDto.CreateUomConversionDto value);

    @Headers("Accept: application/json")
    @PATCH("UomConversions/{id}")
    Observable<String> patch(@Path("id") String id, @Body CreateOrMergePatchUomConversionDto.MergePatchUomConversionDto value);

    @Headers("Accept: application/json")
    @DELETE("UomConversions/{id}")
    Observable<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

