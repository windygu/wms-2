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
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.attributesetinstance.*;

public interface AttributeSetInstancesClient {

    @Headers("Accept: application/json")
    @GET("AttributeSetInstances")
    Call<List<Map<String, Object>>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("AttributeSetInstances/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("AttributeSetInstances/{attributeSetInstanceId}")
    Call<Map<String, Object>> get(@Path("attributeSetInstanceId") String attributeSetInstanceId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("AttributeSetInstances/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("AttributeSetInstances/{attributeSetInstanceId}/_stateEvents/{version}")
    Call<AttributeSetInstanceStateEventDto> getStateEvent(@Path("attributeSetInstanceId") String attributeSetInstanceId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("AttributeSetInstances/{attributeSetInstanceId}/_historyStates/{version}")
    Call<AttributeSetInstanceStateDto> getHistoryState(@Path("attributeSetInstanceId") String attributeSetInstanceId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("AttributeSetInstances/{attributeSetInstanceId}")
    Call<String> put(@Path("attributeSetInstanceId") String attributeSetInstanceId, @Body Map<String, Object> value);

    @Headers("Accept: application/json")
    @POST("AttributeSetInstances")
    Call<String> post(@Body Map<String, Object> value);

}

