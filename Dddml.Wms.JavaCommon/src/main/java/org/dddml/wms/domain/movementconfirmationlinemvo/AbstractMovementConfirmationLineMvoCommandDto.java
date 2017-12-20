package org.dddml.wms.domain.movementconfirmationlinemvo;

import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractMovementConfirmationLineMvoCommandDto extends AbstractCommand
{
    private MovementConfirmationLineIdDto movementConfirmationLineId;

    public MovementConfirmationLineIdDto getMovementConfirmationLineId()
    {
        return this.movementConfirmationLineId;
    }

    public void setMovementConfirmationLineId(MovementConfirmationLineIdDto movementConfirmationLineId)
    {
        this.movementConfirmationLineId = movementConfirmationLineId;
    }

    private Long movementVersion;

    public Long getMovementVersion()
    {
        return this.movementVersion;
    }

    public void setMovementVersion(Long movementVersion)
    {
        this.movementVersion = movementVersion;
    }


    public void copyTo(AbstractMovementConfirmationLineMvoCommand command)
    {
        command.setMovementConfirmationLineId((this.getMovementConfirmationLineId() == null) ? null : this.getMovementConfirmationLineId().toMovementConfirmationLineId());
        command.setMovementVersion(this.getMovementVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
