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
import org.dddml.wms.domain.locatortype.*;

public interface RxLocatorTypesClient {

    @Headers("Accept: application/json")
    @GET("LocatorTypes")
    Observable<List<LocatorTypeStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("LocatorTypes/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("LocatorTypes/{locatorTypeId}")
    Observable<LocatorTypeStateDto> get(@Path("locatorTypeId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("LocatorTypes/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("LocatorTypes/{locatorTypeId}/_stateEvents/{version}")
    Observable<LocatorTypeStateEventDto> getStateEvent(@Path("locatorTypeId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("LocatorTypes/{locatorTypeId}/_historyStates/{version}")
    Observable<LocatorTypeStateDto> getHistoryState(@Path("locatorTypeId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("LocatorTypes/{locatorTypeId}")
    Observable<String> put(@Path("locatorTypeId") String id, @Body CreateOrMergePatchLocatorTypeDto.CreateLocatorTypeDto value);

    @Headers("Accept: application/json")
    @POST("LocatorTypes")
    Observable<String> post(@Body CreateOrMergePatchLocatorTypeDto.CreateLocatorTypeDto value);

    @Headers("Accept: application/json")
    @PATCH("LocatorTypes/{locatorTypeId}")
    Observable<String> patch(@Path("locatorTypeId") String id, @Body CreateOrMergePatchLocatorTypeDto.MergePatchLocatorTypeDto value);

    @Headers("Accept: application/json")
    @DELETE("LocatorTypes/{locatorTypeId}")
    Observable<String> delete(@Path("locatorTypeId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

