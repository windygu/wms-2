package org.dddml.wms.restful.resource;

import org.dddml.wms.domain.AttributeSetApplicationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by Li Yongchun on 2016/8/31.
 */
@Path("attribute_sets")
public class AttributeSetResource {
    @Autowired
    private AttributeSetApplicationService attributeSetApplicationService;

    @GET
    @Path("/{attributeSetId}")
    public void index(@PathParam("attributeSetId") String attributeSetId) {
        attributeSetApplicationService.get(attributeSetId);
    }
}
