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
import org.dddml.wms.domain.attribute.*;

public interface RxAttributesClient {

    @Headers("Accept: application/json")
    @GET("Attributes/_nextId")
    Observable<String> getNextId();

    @Headers("Accept: application/json")
    @GET("Attributes")
    Observable<List<AttributeStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Attributes/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Attributes/{attributeId}")
    Observable<AttributeStateDto> get(@Path("attributeId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Attributes/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Attributes/{attributeId}/_stateEvents/{version}")
    Observable<AttributeStateEventDto> getStateEvent(@Path("attributeId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Attributes/{attributeId}/_historyStates/{version}")
    Observable<AttributeStateDto> getHistoryState(@Path("attributeId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Attributes/{attributeId}/AttributeValues/{value}")
    Observable<AttributeValueStateDto> getAttributeValue(@Path("attributeId") String attributeId, @Path("value") String value);
 
    @Headers("Accept: application/json")
    @GET("Attributes/{attributeId}/AttributeValues")
    Observable<List<AttributeValueStateDto>> getAttributeValues(@Path("attributeId") String attributeId);

    @Headers("Accept: application/json")
    @GET("Attributes/{attributeId}/AttributeAlias/{code}")
    Observable<AttributeAliasStateDto> getAttributeAlias(@Path("attributeId") String attributeId, @Path("code") String code);
 
    @Headers("Accept: application/json")
    @GET("Attributes/{attributeId}/AttributeAlias")
    Observable<List<AttributeAliasStateDto>> getAttributeAlias(@Path("attributeId") String attributeId);

    @Headers("Accept: application/json")
    @PUT("Attributes/{attributeId}")
    Observable<String> put(@Path("attributeId") String id, @Body CreateOrMergePatchAttributeDto.CreateAttributeDto value);

    @Headers("Accept: application/json")
    @POST("Attributes")
    Observable<String> post(@Body CreateOrMergePatchAttributeDto.CreateAttributeDto value);

    @Headers("Accept: application/json")
    @PATCH("Attributes/{attributeId}")
    Observable<String> patch(@Path("attributeId") String id, @Body CreateOrMergePatchAttributeDto.MergePatchAttributeDto value);

    @Headers("Accept: application/json")
    @DELETE("Attributes/{attributeId}")
    Observable<String> delete(@Path("attributeId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

