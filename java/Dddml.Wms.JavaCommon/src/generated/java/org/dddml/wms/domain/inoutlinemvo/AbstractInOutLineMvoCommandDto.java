package org.dddml.wms.domain.inoutlinemvo;

import org.dddml.wms.domain.inout.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractInOutLineMvoCommandDto extends AbstractCommand
{
    /**
     * In Out Line Id
     */
    private InOutLineId inOutLineId;

    public InOutLineId getInOutLineId()
    {
        return this.inOutLineId;
    }

    public void setInOutLineId(InOutLineId inOutLineId)
    {
        this.inOutLineId = inOutLineId;
    }

    /**
     * In Out Version
     */
    private Long inOutVersion;

    public Long getInOutVersion()
    {
        return this.inOutVersion;
    }

    public void setInOutVersion(Long inOutVersion)
    {
        this.inOutVersion = inOutVersion;
    }


    public void copyTo(AbstractInOutLineMvoCommand command)
    {
        command.setInOutLineId(this.getInOutLineId());
        command.setInOutVersion(this.getInOutVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
