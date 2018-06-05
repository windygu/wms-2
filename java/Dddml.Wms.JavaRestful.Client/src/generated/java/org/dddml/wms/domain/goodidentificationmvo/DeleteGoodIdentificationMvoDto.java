package org.dddml.wms.domain.goodidentificationmvo;


public class DeleteGoodIdentificationMvoDto extends AbstractGoodIdentificationMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

