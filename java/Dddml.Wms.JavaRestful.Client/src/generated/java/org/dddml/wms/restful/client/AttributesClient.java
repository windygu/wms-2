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
import org.dddml.wms.domain.attribute.*;

public interface AttributesClient {

    @Headers("Accept: application/json")
    @GET("Attributes/_nextId")
    Call<String> getNextId();

    @Headers("Accept: application/json")
    @GET("Attributes")
    Call<List<AttributeStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Attributes/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Attributes/{id}")
    Call<AttributeStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Attributes/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Attributes/{id}/_stateEvents/{version}")
    Call<AttributeStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Attributes/{id}/_historyStates/{version}")
    Call<AttributeStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Attributes/{attributeId}/AttributeValues/{value}")
    Call<AttributeValueStateDto> getAttributeValue(@Path("attributeId") String attributeId, @Path("value") String value);
 
    @Headers("Accept: application/json")
    @GET("Attributes/{attributeId}/AttributeAlias/{code}")
    Call<AttributeAliasStateDto> getAttributeAlias(@Path("attributeId") String attributeId, @Path("code") String code);
 
    @Headers("Accept: application/json")
    @PUT("Attributes/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchAttributeDto.CreateAttributeDto value);

    @Headers("Accept: application/json")
    @POST("Attributes")
    Call<String> post(@Body CreateOrMergePatchAttributeDto.CreateAttributeDto value);

    @Headers("Accept: application/json")
    @PATCH("Attributes/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchAttributeDto.MergePatchAttributeDto value);

    @Headers("Accept: application/json")
    @DELETE("Attributes/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

