package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class ShipmentPackageContentStateDto
{

    private String shipmentItemSeqId;

    public String getShipmentItemSeqId()
    {
        return this.shipmentItemSeqId;
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.shipmentItemSeqId = shipmentItemSeqId;
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    private String subProductId;

    public String getSubProductId()
    {
        return this.subProductId;
    }

    public void setSubProductId(String subProductId)
    {
        this.subProductId = subProductId;
    }

    private java.math.BigDecimal subProductQuantity;

    public java.math.BigDecimal getSubProductQuantity()
    {
        return this.subProductQuantity;
    }

    public void setSubProductQuantity(java.math.BigDecimal subProductQuantity)
    {
        this.subProductQuantity = subProductQuantity;
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

    private ShipmentPackageId shipmentPackageId;

    public ShipmentPackageId getShipmentPackageId()
    {
        return this.shipmentPackageId;
    }

    public void setShipmentPackageId(ShipmentPackageId shipmentPackageId)
    {
        this.shipmentPackageId = shipmentPackageId;
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

        public ShipmentPackageContentStateDto[] toShipmentPackageContentStateDtoArray(Iterable<ShipmentPackageContentState> states) {
            return toShipmentPackageContentStateDtoList(states).toArray(new ShipmentPackageContentStateDto[0]);
        }

        public List<ShipmentPackageContentStateDto> toShipmentPackageContentStateDtoList(Iterable<ShipmentPackageContentState> states) {
            ArrayList<ShipmentPackageContentStateDto> stateDtos = new ArrayList();
            for (ShipmentPackageContentState s : states) {
                ShipmentPackageContentStateDto dto = toShipmentPackageContentStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public ShipmentPackageContentStateDto toShipmentPackageContentStateDto(ShipmentPackageContentState state)
        {
            if(state == null) {
                return null;
            }
            ShipmentPackageContentStateDto dto = new ShipmentPackageContentStateDto();
            if (returnedFieldsContains("ShipmentItemSeqId")) {
                dto.setShipmentItemSeqId(state.getShipmentItemSeqId());
            }
            if (returnedFieldsContains("Quantity")) {
                dto.setQuantity(state.getQuantity());
            }
            if (returnedFieldsContains("SubProductId")) {
                dto.setSubProductId(state.getSubProductId());
            }
            if (returnedFieldsContains("SubProductQuantity")) {
                dto.setSubProductQuantity(state.getSubProductQuantity());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("ShipmentPackageId")) {
                dto.setShipmentPackageId(state.getShipmentPackageId());
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

