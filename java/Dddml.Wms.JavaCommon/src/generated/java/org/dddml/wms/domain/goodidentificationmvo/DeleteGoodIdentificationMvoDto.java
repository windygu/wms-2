package org.dddml.wms.domain.goodidentificationmvo;


public class DeleteGoodIdentificationMvoDto extends AbstractGoodIdentificationMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public GoodIdentificationMvoCommand.DeleteGoodIdentificationMvo toDeleteGoodIdentificationMvo()
    {
        AbstractGoodIdentificationMvoCommand.SimpleDeleteGoodIdentificationMvo command = new AbstractGoodIdentificationMvoCommand.SimpleDeleteGoodIdentificationMvo();
        ((AbstractGoodIdentificationMvoCommandDto)this).copyTo(command);
        return command;
    }
}

