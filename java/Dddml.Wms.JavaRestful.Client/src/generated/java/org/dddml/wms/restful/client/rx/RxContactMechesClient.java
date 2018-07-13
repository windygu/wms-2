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

public interface RxContactMechesClient {

    @Headers("Accept: application/json")
    @GET("ContactMeches")
    Observable<List<ContactMechStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("ContactMeches/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("ContactMeches/{id}")
    Observable<ContactMechStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("ContactMeches/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("ContactMeches/{id}/_stateEvents/{version}")
    Observable<ContactMechStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("ContactMeches/{id}/_historyStates/{version}")
    Observable<ContactMechStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("ContactMeches/{id}")
    Observable<String> put(@Path("id") String id, @Body CreateOrMergePatchContactMechDto.CreateContactMechDto value);

    @Headers("Accept: application/json")
    @POST("ContactMeches")
    Observable<String> post(@Body CreateOrMergePatchContactMechDto.CreateContactMechDto value);

    @Headers("Accept: application/json")
    @PATCH("ContactMeches/{id}")
    Observable<String> patch(@Path("id") String id, @Body CreateOrMergePatchContactMechDto.MergePatchContactMechDto value);

    @Headers("Accept: application/json")
    @DELETE("ContactMeches/{id}")
    Observable<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

