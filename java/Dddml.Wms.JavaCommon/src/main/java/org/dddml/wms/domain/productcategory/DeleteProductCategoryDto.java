package org.dddml.wms.domain.productcategory;


public class DeleteProductCategoryDto extends AbstractProductCategoryCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public ProductCategoryCommand.DeleteProductCategory toDeleteProductCategory()
    {
        AbstractProductCategoryCommand.SimpleDeleteProductCategory command = new AbstractProductCategoryCommand.SimpleDeleteProductCategory();
        ((AbstractProductCategoryCommandDto)this).copyTo(command);
        return command;
    }
}

