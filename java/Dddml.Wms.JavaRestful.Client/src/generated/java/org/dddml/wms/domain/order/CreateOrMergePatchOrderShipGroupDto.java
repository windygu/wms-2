package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchOrderShipGroupDto extends AbstractOrderShipGroupCommandDto
{
    /**
     * Shipment Method Type Id
     */
    private String shipmentMethodTypeId;

    public String getShipmentMethodTypeId()
    {
        return this.shipmentMethodTypeId;
    }

    public void setShipmentMethodTypeId(String shipmentMethodTypeId)
    {
        this.shipmentMethodTypeId = shipmentMethodTypeId;
    }

    /**
     * Supplier Party Id
     */
    private String supplierPartyId;

    public String getSupplierPartyId()
    {
        return this.supplierPartyId;
    }

    public void setSupplierPartyId(String supplierPartyId)
    {
        this.supplierPartyId = supplierPartyId;
    }

    /**
     * For use with multi-vendor stores, order will be split so that each ship group is associated with only one vendor (only if applicable)
     */
    private String vendorPartyId;

    public String getVendorPartyId()
    {
        return this.vendorPartyId;
    }

    public void setVendorPartyId(String vendorPartyId)
    {
        this.vendorPartyId = vendorPartyId;
    }

    /**
     * Carrier Party Id
     */
    private String carrierPartyId;

    public String getCarrierPartyId()
    {
        return this.carrierPartyId;
    }

    public void setCarrierPartyId(String carrierPartyId)
    {
        this.carrierPartyId = carrierPartyId;
    }

    /**
     * Carrier Role Type Id
     */
    private String carrierRoleTypeId;

    public String getCarrierRoleTypeId()
    {
        return this.carrierRoleTypeId;
    }

    public void setCarrierRoleTypeId(String carrierRoleTypeId)
    {
        this.carrierRoleTypeId = carrierRoleTypeId;
    }

    /**
     * Facility Id
     */
    private String facilityId;

    public String getFacilityId()
    {
        return this.facilityId;
    }

    public void setFacilityId(String facilityId)
    {
        this.facilityId = facilityId;
    }

    /**
     * Contact Mech Id
     */
    private String contactMechId;

    public String getContactMechId()
    {
        return this.contactMechId;
    }

    public void setContactMechId(String contactMechId)
    {
        this.contactMechId = contactMechId;
    }

    /**
     * Telecom Contact Mech Id
     */
    private String telecomContactMechId;

    public String getTelecomContactMechId()
    {
        return this.telecomContactMechId;
    }

    public void setTelecomContactMechId(String telecomContactMechId)
    {
        this.telecomContactMechId = telecomContactMechId;
    }

    /**
     * May Split
     */
    private String maySplit;

    public String getMaySplit()
    {
        return this.maySplit;
    }

    public void setMaySplit(String maySplit)
    {
        this.maySplit = maySplit;
    }

    /**
     * Gift Message
     */
    private String giftMessage;

    public String getGiftMessage()
    {
        return this.giftMessage;
    }

    public void setGiftMessage(String giftMessage)
    {
        this.giftMessage = giftMessage;
    }

    /**
     * Is Gift
     */
    private String isGift;

    public String getIsGift()
    {
        return this.isGift;
    }

    public void setIsGift(String isGift)
    {
        this.isGift = isGift;
    }

    /**
     * Ship After Date
     */
    private java.sql.Timestamp shipAfterDate;

    public java.sql.Timestamp getShipAfterDate()
    {
        return this.shipAfterDate;
    }

    public void setShipAfterDate(java.sql.Timestamp shipAfterDate)
    {
        this.shipAfterDate = shipAfterDate;
    }

    /**
     * Ship By Date
     */
    private java.sql.Timestamp shipByDate;

    public java.sql.Timestamp getShipByDate()
    {
        return this.shipByDate;
    }

    public void setShipByDate(java.sql.Timestamp shipByDate)
    {
        this.shipByDate = shipByDate;
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

    private CreateOrMergePatchOrderItemShipGroupAssociationDto[] orderItemShipGroupAssociations;

    public CreateOrMergePatchOrderItemShipGroupAssociationDto[] getOrderItemShipGroupAssociations()
    {
        return this.orderItemShipGroupAssociations;
    }

    public void setOrderItemShipGroupAssociations(CreateOrMergePatchOrderItemShipGroupAssociationDto[] orderItemShipGroupAssociations)
    {
        this.orderItemShipGroupAssociations = orderItemShipGroupAssociations;
    }

    private Boolean isPropertyShipmentMethodTypeIdRemoved;

    public Boolean getIsPropertyShipmentMethodTypeIdRemoved()
    {
        return this.isPropertyShipmentMethodTypeIdRemoved;
    }

    public void setIsPropertyShipmentMethodTypeIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentMethodTypeIdRemoved = removed;
    }

    private Boolean isPropertySupplierPartyIdRemoved;

    public Boolean getIsPropertySupplierPartyIdRemoved()
    {
        return this.isPropertySupplierPartyIdRemoved;
    }

    public void setIsPropertySupplierPartyIdRemoved(Boolean removed)
    {
        this.isPropertySupplierPartyIdRemoved = removed;
    }

    private Boolean isPropertyVendorPartyIdRemoved;

    public Boolean getIsPropertyVendorPartyIdRemoved()
    {
        return this.isPropertyVendorPartyIdRemoved;
    }

    public void setIsPropertyVendorPartyIdRemoved(Boolean removed)
    {
        this.isPropertyVendorPartyIdRemoved = removed;
    }

    private Boolean isPropertyCarrierPartyIdRemoved;

    public Boolean getIsPropertyCarrierPartyIdRemoved()
    {
        return this.isPropertyCarrierPartyIdRemoved;
    }

    public void setIsPropertyCarrierPartyIdRemoved(Boolean removed)
    {
        this.isPropertyCarrierPartyIdRemoved = removed;
    }

    private Boolean isPropertyCarrierRoleTypeIdRemoved;

    public Boolean getIsPropertyCarrierRoleTypeIdRemoved()
    {
        return this.isPropertyCarrierRoleTypeIdRemoved;
    }

    public void setIsPropertyCarrierRoleTypeIdRemoved(Boolean removed)
    {
        this.isPropertyCarrierRoleTypeIdRemoved = removed;
    }

    private Boolean isPropertyFacilityIdRemoved;

    public Boolean getIsPropertyFacilityIdRemoved()
    {
        return this.isPropertyFacilityIdRemoved;
    }

    public void setIsPropertyFacilityIdRemoved(Boolean removed)
    {
        this.isPropertyFacilityIdRemoved = removed;
    }

    private Boolean isPropertyContactMechIdRemoved;

    public Boolean getIsPropertyContactMechIdRemoved()
    {
        return this.isPropertyContactMechIdRemoved;
    }

    public void setIsPropertyContactMechIdRemoved(Boolean removed)
    {
        this.isPropertyContactMechIdRemoved = removed;
    }

    private Boolean isPropertyTelecomContactMechIdRemoved;

    public Boolean getIsPropertyTelecomContactMechIdRemoved()
    {
        return this.isPropertyTelecomContactMechIdRemoved;
    }

    public void setIsPropertyTelecomContactMechIdRemoved(Boolean removed)
    {
        this.isPropertyTelecomContactMechIdRemoved = removed;
    }

    private Boolean isPropertyMaySplitRemoved;

    public Boolean getIsPropertyMaySplitRemoved()
    {
        return this.isPropertyMaySplitRemoved;
    }

    public void setIsPropertyMaySplitRemoved(Boolean removed)
    {
        this.isPropertyMaySplitRemoved = removed;
    }

    private Boolean isPropertyGiftMessageRemoved;

    public Boolean getIsPropertyGiftMessageRemoved()
    {
        return this.isPropertyGiftMessageRemoved;
    }

    public void setIsPropertyGiftMessageRemoved(Boolean removed)
    {
        this.isPropertyGiftMessageRemoved = removed;
    }

    private Boolean isPropertyIsGiftRemoved;

    public Boolean getIsPropertyIsGiftRemoved()
    {
        return this.isPropertyIsGiftRemoved;
    }

    public void setIsPropertyIsGiftRemoved(Boolean removed)
    {
        this.isPropertyIsGiftRemoved = removed;
    }

    private Boolean isPropertyShipAfterDateRemoved;

    public Boolean getIsPropertyShipAfterDateRemoved()
    {
        return this.isPropertyShipAfterDateRemoved;
    }

    public void setIsPropertyShipAfterDateRemoved(Boolean removed)
    {
        this.isPropertyShipAfterDateRemoved = removed;
    }

    private Boolean isPropertyShipByDateRemoved;

    public Boolean getIsPropertyShipByDateRemoved()
    {
        return this.isPropertyShipByDateRemoved;
    }

    public void setIsPropertyShipByDateRemoved(Boolean removed)
    {
        this.isPropertyShipByDateRemoved = removed;
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

    public static class CreateOrderShipGroupDto extends CreateOrMergePatchOrderShipGroupDto
    {
        public CreateOrderShipGroupDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchOrderShipGroupDto extends CreateOrMergePatchOrderShipGroupDto
    {
        public MergePatchOrderShipGroupDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

