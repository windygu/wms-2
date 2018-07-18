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

public interface IdServiceClient {

    @Headers("Accept: application/json")
    @POST("IdService/GetDocumentNumber")
    Call<String> getDocumentNumber(@Body IdServiceCommandDtos.GetDocumentNumberDto requestContent);

}

