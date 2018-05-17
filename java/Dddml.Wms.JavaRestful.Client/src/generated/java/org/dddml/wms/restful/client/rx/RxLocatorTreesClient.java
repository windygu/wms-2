package org.dddml.wms.restful.client.rx;

import java.util.*;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.locator.*;


public interface RxLocatorTreesClient {

    @Headers("Accept: application/json")
    @GET("LocatorTrees")
    public Observable<List<LocatorStateDto>> get(@Query("parentId") String parentId, @Query("sort")String sort, @Query("fields")String fields, @Query("firstResult")int firstResult, @Query("maxResults")int maxResults, @Query("filter")String filter);

    @Headers("Accept: application/json")
    @GET("LocatorTrees/_metadata/filteringFields")
    public Observable<List<PropertyMetadataDto>> getMetadataFilteringFields();

}

