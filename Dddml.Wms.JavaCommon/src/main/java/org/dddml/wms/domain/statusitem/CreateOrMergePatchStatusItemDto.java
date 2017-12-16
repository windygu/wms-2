package org.dddml.wms.domain.statusitem;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchStatusItemDto extends AbstractStatusItemCommandDto
{
    private String statusTypeId;

    public String getStatusTypeId()
    {
        return this.statusTypeId;
    }

    public void setStatusTypeId(String statusTypeId)
    {
        this.statusTypeId = statusTypeId;
    }

    private String statusCode;

    public String getStatusCode()
    {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode)
    {
        this.statusCode = statusCode;
    }

    private String sequenceId;

    public String getSequenceId()
    {
        return this.sequenceId;
    }

    public void setSequenceId(String sequenceId)
    {
        this.sequenceId = sequenceId;
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

    private Boolean isPropertyStatusTypeIdRemoved;

    public Boolean getIsPropertyStatusTypeIdRemoved()
    {
        return this.isPropertyStatusTypeIdRemoved;
    }

    public void setIsPropertyStatusTypeIdRemoved(Boolean removed)
    {
        this.isPropertyStatusTypeIdRemoved = removed;
    }

    private Boolean isPropertyStatusCodeRemoved;

    public Boolean getIsPropertyStatusCodeRemoved()
    {
        return this.isPropertyStatusCodeRemoved;
    }

    public void setIsPropertyStatusCodeRemoved(Boolean removed)
    {
        this.isPropertyStatusCodeRemoved = removed;
    }

    private Boolean isPropertySequenceIdRemoved;

    public Boolean getIsPropertySequenceIdRemoved()
    {
        return this.isPropertySequenceIdRemoved;
    }

    public void setIsPropertySequenceIdRemoved(Boolean removed)
    {
        this.isPropertySequenceIdRemoved = removed;
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

    public void copyTo(AbstractStatusItemCommand.AbstractCreateOrMergePatchStatusItem command)
    {
        ((AbstractStatusItemCommandDto) this).copyTo(command);
        command.setStatusTypeId(this.getStatusTypeId());
        command.setStatusCode(this.getStatusCode());
        command.setSequenceId(this.getSequenceId());
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public StatusItemCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractStatusItemCommand.SimpleCreateStatusItem command = new AbstractStatusItemCommand.SimpleCreateStatusItem();
            copyTo((AbstractStatusItemCommand.AbstractCreateStatusItem) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractStatusItemCommand.SimpleMergePatchStatusItem command = new AbstractStatusItemCommand.SimpleMergePatchStatusItem();
            copyTo((AbstractStatusItemCommand.SimpleMergePatchStatusItem) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractStatusItemCommand.AbstractCreateStatusItem command)
    {
        copyTo((AbstractStatusItemCommand.AbstractCreateOrMergePatchStatusItem) command);
    }

    public void copyTo(AbstractStatusItemCommand.AbstractMergePatchStatusItem command)
    {
        copyTo((AbstractStatusItemCommand.AbstractCreateOrMergePatchStatusItem) command);
        command.setIsPropertyStatusTypeIdRemoved(this.getIsPropertyStatusTypeIdRemoved());
        command.setIsPropertyStatusCodeRemoved(this.getIsPropertyStatusCodeRemoved());
        command.setIsPropertySequenceIdRemoved(this.getIsPropertySequenceIdRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateStatusItemDto extends CreateOrMergePatchStatusItemDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public StatusItemCommand.CreateStatusItem toCreateStatusItem()
        {
            return (StatusItemCommand.CreateStatusItem) toCommand();
        }

    }

    public static class MergePatchStatusItemDto extends CreateOrMergePatchStatusItemDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public StatusItemCommand.MergePatchStatusItem toMergePatchStatusItem()
        {
            return (StatusItemCommand.MergePatchStatusItem) toCommand();
        }

    }

}

