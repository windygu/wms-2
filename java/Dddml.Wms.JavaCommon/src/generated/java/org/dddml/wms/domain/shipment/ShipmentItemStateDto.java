package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class ShipmentItemStateDto
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

    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
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

    private String shipmentContentDescription;

    public String getShipmentContentDescription()
    {
        return this.shipmentContentDescription;
    }

    public void setShipmentContentDescription(String shipmentContentDescription)
    {
        this.shipmentContentDescription = shipmentContentDescription;
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

    private String shipmentId;

    public String getShipmentId()
    {
        return this.shipmentId;
    }

    public void setShipmentId(String shipmentId)
    {
        this.shipmentId = shipmentId;
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

        public ShipmentItemStateDto[] toShipmentItemStateDtoArray(Iterable<ShipmentItemState> states) {
            return toShipmentItemStateDtoList(states).toArray(new ShipmentItemStateDto[0]);
        }

        public List<ShipmentItemStateDto> toShipmentItemStateDtoList(Iterable<ShipmentItemState> states) {
            ArrayList<ShipmentItemStateDto> stateDtos = new ArrayList();
            for (ShipmentItemState s : states) {
                ShipmentItemStateDto dto = toShipmentItemStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public ShipmentItemStateDto toShipmentItemStateDto(ShipmentItemState state)
        {
            if(state == null) {
                return null;
            }
            ShipmentItemStateDto dto = new ShipmentItemStateDto();
            if (returnedFieldsContains("ShipmentItemSeqId")) {
                dto.setShipmentItemSeqId(state.getShipmentItemSeqId());
            }
            if (returnedFieldsContains("ProductId")) {
                dto.setProductId(state.getProductId());
            }
            if (returnedFieldsContains("AttributeSetInstanceId")) {
                dto.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
            }
            if (returnedFieldsContains("Quantity")) {
                dto.setQuantity(state.getQuantity());
            }
            if (returnedFieldsContains("ShipmentContentDescription")) {
                dto.setShipmentContentDescription(state.getShipmentContentDescription());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("ShipmentId")) {
                dto.setShipmentId(state.getShipmentId());
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

