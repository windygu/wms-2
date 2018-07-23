package org.dddml.wms.domain.shipmenttype;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchShipmentTypeDto extends AbstractShipmentTypeCommandDto
{
    /**
     * Parent Type Id
     */
    private String parentTypeId;

    public String getParentTypeId()
    {
        return this.parentTypeId;
    }

    public void setParentTypeId(String parentTypeId)
    {
        this.parentTypeId = parentTypeId;
    }

    /**
     * Has Table
     */
    private String hasTable;

    public String getHasTable()
    {
        return this.hasTable;
    }

    public void setHasTable(String hasTable)
    {
        this.hasTable = hasTable;
    }

    /**
     * Description
     */
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Active
     */
    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Boolean isPropertyParentTypeIdRemoved;

    public Boolean getIsPropertyParentTypeIdRemoved()
    {
        return this.isPropertyParentTypeIdRemoved;
    }

    public void setIsPropertyParentTypeIdRemoved(Boolean removed)
    {
        this.isPropertyParentTypeIdRemoved = removed;
    }

    private Boolean isPropertyHasTableRemoved;

    public Boolean getIsPropertyHasTableRemoved()
    {
        return this.isPropertyHasTableRemoved;
    }

    public void setIsPropertyHasTableRemoved(Boolean removed)
    {
        this.isPropertyHasTableRemoved = removed;
    }

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved()
    {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed)
    {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public ShipmentTypeCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            return toCreateShipmentType();
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            return toMergePatchShipmentType();
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    protected ShipmentTypeCommand.CreateShipmentType toCreateShipmentType() {
        return new ShipmentTypeCommand.CreateShipmentType() {
            @Override
            public String getShipmentTypeId() {
                return CreateOrMergePatchShipmentTypeDto.this.getShipmentTypeId();
            }

            @Override
            public void setShipmentTypeId(String p) {
                CreateOrMergePatchShipmentTypeDto.this.setShipmentTypeId(p);
            }

            @Override
            public Long getVersion() {
                return CreateOrMergePatchShipmentTypeDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                CreateOrMergePatchShipmentTypeDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return CreateOrMergePatchShipmentTypeDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 CreateOrMergePatchShipmentTypeDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return CreateOrMergePatchShipmentTypeDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                CreateOrMergePatchShipmentTypeDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return CreateOrMergePatchShipmentTypeDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                CreateOrMergePatchShipmentTypeDto.this.setRequesterId(requesterId);
            }

            @Override
            public String getParentTypeId() {
                return CreateOrMergePatchShipmentTypeDto.this.getParentTypeId();
            }

            @Override
            public void setParentTypeId(String p) {
                CreateOrMergePatchShipmentTypeDto.this.setParentTypeId(p);
            }

            @Override
            public String getHasTable() {
                return CreateOrMergePatchShipmentTypeDto.this.getHasTable();
            }

            @Override
            public void setHasTable(String p) {
                CreateOrMergePatchShipmentTypeDto.this.setHasTable(p);
            }

            @Override
            public String getDescription() {
                return CreateOrMergePatchShipmentTypeDto.this.getDescription();
            }

            @Override
            public void setDescription(String p) {
                CreateOrMergePatchShipmentTypeDto.this.setDescription(p);
            }

            @Override
            public Boolean getActive() {
                return CreateOrMergePatchShipmentTypeDto.this.getActive();
            }

            @Override
            public void setActive(Boolean p) {
                CreateOrMergePatchShipmentTypeDto.this.setActive(p);
            }


        };
    }

    protected ShipmentTypeCommand.MergePatchShipmentType toMergePatchShipmentType() {
        return new ShipmentTypeCommand.MergePatchShipmentType() {
            @Override
            public String getShipmentTypeId() {
                return CreateOrMergePatchShipmentTypeDto.this.getShipmentTypeId();
            }

            @Override
            public void setShipmentTypeId(String p) {
                CreateOrMergePatchShipmentTypeDto.this.setShipmentTypeId(p);
            }

            @Override
            public Long getVersion() {
                return CreateOrMergePatchShipmentTypeDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                CreateOrMergePatchShipmentTypeDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return CreateOrMergePatchShipmentTypeDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 CreateOrMergePatchShipmentTypeDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return CreateOrMergePatchShipmentTypeDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                CreateOrMergePatchShipmentTypeDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return CreateOrMergePatchShipmentTypeDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                CreateOrMergePatchShipmentTypeDto.this.setRequesterId(requesterId);
            }

            @Override
            public String getParentTypeId() {
                return CreateOrMergePatchShipmentTypeDto.this.getParentTypeId();
            }

            @Override
            public void setParentTypeId(String p) {
                CreateOrMergePatchShipmentTypeDto.this.setParentTypeId(p);
            }

            @Override
            public String getHasTable() {
                return CreateOrMergePatchShipmentTypeDto.this.getHasTable();
            }

            @Override
            public void setHasTable(String p) {
                CreateOrMergePatchShipmentTypeDto.this.setHasTable(p);
            }

            @Override
            public String getDescription() {
                return CreateOrMergePatchShipmentTypeDto.this.getDescription();
            }

            @Override
            public void setDescription(String p) {
                CreateOrMergePatchShipmentTypeDto.this.setDescription(p);
            }

            @Override
            public Boolean getActive() {
                return CreateOrMergePatchShipmentTypeDto.this.getActive();
            }

            @Override
            public void setActive(Boolean p) {
                CreateOrMergePatchShipmentTypeDto.this.setActive(p);
            }

            @Override
            public Boolean getIsPropertyParentTypeIdRemoved() {
                return CreateOrMergePatchShipmentTypeDto.this.getIsPropertyParentTypeIdRemoved();
            }

            @Override
            public void setIsPropertyParentTypeIdRemoved(Boolean removed) {
                CreateOrMergePatchShipmentTypeDto.this.setIsPropertyParentTypeIdRemoved(removed);
            }

            @Override
            public Boolean getIsPropertyHasTableRemoved() {
                return CreateOrMergePatchShipmentTypeDto.this.getIsPropertyHasTableRemoved();
            }

            @Override
            public void setIsPropertyHasTableRemoved(Boolean removed) {
                CreateOrMergePatchShipmentTypeDto.this.setIsPropertyHasTableRemoved(removed);
            }

            @Override
            public Boolean getIsPropertyDescriptionRemoved() {
                return CreateOrMergePatchShipmentTypeDto.this.getIsPropertyDescriptionRemoved();
            }

            @Override
            public void setIsPropertyDescriptionRemoved(Boolean removed) {
                CreateOrMergePatchShipmentTypeDto.this.setIsPropertyDescriptionRemoved(removed);
            }

            @Override
            public Boolean getIsPropertyActiveRemoved() {
                return CreateOrMergePatchShipmentTypeDto.this.getIsPropertyActiveRemoved();
            }

            @Override
            public void setIsPropertyActiveRemoved(Boolean removed) {
                CreateOrMergePatchShipmentTypeDto.this.setIsPropertyActiveRemoved(removed);
            }


        };
    }

    public static class CreateShipmentTypeDto extends CreateOrMergePatchShipmentTypeDto
    {
        public CreateShipmentTypeDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public ShipmentTypeCommand.CreateShipmentType toCreateShipmentType()
        {
            return super.toCreateShipmentType();
        }

    }

    public static class MergePatchShipmentTypeDto extends CreateOrMergePatchShipmentTypeDto
    {
        public MergePatchShipmentTypeDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public ShipmentTypeCommand.MergePatchShipmentType toMergePatchShipmentType()
        {
            return super.toMergePatchShipmentType();
        }

    }

}

