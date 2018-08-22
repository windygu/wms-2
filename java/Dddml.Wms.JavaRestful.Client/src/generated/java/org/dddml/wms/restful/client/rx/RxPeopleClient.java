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
import org.dddml.wms.domain.party.*;

public interface RxPeopleClient {

    @Headers("Accept: application/json")
    @GET("People")
    Observable<List<PartyStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("People/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("People/{partyId}")
    Observable<PartyStateDto> get(@Path("partyId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("People/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("People/{partyId}/_stateEvents/{version}")
    Observable<PartyStateEventDto> getStateEvent(@Path("partyId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("People/{partyId}/_historyStates/{version}")
    Observable<PartyStateDto> getHistoryState(@Path("partyId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("People/{partyId}")
    Observable<String> put(@Path("partyId") String id, @Body CreateOrMergePatchPartyDto.CreatePartyDto value);

    @Headers("Accept: application/json")
    @POST("People")
    Observable<String> post(@Body CreateOrMergePatchPartyDto.CreatePartyDto value);

    @Headers("Accept: application/json")
    @PATCH("People/{partyId}")
    Observable<String> patch(@Path("partyId") String id, @Body CreateOrMergePatchPartyDto.MergePatchPartyDto value);

    @Headers("Accept: application/json")
    @DELETE("People/{partyId}")
    Observable<String> delete(@Path("partyId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

