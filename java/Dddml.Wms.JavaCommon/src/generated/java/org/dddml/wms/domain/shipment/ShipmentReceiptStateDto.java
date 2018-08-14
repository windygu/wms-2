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

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
    }

    private String locatorId;

    public String getLocatorId()
    {
        return this.locatorId;
    }

    public void setLocatorId(String locatorId)
    {
        this.locatorId = locatorId;
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

    private String shipmentPackageSeqId;

    public String getShipmentPackageSeqId()
    {
        return this.shipmentPackageSeqId;
    }

    public void setShipmentPackageSeqId(String shipmentPackageSeqId)
    {
        this.shipmentPackageSeqId = shipmentPackageSeqId;
    }

    private String orderId;

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    private String orderItemSeqId;

    public String getOrderItemSeqId()
    {
        return this.orderItemSeqId;
    }

    public void setOrderItemSeqId(String orderItemSeqId)
    {
        this.orderItemSeqId = orderItemSeqId;
    }

    private String returnId;

    public String getReturnId()
    {
        return this.returnId;
    }

    public void setReturnId(String returnId)
    {
        this.returnId = returnId;
    }

    private String returnItemSeqId;

    public String getReturnItemSeqId()
    {
        return this.returnItemSeqId;
    }

    public void setReturnItemSeqId(String returnItemSeqId)
    {
        this.returnItemSeqId = returnItemSeqId;
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

    private ShipmentReceiptImageStateDto[] shipmentReceiptImages;

    public ShipmentReceiptImageStateDto[] getShipmentReceiptImages()
    {
        return this.shipmentReceiptImages;
    }	

    public void setShipmentReceiptImages(ShipmentReceiptImageStateDto[] shipmentReceiptImages)
    {
        this.shipmentReceiptImages = shipmentReceiptImages;
    }

    private String[] damageStatusIds;

    public String[] getDamageStatusIds() {
        return this.damageStatusIds;
    }

    public void setDamageStatusIds(String[] damageStatusIds) {
        this.damageStatusIds = damageStatusIds;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"ShipmentReceiptImages"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public ShipmentReceiptStateDto[] toShipmentReceiptStateDtoArray(Iterable<ShipmentReceiptState> states) {
            return toShipmentReceiptStateDtoList(states).toArray(new ShipmentReceiptStateDto[0]);
        }

        public List<ShipmentReceiptStateDto> toShipmentReceiptStateDtoList(Iterable<ShipmentReceiptState> states) {
            ArrayList<ShipmentReceiptStateDto> stateDtos = new ArrayList();
            for (ShipmentReceiptState s : states) {
                ShipmentReceiptStateDto dto = toShipmentReceiptStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
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
            if (returnedFieldsContains("AttributeSetInstanceId")) {
                dto.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
            }
            if (returnedFieldsContains("LocatorId")) {
                dto.setLocatorId(state.getLocatorId());
            }
            if (returnedFieldsContains("ShipmentItemSeqId")) {
                dto.setShipmentItemSeqId(state.getShipmentItemSeqId());
            }
            if (returnedFieldsContains("ShipmentPackageSeqId")) {
                dto.setShipmentPackageSeqId(state.getShipmentPackageSeqId());
            }
            if (returnedFieldsContains("OrderId")) {
                dto.setOrderId(state.getOrderId());
            }
            if (returnedFieldsContains("OrderItemSeqId")) {
                dto.setOrderItemSeqId(state.getOrderItemSeqId());
            }
            if (returnedFieldsContains("ReturnId")) {
                dto.setReturnId(state.getReturnId());
            }
            if (returnedFieldsContains("ReturnItemSeqId")) {
                dto.setReturnItemSeqId(state.getReturnItemSeqId());
            }
            if (returnedFieldsContains("RejectionReasonId")) {
                dto.setRejectionReasonId(state.getRejectionReasonId());
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
            if (returnedFieldsContains("DamageStatusIds")) {
                ArrayList<String> arrayList = new ArrayList();
                if (state.getDamageStatusIds() != null) {
                    for (String s : state.getDamageStatusIds()) {
                        arrayList.add(s);
                    }
                }
                dto.setDamageStatusIds(arrayList.toArray(new String[0]));
            }
            if (returnedFieldsContains("ShipmentReceiptImages")) {
                ArrayList<ShipmentReceiptImageStateDto> arrayList = new ArrayList();
                if (state.getShipmentReceiptImages() != null) {
                    ShipmentReceiptImageStateDto.DtoConverter conv = new ShipmentReceiptImageStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "ShipmentReceiptImages");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (ShipmentReceiptImageState s : state.getShipmentReceiptImages()) {
                        arrayList.add(conv.toShipmentReceiptImageStateDto(s));
                    }
                }
                dto.setShipmentReceiptImages(arrayList.toArray(new ShipmentReceiptImageStateDto[0]));
            }
            return dto;
        }

    }
}

