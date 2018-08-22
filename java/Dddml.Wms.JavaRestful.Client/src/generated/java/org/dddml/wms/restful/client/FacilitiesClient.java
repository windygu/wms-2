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
import org.dddml.wms.domain.facility.*;

public interface FacilitiesClient {

    @Headers("Accept: application/json")
    @GET("Facilities")
    Call<List<FacilityStateDto>> getAll(@Query("sort") String sort, @Query("fields") String fields, @Query("firstResult") int firstResult, @Query("maxResults") int maxResults, @Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Facilities/_count")
    Call<Long> getCount(@Query("filter") String filter);

    @Headers("Accept: application/json")
    @GET("Facilities/{facilityId}")
    Call<FacilityStateDto> get(@Path("facilityId") String id, @Query("fields") String fields);

    @Headers("Accept: application/json")
    @GET("Facilities/_metadata/filteringFields")
    Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

    @Headers("Accept: application/json")
    @GET("Facilities/{facilityId}/_stateEvents/{version}")
    Call<FacilityStateEventDto> getStateEvent(@Path("facilityId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @GET("Facilities/{facilityId}/_historyStates/{version}")
    Call<FacilityStateDto> getHistoryState(@Path("facilityId") String id, @Path("version") long version);

    @Headers("Accept: application/json")
    @PUT("Facilities/{facilityId}")
    Call<String> put(@Path("facilityId") String id, @Body CreateOrMergePatchFacilityDto.CreateFacilityDto value);

    @Headers("Accept: application/json")
    @POST("Facilities")
    Call<String> post(@Body CreateOrMergePatchFacilityDto.CreateFacilityDto value);

    @Headers("Accept: application/json")
    @PATCH("Facilities/{facilityId}")
    Call<String> patch(@Path("facilityId") String id, @Body CreateOrMergePatchFacilityDto.MergePatchFacilityDto value);

    @Headers("Accept: application/json")
    @DELETE("Facilities/{facilityId}")
    Call<String> delete(@Path("facilityId") String id, @Query("commandId") String commandId, @Query("version") String version, @Query("requesterId") String requesterId);

}

