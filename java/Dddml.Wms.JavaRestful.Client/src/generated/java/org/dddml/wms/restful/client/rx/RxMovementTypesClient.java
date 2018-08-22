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
import org.dddml.wms.domain.movementtype.*;

public interface RxMovementTypesClient {

    @Headers("Accept: application/json")
    @GET("MovementTypes")
    Observable<List<MovementTypeStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("MovementTypes/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("MovementTypes/{movementTypeId}")
    Observable<MovementTypeStateDto> get(@Path("movementTypeId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("MovementTypes/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("MovementTypes/{movementTypeId}/_historyStates/{version}")
    Observable<MovementTypeStateDto> getHistoryState(@Path("movementTypeId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("MovementTypes/{movementTypeId}")
    Observable<String> put(@Path("movementTypeId") String id, @Body CreateOrMergePatchMovementTypeDto.CreateMovementTypeDto value);

    @Headers("Accept: application/json")
    @POST("MovementTypes")
    Observable<String> post(@Body CreateOrMergePatchMovementTypeDto.CreateMovementTypeDto value);

    @Headers("Accept: application/json")
    @PATCH("MovementTypes/{movementTypeId}")
    Observable<String> patch(@Path("movementTypeId") String id, @Body CreateOrMergePatchMovementTypeDto.MergePatchMovementTypeDto value);

    @Headers("Accept: application/json")
    @DELETE("MovementTypes/{movementTypeId}")
    Observable<String> delete(@Path("movementTypeId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

