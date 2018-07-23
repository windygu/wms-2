package org.dddml.wms.domain.product;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchGoodIdentificationDto extends AbstractGoodIdentificationCommandDto
{
    /**
     * Id Value
     */
    private String idValue;

    public String getIdValue()
    {
        return this.idValue;
    }

    public void setIdValue(String idValue)
    {
        this.idValue = idValue;
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

    private Boolean isPropertyIdValueRemoved;

    public Boolean getIsPropertyIdValueRemoved()
    {
        return this.isPropertyIdValueRemoved;
    }

    public void setIsPropertyIdValueRemoved(Boolean removed)
    {
        this.isPropertyIdValueRemoved = removed;
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

    public static class CreateGoodIdentificationDto extends CreateOrMergePatchGoodIdentificationDto
    {
        public CreateGoodIdentificationDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchGoodIdentificationDto extends CreateOrMergePatchGoodIdentificationDto
    {
        public MergePatchGoodIdentificationDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

