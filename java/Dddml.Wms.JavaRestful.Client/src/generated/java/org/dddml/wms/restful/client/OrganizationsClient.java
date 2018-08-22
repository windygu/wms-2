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
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.party.*;

public interface OrganizationsClient {

    @Headers("Accept: application/json")
    @GET("Organizations")
    Call<List<PartyStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Organizations/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Organizations/{partyId}")
    Call<PartyStateDto> get(@Path("partyId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Organizations/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Organizations/{partyId}/_stateEvents/{version}")
    Call<PartyStateEventDto> getStateEvent(@Path("partyId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Organizations/{partyId}/_historyStates/{version}")
    Call<PartyStateDto> getHistoryState(@Path("partyId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("Organizations/{partyId}")
    Call<String> put(@Path("partyId") String id, @Body CreateOrMergePatchPartyDto.CreatePartyDto value);

    @Headers("Accept: application/json")
    @POST("Organizations")
    Call<String> post(@Body CreateOrMergePatchPartyDto.CreatePartyDto value);

    @Headers("Accept: application/json")
    @PATCH("Organizations/{partyId}")
    Call<String> patch(@Path("partyId") String id, @Body CreateOrMergePatchPartyDto.MergePatchPartyDto value);

    @Headers("Accept: application/json")
    @DELETE("Organizations/{partyId}")
    Call<String> delete(@Path("partyId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

