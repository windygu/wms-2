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
import org.dddml.wms.domain.attributeset.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.attributeusemvo.*;

public interface RxAttributeUseMvosClient {

    @Headers("Accept: application/json")
    @GET("AttributeUseMvos")
    Observable<List<AttributeUseMvoStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("AttributeUseMvos/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("AttributeUseMvos/{id}")
    Observable<AttributeUseMvoStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("AttributeUseMvos/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("AttributeUseMvos/{id}/_stateEvents/{version}")
    Observable<AttributeUseMvoStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("AttributeUseMvos/{id}/_historyStates/{version}")
    Observable<AttributeUseMvoStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("AttributeUseMvos/{id}")
    Observable<String> put(@Path("id") String id, @Body CreateOrMergePatchAttributeUseMvoDto.CreateAttributeUseMvoDto value);

    @Headers("Accept: application/json")
    @PATCH("AttributeUseMvos/{id}")
    Observable<String> patch(@Path("id") String id, @Body CreateOrMergePatchAttributeUseMvoDto.MergePatchAttributeUseMvoDto value);

    @Headers("Accept: application/json")
    @DELETE("AttributeUseMvos/{id}")
    Observable<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

