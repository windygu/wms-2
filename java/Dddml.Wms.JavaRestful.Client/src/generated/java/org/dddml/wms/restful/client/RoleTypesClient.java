package org.dddml.wms.restful.client;

import java.util.List;

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
import org.dddml.wms.domain.roletype.*;

public interface RoleTypesClient {

    @Headers("Accept: application/json")
    @GET("RoleTypes")
    Call<List<RoleTypeStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("RoleTypes/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("RoleTypes/{id}")
    Call<RoleTypeStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("RoleTypes/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("RoleTypes/{id}/_stateEvents/{version}")
    Call<RoleTypeStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("RoleTypes/{id}/_historyStates/{version}")
    Call<RoleTypeStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("RoleTypes/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchRoleTypeDto.CreateRoleTypeDto value);

    @Headers("Accept: application/json")
    @POST("RoleTypes")
    Call<String> post(@Body CreateOrMergePatchRoleTypeDto.CreateRoleTypeDto value);

    @Headers("Accept: application/json")
    @PATCH("RoleTypes/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchRoleTypeDto.MergePatchRoleTypeDto value);

    @Headers("Accept: application/json")
    @DELETE("RoleTypes/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

