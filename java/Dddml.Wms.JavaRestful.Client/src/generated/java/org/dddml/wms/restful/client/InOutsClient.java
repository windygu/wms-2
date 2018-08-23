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
import org.dddml.wms.domain.inout.*;

public interface InOutsClient {

    @Headers("Accept: application/json")
    @GET("InOuts")
    Call<List<InOutStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InOuts/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InOuts/{documentNumber}")
    Call<InOutStateDto> get(@Path("documentNumber") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("InOuts/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("InOuts/{documentNumber}/_stateEvents/{version}")
    Call<InOutStateEventDto> getStateEvent(@Path("documentNumber") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InOuts/{documentNumber}/_historyStates/{version}")
    Call<InOutStateDto> getHistoryState(@Path("documentNumber") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InOuts/{inOutDocumentNumber}/InOutImages/{sequenceId}")
    Call<InOutImageStateDto> getInOutImage(@Path("inOutDocumentNumber") String inOutDocumentNumber, @Path("sequenceId") String sequenceId);
 
    @Headers("Accept: application/json")
    @GET("InOuts/{documentNumber}/InOutImages")
    Call<List<InOutImageStateDto>> getInOutImages(@Path("documentNumber") String documentNumber);

    @Headers("Accept: application/json")
    @GET("InOuts/{inOutDocumentNumber}/InOutLines/{lineNumber}")
    Call<InOutLineStateDto> getInOutLine(@Path("inOutDocumentNumber") String inOutDocumentNumber, @Path("lineNumber") String lineNumber);
 
    @Headers("Accept: application/json")
    @GET("InOuts/{documentNumber}/InOutLines")
    Call<List<InOutLineStateDto>> getInOutLines(@Path("documentNumber") String documentNumber);

    @Headers("Accept: application/json")
    @GET("InOuts/{inOutDocumentNumber}/InOutLines/{inOutLineLineNumber}/InOutLineImages/{sequenceId}")
    Call<InOutLineImageStateDto> getInOutLineImage(@Path("inOutDocumentNumber") String inOutDocumentNumber, @Path("inOutLineLineNumber") String inOutLineLineNumber, @Path("sequenceId") String sequenceId);
 
    @Headers("Accept: application/json")
    @GET("InOuts/{documentNumber}/InOutLines/{inOutLineLineNumber}/InOutLineImages")
    Call<List<InOutLineImageStateDto>> getInOutLineImages(@Path("documentNumber") String documentNumber, @Path("inOutLineLineNumber") String inOutLineLineNumber);

    @Headers("Accept: application/json")
    @PUT("InOuts/{documentNumber}")
    Call<String> put(@Path("documentNumber") String id, @Body CreateOrMergePatchInOutDto.CreateInOutDto value);

    @Headers("Accept: application/json")
    @POST("InOuts")
    Call<String> post(@Body CreateOrMergePatchInOutDto.CreateInOutDto value);

    @Headers("Accept: application/json")
    @PATCH("InOuts/{documentNumber}")
    Call<String> patch(@Path("documentNumber") String id, @Body CreateOrMergePatchInOutDto.MergePatchInOutDto value);

    @Headers("Accept: application/json")
    @DELETE("InOuts/{documentNumber}")
    Call<String> delete(@Path("documentNumber") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

    @Headers("Accept: application/json")
    @PUT("InOuts/{documentNumber}/_commands/Complete")
    Call<String> complete(@Path("documentNumber") String documentNumber, @Body InOutCommandDtos.CompleteRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{documentNumber}/_commands/Close")
    Call<String> close(@Path("documentNumber") String documentNumber, @Body InOutCommandDtos.CloseRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{documentNumber}/_commands/Void")
    Call<String> _void(@Path("documentNumber") String documentNumber, @Body InOutCommandDtos.VoidRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{documentNumber}/_commands/Reverse")
    Call<String> reverse(@Path("documentNumber") String documentNumber, @Body InOutCommandDtos.ReverseRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{documentNumber}/_commands/AddLine")
    Call<String> addLine(@Path("documentNumber") String documentNumber, @Body InOutCommandDtos.AddLineRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{documentNumber}/_commands/Import")
    Call<String> _import(@Path("documentNumber") String documentNumber, @Body InOutCommandDtos.ImportRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{documentNumber}/_commands/DocumentAction")
    Call<String> documentAction(@Path("documentNumber") String documentNumber, @Body InOutCommandDtos.DocumentActionRequestContent content);

}

