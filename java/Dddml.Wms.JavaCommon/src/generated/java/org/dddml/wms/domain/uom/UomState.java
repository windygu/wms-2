package org.dddml.wms.domain.uom;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.uom.UomEvent.*;

public interface UomState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getUomId();

    void setUomId(String uomId);

    String getUomTypeId();

    void setUomTypeId(String uomTypeId);

    String getAbbreviation();

    void setAbbreviation(String abbreviation);

    String getDescription();

    void setDescription(String description);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(UomEvent.UomStateCreated e);

    void when(UomEvent.UomStateMergePatched e);

    void when(UomEvent.UomStateDeleted e);
    
}

