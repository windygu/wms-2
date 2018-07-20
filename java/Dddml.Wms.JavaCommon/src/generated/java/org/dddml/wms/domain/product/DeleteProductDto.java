package org.dddml.wms.domain.product;


public class DeleteProductDto extends AbstractProductCommandDto
{

    public DeleteProductDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public ProductCommand.DeleteProduct toDeleteProduct()
    {
        AbstractProductCommand.SimpleDeleteProduct command = new AbstractProductCommand.SimpleDeleteProduct();
        ((AbstractProductCommandDto)this).copyTo(command);
        return command;
    }
}

