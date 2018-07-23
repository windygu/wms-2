package org.dddml.wms.domain.uom;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchUomDto extends AbstractUomCommandDto
{
    /**
     * Uom Type Id
     */
    private String uomTypeId;

    public String getUomTypeId()
    {
        return this.uomTypeId;
    }

    public void setUomTypeId(String uomTypeId)
    {
        this.uomTypeId = uomTypeId;
    }

    /**
     * Abbreviation
     */
    private String abbreviation;

    public String getAbbreviation()
    {
        return this.abbreviation;
    }

    public void setAbbreviation(String abbreviation)
    {
        this.abbreviation = abbreviation;
    }

    /**
     * Description
     */
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    private Boolean isPropertyUomTypeIdRemoved;

    public Boolean getIsPropertyUomTypeIdRemoved()
    {
        return this.isPropertyUomTypeIdRemoved;
    }

    public void setIsPropertyUomTypeIdRemoved(Boolean removed)
    {
        this.isPropertyUomTypeIdRemoved = removed;
    }

    private Boolean isPropertyAbbreviationRemoved;

    public Boolean getIsPropertyAbbreviationRemoved()
    {
        return this.isPropertyAbbreviationRemoved;
    }

    public void setIsPropertyAbbreviationRemoved(Boolean removed)
    {
        this.isPropertyAbbreviationRemoved = removed;
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public void copyTo(AbstractUomCommand.AbstractCreateOrMergePatchUom command)
    {
        ((AbstractUomCommandDto) this).copyTo(command);
        command.setUomTypeId(this.getUomTypeId());
        command.setAbbreviation(this.getAbbreviation());
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public UomCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractUomCommand.SimpleCreateUom command = new AbstractUomCommand.SimpleCreateUom();
            copyTo((AbstractUomCommand.AbstractCreateUom) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractUomCommand.SimpleMergePatchUom command = new AbstractUomCommand.SimpleMergePatchUom();
            copyTo((AbstractUomCommand.SimpleMergePatchUom) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractUomCommand.AbstractCreateUom command)
    {
        copyTo((AbstractUomCommand.AbstractCreateOrMergePatchUom) command);
    }

    public void copyTo(AbstractUomCommand.AbstractMergePatchUom command)
    {
        copyTo((AbstractUomCommand.AbstractCreateOrMergePatchUom) command);
        command.setIsPropertyUomTypeIdRemoved(this.getIsPropertyUomTypeIdRemoved());
        command.setIsPropertyAbbreviationRemoved(this.getIsPropertyAbbreviationRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateUomDto extends CreateOrMergePatchUomDto
    {
        public CreateUomDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public UomCommand.CreateUom toCreateUom()
        {
            return (UomCommand.CreateUom) toCommand();
        }

    }

    public static class MergePatchUomDto extends CreateOrMergePatchUomDto
    {
        public MergePatchUomDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public UomCommand.MergePatchUom toMergePatchUom()
        {
            return (UomCommand.MergePatchUom) toCommand();
        }

    }

}

