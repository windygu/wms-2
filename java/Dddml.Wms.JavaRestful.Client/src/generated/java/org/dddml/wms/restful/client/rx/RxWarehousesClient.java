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
import org.dddml.wms.domain.warehouse.*;

public interface RxWarehousesClient {

    @Headers("Accept: application/json")
    @GET("Warehouses")
    Observable<List<WarehouseStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Warehouses/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Warehouses/{warehouseId}")
    Observable<WarehouseStateDto> get(@Path("warehouseId") String warehouseId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Warehouses/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Warehouses/{warehouseId}/_stateEvents/{version}")
    Observable<WarehouseStateEventDto> getStateEvent(@Path("warehouseId") String warehouseId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Warehouses/{warehouseId}/_historyStates/{version}")
    Observable<WarehouseStateDto> getHistoryState(@Path("warehouseId") String warehouseId, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("Warehouses/{warehouseId}")
    Observable<String> put(@Path("warehouseId") String warehouseId, @Body CreateOrMergePatchWarehouseDto.CreateWarehouseDto value);

    @Headers("Accept: application/json")
    @POST("Warehouses")
    Observable<String> post(@Body CreateOrMergePatchWarehouseDto.CreateWarehouseDto value);

    @Headers("Accept: application/json")
    @PATCH("Warehouses/{warehouseId}")
    Observable<String> patch(@Path("warehouseId") String warehouseId, @Body CreateOrMergePatchWarehouseDto.MergePatchWarehouseDto value);

    @Headers("Accept: application/json")
    @DELETE("Warehouses/{warehouseId}")
    Observable<String> delete(@Path("warehouseId") String warehouseId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

