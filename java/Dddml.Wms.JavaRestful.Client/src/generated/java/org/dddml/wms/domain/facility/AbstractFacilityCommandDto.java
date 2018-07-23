package org.dddml.wms.domain.facility;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractFacilityCommandDto extends AbstractCommand
{
    /**
     * Facility Id
     */
    private String facilityId;

    public String getFacilityId()
    {
        return this.facilityId;
    }

    public void setFacilityId(String facilityId)
    {
        this.facilityId = facilityId;
    }

    /**
     * Version
     */
    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


}
