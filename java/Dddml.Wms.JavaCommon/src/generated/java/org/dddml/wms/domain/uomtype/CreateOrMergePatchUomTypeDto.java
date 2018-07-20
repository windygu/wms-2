package org.dddml.wms.domain.uomtype;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchUomTypeDto extends AbstractUomTypeCommandDto
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

    public UomTypeCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            return toCreateUomType();
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            return toMergePatchUomType();
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    protected UomTypeCommand.CreateUomType toCreateUomType() {
        return new UomTypeCommand.CreateUomType() {
            @Override
            public String getUomTypeId() {
                return CreateOrMergePatchUomTypeDto.this.getUomTypeId();
            }

            @Override
            public void setUomTypeId(String p) {
                CreateOrMergePatchUomTypeDto.this.setUomTypeId(p);
            }

            @Override
            public Long getVersion() {
                return CreateOrMergePatchUomTypeDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                CreateOrMergePatchUomTypeDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return CreateOrMergePatchUomTypeDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 CreateOrMergePatchUomTypeDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return CreateOrMergePatchUomTypeDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                CreateOrMergePatchUomTypeDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return CreateOrMergePatchUomTypeDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                CreateOrMergePatchUomTypeDto.this.setRequesterId(requesterId);
            }

            @Override
            public String getParentTypeId() {
                return CreateOrMergePatchUomTypeDto.this.getParentTypeId();
            }

            @Override
            public void setParentTypeId(String p) {
                CreateOrMergePatchUomTypeDto.this.setParentTypeId(p);
            }

            @Override
            public String getHasTable() {
                return CreateOrMergePatchUomTypeDto.this.getHasTable();
            }

            @Override
            public void setHasTable(String p) {
                CreateOrMergePatchUomTypeDto.this.setHasTable(p);
            }

            @Override
            public String getDescription() {
                return CreateOrMergePatchUomTypeDto.this.getDescription();
            }

            @Override
            public void setDescription(String p) {
                CreateOrMergePatchUomTypeDto.this.setDescription(p);
            }

            @Override
            public Boolean getActive() {
                return CreateOrMergePatchUomTypeDto.this.getActive();
            }

            @Override
            public void setActive(Boolean p) {
                CreateOrMergePatchUomTypeDto.this.setActive(p);
            }


        };
    }

    protected UomTypeCommand.MergePatchUomType toMergePatchUomType() {
        return new UomTypeCommand.MergePatchUomType() {
            @Override
            public String getUomTypeId() {
                return CreateOrMergePatchUomTypeDto.this.getUomTypeId();
            }

            @Override
            public void setUomTypeId(String p) {
                CreateOrMergePatchUomTypeDto.this.setUomTypeId(p);
            }

            @Override
            public Long getVersion() {
                return CreateOrMergePatchUomTypeDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                CreateOrMergePatchUomTypeDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return CreateOrMergePatchUomTypeDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 CreateOrMergePatchUomTypeDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return CreateOrMergePatchUomTypeDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                CreateOrMergePatchUomTypeDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return CreateOrMergePatchUomTypeDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                CreateOrMergePatchUomTypeDto.this.setRequesterId(requesterId);
            }

            @Override
            public String getParentTypeId() {
                return CreateOrMergePatchUomTypeDto.this.getParentTypeId();
            }

            @Override
            public void setParentTypeId(String p) {
                CreateOrMergePatchUomTypeDto.this.setParentTypeId(p);
            }

            @Override
            public String getHasTable() {
                return CreateOrMergePatchUomTypeDto.this.getHasTable();
            }

            @Override
            public void setHasTable(String p) {
                CreateOrMergePatchUomTypeDto.this.setHasTable(p);
            }

            @Override
            public String getDescription() {
                return CreateOrMergePatchUomTypeDto.this.getDescription();
            }

            @Override
            public void setDescription(String p) {
                CreateOrMergePatchUomTypeDto.this.setDescription(p);
            }

            @Override
            public Boolean getActive() {
                return CreateOrMergePatchUomTypeDto.this.getActive();
            }

            @Override
            public void setActive(Boolean p) {
                CreateOrMergePatchUomTypeDto.this.setActive(p);
            }

            @Override
            public Boolean getIsPropertyParentTypeIdRemoved() {
                return CreateOrMergePatchUomTypeDto.this.getIsPropertyParentTypeIdRemoved();
            }

            @Override
            public void setIsPropertyParentTypeIdRemoved(Boolean removed) {
                CreateOrMergePatchUomTypeDto.this.setIsPropertyParentTypeIdRemoved(removed);
            }

            @Override
            public Boolean getIsPropertyHasTableRemoved() {
                return CreateOrMergePatchUomTypeDto.this.getIsPropertyHasTableRemoved();
            }

            @Override
            public void setIsPropertyHasTableRemoved(Boolean removed) {
                CreateOrMergePatchUomTypeDto.this.setIsPropertyHasTableRemoved(removed);
            }

            @Override
            public Boolean getIsPropertyDescriptionRemoved() {
                return CreateOrMergePatchUomTypeDto.this.getIsPropertyDescriptionRemoved();
            }

            @Override
            public void setIsPropertyDescriptionRemoved(Boolean removed) {
                CreateOrMergePatchUomTypeDto.this.setIsPropertyDescriptionRemoved(removed);
            }

            @Override
            public Boolean getIsPropertyActiveRemoved() {
                return CreateOrMergePatchUomTypeDto.this.getIsPropertyActiveRemoved();
            }

            @Override
            public void setIsPropertyActiveRemoved(Boolean removed) {
                CreateOrMergePatchUomTypeDto.this.setIsPropertyActiveRemoved(removed);
            }


        };
    }

    public static class CreateUomTypeDto extends CreateOrMergePatchUomTypeDto
    {
        public CreateUomTypeDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public UomTypeCommand.CreateUomType toCreateUomType()
        {
            return super.toCreateUomType();
        }

    }

    public static class MergePatchUomTypeDto extends CreateOrMergePatchUomTypeDto
    {
        public MergePatchUomTypeDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public UomTypeCommand.MergePatchUomType toMergePatchUomType()
        {
            return super.toMergePatchUomType();
        }

    }

}

