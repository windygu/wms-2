package org.dddml.wms.domain.attributeset;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractAttributeSetCommandDto extends AbstractCommand
{
    /**
     * Attribute Set Id
     */
    private String attributeSetId;

    public String getAttributeSetId()
    {
        return this.attributeSetId;
    }

    public void setAttributeSetId(String attributeSetId)
    {
        this.attributeSetId = attributeSetId;
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
