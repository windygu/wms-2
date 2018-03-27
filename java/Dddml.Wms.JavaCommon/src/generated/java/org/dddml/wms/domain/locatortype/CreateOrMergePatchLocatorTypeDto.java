package org.dddml.wms.domain.locatortype;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchLocatorTypeDto extends AbstractLocatorTypeCommandDto
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public void copyTo(AbstractLocatorTypeCommand.AbstractCreateOrMergePatchLocatorType command)
    {
        ((AbstractLocatorTypeCommandDto) this).copyTo(command);
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public LocatorTypeCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractLocatorTypeCommand.SimpleCreateLocatorType command = new AbstractLocatorTypeCommand.SimpleCreateLocatorType();
            copyTo((AbstractLocatorTypeCommand.AbstractCreateLocatorType) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractLocatorTypeCommand.SimpleMergePatchLocatorType command = new AbstractLocatorTypeCommand.SimpleMergePatchLocatorType();
            copyTo((AbstractLocatorTypeCommand.SimpleMergePatchLocatorType) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractLocatorTypeCommand.AbstractCreateLocatorType command)
    {
        copyTo((AbstractLocatorTypeCommand.AbstractCreateOrMergePatchLocatorType) command);
    }

    public void copyTo(AbstractLocatorTypeCommand.AbstractMergePatchLocatorType command)
    {
        copyTo((AbstractLocatorTypeCommand.AbstractCreateOrMergePatchLocatorType) command);
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateLocatorTypeDto extends CreateOrMergePatchLocatorTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public LocatorTypeCommand.CreateLocatorType toCreateLocatorType()
        {
            return (LocatorTypeCommand.CreateLocatorType) toCommand();
        }

    }

    public static class MergePatchLocatorTypeDto extends CreateOrMergePatchLocatorTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public LocatorTypeCommand.MergePatchLocatorType toMergePatchLocatorType()
        {
            return (LocatorTypeCommand.MergePatchLocatorType) toCommand();
        }

    }

}

