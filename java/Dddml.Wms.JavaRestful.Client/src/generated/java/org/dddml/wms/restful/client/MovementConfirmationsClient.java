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
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.movementconfirmation.*;

public interface MovementConfirmationsClient {

    @Headers("Accept: application/json")
    @GET("MovementConfirmations")
    Call<List<MovementConfirmationStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("MovementConfirmations/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("MovementConfirmations/{documentNumber}")
    Call<MovementConfirmationStateDto> get(@Path("documentNumber") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("MovementConfirmations/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("MovementConfirmations/{documentNumber}/_stateEvents/{version}")
    Call<MovementConfirmationStateEventDto> getStateEvent(@Path("documentNumber") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("MovementConfirmations/{documentNumber}/_historyStates/{version}")
    Call<MovementConfirmationStateDto> getHistoryState(@Path("documentNumber") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("MovementConfirmations/{movementConfirmationDocumentNumber}/MovementConfirmationLines/{lineNumber}")
    Call<MovementConfirmationLineStateDto> getMovementConfirmationLine(@Path("movementConfirmationDocumentNumber") String movementConfirmationDocumentNumber, @Path("lineNumber") String lineNumber);
 
    @Headers("Accept: application/json")
    @PUT("MovementConfirmations/{documentNumber}")
    Call<String> put(@Path("documentNumber") String id, @Body CreateOrMergePatchMovementConfirmationDto.CreateMovementConfirmationDto value);

    @Headers("Accept: application/json")
    @POST("MovementConfirmations")
    Call<String> post(@Body CreateOrMergePatchMovementConfirmationDto.CreateMovementConfirmationDto value);

    @Headers("Accept: application/json")
    @PATCH("MovementConfirmations/{documentNumber}")
    Call<String> patch(@Path("documentNumber") String id, @Body CreateOrMergePatchMovementConfirmationDto.MergePatchMovementConfirmationDto value);

    @Headers("Accept: application/json")
    @DELETE("MovementConfirmations/{documentNumber}")
    Call<String> delete(@Path("documentNumber") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

    @Headers("Accept: application/json")
    @PUT("MovementConfirmations/{documentNumber}/_commands/DocumentAction")
    Call<String> documentAction(@Path("documentNumber") String documentNumber, @Body MovementConfirmationCommandDtos.DocumentActionRequestContent content);

}

