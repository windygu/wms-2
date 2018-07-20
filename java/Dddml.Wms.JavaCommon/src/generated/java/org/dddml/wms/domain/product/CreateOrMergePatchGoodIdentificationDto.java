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

    public void copyTo(AbstractGoodIdentificationCommand.AbstractCreateOrMergePatchGoodIdentification command)
    {
        ((AbstractGoodIdentificationCommandDto) this).copyTo(command);
        command.setIdValue(this.getIdValue());
        command.setActive(this.getActive());
    }

    public GoodIdentificationCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractGoodIdentificationCommand.SimpleCreateGoodIdentification command = new AbstractGoodIdentificationCommand.SimpleCreateGoodIdentification();
            copyTo((AbstractGoodIdentificationCommand.AbstractCreateGoodIdentification) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractGoodIdentificationCommand.SimpleMergePatchGoodIdentification command = new AbstractGoodIdentificationCommand.SimpleMergePatchGoodIdentification();
            copyTo((AbstractGoodIdentificationCommand.SimpleMergePatchGoodIdentification) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractGoodIdentificationCommand.SimpleRemoveGoodIdentification command = new AbstractGoodIdentificationCommand.SimpleRemoveGoodIdentification();
            ((AbstractGoodIdentificationCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractGoodIdentificationCommand.AbstractCreateGoodIdentification command)
    {
        copyTo((AbstractGoodIdentificationCommand.AbstractCreateOrMergePatchGoodIdentification) command);
    }

    public void copyTo(AbstractGoodIdentificationCommand.AbstractMergePatchGoodIdentification command)
    {
        copyTo((AbstractGoodIdentificationCommand.AbstractCreateOrMergePatchGoodIdentification) command);
        command.setIsPropertyIdValueRemoved(this.getIsPropertyIdValueRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
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
        public GoodIdentificationCommand.CreateGoodIdentification toCreateGoodIdentification()
        {
            return (GoodIdentificationCommand.CreateGoodIdentification) toCommand();
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
        public GoodIdentificationCommand.MergePatchGoodIdentification toMergePatchGoodIdentification()
        {
            return (GoodIdentificationCommand.MergePatchGoodIdentification) toCommand();
        }

    }

}

