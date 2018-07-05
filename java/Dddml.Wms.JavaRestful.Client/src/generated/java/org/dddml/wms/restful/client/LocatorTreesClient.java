package org.dddml.wms.restful.client;

import java.util.*;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.locator.*;


public interface LocatorTreesClient {

    @Headers("Accept: application/json")
    @GET("LocatorTrees")
    public Call<List<LocatorStateDto>> get(@Query("parentId") String parentId, @Query("sort")String sort, @Query("fields")String fields, @Query("firstResult")int firstResult, @Query("maxResults")int maxResults, @Query("filter")String filter);

    @Headers("Accept: application/json")
    @GET("LocatorTrees/_metadata/filteringFields")
    public Call<List<PropertyMetadataDto>> getMetadataFilteringFields();

}

