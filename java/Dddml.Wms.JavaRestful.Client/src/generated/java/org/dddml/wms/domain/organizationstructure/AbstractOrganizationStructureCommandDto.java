package org.dddml.wms.domain.organizationstructure;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractOrganizationStructureCommandDto extends AbstractCommand
{
    /**
     * Id
     */
    private OrganizationStructureId id;

    public OrganizationStructureId getId()
    {
        return this.id;
    }

    public void setId(OrganizationStructureId id)
    {
        this.id = id;
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
