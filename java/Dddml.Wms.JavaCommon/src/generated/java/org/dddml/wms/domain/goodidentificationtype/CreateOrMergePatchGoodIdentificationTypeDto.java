package org.dddml.wms.domain.goodidentificationtype;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchGoodIdentificationTypeDto extends AbstractGoodIdentificationTypeCommandDto
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

    public void copyTo(AbstractGoodIdentificationTypeCommand.AbstractCreateOrMergePatchGoodIdentificationType command)
    {
        ((AbstractGoodIdentificationTypeCommandDto) this).copyTo(command);
        command.setParentTypeId(this.getParentTypeId());
        command.setHasTable(this.getHasTable());
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public GoodIdentificationTypeCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractGoodIdentificationTypeCommand.SimpleCreateGoodIdentificationType command = new AbstractGoodIdentificationTypeCommand.SimpleCreateGoodIdentificationType();
            copyTo((AbstractGoodIdentificationTypeCommand.AbstractCreateGoodIdentificationType) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractGoodIdentificationTypeCommand.SimpleMergePatchGoodIdentificationType command = new AbstractGoodIdentificationTypeCommand.SimpleMergePatchGoodIdentificationType();
            copyTo((AbstractGoodIdentificationTypeCommand.SimpleMergePatchGoodIdentificationType) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractGoodIdentificationTypeCommand.AbstractCreateGoodIdentificationType command)
    {
        copyTo((AbstractGoodIdentificationTypeCommand.AbstractCreateOrMergePatchGoodIdentificationType) command);
    }

    public void copyTo(AbstractGoodIdentificationTypeCommand.AbstractMergePatchGoodIdentificationType command)
    {
        copyTo((AbstractGoodIdentificationTypeCommand.AbstractCreateOrMergePatchGoodIdentificationType) command);
        command.setIsPropertyParentTypeIdRemoved(this.getIsPropertyParentTypeIdRemoved());
        command.setIsPropertyHasTableRemoved(this.getIsPropertyHasTableRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateGoodIdentificationTypeDto extends CreateOrMergePatchGoodIdentificationTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public GoodIdentificationTypeCommand.CreateGoodIdentificationType toCreateGoodIdentificationType()
        {
            return (GoodIdentificationTypeCommand.CreateGoodIdentificationType) toCommand();
        }

    }

    public static class MergePatchGoodIdentificationTypeDto extends CreateOrMergePatchGoodIdentificationTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public GoodIdentificationTypeCommand.MergePatchGoodIdentificationType toMergePatchGoodIdentificationType()
        {
            return (GoodIdentificationTypeCommand.MergePatchGoodIdentificationType) toCommand();
        }

    }

}

