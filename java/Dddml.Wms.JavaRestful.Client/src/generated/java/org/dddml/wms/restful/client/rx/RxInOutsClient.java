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
import org.dddml.wms.domain.inout.*;

public interface RxInOutsClient {

    @Headers("Accept: application/json")
    @GET("InOuts")
    Observable<List<InOutStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InOuts/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InOuts/{documentNumber}")
    Observable<InOutStateDto> get(@Path("documentNumber") String documentNumber, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("InOuts/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("InOuts/{documentNumber}/_stateEvents/{version}")
    Observable<InOutStateEventDto> getStateEvent(@Path("documentNumber") String documentNumber, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InOuts/{documentNumber}/_historyStates/{version}")
    Observable<InOutStateDto> getHistoryState(@Path("documentNumber") String documentNumber, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InOuts/{inOutDocumentNumber}/InOutImages/{sequenceId}")
    Observable<InOutImageStateDto> getInOutImage(@Path("inOutDocumentNumber") String inOutDocumentNumber, @Path("sequenceId") String sequenceId);
 
    @Headers("Accept: application/json")
    @GET("InOuts/{documentNumber}/InOutImages")
    Observable<List<InOutImageStateDto>> getInOutImages(@Path("documentNumber") String documentNumber, @Query("sort") String sort, @Query("fields") String fields, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InOuts/{inOutDocumentNumber}/InOutLines/{lineNumber}")
    Observable<InOutLineStateDto> getInOutLine(@Path("inOutDocumentNumber") String inOutDocumentNumber, @Path("lineNumber") String lineNumber);
 
    @Headers("Accept: application/json")
    @GET("InOuts/{documentNumber}/InOutLines")
    Observable<List<InOutLineStateDto>> getInOutLines(@Path("documentNumber") String documentNumber, @Query("sort") String sort, @Query("fields") String fields, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InOuts/{inOutDocumentNumber}/InOutLines/{inOutLineLineNumber}/InOutLineImages/{sequenceId}")
    Observable<InOutLineImageStateDto> getInOutLineImage(@Path("inOutDocumentNumber") String inOutDocumentNumber, @Path("inOutLineLineNumber") String inOutLineLineNumber, @Path("sequenceId") String sequenceId);
 
    @Headers("Accept: application/json")
    @GET("InOuts/{documentNumber}/InOutLines/{inOutLineLineNumber}/InOutLineImages")
    Observable<List<InOutLineImageStateDto>> getInOutLineImages(@Path("documentNumber") String documentNumber, @Path("inOutLineLineNumber") String inOutLineLineNumber, @Query("sort") String sort, @Query("fields") String fields, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @PUT("InOuts/{documentNumber}")
    Observable<String> put(@Path("documentNumber") String documentNumber, @Body CreateOrMergePatchInOutDto.CreateInOutDto value);

    @Headers("Accept: application/json")
    @POST("InOuts")
    Observable<String> post(@Body CreateOrMergePatchInOutDto.CreateInOutDto value);

    @Headers("Accept: application/json")
    @PATCH("InOuts/{documentNumber}")
    Observable<String> patch(@Path("documentNumber") String documentNumber, @Body CreateOrMergePatchInOutDto.MergePatchInOutDto value);

    @Headers("Accept: application/json")
    @DELETE("InOuts/{documentNumber}")
    Observable<String> delete(@Path("documentNumber") String documentNumber, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

    @Headers("Accept: application/json")
    @PUT("InOuts/{documentNumber}/_commands/Complete")
    Observable<String> complete(@Path("documentNumber") String documentNumber, @Body InOutCommandDtos.CompleteRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{documentNumber}/_commands/Close")
    Observable<String> close(@Path("documentNumber") String documentNumber, @Body InOutCommandDtos.CloseRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{documentNumber}/_commands/Void")
    Observable<String> _void(@Path("documentNumber") String documentNumber, @Body InOutCommandDtos.VoidRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{documentNumber}/_commands/Reverse")
    Observable<String> reverse(@Path("documentNumber") String documentNumber, @Body InOutCommandDtos.ReverseRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{documentNumber}/_commands/AddLine")
    Observable<String> addLine(@Path("documentNumber") String documentNumber, @Body InOutCommandDtos.AddLineRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{documentNumber}/_commands/Import")
    Observable<String> _import(@Path("documentNumber") String documentNumber, @Body InOutCommandDtos.ImportRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{documentNumber}/_commands/DocumentAction")
    Observable<String> documentAction(@Path("documentNumber") String documentNumber, @Body InOutCommandDtos.DocumentActionRequestContent content);

}

