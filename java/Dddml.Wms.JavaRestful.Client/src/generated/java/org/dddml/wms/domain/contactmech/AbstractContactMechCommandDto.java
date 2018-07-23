package org.dddml.wms.domain.contactmech;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractContactMechCommandDto extends AbstractCommand
{
    /**
     * Contact Mech Id
     */
    private String contactMechId;

    public String getContactMechId()
    {
        return this.contactMechId;
    }

    public void setContactMechId(String contactMechId)
    {
        this.contactMechId = contactMechId;
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
