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
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.documenttype.*;

public interface DocumentTypesClient {

    @Headers("Accept: application/json")
    @GET("DocumentTypes")
    Call<List<DocumentTypeStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("DocumentTypes/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("DocumentTypes/{id}")
    Call<DocumentTypeStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("DocumentTypes/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("DocumentTypes/{id}/_historyStates/{version}")
    Call<DocumentTypeStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("DocumentTypes/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchDocumentTypeDto.CreateDocumentTypeDto value);

    @Headers("Accept: application/json")
    @POST("DocumentTypes")
    Call<String> post(@Body CreateOrMergePatchDocumentTypeDto.CreateDocumentTypeDto value);

    @Headers("Accept: application/json")
    @PATCH("DocumentTypes/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchDocumentTypeDto.MergePatchDocumentTypeDto value);

    @Headers("Accept: application/json")
    @DELETE("DocumentTypes/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

