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
import org.dddml.wms.domain.picklistbin.*;

public interface RxPicklistBinsClient {

    @Headers("Accept: application/json")
    @GET("PicklistBins")
    Observable<List<PicklistBinStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("PicklistBins/_count")
    Observable<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("PicklistBins/{picklistBinId}")
    Observable<PicklistBinStateDto> get(@Path("picklistBinId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("PicklistBins/_metadata/filteringFields")
    Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("PicklistBins/{picklistBinId}/_stateEvents/{version}")
    Observable<PicklistBinStateEventDto> getStateEvent(@Path("picklistBinId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("PicklistBins/{picklistBinId}/_historyStates/{version}")
    Observable<PicklistBinStateDto> getHistoryState(@Path("picklistBinId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("PicklistBins/{picklistBinId}/PicklistItems/{picklistItemOrderShipGrpInvId}")
    Observable<PicklistItemStateDto> getPicklistItem(@Path("picklistBinId") String picklistBinId, @Path("picklistItemOrderShipGrpInvId") String picklistItemOrderShipGrpInvId);
 
    @Headers("Accept: application/json")
    @GET("PicklistBins/{picklistBinId}/PicklistItems")
    Observable<List<PicklistItemStateDto>> getPicklistItems(@Path("picklistBinId") String picklistBinId);

    @Headers("Accept: application/json")
    @PUT("PicklistBins/{picklistBinId}")
    Observable<String> put(@Path("picklistBinId") String id, @Body CreateOrMergePatchPicklistBinDto.CreatePicklistBinDto value);

    @Headers("Accept: application/json")
    @POST("PicklistBins")
    Observable<String> post(@Body CreateOrMergePatchPicklistBinDto.CreatePicklistBinDto value);

    @Headers("Accept: application/json")
    @PATCH("PicklistBins/{picklistBinId}")
    Observable<String> patch(@Path("picklistBinId") String id, @Body CreateOrMergePatchPicklistBinDto.MergePatchPicklistBinDto value);

    @Headers("Accept: application/json")
    @DELETE("PicklistBins/{picklistBinId}")
    Observable<String> delete(@Path("picklistBinId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

