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

@RequestMapping(path = "IdService", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class IdServiceResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IdApplicationService idApplicationService;

    @PostMapping("GetDocumentNumber")
    public String getDocumentNumber(@RequestBody IdServiceCommands.GetDocumentNumber requestContent)
    {
        try {
        return idApplicationService.when(requestContent);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

}

