package org.dddml.wms.domain.inout;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInOutImageDto extends AbstractInOutImageCommandDto
{
    /**
     * Url
     */
    private String url;

    public String getUrl()
    {
        return this.url;
    }

    public void setUrl(String url)
    {
        this.url = url;
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

    private Boolean isPropertyUrlRemoved;

    public Boolean getIsPropertyUrlRemoved()
    {
        return this.isPropertyUrlRemoved;
    }

    public void setIsPropertyUrlRemoved(Boolean removed)
    {
        this.isPropertyUrlRemoved = removed;
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

    public void copyTo(AbstractInOutImageCommand.AbstractCreateOrMergePatchInOutImage command)
    {
        ((AbstractInOutImageCommandDto) this).copyTo(command);
        command.setUrl(this.getUrl());
        command.setActive(this.getActive());
    }

    public InOutImageCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractInOutImageCommand.SimpleCreateInOutImage command = new AbstractInOutImageCommand.SimpleCreateInOutImage();
            copyTo((AbstractInOutImageCommand.AbstractCreateInOutImage) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractInOutImageCommand.SimpleMergePatchInOutImage command = new AbstractInOutImageCommand.SimpleMergePatchInOutImage();
            copyTo((AbstractInOutImageCommand.SimpleMergePatchInOutImage) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractInOutImageCommand.SimpleRemoveInOutImage command = new AbstractInOutImageCommand.SimpleRemoveInOutImage();
            ((AbstractInOutImageCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractInOutImageCommand.AbstractCreateInOutImage command)
    {
        copyTo((AbstractInOutImageCommand.AbstractCreateOrMergePatchInOutImage) command);
    }

    public void copyTo(AbstractInOutImageCommand.AbstractMergePatchInOutImage command)
    {
        copyTo((AbstractInOutImageCommand.AbstractCreateOrMergePatchInOutImage) command);
        command.setIsPropertyUrlRemoved(this.getIsPropertyUrlRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateInOutImageDto extends CreateOrMergePatchInOutImageDto
    {
        public CreateInOutImageDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public InOutImageCommand.CreateInOutImage toCreateInOutImage()
        {
            return (InOutImageCommand.CreateInOutImage) toCommand();
        }

    }

    public static class MergePatchInOutImageDto extends CreateOrMergePatchInOutImageDto
    {
        public MergePatchInOutImageDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public InOutImageCommand.MergePatchInOutImage toMergePatchInOutImage()
        {
            return (InOutImageCommand.MergePatchInOutImage) toCommand();
        }

    }

}

