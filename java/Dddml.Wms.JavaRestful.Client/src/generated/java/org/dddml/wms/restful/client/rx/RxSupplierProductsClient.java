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
import org.dddml.wms.domain.supplierproduct.*;

public interface RxSupplierProductsClient {

    @Headers("Accept: application/json")
    @GET("SupplierProducts")
    Observable<List<SupplierProductStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("SupplierProducts/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("SupplierProducts/{supplierProductId}")
    Observable<SupplierProductStateDto> get(@Path("supplierProductId") String supplierProductId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("SupplierProducts/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("SupplierProducts/{supplierProductId}/_stateEvents/{version}")
    Observable<SupplierProductStateEventDto> getStateEvent(@Path("supplierProductId") String supplierProductId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("SupplierProducts/{supplierProductId}/_historyStates/{version}")
    Observable<SupplierProductStateDto> getHistoryState(@Path("supplierProductId") String supplierProductId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("SupplierProducts/{supplierProductId}")
    Observable<String> put(@Path("supplierProductId") String supplierProductId, @Body CreateOrMergePatchSupplierProductDto.CreateSupplierProductDto value);

    @Headers("Accept: application/json")
    @POST("SupplierProducts")
    Observable<SupplierProductId> post(@Body CreateOrMergePatchSupplierProductDto.CreateSupplierProductDto value);

    @Headers("Accept: application/json")
    @PATCH("SupplierProducts/{supplierProductId}")
    Observable<String> patch(@Path("supplierProductId") String supplierProductId, @Body CreateOrMergePatchSupplierProductDto.MergePatchSupplierProductDto value);

    @Headers("Accept: application/json")
    @DELETE("SupplierProducts/{supplierProductId}")
    Observable<String> delete(@Path("supplierProductId") String supplierProductId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

