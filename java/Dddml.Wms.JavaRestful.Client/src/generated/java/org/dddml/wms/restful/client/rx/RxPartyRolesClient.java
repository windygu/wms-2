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
import org.dddml.wms.domain.partyrole.*;

public interface RxPartyRolesClient {

    @Headers("Accept: application/json")
    @GET("PartyRoles")
    Observable<List<PartyRoleStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("PartyRoles/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("PartyRoles/{partyRoleId}")
    Observable<PartyRoleStateDto> get(@Path("partyRoleId") String partyRoleId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("PartyRoles/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("PartyRoles/{partyRoleId}/_stateEvents/{version}")
    Observable<PartyRoleStateEventDto> getStateEvent(@Path("partyRoleId") String partyRoleId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("PartyRoles/{partyRoleId}/_historyStates/{version}")
    Observable<PartyRoleStateDto> getHistoryState(@Path("partyRoleId") String partyRoleId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("PartyRoles/{partyRoleId}")
    Observable<String> put(@Path("partyRoleId") String partyRoleId, @Body CreateOrMergePatchPartyRoleDto.CreatePartyRoleDto value);

    @Headers("Accept: application/json")
    @POST("PartyRoles")
    Observable<PartyRoleId> post(@Body CreateOrMergePatchPartyRoleDto.CreatePartyRoleDto value);

    @Headers("Accept: application/json")
    @PATCH("PartyRoles/{partyRoleId}")
    Observable<String> patch(@Path("partyRoleId") String partyRoleId, @Body CreateOrMergePatchPartyRoleDto.MergePatchPartyRoleDto value);

    @Headers("Accept: application/json")
    @DELETE("PartyRoles/{partyRoleId}")
    Observable<String> delete(@Path("partyRoleId") String partyRoleId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

