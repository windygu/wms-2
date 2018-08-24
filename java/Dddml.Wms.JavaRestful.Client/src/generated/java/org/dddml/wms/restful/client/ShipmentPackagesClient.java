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
import org.dddml.wms.domain.shipmentpackage.*;

public interface ShipmentPackagesClient {

    @Headers("Accept: application/json")
    @GET("ShipmentPackages")
    Call<List<ShipmentPackageStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("ShipmentPackages/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("ShipmentPackages/{shipmentPackageId}")
    Call<ShipmentPackageStateDto> get(@Path("shipmentPackageId") String shipmentPackageId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("ShipmentPackages/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("ShipmentPackages/{shipmentPackageId}/_stateEvents/{version}")
    Call<ShipmentPackageStateEventDto> getStateEvent(@Path("shipmentPackageId") String shipmentPackageId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("ShipmentPackages/{shipmentPackageId}/_historyStates/{version}")
    Call<ShipmentPackageStateDto> getHistoryState(@Path("shipmentPackageId") String shipmentPackageId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("ShipmentPackages/{shipmentPackageId}/ShipmentPackageContents/{shipmentItemSeqId}")
    Call<ShipmentPackageContentStateDto> getShipmentPackageContent(@Path("shipmentPackageId") String shipmentPackageId, @Path("shipmentItemSeqId") String shipmentItemSeqId);
 
    @Headers("Accept: application/json")
    @GET("ShipmentPackages/{shipmentPackageId}/ShipmentPackageContents")
    Call<List<ShipmentPackageContentStateDto>> getShipmentPackageContents(@Path("shipmentPackageId") String shipmentPackageId, @Query("sort") String sort, @Query("fields") String fields, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @PUT("ShipmentPackages/{shipmentPackageId}")
    Call<String> put(@Path("shipmentPackageId") String shipmentPackageId, @Body CreateOrMergePatchShipmentPackageDto.CreateShipmentPackageDto value);

    @Headers("Accept: application/json")
    @POST("ShipmentPackages")
    Call<ShipmentPackageId> post(@Body CreateOrMergePatchShipmentPackageDto.CreateShipmentPackageDto value);

    @Headers("Accept: application/json")
    @PATCH("ShipmentPackages/{shipmentPackageId}")
    Call<String> patch(@Path("shipmentPackageId") String shipmentPackageId, @Body CreateOrMergePatchShipmentPackageDto.MergePatchShipmentPackageDto value);

    @Headers("Accept: application/json")
    @DELETE("ShipmentPackages/{shipmentPackageId}")
    Call<String> delete(@Path("shipmentPackageId") String shipmentPackageId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

