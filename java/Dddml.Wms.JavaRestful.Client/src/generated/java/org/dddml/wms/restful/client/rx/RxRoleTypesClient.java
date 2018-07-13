package org.dddml.wms.restful.client.rx;

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
import rx.Observable;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.roletype.*;

public interface RxRoleTypesClient {

    @Headers("Accept: application/json")
    @GET("RoleTypes")
    Observable<List<RoleTypeStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("RoleTypes/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("RoleTypes/{id}")
    Observable<RoleTypeStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("RoleTypes/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("RoleTypes/{id}/_stateEvents/{version}")
    Observable<RoleTypeStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("RoleTypes/{id}/_historyStates/{version}")
    Observable<RoleTypeStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("RoleTypes/{id}")
    Observable<String> put(@Path("id") String id, @Body CreateOrMergePatchRoleTypeDto.CreateRoleTypeDto value);

    @Headers("Accept: application/json")
    @POST("RoleTypes")
    Observable<String> post(@Body CreateOrMergePatchRoleTypeDto.CreateRoleTypeDto value);

    @Headers("Accept: application/json")
    @PATCH("RoleTypes/{id}")
    Observable<String> patch(@Path("id") String id, @Body CreateOrMergePatchRoleTypeDto.MergePatchRoleTypeDto value);

    @Headers("Accept: application/json")
    @DELETE("RoleTypes/{id}")
    Observable<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

