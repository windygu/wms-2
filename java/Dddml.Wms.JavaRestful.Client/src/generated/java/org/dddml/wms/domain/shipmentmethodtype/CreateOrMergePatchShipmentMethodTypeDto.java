package org.dddml.wms.domain.shipmentmethodtype;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchShipmentMethodTypeDto extends AbstractShipmentMethodTypeCommandDto
{
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private Long sequenceNum;

    public Long getSequenceNum()
    {
        return this.sequenceNum;
    }

    public void setSequenceNum(Long sequenceNum)
    {
        this.sequenceNum = sequenceNum;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved()
    {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed)
    {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertySequenceNumRemoved;

    public Boolean getIsPropertySequenceNumRemoved()
    {
        return this.isPropertySequenceNumRemoved;
    }

    public void setIsPropertySequenceNumRemoved(Boolean removed)
    {
        this.isPropertySequenceNumRemoved = removed;
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

    public static class CreateShipmentMethodTypeDto extends CreateOrMergePatchShipmentMethodTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchShipmentMethodTypeDto extends CreateOrMergePatchShipmentMethodTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

