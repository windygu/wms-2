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
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.picklist.*;

public interface PicklistsClient {

    @Headers("Accept: application/json")
    @GET("Picklists")
    Call<List<PicklistStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Picklists/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Picklists/{picklistId}")
    Call<PicklistStateDto> get(@Path("picklistId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Picklists/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Picklists/{picklistId}/_stateEvents/{version}")
    Call<PicklistStateEventDto> getStateEvent(@Path("picklistId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Picklists/{picklistId}/_historyStates/{version}")
    Call<PicklistStateDto> getHistoryState(@Path("picklistId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Picklists/{picklistId}/PicklistRoles/{partyRoleId}")
    Call<PicklistRoleStateDto> getPicklistRole(@Path("picklistId") String picklistId, @Path("partyRoleId") String partyRoleId);
 
    @Headers("Accept: application/json")
    @GET("Picklists/{picklistId}/PicklistRoles")
    Call<List<PicklistRoleStateDto>> getPicklistRoles(@Path("picklistId") String picklistId);

    @Headers("Accept: application/json")
    @PUT("Picklists/{picklistId}")
    Call<String> put(@Path("picklistId") String id, @Body CreateOrMergePatchPicklistDto.CreatePicklistDto value);

    @Headers("Accept: application/json")
    @POST("Picklists")
    Call<String> post(@Body CreateOrMergePatchPicklistDto.CreatePicklistDto value);

    @Headers("Accept: application/json")
    @PATCH("Picklists/{picklistId}")
    Call<String> patch(@Path("picklistId") String id, @Body CreateOrMergePatchPicklistDto.MergePatchPicklistDto value);

    @Headers("Accept: application/json")
    @DELETE("Picklists/{picklistId}")
    Call<String> delete(@Path("picklistId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

