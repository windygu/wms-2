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
import org.dddml.wms.domain.lot.*;

public interface RxLotsClient {

    @Headers("Accept: application/json")
    @GET("Lots")
    Observable<List<LotStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Lots/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Lots/{lotId}")
    Observable<LotStateDto> get(@Path("lotId") String lotId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Lots/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Lots/{lotId}/_stateEvents/{version}")
    Observable<LotStateEventDto> getStateEvent(@Path("lotId") String lotId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Lots/{lotId}/_historyStates/{version}")
    Observable<LotStateDto> getHistoryState(@Path("lotId") String lotId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("Lots/{lotId}")
    Observable<String> put(@Path("lotId") String lotId, @Body CreateOrMergePatchLotDto.CreateLotDto value);

    @Headers("Accept: application/json")
    @POST("Lots")
    Observable<String> post(@Body CreateOrMergePatchLotDto.CreateLotDto value);

    @Headers("Accept: application/json")
    @PATCH("Lots/{lotId}")
    Observable<String> patch(@Path("lotId") String lotId, @Body CreateOrMergePatchLotDto.MergePatchLotDto value);

    @Headers("Accept: application/json")
    @DELETE("Lots/{lotId}")
    Observable<String> delete(@Path("lotId") String lotId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

