package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.annotation.*;
import org.dddml.wms.domain.meta.*;
import org.dddml.wms.domain.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

@RequestMapping(path = "OrderShipGroupService", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class OrderShipGroupServiceResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderShipGroupApplicationService orderShipGroupApplicationService;

    @PostMapping("CreatePOShipGroup")
    public void createPOShipGroup(@RequestBody OrderShipGroupServiceCommands.CreatePOShipGroup requestContent)
    {
        try {
        requestContent.setRequesterId(SecurityContextUtil.getRequesterId());
         orderShipGroupApplicationService.when(requestContent);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @PostMapping("CreateSOShipGroup")
    public void createSOShipGroup(@RequestBody OrderShipGroupServiceCommands.CreateSOShipGroup requestContent)
    {
        try {
        requestContent.setRequesterId(SecurityContextUtil.getRequesterId());
         orderShipGroupApplicationService.when(requestContent);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @PostMapping("UpdateOrderItemShipGroupAssociation")
    public void updateOrderItemShipGroupAssociation(@RequestBody OrderShipGroupServiceCommands.UpdateOrderItemShipGroupAssociation requestContent)
    {
        try {
        requestContent.setRequesterId(SecurityContextUtil.getRequesterId());
         orderShipGroupApplicationService.when(requestContent);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @PostMapping("CreatePOShipment")
    public String createPOShipment(@RequestBody OrderShipGroupServiceCommands.CreatePOShipment requestContent)
    {
        try {
        requestContent.setRequesterId(SecurityContextUtil.getRequesterId());
        return orderShipGroupApplicationService.when(requestContent);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @PostMapping("CreateSOShipment")
    public String createSOShipment(@RequestBody OrderShipGroupServiceCommands.CreateSOShipment requestContent)
    {
        try {
        requestContent.setRequesterId(SecurityContextUtil.getRequesterId());
        return orderShipGroupApplicationService.when(requestContent);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @PostMapping("Ship")
    public void ship(@RequestBody OrderShipGroupServiceCommands.Ship requestContent)
    {
        try {
        requestContent.setRequesterId(SecurityContextUtil.getRequesterId());
         orderShipGroupApplicationService.when(requestContent);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

}

