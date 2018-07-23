package org.dddml.wms.domain.attribute;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractAttributeCommandDto extends AbstractCommand
{
    /**
     * Attribute Id
     */
    private String attributeId;

    public String getAttributeId()
    {
        return this.attributeId;
    }

    public void setAttributeId(String attributeId)
    {
        this.attributeId = attributeId;
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
