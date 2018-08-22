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
import org.dddml.wms.domain.damagehandlingmethod.*;

public interface RxDamageHandlingMethodsClient {

    @Headers("Accept: application/json")
    @GET("DamageHandlingMethods")
    Observable<List<DamageHandlingMethodStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("DamageHandlingMethods/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("DamageHandlingMethods/{damageHandlingMethodId}")
    Observable<DamageHandlingMethodStateDto> get(@Path("damageHandlingMethodId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("DamageHandlingMethods/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("DamageHandlingMethods/{damageHandlingMethodId}/_historyStates/{version}")
    Observable<DamageHandlingMethodStateDto> getHistoryState(@Path("damageHandlingMethodId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("DamageHandlingMethods/{damageHandlingMethodId}")
    Observable<String> put(@Path("damageHandlingMethodId") String id, @Body CreateOrMergePatchDamageHandlingMethodDto.CreateDamageHandlingMethodDto value);

    @Headers("Accept: application/json")
    @POST("DamageHandlingMethods")
    Observable<String> post(@Body CreateOrMergePatchDamageHandlingMethodDto.CreateDamageHandlingMethodDto value);

    @Headers("Accept: application/json")
    @PATCH("DamageHandlingMethods/{damageHandlingMethodId}")
    Observable<String> patch(@Path("damageHandlingMethodId") String id, @Body CreateOrMergePatchDamageHandlingMethodDto.MergePatchDamageHandlingMethodDto value);

    @Headers("Accept: application/json")
    @DELETE("DamageHandlingMethods/{damageHandlingMethodId}")
    Observable<String> delete(@Path("damageHandlingMethodId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

