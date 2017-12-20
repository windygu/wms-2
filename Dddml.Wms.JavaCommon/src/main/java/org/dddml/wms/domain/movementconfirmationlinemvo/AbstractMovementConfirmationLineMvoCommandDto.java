package org.dddml.wms.domain.movementconfirmationlinemvo;

import org.dddml.wms.domain.movementconfirmation.*;
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

    private Long movementConfirmationVersion;

    public Long getMovementConfirmationVersion()
    {
        return this.movementConfirmationVersion;
    }

    public void setMovementConfirmationVersion(Long movementConfirmationVersion)
    {
        this.movementConfirmationVersion = movementConfirmationVersion;
    }


    public void copyTo(AbstractMovementConfirmationLineMvoCommand command)
    {
        command.setMovementConfirmationLineId((this.getMovementConfirmationLineId() == null) ? null : this.getMovementConfirmationLineId().toMovementConfirmationLineId());
        command.setMovementConfirmationVersion(this.getMovementConfirmationVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
