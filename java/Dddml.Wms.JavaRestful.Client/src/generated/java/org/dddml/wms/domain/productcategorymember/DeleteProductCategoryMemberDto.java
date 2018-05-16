package org.dddml.wms.domain.productcategorymember;


public class DeleteProductCategoryMemberDto extends AbstractProductCategoryMemberCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

