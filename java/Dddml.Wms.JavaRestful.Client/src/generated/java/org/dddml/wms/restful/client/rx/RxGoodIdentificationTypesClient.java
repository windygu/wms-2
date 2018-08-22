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
import org.dddml.wms.domain.goodidentificationtype.*;

public interface RxGoodIdentificationTypesClient {

    @Headers("Accept: application/json")
    @GET("GoodIdentificationTypes")
    Observable<List<GoodIdentificationTypeStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("GoodIdentificationTypes/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("GoodIdentificationTypes/{goodIdentificationTypeId}")
    Observable<GoodIdentificationTypeStateDto> get(@Path("goodIdentificationTypeId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("GoodIdentificationTypes/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("GoodIdentificationTypes/{goodIdentificationTypeId}/_stateEvents/{version}")
    Observable<GoodIdentificationTypeStateEventDto> getStateEvent(@Path("goodIdentificationTypeId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("GoodIdentificationTypes/{goodIdentificationTypeId}/_historyStates/{version}")
    Observable<GoodIdentificationTypeStateDto> getHistoryState(@Path("goodIdentificationTypeId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("GoodIdentificationTypes/{goodIdentificationTypeId}")
    Observable<String> put(@Path("goodIdentificationTypeId") String id, @Body CreateOrMergePatchGoodIdentificationTypeDto.CreateGoodIdentificationTypeDto value);

    @Headers("Accept: application/json")
    @POST("GoodIdentificationTypes")
    Observable<String> post(@Body CreateOrMergePatchGoodIdentificationTypeDto.CreateGoodIdentificationTypeDto value);

    @Headers("Accept: application/json")
    @PATCH("GoodIdentificationTypes/{goodIdentificationTypeId}")
    Observable<String> patch(@Path("goodIdentificationTypeId") String id, @Body CreateOrMergePatchGoodIdentificationTypeDto.MergePatchGoodIdentificationTypeDto value);

    @Headers("Accept: application/json")
    @DELETE("GoodIdentificationTypes/{goodIdentificationTypeId}")
    Observable<String> delete(@Path("goodIdentificationTypeId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

