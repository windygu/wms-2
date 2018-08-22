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
import org.dddml.wms.domain.documenttype.*;

public interface RxDocumentTypesClient {

    @Headers("Accept: application/json")
    @GET("DocumentTypes")
    Observable<List<DocumentTypeStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("DocumentTypes/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("DocumentTypes/{documentTypeId}")
    Observable<DocumentTypeStateDto> get(@Path("documentTypeId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("DocumentTypes/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("DocumentTypes/{documentTypeId}/_historyStates/{version}")
    Observable<DocumentTypeStateDto> getHistoryState(@Path("documentTypeId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("DocumentTypes/{documentTypeId}")
    Observable<String> put(@Path("documentTypeId") String id, @Body CreateOrMergePatchDocumentTypeDto.CreateDocumentTypeDto value);

    @Headers("Accept: application/json")
    @POST("DocumentTypes")
    Observable<String> post(@Body CreateOrMergePatchDocumentTypeDto.CreateDocumentTypeDto value);

    @Headers("Accept: application/json")
    @PATCH("DocumentTypes/{documentTypeId}")
    Observable<String> patch(@Path("documentTypeId") String id, @Body CreateOrMergePatchDocumentTypeDto.MergePatchDocumentTypeDto value);

    @Headers("Accept: application/json")
    @DELETE("DocumentTypes/{documentTypeId}")
    Observable<String> delete(@Path("documentTypeId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

