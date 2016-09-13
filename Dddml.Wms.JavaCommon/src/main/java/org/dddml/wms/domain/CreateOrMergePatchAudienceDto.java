package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchAudienceDto extends AbstractAudienceCommandDto
{
    private String name;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    private String base64Secret;

    public String getBase64Secret()
    {
        return this.base64Secret;
    }

    public void setBase64Secret(String base64Secret)
    {
        this.base64Secret = base64Secret;
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

    private Boolean isPropertyNameRemoved;

    public Boolean getIsPropertyNameRemoved()
    {
        return this.isPropertyNameRemoved;
    }

    public void setIsPropertyNameRemoved(Boolean removed)
    {
        this.isPropertyNameRemoved = removed;
    }

    private Boolean isPropertyBase64SecretRemoved;

    public Boolean getIsPropertyBase64SecretRemoved()
    {
        return this.isPropertyBase64SecretRemoved;
    }

    public void setIsPropertyBase64SecretRemoved(Boolean removed)
    {
        this.isPropertyBase64SecretRemoved = removed;
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

    public void copyTo(AbstractAudienceCommand.AbstractCreateOrMergePatchAudience command)
    {
        ((AbstractAudienceCommandDto) this).copyTo(command);
        command.setName(this.getName());
        command.setBase64Secret(this.getBase64Secret());
        command.setActive(this.getActive());
    }

    public AudienceCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractAudienceCommand.SimpleCreateAudience command = new AbstractAudienceCommand.SimpleCreateAudience();
            copyTo((AbstractAudienceCommand.AbstractCreateAudience) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractAudienceCommand.SimpleMergePatchAudience command = new AbstractAudienceCommand.SimpleMergePatchAudience();
            copyTo((AbstractAudienceCommand.SimpleMergePatchAudience) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractAudienceCommand.AbstractCreateAudience command)
    {
        copyTo((AbstractAudienceCommand.AbstractCreateOrMergePatchAudience) command);
    }

    public void copyTo(AbstractAudienceCommand.AbstractMergePatchAudience command)
    {
        copyTo((AbstractAudienceCommand.AbstractCreateOrMergePatchAudience) command);
        command.setIsPropertyNameRemoved(this.getIsPropertyNameRemoved());
        command.setIsPropertyBase64SecretRemoved(this.getIsPropertyBase64SecretRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateAudienceDto extends CreateOrMergePatchAudienceDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public AudienceCommand.CreateAudience toCreateAudience()
        {
            return (AudienceCommand.CreateAudience) toCommand();
        }

    }

    public static class MergePatchAudienceDto extends CreateOrMergePatchAudienceDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public AudienceCommand.MergePatchAudience toMergePatchAudience()
        {
            return (AudienceCommand.MergePatchAudience) toCommand();
        }

    }

}

