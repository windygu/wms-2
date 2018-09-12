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
import org.dddml.wms.domain.contactmech.*;

public interface RxTelecomNumbersClient {

    @Headers("Accept: application/json")
    @GET("TelecomNumbers")
    Observable<List<ContactMechStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("TelecomNumbers/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("TelecomNumbers/{contactMechId}")
    Observable<ContactMechStateDto> get(@Path("contactMechId") String contactMechId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("TelecomNumbers/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("TelecomNumbers/{contactMechId}/_stateEvents/{version}")
    Observable<ContactMechStateEventDto> getStateEvent(@Path("contactMechId") String contactMechId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("TelecomNumbers/{contactMechId}/_historyStates/{version}")
    Observable<ContactMechStateDto> getHistoryState(@Path("contactMechId") String contactMechId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("TelecomNumbers/{contactMechId}")
    Observable<String> put(@Path("contactMechId") String contactMechId, @Body CreateOrMergePatchContactMechDto.CreateContactMechDto value);

    @Headers("Accept: application/json")
    @POST("TelecomNumbers")
    Observable<String> post(@Body CreateOrMergePatchContactMechDto.CreateContactMechDto value);

    @Headers("Accept: application/json")
    @PATCH("TelecomNumbers/{contactMechId}")
    Observable<String> patch(@Path("contactMechId") String contactMechId, @Body CreateOrMergePatchContactMechDto.MergePatchContactMechDto value);

    @Headers("Accept: application/json")
    @DELETE("TelecomNumbers/{contactMechId}")
    Observable<String> delete(@Path("contactMechId") String contactMechId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

