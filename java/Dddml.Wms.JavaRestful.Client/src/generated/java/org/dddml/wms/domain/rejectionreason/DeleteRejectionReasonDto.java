package org.dddml.wms.domain.rejectionreason;


public class DeleteRejectionReasonDto extends AbstractRejectionReasonCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

