package org.dddml.wms.domain.shipmentmethodtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class ShipmentMethodTypeStateDto
{

    private String shipmentMethodTypeId;

    public String getShipmentMethodTypeId()
    {
        return this.shipmentMethodTypeId;
    }

    public void setShipmentMethodTypeId(String shipmentMethodTypeId)
    {
        this.shipmentMethodTypeId = shipmentMethodTypeId;
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

    private Long sequenceNum;

    public Long getSequenceNum()
    {
        return this.sequenceNum;
    }

    public void setSequenceNum(Long sequenceNum)
    {
        this.sequenceNum = sequenceNum;
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

        public ShipmentMethodTypeStateDto[] toShipmentMethodTypeStateDtoArray(Iterable<ShipmentMethodTypeState> states) 
        {
            ArrayList<ShipmentMethodTypeStateDto> stateDtos = new ArrayList();
            for (ShipmentMethodTypeState s : states) {
                ShipmentMethodTypeStateDto dto = toShipmentMethodTypeStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new ShipmentMethodTypeStateDto[0]);
        }

        public ShipmentMethodTypeStateDto toShipmentMethodTypeStateDto(ShipmentMethodTypeState state)
        {
            if(state == null) {
                return null;
            }
            ShipmentMethodTypeStateDto dto = new ShipmentMethodTypeStateDto();
            if (returnedFieldsContains("ShipmentMethodTypeId")) {
                dto.setShipmentMethodTypeId(state.getShipmentMethodTypeId());
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
            }
            if (returnedFieldsContains("SequenceNum")) {
                dto.setSequenceNum(state.getSequenceNum());
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

