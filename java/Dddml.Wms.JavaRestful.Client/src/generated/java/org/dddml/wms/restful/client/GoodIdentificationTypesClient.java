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
import org.dddml.wms.domain.goodidentificationtype.*;

public interface GoodIdentificationTypesClient {

    @Headers("Accept: application/json")
    @GET("GoodIdentificationTypes")
    Call<List<GoodIdentificationTypeStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("GoodIdentificationTypes/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("GoodIdentificationTypes/{goodIdentificationTypeId}")
    Call<GoodIdentificationTypeStateDto> get(@Path("goodIdentificationTypeId") String goodIdentificationTypeId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("GoodIdentificationTypes/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("GoodIdentificationTypes/{goodIdentificationTypeId}/_stateEvents/{version}")
    Call<GoodIdentificationTypeStateEventDto> getStateEvent(@Path("goodIdentificationTypeId") String goodIdentificationTypeId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("GoodIdentificationTypes/{goodIdentificationTypeId}/_historyStates/{version}")
    Call<GoodIdentificationTypeStateDto> getHistoryState(@Path("goodIdentificationTypeId") String goodIdentificationTypeId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("GoodIdentificationTypes/{goodIdentificationTypeId}")
    Call<String> put(@Path("goodIdentificationTypeId") String goodIdentificationTypeId, @Body CreateOrMergePatchGoodIdentificationTypeDto.CreateGoodIdentificationTypeDto value);

    @Headers("Accept: application/json")
    @POST("GoodIdentificationTypes")
    Call<String> post(@Body CreateOrMergePatchGoodIdentificationTypeDto.CreateGoodIdentificationTypeDto value);

    @Headers("Accept: application/json")
    @PATCH("GoodIdentificationTypes/{goodIdentificationTypeId}")
    Call<String> patch(@Path("goodIdentificationTypeId") String goodIdentificationTypeId, @Body CreateOrMergePatchGoodIdentificationTypeDto.MergePatchGoodIdentificationTypeDto value);

    @Headers("Accept: application/json")
    @DELETE("GoodIdentificationTypes/{goodIdentificationTypeId}")
    Call<String> delete(@Path("goodIdentificationTypeId") String goodIdentificationTypeId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

