package org.dddml.wms.domain.inoutnotice;


public class DeleteInOutNoticeDto extends AbstractInOutNoticeCommandDto
{

    public DeleteInOutNoticeDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

