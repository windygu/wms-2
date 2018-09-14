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
import org.dddml.wms.domain.inoutnotice.*;

public interface RxInOutNoticesClient {

    @Headers("Accept: application/json")
    @GET("InOutNotices")
    Observable<List<InOutNoticeStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InOutNotices/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("InOutNotices/{inOutNoticeId}")
    Observable<InOutNoticeStateDto> get(@Path("inOutNoticeId") String inOutNoticeId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("InOutNotices/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("InOutNotices/{inOutNoticeId}/_stateEvents/{version}")
    Observable<InOutNoticeStateEventDto> getStateEvent(@Path("inOutNoticeId") String inOutNoticeId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("InOutNotices/{inOutNoticeId}/_historyStates/{version}")
    Observable<InOutNoticeStateDto> getHistoryState(@Path("inOutNoticeId") String inOutNoticeId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("InOutNotices/{inOutNoticeId}")
    Observable<String> put(@Path("inOutNoticeId") String inOutNoticeId, @Body CreateOrMergePatchInOutNoticeDto.CreateInOutNoticeDto value);

    @Headers("Accept: application/json")
    @POST("InOutNotices")
    Observable<String> post(@Body CreateOrMergePatchInOutNoticeDto.CreateInOutNoticeDto value);

    @Headers("Accept: application/json")
    @PATCH("InOutNotices/{inOutNoticeId}")
    Observable<String> patch(@Path("inOutNoticeId") String inOutNoticeId, @Body CreateOrMergePatchInOutNoticeDto.MergePatchInOutNoticeDto value);

    @Headers("Accept: application/json")
    @DELETE("InOutNotices/{inOutNoticeId}")
    Observable<String> delete(@Path("inOutNoticeId") String inOutNoticeId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

    @Headers("Accept: application/json")
    @PUT("InOutNotices/{inOutNoticeId}/_commands/InOutNoticeAction")
    Observable<String> inOutNoticeAction(@Path("inOutNoticeId") String inOutNoticeId, @Body InOutNoticeCommandDtos.InOutNoticeActionRequestContent content);

}

