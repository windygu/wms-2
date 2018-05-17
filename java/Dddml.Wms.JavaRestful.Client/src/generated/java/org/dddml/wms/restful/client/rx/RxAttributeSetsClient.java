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
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.attributeset.*;

public interface RxAttributeSetsClient {

    @Headers("Accept: application/json")
    @GET("AttributeSets")
    Observable<List<AttributeSetStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("AttributeSets/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("AttributeSets/{id}")
    Observable<AttributeSetStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("AttributeSets/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("AttributeSets/{id}/_stateEvents/{version}")
    Observable<AttributeSetStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("AttributeSets/{id}/_historyStates/{version}")
    Observable<AttributeSetStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("AttributeSets/{attributeSetId}/AttributeUses/{attributeId}")
    Observable<AttributeUseStateDto> getAttributeUse(@Path("attributeSetId") String attributeSetId, @Path("attributeId") String attributeId);
 
    @Headers("Accept: application/json")
    @PUT("AttributeSets/{id}")
    Observable<String> put(@Path("id") String id, @Body CreateOrMergePatchAttributeSetDto.CreateAttributeSetDto value);

    @Headers("Accept: application/json")
    @PATCH("AttributeSets/{id}")
    Observable<String> patch(@Path("id") String id, @Body CreateOrMergePatchAttributeSetDto.MergePatchAttributeSetDto value);

    @Headers("Accept: application/json")
    @DELETE("AttributeSets/{id}")
    Observable<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

