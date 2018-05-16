package org.dddml.wms.domain.inoutlinemvo;


public class DeleteInOutLineMvoDto extends AbstractInOutLineMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

