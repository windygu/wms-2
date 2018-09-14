package org.dddml.wms.restful.client;

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

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.service.*;

public interface OrderShipGroupServiceClient {

    @Headers("Accept: application/json")
    @POST("OrderShipGroupService/CreatePOShipGroup")
    Call<String> createPOShipGroup(@Body OrderShipGroupServiceCommandDtos.CreatePOShipGroupDto requestContent);

    @Headers("Accept: application/json")
    @POST("OrderShipGroupService/CreateSOShipGroup")
    Call<String> createSOShipGroup(@Body OrderShipGroupServiceCommandDtos.CreateSOShipGroupDto requestContent);

    @Headers("Accept: application/json")
    @POST("OrderShipGroupService/UpdateOrderItemShipGroupAssociation")
    Call<String> updateOrderItemShipGroupAssociation(@Body OrderShipGroupServiceCommandDtos.UpdateOrderItemShipGroupAssociationDto requestContent);

    @Headers("Accept: application/json")
    @POST("OrderShipGroupService/CreatePOShipment")
    Call<String> createPOShipment(@Body OrderShipGroupServiceCommandDtos.CreatePOShipmentDto requestContent);

    @Headers("Accept: application/json")
    @POST("OrderShipGroupService/CreateSOShipment")
    Call<String> createSOShipment(@Body OrderShipGroupServiceCommandDtos.CreateSOShipmentDto requestContent);

    @Headers("Accept: application/json")
    @POST("OrderShipGroupService/Ship")
    Call<String> ship(@Body OrderShipGroupServiceCommandDtos.ShipDto requestContent);

}

