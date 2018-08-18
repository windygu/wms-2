package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.meta.*;
import org.dddml.wms.domain.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

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
         orderShipGroupApplicationService.when(requestContent);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @PostMapping("CreateSOShipGroup")
    public void createSOShipGroup(@RequestBody OrderShipGroupServiceCommands.CreateSOShipGroup requestContent)
    {
        try {
         orderShipGroupApplicationService.when(requestContent);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @PostMapping("CreatePOShipment")
    public String createPOShipment(@RequestBody OrderShipGroupServiceCommands.CreatePOShipment requestContent)
    {
        try {
        return orderShipGroupApplicationService.when(requestContent);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

}

