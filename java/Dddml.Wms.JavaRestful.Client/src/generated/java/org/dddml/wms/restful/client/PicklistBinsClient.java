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
import org.dddml.wms.domain.picklistbin.*;

public interface PicklistBinsClient {

    @Headers("Accept: application/json")
    @GET("PicklistBins")
    Call<List<PicklistBinStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("PicklistBins/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("PicklistBins/{picklistBinId}")
    Call<PicklistBinStateDto> get(@Path("picklistBinId") String picklistBinId, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("PicklistBins/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("PicklistBins/{picklistBinId}/_stateEvents/{version}")
    Call<PicklistBinStateEventDto> getStateEvent(@Path("picklistBinId") String picklistBinId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("PicklistBins/{picklistBinId}/_historyStates/{version}")
    Call<PicklistBinStateDto> getHistoryState(@Path("picklistBinId") String picklistBinId, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("PicklistBins/{picklistBinId}/PicklistItems/{picklistItemOrderShipGrpInvId}")
    Call<PicklistItemStateDto> getPicklistItem(@Path("picklistBinId") String picklistBinId, @Path("picklistItemOrderShipGrpInvId") String picklistItemOrderShipGrpInvId);
 
    @Headers("Accept: application/json")
    @GET("PicklistBins/{picklistBinId}/PicklistItems")
    Call<List<PicklistItemStateDto>> getPicklistItems(@Path("picklistBinId") String picklistBinId);

    @Headers("Accept: application/json")
    @PUT("PicklistBins/{picklistBinId}")
    Call<String> put(@Path("picklistBinId") String picklistBinId, @Body CreateOrMergePatchPicklistBinDto.CreatePicklistBinDto value);

    @Headers("Accept: application/json")
    @POST("PicklistBins")
    Call<String> post(@Body CreateOrMergePatchPicklistBinDto.CreatePicklistBinDto value);

    @Headers("Accept: application/json")
    @PATCH("PicklistBins/{picklistBinId}")
    Call<String> patch(@Path("picklistBinId") String picklistBinId, @Body CreateOrMergePatchPicklistBinDto.MergePatchPicklistBinDto value);

    @Headers("Accept: application/json")
    @DELETE("PicklistBins/{picklistBinId}")
    Call<String> delete(@Path("picklistBinId") String picklistBinId, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

