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
    @POST("OrderShipGroupService/CreatePOShipGroups")
    Observable<String> createPOShipGroups(@Body OrderShipGroupServiceCommandDtos.CreatePOShipGroupsDto requestContent);

    @Headers("Accept: application/json")
    @POST("OrderShipGroupService/CreateSOShipGroups")
    Observable<String> createSOShipGroups(@Body OrderShipGroupServiceCommandDtos.CreateSOShipGroupsDto requestContent);

    @Headers("Accept: application/json")
    @POST("OrderShipGroupService/UpdateOrderItemShipGroupAssociation")
    Observable<String> updateOrderItemShipGroupAssociation(@Body OrderShipGroupServiceCommandDtos.UpdateOrderItemShipGroupAssociationDto requestContent);

    @Headers("Accept: application/json")
    @POST("OrderShipGroupService/CreatePOShipment")
    Observable<String> createPOShipment(@Body OrderShipGroupServiceCommandDtos.CreatePOShipmentDto requestContent);

    @Headers("Accept: application/json")
    @POST("OrderShipGroupService/CreateSOShipment")
    Observable<String> createSOShipment(@Body OrderShipGroupServiceCommandDtos.CreateSOShipmentDto requestContent);

    @Headers("Accept: application/json")
    @POST("OrderShipGroupService/ShipPOShipment")
    Observable<String> shipPOShipment(@Body OrderShipGroupServiceCommandDtos.ShipPOShipmentDto requestContent);

}

