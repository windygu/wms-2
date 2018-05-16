package org.dddml.wms.domain.picklistitemmvo;


public class DeletePicklistItemMvoDto extends AbstractPicklistItemMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

