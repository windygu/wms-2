package org.dddml.wms.domain.uomconversion;


public class DeleteUomConversionDto extends AbstractUomConversionCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

