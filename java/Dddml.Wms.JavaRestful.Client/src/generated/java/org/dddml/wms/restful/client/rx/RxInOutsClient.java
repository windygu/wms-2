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
    @GET("InOuts/{id}")
    Observable<InOutStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("InOuts/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("InOuts/{id}/_stateEvents/{version}")
    Observable<InOutStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InOuts/{id}/_historyStates/{version}")
    Observable<InOutStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InOuts/{inOutDocumentNumber}/InOutLines/{lineNumber}")
    Observable<InOutLineStateDto> getInOutLine(@Path("inOutDocumentNumber") String inOutDocumentNumber, @Path("lineNumber") String lineNumber);
 
    @Headers("Accept: application/json")
    @PUT("InOuts/{id}")
    Observable<String> put(@Path("id") String id, @Body CreateOrMergePatchInOutDto.CreateInOutDto value);

    @Headers("Accept: application/json")
    @PATCH("InOuts/{id}")
    Observable<String> patch(@Path("id") String id, @Body CreateOrMergePatchInOutDto.MergePatchInOutDto value);

    @Headers("Accept: application/json")
    @DELETE("InOuts/{id}")
    Observable<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

    @Headers("Accept: application/json")
    @PUT("InOuts/{id}/_commands/Complete")
    Observable<String> complete(@Path("id") String id, @Body InOutCommandDtos.CompleteRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{id}/_commands/Close")
    Observable<String> close(@Path("id") String id, @Body InOutCommandDtos.CloseRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{id}/_commands/Void")
    Observable<String> _void(@Path("id") String id, @Body InOutCommandDtos.VoidRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{id}/_commands/Reverse")
    Observable<String> reverse(@Path("id") String id, @Body InOutCommandDtos.ReverseRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{id}/_commands/AddLine")
    Observable<String> addLine(@Path("id") String id, @Body InOutCommandDtos.AddLineRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{id}/_commands/DocumentAction")
    Observable<String> documentAction(@Path("id") String id, @Body InOutCommandDtos.DocumentActionRequestContent content);

}

