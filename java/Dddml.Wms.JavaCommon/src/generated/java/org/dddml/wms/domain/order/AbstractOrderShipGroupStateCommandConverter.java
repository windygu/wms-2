package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractOrderShipGroupStateCommandConverter<TCreateOrderShipGroup extends OrderShipGroupCommand.CreateOrderShipGroup, TMergePatchOrderShipGroup extends OrderShipGroupCommand.MergePatchOrderShipGroup, TRemoveOrderShipGroup extends OrderShipGroupCommand.RemoveOrderShipGroup, TCreateOrderItemShipGroupAssociation extends OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation, TMergePatchOrderItemShipGroupAssociation extends OrderItemShipGroupAssociationCommand.MergePatchOrderItemShipGroupAssociation, TRemoveOrderItemShipGroupAssociation extends OrderItemShipGroupAssociationCommand.RemoveOrderItemShipGroupAssociation>
{
    public OrderShipGroupCommand toCreateOrMergePatchOrderShipGroup(OrderShipGroupState state)
    {
        //where TCreateOrderShipGroup : ICreateOrderShipGroup, new()
        //where TMergePatchOrderShipGroup : IMergePatchOrderShipGroup, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateOrderShipGroup(state);
        }
        else 
        {
            return toMergePatchOrderShipGroup(state);
        }
    }

    public TRemoveOrderShipGroup toRemoveOrderShipGroup(OrderShipGroupState state) //where TRemoveOrderShipGroup : IRemoveOrderShipGroup, new()
    {
        TRemoveOrderShipGroup cmd = newRemoveOrderShipGroup();
        cmd.setShipGroupSeqId(state.getShipGroupSeqId());
        return cmd;
    }

    public TMergePatchOrderShipGroup toMergePatchOrderShipGroup(OrderShipGroupState state) //where TMergePatchOrderShipGroup : IMergePatchOrderShipGroup, new()
    {
        TMergePatchOrderShipGroup cmd = newMergePatchOrderShipGroup();

        cmd.setShipGroupSeqId(state.getShipGroupSeqId());
        cmd.setShipmentMethodTypeId(state.getShipmentMethodTypeId());
        cmd.setSupplierPartyId(state.getSupplierPartyId());
        cmd.setVendorPartyId(state.getVendorPartyId());
        cmd.setCarrierPartyId(state.getCarrierPartyId());
        cmd.setCarrierRoleTypeId(state.getCarrierRoleTypeId());
        cmd.setFacilityId(state.getFacilityId());
        cmd.setContactMechId(state.getContactMechId());
        cmd.setTelecomContactMechId(state.getTelecomContactMechId());
        cmd.setTrackingNumber(state.getTrackingNumber());
        cmd.setShippingInstructions(state.getShippingInstructions());
        cmd.setMaySplit(state.getMaySplit());
        cmd.setGiftMessage(state.getGiftMessage());
        cmd.setIsGift(state.getIsGift());
        cmd.setShipAfterDate(state.getShipAfterDate());
        cmd.setShipByDate(state.getShipByDate());
        cmd.setEstimatedShipDate(state.getEstimatedShipDate());
        cmd.setEstimatedDeliveryDate(state.getEstimatedDeliveryDate());
        cmd.setPickwaveId(state.getPickwaveId());
        cmd.setActive(state.getActive());
        cmd.setOrderId(state.getOrderId());
            
        if (state.getShipmentMethodTypeId() == null) { cmd.setIsPropertyShipmentMethodTypeIdRemoved(true); }
        if (state.getSupplierPartyId() == null) { cmd.setIsPropertySupplierPartyIdRemoved(true); }
        if (state.getVendorPartyId() == null) { cmd.setIsPropertyVendorPartyIdRemoved(true); }
        if (state.getCarrierPartyId() == null) { cmd.setIsPropertyCarrierPartyIdRemoved(true); }
        if (state.getCarrierRoleTypeId() == null) { cmd.setIsPropertyCarrierRoleTypeIdRemoved(true); }
        if (state.getFacilityId() == null) { cmd.setIsPropertyFacilityIdRemoved(true); }
        if (state.getContactMechId() == null) { cmd.setIsPropertyContactMechIdRemoved(true); }
        if (state.getTelecomContactMechId() == null) { cmd.setIsPropertyTelecomContactMechIdRemoved(true); }
        if (state.getTrackingNumber() == null) { cmd.setIsPropertyTrackingNumberRemoved(true); }
        if (state.getShippingInstructions() == null) { cmd.setIsPropertyShippingInstructionsRemoved(true); }
        if (state.getMaySplit() == null) { cmd.setIsPropertyMaySplitRemoved(true); }
        if (state.getGiftMessage() == null) { cmd.setIsPropertyGiftMessageRemoved(true); }
        if (state.getIsGift() == null) { cmd.setIsPropertyIsGiftRemoved(true); }
        if (state.getShipAfterDate() == null) { cmd.setIsPropertyShipAfterDateRemoved(true); }
        if (state.getShipByDate() == null) { cmd.setIsPropertyShipByDateRemoved(true); }
        if (state.getEstimatedShipDate() == null) { cmd.setIsPropertyEstimatedShipDateRemoved(true); }
        if (state.getEstimatedDeliveryDate() == null) { cmd.setIsPropertyEstimatedDeliveryDateRemoved(true); }
        if (state.getPickwaveId() == null) { cmd.setIsPropertyPickwaveIdRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        for (OrderItemShipGroupAssociationState d : state.getOrderItemShipGroupAssociations())
        {
            OrderItemShipGroupAssociationCommand c = getOrderItemShipGroupAssociationStateCommandConverter().toCreateOrMergePatchOrderItemShipGroupAssociation(d);
            cmd.getOrderItemShipGroupAssociationCommands().add(c);
        }
        return cmd;
    }

    public TCreateOrderShipGroup toCreateOrderShipGroup(OrderShipGroupState state) //where TCreateOrderShipGroup : ICreateOrderShipGroup, new()
    {
        TCreateOrderShipGroup cmd = newCreateOrderShipGroup();

        cmd.setShipGroupSeqId(state.getShipGroupSeqId());
        cmd.setShipmentMethodTypeId(state.getShipmentMethodTypeId());
        cmd.setSupplierPartyId(state.getSupplierPartyId());
        cmd.setVendorPartyId(state.getVendorPartyId());
        cmd.setCarrierPartyId(state.getCarrierPartyId());
        cmd.setCarrierRoleTypeId(state.getCarrierRoleTypeId());
        cmd.setFacilityId(state.getFacilityId());
        cmd.setContactMechId(state.getContactMechId());
        cmd.setTelecomContactMechId(state.getTelecomContactMechId());
        cmd.setTrackingNumber(state.getTrackingNumber());
        cmd.setShippingInstructions(state.getShippingInstructions());
        cmd.setMaySplit(state.getMaySplit());
        cmd.setGiftMessage(state.getGiftMessage());
        cmd.setIsGift(state.getIsGift());
        cmd.setShipAfterDate(state.getShipAfterDate());
        cmd.setShipByDate(state.getShipByDate());
        cmd.setEstimatedShipDate(state.getEstimatedShipDate());
        cmd.setEstimatedDeliveryDate(state.getEstimatedDeliveryDate());
        cmd.setPickwaveId(state.getPickwaveId());
        cmd.setActive(state.getActive());
        cmd.setOrderId(state.getOrderId());
        for (OrderItemShipGroupAssociationState d : state.getOrderItemShipGroupAssociations())
        {
            OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation c = getOrderItemShipGroupAssociationStateCommandConverter().toCreateOrderItemShipGroupAssociation(d);
            cmd.getOrderItemShipGroupAssociations().add(c);
        }
        return cmd;
    }

    protected abstract AbstractOrderItemShipGroupAssociationStateCommandConverter<TCreateOrderItemShipGroupAssociation, TMergePatchOrderItemShipGroupAssociation, TRemoveOrderItemShipGroupAssociation>
        getOrderItemShipGroupAssociationStateCommandConverter();

    protected abstract TCreateOrderShipGroup newCreateOrderShipGroup();

    protected abstract TMergePatchOrderShipGroup newMergePatchOrderShipGroup(); 

    protected abstract TRemoveOrderShipGroup newRemoveOrderShipGroup();

    public static class SimpleOrderShipGroupStateCommandConverter extends AbstractOrderShipGroupStateCommandConverter<AbstractOrderShipGroupCommand.SimpleCreateOrderShipGroup, AbstractOrderShipGroupCommand.SimpleMergePatchOrderShipGroup, AbstractOrderShipGroupCommand.SimpleRemoveOrderShipGroup, AbstractOrderItemShipGroupAssociationCommand.SimpleCreateOrderItemShipGroupAssociation, AbstractOrderItemShipGroupAssociationCommand.SimpleMergePatchOrderItemShipGroupAssociation, AbstractOrderItemShipGroupAssociationCommand.SimpleRemoveOrderItemShipGroupAssociation>
    {
        @Override
        protected AbstractOrderShipGroupCommand.SimpleCreateOrderShipGroup newCreateOrderShipGroup() {
            return new AbstractOrderShipGroupCommand.SimpleCreateOrderShipGroup();
        }

        @Override
        protected AbstractOrderShipGroupCommand.SimpleMergePatchOrderShipGroup newMergePatchOrderShipGroup() {
            return new AbstractOrderShipGroupCommand.SimpleMergePatchOrderShipGroup();
        }

        @Override
        protected AbstractOrderShipGroupCommand.SimpleRemoveOrderShipGroup newRemoveOrderShipGroup() {
            return new AbstractOrderShipGroupCommand.SimpleRemoveOrderShipGroup();
        }

        @Override
        protected AbstractOrderItemShipGroupAssociationStateCommandConverter<AbstractOrderItemShipGroupAssociationCommand.SimpleCreateOrderItemShipGroupAssociation, AbstractOrderItemShipGroupAssociationCommand.SimpleMergePatchOrderItemShipGroupAssociation, AbstractOrderItemShipGroupAssociationCommand.SimpleRemoveOrderItemShipGroupAssociation> getOrderItemShipGroupAssociationStateCommandConverter()
        {
            return new AbstractOrderItemShipGroupAssociationStateCommandConverter.SimpleOrderItemShipGroupAssociationStateCommandConverter();
        }


    }

}

