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
import org.dddml.wms.domain.documenttype.*;

public interface DocumentTypesClient {

    @Headers("Accept: application/json")
    @GET("DocumentTypes")
    Call<List<DocumentTypeStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("DocumentTypes/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("DocumentTypes/{documentTypeId}")
    Call<DocumentTypeStateDto> get(@Path("documentTypeId") String documentTypeId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("DocumentTypes/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("DocumentTypes/{documentTypeId}/_historyStates/{version}")
    Call<DocumentTypeStateDto> getHistoryState(@Path("documentTypeId") String documentTypeId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("DocumentTypes/{documentTypeId}")
    Call<String> put(@Path("documentTypeId") String documentTypeId, @Body CreateOrMergePatchDocumentTypeDto.CreateDocumentTypeDto value);

    @Headers("Accept: application/json")
    @POST("DocumentTypes")
    Call<String> post(@Body CreateOrMergePatchDocumentTypeDto.CreateDocumentTypeDto value);

    @Headers("Accept: application/json")
    @PATCH("DocumentTypes/{documentTypeId}")
    Call<String> patch(@Path("documentTypeId") String documentTypeId, @Body CreateOrMergePatchDocumentTypeDto.MergePatchDocumentTypeDto value);

    @Headers("Accept: application/json")
    @DELETE("DocumentTypes/{documentTypeId}")
    Call<String> delete(@Path("documentTypeId") String documentTypeId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

