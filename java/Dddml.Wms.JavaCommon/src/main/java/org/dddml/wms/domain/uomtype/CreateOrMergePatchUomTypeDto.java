package org.dddml.wms.domain.uomtype;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchUomTypeDto extends AbstractUomTypeCommandDto
{
    private String parentTypeId;

    public String getParentTypeId()
    {
        return this.parentTypeId;
    }

    public void setParentTypeId(String parentTypeId)
    {
        this.parentTypeId = parentTypeId;
    }

    private String hasTable;

    public String getHasTable()
    {
        return this.hasTable;
    }

    public void setHasTable(String hasTable)
    {
        this.hasTable = hasTable;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    private Boolean isPropertyParentTypeIdRemoved;

    public Boolean getIsPropertyParentTypeIdRemoved()
    {
        return this.isPropertyParentTypeIdRemoved;
    }

    public void setIsPropertyParentTypeIdRemoved(Boolean removed)
    {
        this.isPropertyParentTypeIdRemoved = removed;
    }

    private Boolean isPropertyHasTableRemoved;

    public Boolean getIsPropertyHasTableRemoved()
    {
        return this.isPropertyHasTableRemoved;
    }

    public void setIsPropertyHasTableRemoved(Boolean removed)
    {
        this.isPropertyHasTableRemoved = removed;
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

    public void copyTo(AbstractUomTypeCommand.AbstractCreateOrMergePatchUomType command)
    {
        ((AbstractUomTypeCommandDto) this).copyTo(command);
        command.setParentTypeId(this.getParentTypeId());
        command.setHasTable(this.getHasTable());
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public UomTypeCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractUomTypeCommand.SimpleCreateUomType command = new AbstractUomTypeCommand.SimpleCreateUomType();
            copyTo((AbstractUomTypeCommand.AbstractCreateUomType) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractUomTypeCommand.SimpleMergePatchUomType command = new AbstractUomTypeCommand.SimpleMergePatchUomType();
            copyTo((AbstractUomTypeCommand.SimpleMergePatchUomType) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractUomTypeCommand.AbstractCreateUomType command)
    {
        copyTo((AbstractUomTypeCommand.AbstractCreateOrMergePatchUomType) command);
    }

    public void copyTo(AbstractUomTypeCommand.AbstractMergePatchUomType command)
    {
        copyTo((AbstractUomTypeCommand.AbstractCreateOrMergePatchUomType) command);
        command.setIsPropertyParentTypeIdRemoved(this.getIsPropertyParentTypeIdRemoved());
        command.setIsPropertyHasTableRemoved(this.getIsPropertyHasTableRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateUomTypeDto extends CreateOrMergePatchUomTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public UomTypeCommand.CreateUomType toCreateUomType()
        {
            return (UomTypeCommand.CreateUomType) toCommand();
        }

    }

    public static class MergePatchUomTypeDto extends CreateOrMergePatchUomTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public UomTypeCommand.MergePatchUomType toMergePatchUomType()
        {
            return (UomTypeCommand.MergePatchUomType) toCommand();
        }

    }

}

