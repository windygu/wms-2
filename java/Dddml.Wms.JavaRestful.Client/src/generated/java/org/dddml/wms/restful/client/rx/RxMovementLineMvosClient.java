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
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.movementlinemvo.*;

public interface RxMovementLineMvosClient {

    @Headers("Accept: application/json")
    @GET("MovementLineMvos")
    Observable<List<MovementLineMvoStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("MovementLineMvos/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("MovementLineMvos/{id}")
    Observable<MovementLineMvoStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("MovementLineMvos/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("MovementLineMvos/{id}/_stateEvents/{version}")
    Observable<MovementLineMvoStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("MovementLineMvos/{id}/_historyStates/{version}")
    Observable<MovementLineMvoStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("MovementLineMvos/{id}")
    Observable<String> put(@Path("id") String id, @Body CreateOrMergePatchMovementLineMvoDto.CreateMovementLineMvoDto value);

    @Headers("Accept: application/json")
    @PATCH("MovementLineMvos/{id}")
    Observable<String> patch(@Path("id") String id, @Body CreateOrMergePatchMovementLineMvoDto.MergePatchMovementLineMvoDto value);

    @Headers("Accept: application/json")
    @DELETE("MovementLineMvos/{id}")
    Observable<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

