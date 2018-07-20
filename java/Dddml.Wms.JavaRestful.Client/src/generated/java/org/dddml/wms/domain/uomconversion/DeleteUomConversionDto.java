package org.dddml.wms.domain.uomconversion;


public class DeleteUomConversionDto extends AbstractUomConversionCommandDto
{

    public DeleteUomConversionDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

