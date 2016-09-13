package org.dddml.wms.domain;


public class DeleteAudienceDto extends AbstractAudienceCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public AudienceCommand.DeleteAudience toDeleteAudience()
    {
        AbstractAudienceCommand.SimpleDeleteAudience command = new AbstractAudienceCommand.SimpleDeleteAudience();
        ((AbstractAudienceCommandDto)this).copyTo(command);
        return command;
    }
}

