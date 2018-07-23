package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractAttributeSetInstanceExtensionFieldCommandDto extends AbstractCommand
{
    /**
     * Name
     */
    private String name;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
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
