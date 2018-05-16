package org.dddml.wms.domain.supplierproduct;


public class DeleteSupplierProductDto extends AbstractSupplierProductCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

