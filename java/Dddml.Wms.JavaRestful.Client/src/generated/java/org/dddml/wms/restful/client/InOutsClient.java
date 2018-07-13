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
    @GET("InOuts/{id}")
    Call<InOutStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("InOuts/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("InOuts/{id}/_stateEvents/{version}")
    Call<InOutStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InOuts/{id}/_historyStates/{version}")
    Call<InOutStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InOuts/{inOutDocumentNumber}/InOutLines/{lineNumber}")
    Call<InOutLineStateDto> getInOutLine(@Path("inOutDocumentNumber") String inOutDocumentNumber, @Path("lineNumber") String lineNumber);
 
    @Headers("Accept: application/json")
    @PUT("InOuts/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchInOutDto.CreateInOutDto value);

    @Headers("Accept: application/json")
    @POST("InOuts")
    Call<String> post(@Body CreateOrMergePatchInOutDto.CreateInOutDto value);

    @Headers("Accept: application/json")
    @PATCH("InOuts/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchInOutDto.MergePatchInOutDto value);

    @Headers("Accept: application/json")
    @DELETE("InOuts/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

    @Headers("Accept: application/json")
    @PUT("InOuts/{id}/_commands/Complete")
    Call<String> complete(@Path("id") String id, @Body InOutCommandDtos.CompleteRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{id}/_commands/Close")
    Call<String> close(@Path("id") String id, @Body InOutCommandDtos.CloseRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{id}/_commands/Void")
    Call<String> _void(@Path("id") String id, @Body InOutCommandDtos.VoidRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{id}/_commands/Reverse")
    Call<String> reverse(@Path("id") String id, @Body InOutCommandDtos.ReverseRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{id}/_commands/AddLine")
    Call<String> addLine(@Path("id") String id, @Body InOutCommandDtos.AddLineRequestContent content);

    @Headers("Accept: application/json")
    @PUT("InOuts/{id}/_commands/DocumentAction")
    Call<String> documentAction(@Path("id") String id, @Body InOutCommandDtos.DocumentActionRequestContent content);

}

