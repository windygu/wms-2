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
import retrofit2.http.Path;
import retrofit2.http.Query;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.*;

public interface AttributeSetInstanceExtensionFieldGroupsClient {

    @Headers("Accept: application/json")
    @GET("AttributeSetInstanceExtensionFieldGroups")
    Call<List<AttributeSetInstanceExtensionFieldGroupStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("AttributeSetInstanceExtensionFieldGroups/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("AttributeSetInstanceExtensionFieldGroups/{id}")
    Call<AttributeSetInstanceExtensionFieldGroupStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("AttributeSetInstanceExtensionFieldGroups/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("AttributeSetInstanceExtensionFieldGroups/{id}/_stateEvents/{version}")
    Call<AttributeSetInstanceExtensionFieldGroupStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("AttributeSetInstanceExtensionFieldGroups/{id}/_historyStates/{version}")
    Call<AttributeSetInstanceExtensionFieldGroupStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("AttributeSetInstanceExtensionFieldGroups/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchAttributeSetInstanceExtensionFieldGroupDto.CreateAttributeSetInstanceExtensionFieldGroupDto value);

    @Headers("Accept: application/json")
    @PATCH("AttributeSetInstanceExtensionFieldGroups/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchAttributeSetInstanceExtensionFieldGroupDto.MergePatchAttributeSetInstanceExtensionFieldGroupDto value);

    @Headers("Accept: application/json")
    @DELETE("AttributeSetInstanceExtensionFieldGroups/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

