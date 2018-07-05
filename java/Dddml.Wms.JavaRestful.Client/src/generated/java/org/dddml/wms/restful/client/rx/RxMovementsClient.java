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
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.movement.*;

public interface RxMovementsClient {

    @Headers("Accept: application/json")
    @GET("Movements")
    Observable<List<MovementStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Movements/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Movements/{id}")
    Observable<MovementStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Movements/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Movements/{id}/_stateEvents/{version}")
    Observable<MovementStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Movements/{id}/_historyStates/{version}")
    Observable<MovementStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Movements/{movementDocumentNumber}/MovementLines/{lineNumber}")
    Observable<MovementLineStateDto> getMovementLine(@Path("movementDocumentNumber") String movementDocumentNumber, @Path("lineNumber") String lineNumber);
 
    @Headers("Accept: application/json")
    @PUT("Movements/{id}")
    Observable<String> put(@Path("id") String id, @Body CreateOrMergePatchMovementDto.CreateMovementDto value);

    @Headers("Accept: application/json")
    @PATCH("Movements/{id}")
    Observable<String> patch(@Path("id") String id, @Body CreateOrMergePatchMovementDto.MergePatchMovementDto value);

    @Headers("Accept: application/json")
    @DELETE("Movements/{id}")
    Observable<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

    @Headers("Accept: application/json")
    @PUT("Movements/{id}/_commands/DocumentAction")
    Observable<String> documentAction(@Path("id") String id, @Body MovementCommandDtos.DocumentActionRequestContent content);

}

