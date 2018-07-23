package org.dddml.wms.domain.shipmenttype;


public class DeleteShipmentTypeDto extends AbstractShipmentTypeCommandDto
{

    public DeleteShipmentTypeDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public ShipmentTypeCommand.DeleteShipmentType toDeleteShipmentType()
    {
        return new ShipmentTypeCommand.DeleteShipmentType() {
            @Override
            public String getShipmentTypeId() {
                return DeleteShipmentTypeDto.this.getShipmentTypeId();
            }

            @Override
            public void setShipmentTypeId(String p) {
                DeleteShipmentTypeDto.this.setShipmentTypeId(p);
            }

            @Override
            public Long getVersion() {
                return DeleteShipmentTypeDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                DeleteShipmentTypeDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return DeleteShipmentTypeDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 DeleteShipmentTypeDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return DeleteShipmentTypeDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                DeleteShipmentTypeDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return DeleteShipmentTypeDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                DeleteShipmentTypeDto.this.setRequesterId(requesterId);
            }


        };
    }
}

