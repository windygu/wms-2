package org.dddml.wms.domain.supplierproduct;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractSupplierProductStateCommandConverter<TCreateSupplierProduct extends SupplierProductCommand.CreateSupplierProduct, TMergePatchSupplierProduct extends SupplierProductCommand.MergePatchSupplierProduct, TDeleteSupplierProduct extends SupplierProductCommand.DeleteSupplierProduct>
{
    public SupplierProductCommand toCreateOrMergePatchSupplierProduct(SupplierProductState state)
    {
        //where TCreateSupplierProduct : ICreateSupplierProduct, new()
        //where TMergePatchSupplierProduct : IMergePatchSupplierProduct, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateSupplierProduct(state);
        }
        else 
        {
            return toMergePatchSupplierProduct(state);
        }
    }

    public TDeleteSupplierProduct toDeleteSupplierProduct(SupplierProductState state) //where TDeleteSupplierProduct : IDeleteSupplierProduct, new()
    {
        TDeleteSupplierProduct cmd = newDeleteSupplierProduct();
        cmd.setSupplierProductId(state.getSupplierProductId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchSupplierProduct toMergePatchSupplierProduct(SupplierProductState state) //where TMergePatchSupplierProduct : IMergePatchSupplierProduct, new()
    {
        TMergePatchSupplierProduct cmd = newMergePatchSupplierProduct();

        cmd.setVersion(state.getVersion());

        cmd.setSupplierProductId(state.getSupplierProductId());
        cmd.setAvailableThruDate(state.getAvailableThruDate());
        cmd.setSupplierPrefOrderId(state.getSupplierPrefOrderId());
        cmd.setSupplierRatingTypeId(state.getSupplierRatingTypeId());
        cmd.setStandardLeadTimeDays(state.getStandardLeadTimeDays());
        cmd.setManufacturingLeadTimeDays(state.getManufacturingLeadTimeDays());
        cmd.setDeliveryLeadTimeDays(state.getDeliveryLeadTimeDays());
        cmd.setQuantityUomId(state.getQuantityUomId());
        cmd.setLastPrice(state.getLastPrice());
        cmd.setShippingPrice(state.getShippingPrice());
        cmd.setExternalProductName(state.getExternalProductName());
        cmd.setExternalProductId(state.getExternalProductId());
        cmd.setCanDropShip(state.getCanDropShip());
        cmd.setComments(state.getComments());
        cmd.setActive(state.getActive());
            
        if (state.getAvailableThruDate() == null) { cmd.setIsPropertyAvailableThruDateRemoved(true); }
        if (state.getSupplierPrefOrderId() == null) { cmd.setIsPropertySupplierPrefOrderIdRemoved(true); }
        if (state.getSupplierRatingTypeId() == null) { cmd.setIsPropertySupplierRatingTypeIdRemoved(true); }
        if (state.getStandardLeadTimeDays() == null) { cmd.setIsPropertyStandardLeadTimeDaysRemoved(true); }
        if (state.getManufacturingLeadTimeDays() == null) { cmd.setIsPropertyManufacturingLeadTimeDaysRemoved(true); }
        if (state.getDeliveryLeadTimeDays() == null) { cmd.setIsPropertyDeliveryLeadTimeDaysRemoved(true); }
        if (state.getQuantityUomId() == null) { cmd.setIsPropertyQuantityUomIdRemoved(true); }
        if (state.getLastPrice() == null) { cmd.setIsPropertyLastPriceRemoved(true); }
        if (state.getShippingPrice() == null) { cmd.setIsPropertyShippingPriceRemoved(true); }
        if (state.getExternalProductName() == null) { cmd.setIsPropertyExternalProductNameRemoved(true); }
        if (state.getExternalProductId() == null) { cmd.setIsPropertyExternalProductIdRemoved(true); }
        if (state.getCanDropShip() == null) { cmd.setIsPropertyCanDropShipRemoved(true); }
        if (state.getComments() == null) { cmd.setIsPropertyCommentsRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateSupplierProduct toCreateSupplierProduct(SupplierProductState state) //where TCreateSupplierProduct : ICreateSupplierProduct, new()
    {
        TCreateSupplierProduct cmd = newCreateSupplierProduct();

        cmd.setVersion(state.getVersion());
        cmd.setSupplierProductId(state.getSupplierProductId());
        cmd.setAvailableThruDate(state.getAvailableThruDate());
        cmd.setSupplierPrefOrderId(state.getSupplierPrefOrderId());
        cmd.setSupplierRatingTypeId(state.getSupplierRatingTypeId());
        cmd.setStandardLeadTimeDays(state.getStandardLeadTimeDays());
        cmd.setManufacturingLeadTimeDays(state.getManufacturingLeadTimeDays());
        cmd.setDeliveryLeadTimeDays(state.getDeliveryLeadTimeDays());
        cmd.setQuantityUomId(state.getQuantityUomId());
        cmd.setLastPrice(state.getLastPrice());
        cmd.setShippingPrice(state.getShippingPrice());
        cmd.setExternalProductName(state.getExternalProductName());
        cmd.setExternalProductId(state.getExternalProductId());
        cmd.setCanDropShip(state.getCanDropShip());
        cmd.setComments(state.getComments());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateSupplierProduct newCreateSupplierProduct();

    protected abstract TMergePatchSupplierProduct newMergePatchSupplierProduct(); 

    protected abstract TDeleteSupplierProduct newDeleteSupplierProduct();

    public static class SimpleSupplierProductStateCommandConverter extends AbstractSupplierProductStateCommandConverter<AbstractSupplierProductCommand.SimpleCreateSupplierProduct, AbstractSupplierProductCommand.SimpleMergePatchSupplierProduct, AbstractSupplierProductCommand.SimpleDeleteSupplierProduct>
    {
        @Override
        protected AbstractSupplierProductCommand.SimpleCreateSupplierProduct newCreateSupplierProduct() {
            return new AbstractSupplierProductCommand.SimpleCreateSupplierProduct();
        }

        @Override
        protected AbstractSupplierProductCommand.SimpleMergePatchSupplierProduct newMergePatchSupplierProduct() {
            return new AbstractSupplierProductCommand.SimpleMergePatchSupplierProduct();
        }

        @Override
        protected AbstractSupplierProductCommand.SimpleDeleteSupplierProduct newDeleteSupplierProduct() {
            return new AbstractSupplierProductCommand.SimpleDeleteSupplierProduct();
        }


    }

}

