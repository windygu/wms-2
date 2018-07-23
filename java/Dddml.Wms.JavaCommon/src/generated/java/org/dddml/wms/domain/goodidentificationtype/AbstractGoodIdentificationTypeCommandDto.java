package org.dddml.wms.domain.goodidentificationtype;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractGoodIdentificationTypeCommandDto extends AbstractCommand
{
    /**
     * Good Identification Type Id
     */
    private String goodIdentificationTypeId;

    public String getGoodIdentificationTypeId()
    {
        return this.goodIdentificationTypeId;
    }

    public void setGoodIdentificationTypeId(String goodIdentificationTypeId)
    {
        this.goodIdentificationTypeId = goodIdentificationTypeId;
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


    public void copyTo(AbstractGoodIdentificationTypeCommand command)
    {
        command.setGoodIdentificationTypeId(this.getGoodIdentificationTypeId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
