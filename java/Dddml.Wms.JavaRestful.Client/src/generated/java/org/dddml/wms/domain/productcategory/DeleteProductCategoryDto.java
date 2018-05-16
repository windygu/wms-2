package org.dddml.wms.domain.productcategory;


public class DeleteProductCategoryDto extends AbstractProductCategoryCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

