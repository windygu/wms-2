package org.dddml.wms.domain.lot;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchLotDto extends AbstractLotCommandDto
{
    /**
     * Quantity
     */
    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    /**
     * Expiration Date
     */
    private java.sql.Timestamp expirationDate;

    public java.sql.Timestamp getExpirationDate()
    {
        return this.expirationDate;
    }

    public void setExpirationDate(java.sql.Timestamp expirationDate)
    {
        this.expirationDate = expirationDate;
    }

    /**
     * Active
     */
    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved()
    {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed)
    {
        this.isPropertyQuantityRemoved = removed;
    }

    private Boolean isPropertyExpirationDateRemoved;

    public Boolean getIsPropertyExpirationDateRemoved()
    {
        return this.isPropertyExpirationDateRemoved;
    }

    public void setIsPropertyExpirationDateRemoved(Boolean removed)
    {
        this.isPropertyExpirationDateRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public static class CreateLotDto extends CreateOrMergePatchLotDto
    {
        public CreateLotDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchLotDto extends CreateOrMergePatchLotDto
    {
        public MergePatchLotDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

