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
import org.dddml.wms.domain.damagereason.*;

public interface RxDamageReasonsClient {

    @Headers("Accept: application/json")
    @GET("DamageReasons")
    Observable<List<DamageReasonStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("DamageReasons/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("DamageReasons/{damageReasonId}")
    Observable<DamageReasonStateDto> get(@Path("damageReasonId") String damageReasonId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("DamageReasons/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("DamageReasons/{damageReasonId}/_stateEvents/{version}")
    Observable<DamageReasonStateEventDto> getStateEvent(@Path("damageReasonId") String damageReasonId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("DamageReasons/{damageReasonId}/_historyStates/{version}")
    Observable<DamageReasonStateDto> getHistoryState(@Path("damageReasonId") String damageReasonId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("DamageReasons/{damageReasonId}")
    Observable<String> put(@Path("damageReasonId") String damageReasonId, @Body CreateOrMergePatchDamageReasonDto.CreateDamageReasonDto value);

    @Headers("Accept: application/json")
    @POST("DamageReasons")
    Observable<String> post(@Body CreateOrMergePatchDamageReasonDto.CreateDamageReasonDto value);

    @Headers("Accept: application/json")
    @PATCH("DamageReasons/{damageReasonId}")
    Observable<String> patch(@Path("damageReasonId") String damageReasonId, @Body CreateOrMergePatchDamageReasonDto.MergePatchDamageReasonDto value);

    @Headers("Accept: application/json")
    @DELETE("DamageReasons/{damageReasonId}")
    Observable<String> delete(@Path("damageReasonId") String damageReasonId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

