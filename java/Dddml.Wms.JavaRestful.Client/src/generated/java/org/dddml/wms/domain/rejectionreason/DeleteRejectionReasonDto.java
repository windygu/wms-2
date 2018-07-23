package org.dddml.wms.domain.rejectionreason;


public class DeleteRejectionReasonDto extends AbstractRejectionReasonCommandDto
{

    public DeleteRejectionReasonDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

