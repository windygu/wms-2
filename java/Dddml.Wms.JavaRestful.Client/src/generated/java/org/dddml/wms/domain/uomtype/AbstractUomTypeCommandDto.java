package org.dddml.wms.domain.uomtype;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractUomTypeCommandDto extends AbstractCommand
{
    /**
     * Uom Type Id
     */
    private String uomTypeId;

    public String getUomTypeId()
    {
        return this.uomTypeId;
    }

    public void setUomTypeId(String uomTypeId)
    {
        this.uomTypeId = uomTypeId;
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
