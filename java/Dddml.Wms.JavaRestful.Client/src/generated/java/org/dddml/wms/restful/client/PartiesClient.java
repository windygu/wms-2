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

public interface PartiesClient {

    @Headers("Accept: application/json")
    @GET("Parties")
    Call<List<PartyStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Parties/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Parties/{partyId}")
    Call<PartyStateDto> get(@Path("partyId") String partyId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Parties/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Parties/{partyId}/_stateEvents/{version}")
    Call<PartyStateEventDto> getStateEvent(@Path("partyId") String partyId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Parties/{partyId}/_historyStates/{version}")
    Call<PartyStateDto> getHistoryState(@Path("partyId") String partyId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("Parties/{partyId}")
    Call<String> put(@Path("partyId") String partyId, @Body CreateOrMergePatchPartyDto.CreatePartyDto value);

    @Headers("Accept: application/json")
    @POST("Parties")
    Call<String> post(@Body CreateOrMergePatchPartyDto.CreatePartyDto value);

    @Headers("Accept: application/json")
    @PATCH("Parties/{partyId}")
    Call<String> patch(@Path("partyId") String partyId, @Body CreateOrMergePatchPartyDto.MergePatchPartyDto value);

    @Headers("Accept: application/json")
    @DELETE("Parties/{partyId}")
    Call<String> delete(@Path("partyId") String partyId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

