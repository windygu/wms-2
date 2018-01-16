package org.dddml.wms.domain.productcategorymember;


public class DeleteProductCategoryMemberDto extends AbstractProductCategoryMemberCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public ProductCategoryMemberCommand.DeleteProductCategoryMember toDeleteProductCategoryMember()
    {
        AbstractProductCategoryMemberCommand.SimpleDeleteProductCategoryMember command = new AbstractProductCategoryMemberCommand.SimpleDeleteProductCategoryMember();
        ((AbstractProductCategoryMemberCommandDto)this).copyTo(command);
        return command;
    }
}

