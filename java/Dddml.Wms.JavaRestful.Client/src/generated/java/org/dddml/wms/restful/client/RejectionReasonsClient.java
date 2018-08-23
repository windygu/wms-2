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
import org.dddml.wms.domain.rejectionreason.*;

public interface RejectionReasonsClient {

    @Headers("Accept: application/json")
    @GET("RejectionReasons")
    Call<List<RejectionReasonStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("RejectionReasons/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("RejectionReasons/{rejectionReasonId}")
    Call<RejectionReasonStateDto> get(@Path("rejectionReasonId") String rejectionReasonId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("RejectionReasons/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("RejectionReasons/{rejectionReasonId}/_stateEvents/{version}")
    Call<RejectionReasonStateEventDto> getStateEvent(@Path("rejectionReasonId") String rejectionReasonId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("RejectionReasons/{rejectionReasonId}/_historyStates/{version}")
    Call<RejectionReasonStateDto> getHistoryState(@Path("rejectionReasonId") String rejectionReasonId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("RejectionReasons/{rejectionReasonId}")
    Call<String> put(@Path("rejectionReasonId") String rejectionReasonId, @Body CreateOrMergePatchRejectionReasonDto.CreateRejectionReasonDto value);

    @Headers("Accept: application/json")
    @POST("RejectionReasons")
    Call<String> post(@Body CreateOrMergePatchRejectionReasonDto.CreateRejectionReasonDto value);

    @Headers("Accept: application/json")
    @PATCH("RejectionReasons/{rejectionReasonId}")
    Call<String> patch(@Path("rejectionReasonId") String rejectionReasonId, @Body CreateOrMergePatchRejectionReasonDto.MergePatchRejectionReasonDto value);

    @Headers("Accept: application/json")
    @DELETE("RejectionReasons/{rejectionReasonId}")
    Call<String> delete(@Path("rejectionReasonId") String rejectionReasonId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

