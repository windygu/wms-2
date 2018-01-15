package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class ShipmentReceiptStateDto
{

    private String receiptSeqId;

    public String getReceiptSeqId()
    {
        return this.receiptSeqId;
    }

    public void setReceiptSeqId(String receiptSeqId)
    {
        this.receiptSeqId = receiptSeqId;
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

    private String shipmentItemSeqId;

    public String getShipmentItemSeqId()
    {
        return this.shipmentItemSeqId;
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.shipmentItemSeqId = shipmentItemSeqId;
    }

    private String rejectionReasonId;

    public String getRejectionReasonId()
    {
        return this.rejectionReasonId;
    }

    public void setRejectionReasonId(String rejectionReasonId)
    {
        this.rejectionReasonId = rejectionReasonId;
    }

    private String damageStatusId;

    public String getDamageStatusId()
    {
        return this.damageStatusId;
    }

    public void setDamageStatusId(String damageStatusId)
    {
        this.damageStatusId = damageStatusId;
    }

    private String damageReasonId;

    public String getDamageReasonId()
    {
        return this.damageReasonId;
    }

    public void setDamageReasonId(String damageReasonId)
    {
        this.damageReasonId = damageReasonId;
    }

    private String receivedBy;

    public String getReceivedBy()
    {
        return this.receivedBy;
    }

    public void setReceivedBy(String receivedBy)
    {
        this.receivedBy = receivedBy;
    }

    private java.sql.Timestamp datetimeReceived;

    public java.sql.Timestamp getDatetimeReceived()
    {
        return this.datetimeReceived;
    }

    public void setDatetimeReceived(java.sql.Timestamp datetimeReceived)
    {
        this.datetimeReceived = datetimeReceived;
    }

    private String itemDescription;

    public String getItemDescription()
    {
        return this.itemDescription;
    }

    public void setItemDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
    }

    private java.math.BigDecimal acceptedQuantity;

    public java.math.BigDecimal getAcceptedQuantity()
    {
        return this.acceptedQuantity;
    }

    public void setAcceptedQuantity(java.math.BigDecimal acceptedQuantity)
    {
        this.acceptedQuantity = acceptedQuantity;
    }

    private java.math.BigDecimal rejectedQuantity;

    public java.math.BigDecimal getRejectedQuantity()
    {
        return this.rejectedQuantity;
    }

    public void setRejectedQuantity(java.math.BigDecimal rejectedQuantity)
    {
        this.rejectedQuantity = rejectedQuantity;
    }

    private java.math.BigDecimal damagedQuantity;

    public java.math.BigDecimal getDamagedQuantity()
    {
        return this.damagedQuantity;
    }

    public void setDamagedQuantity(java.math.BigDecimal damagedQuantity)
    {
        this.damagedQuantity = damagedQuantity;
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

        public ShipmentReceiptStateDto[] toShipmentReceiptStateDtoArray(Iterable<ShipmentReceiptState> states) 
        {
            ArrayList<ShipmentReceiptStateDto> stateDtos = new ArrayList();
            for (ShipmentReceiptState s : states) {
                ShipmentReceiptStateDto dto = toShipmentReceiptStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new ShipmentReceiptStateDto[0]);
        }

        public ShipmentReceiptStateDto toShipmentReceiptStateDto(ShipmentReceiptState state)
        {
            if(state == null) {
                return null;
            }
            ShipmentReceiptStateDto dto = new ShipmentReceiptStateDto();
            if (returnedFieldsContains("ReceiptSeqId")) {
                dto.setReceiptSeqId(state.getReceiptSeqId());
            }
            if (returnedFieldsContains("ProductId")) {
                dto.setProductId(state.getProductId());
            }
            if (returnedFieldsContains("ShipmentItemSeqId")) {
                dto.setShipmentItemSeqId(state.getShipmentItemSeqId());
            }
            if (returnedFieldsContains("RejectionReasonId")) {
                dto.setRejectionReasonId(state.getRejectionReasonId());
            }
            if (returnedFieldsContains("DamageStatusId")) {
                dto.setDamageStatusId(state.getDamageStatusId());
            }
            if (returnedFieldsContains("DamageReasonId")) {
                dto.setDamageReasonId(state.getDamageReasonId());
            }
            if (returnedFieldsContains("ReceivedBy")) {
                dto.setReceivedBy(state.getReceivedBy());
            }
            if (returnedFieldsContains("DatetimeReceived")) {
                dto.setDatetimeReceived(state.getDatetimeReceived());
            }
            if (returnedFieldsContains("ItemDescription")) {
                dto.setItemDescription(state.getItemDescription());
            }
            if (returnedFieldsContains("AcceptedQuantity")) {
                dto.setAcceptedQuantity(state.getAcceptedQuantity());
            }
            if (returnedFieldsContains("RejectedQuantity")) {
                dto.setRejectedQuantity(state.getRejectedQuantity());
            }
            if (returnedFieldsContains("DamagedQuantity")) {
                dto.setDamagedQuantity(state.getDamagedQuantity());
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

