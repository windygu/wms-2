package org.dddml.wms.restful.client.rx;

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
    @GET("GoodIdentificationTypes/{id}")
    Observable<GoodIdentificationTypeStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("GoodIdentificationTypes/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("GoodIdentificationTypes/{id}/_stateEvents/{version}")
    Observable<GoodIdentificationTypeStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("GoodIdentificationTypes/{id}/_historyStates/{version}")
    Observable<GoodIdentificationTypeStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("GoodIdentificationTypes/{id}")
    Observable<String> put(@Path("id") String id, @Body CreateOrMergePatchGoodIdentificationTypeDto.CreateGoodIdentificationTypeDto value);

    @Headers("Accept: application/json")
    @POST("GoodIdentificationTypes")
    Observable<String> post(@Body CreateOrMergePatchGoodIdentificationTypeDto.CreateGoodIdentificationTypeDto value);

    @Headers("Accept: application/json")
    @PATCH("GoodIdentificationTypes/{id}")
    Observable<String> patch(@Path("id") String id, @Body CreateOrMergePatchGoodIdentificationTypeDto.MergePatchGoodIdentificationTypeDto value);

    @Headers("Accept: application/json")
    @DELETE("GoodIdentificationTypes/{id}")
    Observable<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

