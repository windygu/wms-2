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
import org.dddml.wms.domain.pickwave.*;

public interface RxPickwavesClient {

    @Headers("Accept: application/json")
    @GET("Pickwaves")
    Observable<List<PickwaveStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Pickwaves/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Pickwaves/{pickwaveId}")
    Observable<PickwaveStateDto> get(@Path("pickwaveId") Long pickwaveId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Pickwaves/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Pickwaves/{pickwaveId}/_stateEvents/{version}")
    Observable<PickwaveStateEventDto> getStateEvent(@Path("pickwaveId") Long pickwaveId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Pickwaves/{pickwaveId}/_historyStates/{version}")
    Observable<PickwaveStateDto> getHistoryState(@Path("pickwaveId") Long pickwaveId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("Pickwaves/{pickwaveId}")
    Observable<String> put(@Path("pickwaveId") Long pickwaveId, @Body CreateOrMergePatchPickwaveDto.CreatePickwaveDto value);

    @Headers("Accept: application/json")
    @POST("Pickwaves")
    Observable<Long> post(@Body CreateOrMergePatchPickwaveDto.CreatePickwaveDto value);

    @Headers("Accept: application/json")
    @PATCH("Pickwaves/{pickwaveId}")
    Observable<String> patch(@Path("pickwaveId") Long pickwaveId, @Body CreateOrMergePatchPickwaveDto.MergePatchPickwaveDto value);

    @Headers("Accept: application/json")
    @DELETE("Pickwaves/{pickwaveId}")
    Observable<String> delete(@Path("pickwaveId") Long pickwaveId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

