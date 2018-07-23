package org.dddml.wms.domain.inout;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInOutLineImageDto extends AbstractInOutLineImageCommandDto
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

    public void copyTo(AbstractInOutLineImageCommand.AbstractCreateOrMergePatchInOutLineImage command)
    {
        ((AbstractInOutLineImageCommandDto) this).copyTo(command);
        command.setUrl(this.getUrl());
        command.setActive(this.getActive());
    }

    public InOutLineImageCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractInOutLineImageCommand.SimpleCreateInOutLineImage command = new AbstractInOutLineImageCommand.SimpleCreateInOutLineImage();
            copyTo((AbstractInOutLineImageCommand.AbstractCreateInOutLineImage) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractInOutLineImageCommand.SimpleMergePatchInOutLineImage command = new AbstractInOutLineImageCommand.SimpleMergePatchInOutLineImage();
            copyTo((AbstractInOutLineImageCommand.SimpleMergePatchInOutLineImage) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractInOutLineImageCommand.SimpleRemoveInOutLineImage command = new AbstractInOutLineImageCommand.SimpleRemoveInOutLineImage();
            ((AbstractInOutLineImageCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractInOutLineImageCommand.AbstractCreateInOutLineImage command)
    {
        copyTo((AbstractInOutLineImageCommand.AbstractCreateOrMergePatchInOutLineImage) command);
    }

    public void copyTo(AbstractInOutLineImageCommand.AbstractMergePatchInOutLineImage command)
    {
        copyTo((AbstractInOutLineImageCommand.AbstractCreateOrMergePatchInOutLineImage) command);
        command.setIsPropertyUrlRemoved(this.getIsPropertyUrlRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateInOutLineImageDto extends CreateOrMergePatchInOutLineImageDto
    {
        public CreateInOutLineImageDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public InOutLineImageCommand.CreateInOutLineImage toCreateInOutLineImage()
        {
            return (InOutLineImageCommand.CreateInOutLineImage) toCommand();
        }

    }

    public static class MergePatchInOutLineImageDto extends CreateOrMergePatchInOutLineImageDto
    {
        public MergePatchInOutLineImageDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public InOutLineImageCommand.MergePatchInOutLineImage toMergePatchInOutLineImage()
        {
            return (InOutLineImageCommand.MergePatchInOutLineImage) toCommand();
        }

    }

}

