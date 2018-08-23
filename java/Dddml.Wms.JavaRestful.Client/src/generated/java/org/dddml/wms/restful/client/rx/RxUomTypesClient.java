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
import org.dddml.wms.domain.uomtype.*;

public interface RxUomTypesClient {

    @Headers("Accept: application/json")
    @GET("UomTypes")
    Observable<List<UomTypeStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("UomTypes/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("UomTypes/{uomTypeId}")
    Observable<UomTypeStateDto> get(@Path("uomTypeId") String uomTypeId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("UomTypes/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("UomTypes/{uomTypeId}/_historyStates/{version}")
    Observable<UomTypeStateDto> getHistoryState(@Path("uomTypeId") String uomTypeId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("UomTypes/{uomTypeId}")
    Observable<String> put(@Path("uomTypeId") String uomTypeId, @Body CreateOrMergePatchUomTypeDto.CreateUomTypeDto value);

    @Headers("Accept: application/json")
    @POST("UomTypes")
    Observable<String> post(@Body CreateOrMergePatchUomTypeDto.CreateUomTypeDto value);

    @Headers("Accept: application/json")
    @PATCH("UomTypes/{uomTypeId}")
    Observable<String> patch(@Path("uomTypeId") String uomTypeId, @Body CreateOrMergePatchUomTypeDto.MergePatchUomTypeDto value);

    @Headers("Accept: application/json")
    @DELETE("UomTypes/{uomTypeId}")
    Observable<String> delete(@Path("uomTypeId") String uomTypeId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

