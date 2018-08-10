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

import org.springframework.beans.factory.annotation.Autowired;

@RequestMapping(path = "IdService", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class IdServiceResource {

    @Autowired
    private IdApplicationService idApplicationService;

    @PostMapping("GetDocumentNumber")
    public String getDocumentNumber(@RequestBody IdServiceCommands.GetDocumentNumber requestContent)
    {
        return idApplicationService.when(requestContent);
    }

}

