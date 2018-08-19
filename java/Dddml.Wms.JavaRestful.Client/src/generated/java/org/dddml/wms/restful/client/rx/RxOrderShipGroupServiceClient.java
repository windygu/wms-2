package org.dddml.wms.restful.client.rx;

import java.util.*;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.service.*;

public interface RxOrderShipGroupServiceClient {

    @Headers("Accept: application/json")
    @POST("OrderShipGroupService/CreatePOShipGroup")
    Observable<String> createPOShipGroup(@Body OrderShipGroupServiceCommandDtos.CreatePOShipGroupDto requestContent);

    @Headers("Accept: application/json")
    @POST("OrderShipGroupService/CreateSOShipGroup")
    Observable<String> createSOShipGroup(@Body OrderShipGroupServiceCommandDtos.CreateSOShipGroupDto requestContent);

    @Headers("Accept: application/json")
    @POST("OrderShipGroupService/CreatePOShipment")
    Observable<String> createPOShipment(@Body OrderShipGroupServiceCommandDtos.CreatePOShipmentDto requestContent);

    @Headers("Accept: application/json")
    @POST("OrderShipGroupService/CreateSOShipment")
    Observable<String> createSOShipment(@Body OrderShipGroupServiceCommandDtos.CreateSOShipmentDto requestContent);

}

