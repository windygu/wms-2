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
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.attributesetinstance.*;

public interface AttributeSetInstancesClient {

    @Headers("Accept: application/json")
    @GET("AttributeSetInstances")
    Call<List<AttributeSetInstanceStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("AttributeSetInstances/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("AttributeSetInstances/{id}")
    Call<AttributeSetInstanceStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("AttributeSetInstances/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("AttributeSetInstances/{id}/_stateEvents/{version}")
    Call<AttributeSetInstanceStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("AttributeSetInstances/{id}/_historyStates/{version}")
    Call<AttributeSetInstanceStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("AttributeSetInstances/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchAttributeSetInstanceDto.CreateAttributeSetInstanceDto value);

}

