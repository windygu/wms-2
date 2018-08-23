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
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.physicalinventory.*;

public interface RxPhysicalInventoriesClient {

    @Headers("Accept: application/json")
    @GET("PhysicalInventories")
    Observable<List<PhysicalInventoryStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("PhysicalInventories/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("PhysicalInventories/{documentNumber}")
    Observable<PhysicalInventoryStateDto> get(@Path("documentNumber") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("PhysicalInventories/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("PhysicalInventories/{documentNumber}/_stateEvents/{version}")
    Observable<PhysicalInventoryStateEventDto> getStateEvent(@Path("documentNumber") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("PhysicalInventories/{documentNumber}/_historyStates/{version}")
    Observable<PhysicalInventoryStateDto> getHistoryState(@Path("documentNumber") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("PhysicalInventories/{physicalInventoryDocumentNumber}/PhysicalInventoryLines/{inventoryItemId}")
    Observable<PhysicalInventoryLineStateDto> getPhysicalInventoryLine(@Path("physicalInventoryDocumentNumber") String physicalInventoryDocumentNumber, @Path("inventoryItemId") String inventoryItemId);
 
    @Headers("Accept: application/json")
    @GET("PhysicalInventories/{documentNumber}/PhysicalInventoryLines")
    Observable<List<PhysicalInventoryLineStateDto>> getPhysicalInventoryLines(@Path("documentNumber") String documentNumber);

    @Headers("Accept: application/json")
    @PUT("PhysicalInventories/{documentNumber}")
    Observable<String> put(@Path("documentNumber") String id, @Body CreateOrMergePatchPhysicalInventoryDto.CreatePhysicalInventoryDto value);

    @Headers("Accept: application/json")
    @POST("PhysicalInventories")
    Observable<String> post(@Body CreateOrMergePatchPhysicalInventoryDto.CreatePhysicalInventoryDto value);

    @Headers("Accept: application/json")
    @PATCH("PhysicalInventories/{documentNumber}")
    Observable<String> patch(@Path("documentNumber") String id, @Body CreateOrMergePatchPhysicalInventoryDto.MergePatchPhysicalInventoryDto value);

    @Headers("Accept: application/json")
    @DELETE("PhysicalInventories/{documentNumber}")
    Observable<String> delete(@Path("documentNumber") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

    @Headers("Accept: application/json")
    @PUT("PhysicalInventories/{documentNumber}/_commands/CountItem")
    Observable<String> countItem(@Path("documentNumber") String documentNumber, @Body PhysicalInventoryCommandDtos.CountItemRequestContent content);

    @Headers("Accept: application/json")
    @PUT("PhysicalInventories/{documentNumber}/_commands/DocumentAction")
    Observable<String> documentAction(@Path("documentNumber") String documentNumber, @Body PhysicalInventoryCommandDtos.DocumentActionRequestContent content);

}

