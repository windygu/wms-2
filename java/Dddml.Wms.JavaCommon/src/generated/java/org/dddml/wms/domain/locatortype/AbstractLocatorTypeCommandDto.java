package org.dddml.wms.domain.locatortype;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractLocatorTypeCommandDto extends AbstractCommand
{
    /**
     * Locator Type Id
     */
    private String locatorTypeId;

    public String getLocatorTypeId()
    {
        return this.locatorTypeId;
    }

    public void setLocatorTypeId(String locatorTypeId)
    {
        this.locatorTypeId = locatorTypeId;
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


    public void copyTo(AbstractLocatorTypeCommand command)
    {
        command.setLocatorTypeId(this.getLocatorTypeId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
