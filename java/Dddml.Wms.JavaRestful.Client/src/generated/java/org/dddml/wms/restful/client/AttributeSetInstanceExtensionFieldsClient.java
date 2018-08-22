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
import org.dddml.wms.domain.attributesetinstanceextensionfield.*;

public interface AttributeSetInstanceExtensionFieldsClient {

    @Headers("Accept: application/json")
    @GET("AttributeSetInstanceExtensionFields")
    Call<List<AttributeSetInstanceExtensionFieldStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("AttributeSetInstanceExtensionFields/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("AttributeSetInstanceExtensionFields/{name}")
    Call<AttributeSetInstanceExtensionFieldStateDto> get(@Path("name") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("AttributeSetInstanceExtensionFields/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("AttributeSetInstanceExtensionFields/{name}/_stateEvents/{version}")
    Call<AttributeSetInstanceExtensionFieldStateEventDto> getStateEvent(@Path("name") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("AttributeSetInstanceExtensionFields/{name}/_historyStates/{version}")
    Call<AttributeSetInstanceExtensionFieldStateDto> getHistoryState(@Path("name") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("AttributeSetInstanceExtensionFields/{name}")
    Call<String> put(@Path("name") String id, @Body CreateOrMergePatchAttributeSetInstanceExtensionFieldDto.CreateAttributeSetInstanceExtensionFieldDto value);

    @Headers("Accept: application/json")
    @POST("AttributeSetInstanceExtensionFields")
    Call<String> post(@Body CreateOrMergePatchAttributeSetInstanceExtensionFieldDto.CreateAttributeSetInstanceExtensionFieldDto value);

    @Headers("Accept: application/json")
    @PATCH("AttributeSetInstanceExtensionFields/{name}")
    Call<String> patch(@Path("name") String id, @Body CreateOrMergePatchAttributeSetInstanceExtensionFieldDto.MergePatchAttributeSetInstanceExtensionFieldDto value);

    @Headers("Accept: application/json")
    @DELETE("AttributeSetInstanceExtensionFields/{name}")
    Call<String> delete(@Path("name") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

