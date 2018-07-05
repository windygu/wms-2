package org.dddml.wms.domain.product;


public class DeleteProductDto extends AbstractProductCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

