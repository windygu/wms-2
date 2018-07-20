package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface ShipmentPackageCommand extends Command
{
    ShipmentPackageId getShipmentPackageId();

    void setShipmentPackageId(ShipmentPackageId shipmentPackageId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(ShipmentPackageState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((ShipmentPackageCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((ShipmentPackageCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(ShipmentPackageCommand c) {
        return ((c instanceof ShipmentPackageCommand.CreateShipmentPackage) 
            && c.getVersion().equals(ShipmentPackageState.VERSION_NULL));
    }

    interface CreateOrMergePatchShipmentPackage extends ShipmentPackageCommand
    {
        String getShipmentBoxTypeId();

        void setShipmentBoxTypeId(String shipmentBoxTypeId);

        java.sql.Timestamp getDateCreated();

        void setDateCreated(java.sql.Timestamp dateCreated);

        java.math.BigDecimal getBoxLength();

        void setBoxLength(java.math.BigDecimal boxLength);

        java.math.BigDecimal getBoxHeight();

        void setBoxHeight(java.math.BigDecimal boxHeight);

        java.math.BigDecimal getBoxWidth();

        void setBoxWidth(java.math.BigDecimal boxWidth);

        String getDimensionUomId();

        void setDimensionUomId(String dimensionUomId);

        java.math.BigDecimal getWeight();

        void setWeight(java.math.BigDecimal weight);

        String getWeightUomId();

        void setWeightUomId(String weightUomId);

        java.math.BigDecimal getInsuredValue();

        void setInsuredValue(java.math.BigDecimal insuredValue);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateShipmentPackage extends CreateOrMergePatchShipmentPackage
    {
        CreateShipmentPackageContentCommands getShipmentPackageContents();

        ShipmentPackageContentCommand.CreateShipmentPackageContent newCreateShipmentPackageContent();

    }

    interface MergePatchShipmentPackage extends CreateOrMergePatchShipmentPackage
    {
        Boolean getIsPropertyShipmentBoxTypeIdRemoved();

        void setIsPropertyShipmentBoxTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyDateCreatedRemoved();

        void setIsPropertyDateCreatedRemoved(Boolean removed);

        Boolean getIsPropertyBoxLengthRemoved();

        void setIsPropertyBoxLengthRemoved(Boolean removed);

        Boolean getIsPropertyBoxHeightRemoved();

        void setIsPropertyBoxHeightRemoved(Boolean removed);

        Boolean getIsPropertyBoxWidthRemoved();

        void setIsPropertyBoxWidthRemoved(Boolean removed);

        Boolean getIsPropertyDimensionUomIdRemoved();

        void setIsPropertyDimensionUomIdRemoved(Boolean removed);

        Boolean getIsPropertyWeightRemoved();

        void setIsPropertyWeightRemoved(Boolean removed);

        Boolean getIsPropertyWeightUomIdRemoved();

        void setIsPropertyWeightUomIdRemoved(Boolean removed);

        Boolean getIsPropertyInsuredValueRemoved();

        void setIsPropertyInsuredValueRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        ShipmentPackageContentCommands getShipmentPackageContentCommands();

        ShipmentPackageContentCommand.CreateShipmentPackageContent newCreateShipmentPackageContent();

        ShipmentPackageContentCommand.MergePatchShipmentPackageContent newMergePatchShipmentPackageContent();

        ShipmentPackageContentCommand.RemoveShipmentPackageContent newRemoveShipmentPackageContent();

    }

	interface DeleteShipmentPackage extends ShipmentPackageCommand
	{
	}

    interface CreateShipmentPackageContentCommands extends Iterable<ShipmentPackageContentCommand.CreateShipmentPackageContent>
    {
        void add(ShipmentPackageContentCommand.CreateShipmentPackageContent c);

        void remove(ShipmentPackageContentCommand.CreateShipmentPackageContent c);

        void clear();
    }

    interface ShipmentPackageContentCommands extends Iterable<ShipmentPackageContentCommand>
    {
        void add(ShipmentPackageContentCommand c);

        void remove(ShipmentPackageContentCommand c);

        void clear();
    }

}

