package org.dddml.wms.domain.pickwave;


public class DeletePickwaveDto extends AbstractPickwaveCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

