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
    @GET("Movements/{documentNumber}")
    Observable<MovementStateDto> get(@Path("documentNumber") String documentNumber, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Movements/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Movements/{documentNumber}/_stateEvents/{version}")
    Observable<MovementStateEventDto> getStateEvent(@Path("documentNumber") String documentNumber, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Movements/{documentNumber}/_historyStates/{version}")
    Observable<MovementStateDto> getHistoryState(@Path("documentNumber") String documentNumber, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Movements/{movementDocumentNumber}/MovementLines/{lineNumber}")
    Observable<MovementLineStateDto> getMovementLine(@Path("movementDocumentNumber") String movementDocumentNumber, @Path("lineNumber") String lineNumber);
 
    @Headers("Accept: application/json")
    @GET("Movements/{documentNumber}/MovementLines")
    Observable<List<MovementLineStateDto>> getMovementLines(@Path("documentNumber") String documentNumber, @Query("sort") String sort, @Query("fields") String fields, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @PUT("Movements/{documentNumber}")
    Observable<String> put(@Path("documentNumber") String documentNumber, @Body CreateOrMergePatchMovementDto.CreateMovementDto value);

    @Headers("Accept: application/json")
    @POST("Movements")
    Observable<String> post(@Body CreateOrMergePatchMovementDto.CreateMovementDto value);

    @Headers("Accept: application/json")
    @PATCH("Movements/{documentNumber}")
    Observable<String> patch(@Path("documentNumber") String documentNumber, @Body CreateOrMergePatchMovementDto.MergePatchMovementDto value);

    @Headers("Accept: application/json")
    @DELETE("Movements/{documentNumber}")
    Observable<String> delete(@Path("documentNumber") String documentNumber, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

    @Headers("Accept: application/json")
    @PUT("Movements/{documentNumber}/_commands/AddLine")
    Observable<String> addLine(@Path("documentNumber") String documentNumber, @Body MovementCommandDtos.AddLineRequestContent content);

    @Headers("Accept: application/json")
    @PUT("Movements/{documentNumber}/_commands/DocumentAction")
    Observable<String> documentAction(@Path("documentNumber") String documentNumber, @Body MovementCommandDtos.DocumentActionRequestContent content);

}

