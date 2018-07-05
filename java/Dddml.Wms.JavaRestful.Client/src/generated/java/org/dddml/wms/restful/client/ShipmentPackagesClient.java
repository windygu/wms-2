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
    @GET("ShipmentPackages/{id}")
    Call<ShipmentPackageStateDto> get(@Path("id") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("ShipmentPackages/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("ShipmentPackages/{id}/_stateEvents/{version}")
    Call<ShipmentPackageStateEventDto> getStateEvent(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("ShipmentPackages/{id}/_historyStates/{version}")
    Call<ShipmentPackageStateDto> getHistoryState(@Path("id") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("ShipmentPackages/{shipmentPackageId}/ShipmentPackageContents/{shipmentItemSeqId}")
    Call<ShipmentPackageContentStateDto> getShipmentPackageContent(@Path("shipmentPackageId") String shipmentPackageId, @Path("shipmentItemSeqId") String shipmentItemSeqId);
 
    @Headers("Accept: application/json")
    @PUT("ShipmentPackages/{id}")
    Call<String> put(@Path("id") String id, @Body CreateOrMergePatchShipmentPackageDto.CreateShipmentPackageDto value);

    @Headers("Accept: application/json")
    @PATCH("ShipmentPackages/{id}")
    Call<String> patch(@Path("id") String id, @Body CreateOrMergePatchShipmentPackageDto.MergePatchShipmentPackageDto value);

    @Headers("Accept: application/json")
    @DELETE("ShipmentPackages/{id}")
    Call<String> delete(@Path("id") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

