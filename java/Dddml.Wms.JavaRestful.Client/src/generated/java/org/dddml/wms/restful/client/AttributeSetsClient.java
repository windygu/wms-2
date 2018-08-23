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
import org.dddml.wms.domain.attributeset.*;

public interface AttributeSetsClient {

    @Headers("Accept: application/json")
    @GET("AttributeSets")
    Call<List<AttributeSetStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("AttributeSets/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("AttributeSets/{attributeSetId}")
    Call<AttributeSetStateDto> get(@Path("attributeSetId") String attributeSetId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("AttributeSets/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("AttributeSets/{attributeSetId}/_stateEvents/{version}")
    Call<AttributeSetStateEventDto> getStateEvent(@Path("attributeSetId") String attributeSetId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("AttributeSets/{attributeSetId}/_historyStates/{version}")
    Call<AttributeSetStateDto> getHistoryState(@Path("attributeSetId") String attributeSetId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("AttributeSets/{attributeSetId}/AttributeUses/{attributeId}")
    Call<AttributeUseStateDto> getAttributeUse(@Path("attributeSetId") String attributeSetId, @Path("attributeId") String attributeId);
 
    @Headers("Accept: application/json")
    @GET("AttributeSets/{attributeSetId}/AttributeUses")
    Call<List<AttributeUseStateDto>> getAttributeUses(@Path("attributeSetId") String attributeSetId);

    @Headers("Accept: application/json")
    @PUT("AttributeSets/{attributeSetId}")
    Call<String> put(@Path("attributeSetId") String attributeSetId, @Body CreateOrMergePatchAttributeSetDto.CreateAttributeSetDto value);

    @Headers("Accept: application/json")
    @POST("AttributeSets")
    Call<String> post(@Body CreateOrMergePatchAttributeSetDto.CreateAttributeSetDto value);

    @Headers("Accept: application/json")
    @PATCH("AttributeSets/{attributeSetId}")
    Call<String> patch(@Path("attributeSetId") String attributeSetId, @Body CreateOrMergePatchAttributeSetDto.MergePatchAttributeSetDto value);

    @Headers("Accept: application/json")
    @DELETE("AttributeSets/{attributeSetId}")
    Call<String> delete(@Path("attributeSetId") String attributeSetId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

