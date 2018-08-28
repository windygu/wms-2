package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class OrderShipGroupStateDto
{

    private String shipGroupSeqId;

    public String getShipGroupSeqId()
    {
        return this.shipGroupSeqId;
    }

    public void setShipGroupSeqId(String shipGroupSeqId)
    {
        this.shipGroupSeqId = shipGroupSeqId;
    }

    private String shipmentMethodTypeId;

    public String getShipmentMethodTypeId()
    {
        return this.shipmentMethodTypeId;
    }

    public void setShipmentMethodTypeId(String shipmentMethodTypeId)
    {
        this.shipmentMethodTypeId = shipmentMethodTypeId;
    }

    private String supplierPartyId;

    public String getSupplierPartyId()
    {
        return this.supplierPartyId;
    }

    public void setSupplierPartyId(String supplierPartyId)
    {
        this.supplierPartyId = supplierPartyId;
    }

    private String vendorPartyId;

    public String getVendorPartyId()
    {
        return this.vendorPartyId;
    }

    public void setVendorPartyId(String vendorPartyId)
    {
        this.vendorPartyId = vendorPartyId;
    }

    private String carrierPartyId;

    public String getCarrierPartyId()
    {
        return this.carrierPartyId;
    }

    public void setCarrierPartyId(String carrierPartyId)
    {
        this.carrierPartyId = carrierPartyId;
    }

    private String carrierRoleTypeId;

    public String getCarrierRoleTypeId()
    {
        return this.carrierRoleTypeId;
    }

    public void setCarrierRoleTypeId(String carrierRoleTypeId)
    {
        this.carrierRoleTypeId = carrierRoleTypeId;
    }

    private String facilityId;

    public String getFacilityId()
    {
        return this.facilityId;
    }

    public void setFacilityId(String facilityId)
    {
        this.facilityId = facilityId;
    }

    private String contactMechId;

    public String getContactMechId()
    {
        return this.contactMechId;
    }

    public void setContactMechId(String contactMechId)
    {
        this.contactMechId = contactMechId;
    }

    private String telecomContactMechId;

    public String getTelecomContactMechId()
    {
        return this.telecomContactMechId;
    }

    public void setTelecomContactMechId(String telecomContactMechId)
    {
        this.telecomContactMechId = telecomContactMechId;
    }

    private String trackingNumber;

    public String getTrackingNumber()
    {
        return this.trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber)
    {
        this.trackingNumber = trackingNumber;
    }

    private String contactPartyId;

    public String getContactPartyId()
    {
        return this.contactPartyId;
    }

    public void setContactPartyId(String contactPartyId)
    {
        this.contactPartyId = contactPartyId;
    }

    private String vehiclePlateNumber;

    public String getVehiclePlateNumber()
    {
        return this.vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber)
    {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    private String shippingInstructions;

    public String getShippingInstructions()
    {
        return this.shippingInstructions;
    }

    public void setShippingInstructions(String shippingInstructions)
    {
        this.shippingInstructions = shippingInstructions;
    }

    private String maySplit;

    public String getMaySplit()
    {
        return this.maySplit;
    }

    public void setMaySplit(String maySplit)
    {
        this.maySplit = maySplit;
    }

    private String giftMessage;

    public String getGiftMessage()
    {
        return this.giftMessage;
    }

    public void setGiftMessage(String giftMessage)
    {
        this.giftMessage = giftMessage;
    }

    private String isGift;

    public String getIsGift()
    {
        return this.isGift;
    }

    public void setIsGift(String isGift)
    {
        this.isGift = isGift;
    }

    private java.sql.Timestamp shipAfterDate;

    public java.sql.Timestamp getShipAfterDate()
    {
        return this.shipAfterDate;
    }

    public void setShipAfterDate(java.sql.Timestamp shipAfterDate)
    {
        this.shipAfterDate = shipAfterDate;
    }

    private java.sql.Timestamp shipByDate;

    public java.sql.Timestamp getShipByDate()
    {
        return this.shipByDate;
    }

    public void setShipByDate(java.sql.Timestamp shipByDate)
    {
        this.shipByDate = shipByDate;
    }

    private java.sql.Timestamp estimatedShipDate;

    public java.sql.Timestamp getEstimatedShipDate()
    {
        return this.estimatedShipDate;
    }

    public void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate)
    {
        this.estimatedShipDate = estimatedShipDate;
    }

    private java.sql.Timestamp estimatedDeliveryDate;

    public java.sql.Timestamp getEstimatedDeliveryDate()
    {
        return this.estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate)
    {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    private Long pickwaveId;

    public Long getPickwaveId()
    {
        return this.pickwaveId;
    }

    public void setPickwaveId(Long pickwaveId)
    {
        this.pickwaveId = pickwaveId;
    }

    private Integer numberOfPackages;

    public Integer getNumberOfPackages()
    {
        return this.numberOfPackages;
    }

    public void setNumberOfPackages(Integer numberOfPackages)
    {
        this.numberOfPackages = numberOfPackages;
    }

    private Integer numberOfContainers;

    public Integer getNumberOfContainers()
    {
        return this.numberOfContainers;
    }

    public void setNumberOfContainers(Integer numberOfContainers)
    {
        this.numberOfContainers = numberOfContainers;
    }

    private Integer numberOfPakagesPerContainer;

    public Integer getNumberOfPakagesPerContainer()
    {
        return this.numberOfPakagesPerContainer;
    }

    public void setNumberOfPakagesPerContainer(Integer numberOfPakagesPerContainer)
    {
        this.numberOfPakagesPerContainer = numberOfPakagesPerContainer;
    }

    private String orderShipGroupStatusId;

    public String getOrderShipGroupStatusId()
    {
        return this.orderShipGroupStatusId;
    }

    public void setOrderShipGroupStatusId(String orderShipGroupStatusId)
    {
        this.orderShipGroupStatusId = orderShipGroupStatusId;
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

    private String orderId;

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
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

    private OrderItemShipGroupAssociationStateDto[] orderItemShipGroupAssociations;

    public OrderItemShipGroupAssociationStateDto[] getOrderItemShipGroupAssociations()
    {
        return this.orderItemShipGroupAssociations;
    }	

    public void setOrderItemShipGroupAssociations(OrderItemShipGroupAssociationStateDto[] orderItemShipGroupAssociations)
    {
        this.orderItemShipGroupAssociations = orderItemShipGroupAssociations;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"OrderItemShipGroupAssociations"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public OrderShipGroupStateDto[] toOrderShipGroupStateDtoArray(Iterable<OrderShipGroupState> states) {
            return toOrderShipGroupStateDtoList(states).toArray(new OrderShipGroupStateDto[0]);
        }

        public List<OrderShipGroupStateDto> toOrderShipGroupStateDtoList(Iterable<OrderShipGroupState> states) {
            ArrayList<OrderShipGroupStateDto> stateDtos = new ArrayList();
            for (OrderShipGroupState s : states) {
                OrderShipGroupStateDto dto = toOrderShipGroupStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public OrderShipGroupStateDto toOrderShipGroupStateDto(OrderShipGroupState state)
        {
            if(state == null) {
                return null;
            }
            OrderShipGroupStateDto dto = new OrderShipGroupStateDto();
            if (returnedFieldsContains("ShipGroupSeqId")) {
                dto.setShipGroupSeqId(state.getShipGroupSeqId());
            }
            if (returnedFieldsContains("ShipmentMethodTypeId")) {
                dto.setShipmentMethodTypeId(state.getShipmentMethodTypeId());
            }
            if (returnedFieldsContains("SupplierPartyId")) {
                dto.setSupplierPartyId(state.getSupplierPartyId());
            }
            if (returnedFieldsContains("VendorPartyId")) {
                dto.setVendorPartyId(state.getVendorPartyId());
            }
            if (returnedFieldsContains("CarrierPartyId")) {
                dto.setCarrierPartyId(state.getCarrierPartyId());
            }
            if (returnedFieldsContains("CarrierRoleTypeId")) {
                dto.setCarrierRoleTypeId(state.getCarrierRoleTypeId());
            }
            if (returnedFieldsContains("FacilityId")) {
                dto.setFacilityId(state.getFacilityId());
            }
            if (returnedFieldsContains("ContactMechId")) {
                dto.setContactMechId(state.getContactMechId());
            }
            if (returnedFieldsContains("TelecomContactMechId")) {
                dto.setTelecomContactMechId(state.getTelecomContactMechId());
            }
            if (returnedFieldsContains("TrackingNumber")) {
                dto.setTrackingNumber(state.getTrackingNumber());
            }
            if (returnedFieldsContains("ContactPartyId")) {
                dto.setContactPartyId(state.getContactPartyId());
            }
            if (returnedFieldsContains("VehiclePlateNumber")) {
                dto.setVehiclePlateNumber(state.getVehiclePlateNumber());
            }
            if (returnedFieldsContains("ShippingInstructions")) {
                dto.setShippingInstructions(state.getShippingInstructions());
            }
            if (returnedFieldsContains("MaySplit")) {
                dto.setMaySplit(state.getMaySplit());
            }
            if (returnedFieldsContains("GiftMessage")) {
                dto.setGiftMessage(state.getGiftMessage());
            }
            if (returnedFieldsContains("IsGift")) {
                dto.setIsGift(state.getIsGift());
            }
            if (returnedFieldsContains("ShipAfterDate")) {
                dto.setShipAfterDate(state.getShipAfterDate());
            }
            if (returnedFieldsContains("ShipByDate")) {
                dto.setShipByDate(state.getShipByDate());
            }
            if (returnedFieldsContains("EstimatedShipDate")) {
                dto.setEstimatedShipDate(state.getEstimatedShipDate());
            }
            if (returnedFieldsContains("EstimatedDeliveryDate")) {
                dto.setEstimatedDeliveryDate(state.getEstimatedDeliveryDate());
            }
            if (returnedFieldsContains("PickwaveId")) {
                dto.setPickwaveId(state.getPickwaveId());
            }
            if (returnedFieldsContains("NumberOfPackages")) {
                dto.setNumberOfPackages(state.getNumberOfPackages());
            }
            if (returnedFieldsContains("NumberOfContainers")) {
                dto.setNumberOfContainers(state.getNumberOfContainers());
            }
            if (returnedFieldsContains("NumberOfPakagesPerContainer")) {
                dto.setNumberOfPakagesPerContainer(state.getNumberOfPakagesPerContainer());
            }
            if (returnedFieldsContains("OrderShipGroupStatusId")) {
                dto.setOrderShipGroupStatusId(state.getOrderShipGroupStatusId());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("OrderId")) {
                dto.setOrderId(state.getOrderId());
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
            if (returnedFieldsContains("OrderItemShipGroupAssociations")) {
                ArrayList<OrderItemShipGroupAssociationStateDto> arrayList = new ArrayList();
                if (state.getOrderItemShipGroupAssociations() != null) {
                    OrderItemShipGroupAssociationStateDto.DtoConverter conv = new OrderItemShipGroupAssociationStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "OrderItemShipGroupAssociations");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (OrderItemShipGroupAssociationState s : state.getOrderItemShipGroupAssociations()) {
                        arrayList.add(conv.toOrderItemShipGroupAssociationStateDto(s));
                    }
                }
                dto.setOrderItemShipGroupAssociations(arrayList.toArray(new OrderItemShipGroupAssociationStateDto[0]));
            }
            return dto;
        }

    }
}

