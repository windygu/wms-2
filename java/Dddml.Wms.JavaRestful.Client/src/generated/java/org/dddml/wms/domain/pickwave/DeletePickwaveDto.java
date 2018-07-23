package org.dddml.wms.domain.pickwave;


public class DeletePickwaveDto extends AbstractPickwaveCommandDto
{

    public DeletePickwaveDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

