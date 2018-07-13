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
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.movementconfirmation.*;

public interface RxMovementConfirmationsClient {

    @Headers("Accept: application/json")
    @GET("MovementConfirmations")
    Observable<List<MovementConfirmationStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("MovementConfirmations/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("MovementConfirmations/{id}")
    Observable<MovementConfirmationStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("MovementConfirmations/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("MovementConfirmations/{id}/_stateEvents/{version}")
    Observable<MovementConfirmationStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("MovementConfirmations/{id}/_historyStates/{version}")
    Observable<MovementConfirmationStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("MovementConfirmations/{movementConfirmationDocumentNumber}/MovementConfirmationLines/{lineNumber}")
    Observable<MovementConfirmationLineStateDto> getMovementConfirmationLine(@Path("movementConfirmationDocumentNumber") String movementConfirmationDocumentNumber, @Path("lineNumber") String lineNumber);
 
    @Headers("Accept: application/json")
    @PUT("MovementConfirmations/{id}")
    Observable<String> put(@Path("id") String id, @Body CreateOrMergePatchMovementConfirmationDto.CreateMovementConfirmationDto value);

    @Headers("Accept: application/json")
    @POST("MovementConfirmations")
    Observable<String> post(@Body CreateOrMergePatchMovementConfirmationDto.CreateMovementConfirmationDto value);

    @Headers("Accept: application/json")
    @PATCH("MovementConfirmations/{id}")
    Observable<String> patch(@Path("id") String id, @Body CreateOrMergePatchMovementConfirmationDto.MergePatchMovementConfirmationDto value);

    @Headers("Accept: application/json")
    @DELETE("MovementConfirmations/{id}")
    Observable<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

    @Headers("Accept: application/json")
    @PUT("MovementConfirmations/{id}/_commands/DocumentAction")
    Observable<String> documentAction(@Path("id") String id, @Body MovementConfirmationCommandDtos.DocumentActionRequestContent content);

}

