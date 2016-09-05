package org.dddml.wms.restful.resource;

import org.dddml.wms.domain.*;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Li Yongchun on 2016/8/31.
 */
@Path("in_outs")
@Produces(MediaType.APPLICATION_JSON)
public class InOutResource {
    @Autowired
    private InOutApplicationService inOutApplicationService;


    /**
     * 创建出入库单
     *
     * @param inout
     */
    @POST
    public void createInOut(CreateOrMergePatchInOutDto.CreateInOutDto inout) {
        AbstractInOutCommand.AbstractCreateInOut command = new AbstractInOutCommand.SimpleCreateInOut();
        inout.copyTo(command);
        inOutApplicationService.when(command);
    }

    /**
     * 修改出入库单
     *
     * @param documentNumber 单据号码
     * @param inout
     */
    @PUT
    @Path("/{documentNumber}")
    public void UpdateInOut(@PathParam("documentNumber") String documentNumber, CreateOrMergePatchInOutDto.MergePatchInOutDto inout) {
        inout.setDocumentNumber(documentNumber);
        InOutCommand.MergePatchInOut command = new AbstractInOutCommand.SimpleMergePatchInOut();
        inOutApplicationService.when(command);
    }
}
