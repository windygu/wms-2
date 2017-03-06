package org.dddml.wms.domain.inoutlinemvo;

import org.dddml.wms.domain.inout.*;
import java.math.BigDecimal;
import java.util.Date;
import org.joda.money.Money;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractInOutLineMvoCommandDto extends AbstractCommand
{
    private InOutLineIdDto inOutLineId;

    public InOutLineIdDto getInOutLineId()
    {
        return this.inOutLineId;
    }

    public void setInOutLineId(InOutLineIdDto inOutLineId)
    {
        this.inOutLineId = inOutLineId;
    }

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
        command.setInOutLineId((this.getInOutLineId() == null) ? null : this.getInOutLineId().toInOutLineId());
        command.setInOutVersion(this.getInOutVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
