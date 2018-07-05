package org.dddml.wms.domain.goodidentificationtype;


public class DeleteGoodIdentificationTypeDto extends AbstractGoodIdentificationTypeCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public GoodIdentificationTypeCommand.DeleteGoodIdentificationType toDeleteGoodIdentificationType()
    {
        AbstractGoodIdentificationTypeCommand.SimpleDeleteGoodIdentificationType command = new AbstractGoodIdentificationTypeCommand.SimpleDeleteGoodIdentificationType();
        ((AbstractGoodIdentificationTypeCommandDto)this).copyTo(command);
        return command;
    }
}

