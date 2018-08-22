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
import org.dddml.wms.domain.partyrole.*;

public interface PartyRolesClient {

    @Headers("Accept: application/json")
    @GET("PartyRoles")
    Call<List<PartyRoleStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("PartyRoles/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("PartyRoles/{partyRoleId}")
    Call<PartyRoleStateDto> get(@Path("partyRoleId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("PartyRoles/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("PartyRoles/{partyRoleId}/_stateEvents/{version}")
    Call<PartyRoleStateEventDto> getStateEvent(@Path("partyRoleId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("PartyRoles/{partyRoleId}/_historyStates/{version}")
    Call<PartyRoleStateDto> getHistoryState(@Path("partyRoleId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("PartyRoles/{partyRoleId}")
    Call<String> put(@Path("partyRoleId") String id, @Body CreateOrMergePatchPartyRoleDto.CreatePartyRoleDto value);

    @Headers("Accept: application/json")
    @POST("PartyRoles")
    Call<PartyRoleId> post(@Body CreateOrMergePatchPartyRoleDto.CreatePartyRoleDto value);

    @Headers("Accept: application/json")
    @PATCH("PartyRoles/{partyRoleId}")
    Call<String> patch(@Path("partyRoleId") String id, @Body CreateOrMergePatchPartyRoleDto.MergePatchPartyRoleDto value);

    @Headers("Accept: application/json")
    @DELETE("PartyRoles/{partyRoleId}")
    Call<String> delete(@Path("partyRoleId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

