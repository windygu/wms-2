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
import org.dddml.wms.domain.warehouse.*;

public interface WarehousesClient {

    @Headers("Accept: application/json")
    @GET("Warehouses")
    Call<List<WarehouseStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Warehouses/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Warehouses/{warehouseId}")
    Call<WarehouseStateDto> get(@Path("warehouseId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Warehouses/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Warehouses/{warehouseId}/_stateEvents/{version}")
    Call<WarehouseStateEventDto> getStateEvent(@Path("warehouseId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Warehouses/{warehouseId}/_historyStates/{version}")
    Call<WarehouseStateDto> getHistoryState(@Path("warehouseId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("Warehouses/{warehouseId}")
    Call<String> put(@Path("warehouseId") String id, @Body CreateOrMergePatchWarehouseDto.CreateWarehouseDto value);

    @Headers("Accept: application/json")
    @POST("Warehouses")
    Call<String> post(@Body CreateOrMergePatchWarehouseDto.CreateWarehouseDto value);

    @Headers("Accept: application/json")
    @PATCH("Warehouses/{warehouseId}")
    Call<String> patch(@Path("warehouseId") String id, @Body CreateOrMergePatchWarehouseDto.MergePatchWarehouseDto value);

    @Headers("Accept: application/json")
    @DELETE("Warehouses/{warehouseId}")
    Call<String> delete(@Path("warehouseId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

