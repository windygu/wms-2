package org.dddml.wms.domain.locator;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class LocatorStateDto
{

    private String locatorId;

    public String getLocatorId()
    {
        return this.locatorId;
    }

    public void setLocatorId(String locatorId)
    {
        this.locatorId = locatorId;
    }

    private String warehouseId;

    public String getWarehouseId()
    {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    private String parentLocatorId;

    public String getParentLocatorId()
    {
        return this.parentLocatorId;
    }

    public void setParentLocatorId(String parentLocatorId)
    {
        this.parentLocatorId = parentLocatorId;
    }

    private String locatorType;

    public String getLocatorType()
    {
        return this.locatorType;
    }

    public void setLocatorType(String locatorType)
    {
        this.locatorType = locatorType;
    }

    private String priorityNumber;

    public String getPriorityNumber()
    {
        return this.priorityNumber;
    }

    public void setPriorityNumber(String priorityNumber)
    {
        this.priorityNumber = priorityNumber;
    }

    private Boolean isDefault;

    public Boolean getIsDefault()
    {
        return this.isDefault;
    }

    public void setIsDefault(Boolean isDefault)
    {
        this.isDefault = isDefault;
    }

    private String x;

    public String getX()
    {
        return this.x;
    }

    public void setX(String x)
    {
        this.x = x;
    }

    private String y;

    public String getY()
    {
        return this.y;
    }

    public void setY(String y)
    {
        this.y = y;
    }

    private String z;

    public String getZ()
    {
        return this.z;
    }

    public void setZ(String z)
    {
        this.z = z;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private String locatorTypeId;

    public String getLocatorTypeId()
    {
        return this.locatorTypeId;
    }

    public void setLocatorTypeId(String locatorTypeId)
    {
        this.locatorTypeId = locatorTypeId;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public LocatorStateDto[] toLocatorStateDtoArray(Iterable<LocatorState> states) {
            return toLocatorStateDtoList(states).toArray(new LocatorStateDto[0]);
        }

        public List<LocatorStateDto> toLocatorStateDtoList(Iterable<LocatorState> states) {
            ArrayList<LocatorStateDto> stateDtos = new ArrayList();
            for (LocatorState s : states) {
                LocatorStateDto dto = toLocatorStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public LocatorStateDto toLocatorStateDto(LocatorState state)
        {
            if(state == null) {
                return null;
            }
            LocatorStateDto dto = new LocatorStateDto();
            if (returnedFieldsContains("LocatorId")) {
                dto.setLocatorId(state.getLocatorId());
            }
            if (returnedFieldsContains("WarehouseId")) {
                dto.setWarehouseId(state.getWarehouseId());
            }
            if (returnedFieldsContains("ParentLocatorId")) {
                dto.setParentLocatorId(state.getParentLocatorId());
            }
            if (returnedFieldsContains("LocatorType")) {
                dto.setLocatorType(state.getLocatorType());
            }
            if (returnedFieldsContains("PriorityNumber")) {
                dto.setPriorityNumber(state.getPriorityNumber());
            }
            if (returnedFieldsContains("IsDefault")) {
                dto.setIsDefault(state.getIsDefault());
            }
            if (returnedFieldsContains("X")) {
                dto.setX(state.getX());
            }
            if (returnedFieldsContains("Y")) {
                dto.setY(state.getY());
            }
            if (returnedFieldsContains("Z")) {
                dto.setZ(state.getZ());
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
            }
            if (returnedFieldsContains("LocatorTypeId")) {
                dto.setLocatorTypeId(state.getLocatorTypeId());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("CreatedBy")) {
                dto.setCreatedBy(state.getCreatedBy());
            }
            if (returnedFieldsContains("CreatedAt")) {
                dto.setCreatedAt(state.getCreatedAt());
            }
            if (returnedFieldsContains("UpdatedBy")) {
                dto.setUpdatedBy(state.getUpdatedBy());
            }
            if (returnedFieldsContains("UpdatedAt")) {
                dto.setUpdatedAt(state.getUpdatedAt());
            }
            return dto;
        }

    }
}

