package org.dddml.wms.domain.shipmentpackagecontentmvo;

import java.util.*;
import org.dddml.wms.domain.shipmentpackage.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface ShipmentPackageContentMvoCommand extends Command
{
    ShipmentPackageContentId getShipmentPackageContentId();

    void setShipmentPackageContentId(ShipmentPackageContentId shipmentPackageContentId);

    Long getShipmentPackageVersion();

    void setShipmentPackageVersion(Long shipmentPackageVersion);

    static void throwOnInvalidStateTransition(ShipmentPackageContentMvoState state, Command c) {
        if (state.getShipmentPackageVersion() == null)
        {
            if (isCommandCreate((ShipmentPackageContentMvoCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((ShipmentPackageContentMvoCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(ShipmentPackageContentMvoCommand c) {
        return ((c instanceof ShipmentPackageContentMvoCommand.CreateShipmentPackageContentMvo) 
            && c.getShipmentPackageVersion().equals(ShipmentPackageContentMvoState.VERSION_NULL));
    }

    interface CreateOrMergePatchShipmentPackageContentMvo extends ShipmentPackageContentMvoCommand
    {
        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        String getSubProductId();

        void setSubProductId(String subProductId);

        java.math.BigDecimal getSubProductQuantity();

        void setSubProductQuantity(java.math.BigDecimal subProductQuantity);

        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        String getShipmentPackageShipmentBoxTypeId();

        void setShipmentPackageShipmentBoxTypeId(String shipmentPackageShipmentBoxTypeId);

        java.sql.Timestamp getShipmentPackageDateCreated();

        void setShipmentPackageDateCreated(java.sql.Timestamp shipmentPackageDateCreated);

        java.math.BigDecimal getShipmentPackageBoxLength();

        void setShipmentPackageBoxLength(java.math.BigDecimal shipmentPackageBoxLength);

        java.math.BigDecimal getShipmentPackageBoxHeight();

        void setShipmentPackageBoxHeight(java.math.BigDecimal shipmentPackageBoxHeight);

        java.math.BigDecimal getShipmentPackageBoxWidth();

        void setShipmentPackageBoxWidth(java.math.BigDecimal shipmentPackageBoxWidth);

        String getShipmentPackageDimensionUomId();

        void setShipmentPackageDimensionUomId(String shipmentPackageDimensionUomId);

        java.math.BigDecimal getShipmentPackageWeight();

        void setShipmentPackageWeight(java.math.BigDecimal shipmentPackageWeight);

        String getShipmentPackageWeightUomId();

        void setShipmentPackageWeightUomId(String shipmentPackageWeightUomId);

        java.math.BigDecimal getShipmentPackageInsuredValue();

        void setShipmentPackageInsuredValue(java.math.BigDecimal shipmentPackageInsuredValue);

        String getShipmentPackageCreatedBy();

        void setShipmentPackageCreatedBy(String shipmentPackageCreatedBy);

        Date getShipmentPackageCreatedAt();

        void setShipmentPackageCreatedAt(Date shipmentPackageCreatedAt);

        String getShipmentPackageUpdatedBy();

        void setShipmentPackageUpdatedBy(String shipmentPackageUpdatedBy);

        Date getShipmentPackageUpdatedAt();

        void setShipmentPackageUpdatedAt(Date shipmentPackageUpdatedAt);

        Boolean getShipmentPackageActive();

        void setShipmentPackageActive(Boolean shipmentPackageActive);

        Boolean getShipmentPackageDeleted();

        void setShipmentPackageDeleted(Boolean shipmentPackageDeleted);

    }

    interface CreateShipmentPackageContentMvo extends CreateOrMergePatchShipmentPackageContentMvo
    {
    }

    interface MergePatchShipmentPackageContentMvo extends CreateOrMergePatchShipmentPackageContentMvo
    {
        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertySubProductIdRemoved();

        void setIsPropertySubProductIdRemoved(Boolean removed);

        Boolean getIsPropertySubProductQuantityRemoved();

        void setIsPropertySubProductQuantityRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageShipmentBoxTypeIdRemoved();

        void setIsPropertyShipmentPackageShipmentBoxTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageDateCreatedRemoved();

        void setIsPropertyShipmentPackageDateCreatedRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageBoxLengthRemoved();

        void setIsPropertyShipmentPackageBoxLengthRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageBoxHeightRemoved();

        void setIsPropertyShipmentPackageBoxHeightRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageBoxWidthRemoved();

        void setIsPropertyShipmentPackageBoxWidthRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageDimensionUomIdRemoved();

        void setIsPropertyShipmentPackageDimensionUomIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageWeightRemoved();

        void setIsPropertyShipmentPackageWeightRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageWeightUomIdRemoved();

        void setIsPropertyShipmentPackageWeightUomIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageInsuredValueRemoved();

        void setIsPropertyShipmentPackageInsuredValueRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageCreatedByRemoved();

        void setIsPropertyShipmentPackageCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageCreatedAtRemoved();

        void setIsPropertyShipmentPackageCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageUpdatedByRemoved();

        void setIsPropertyShipmentPackageUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageUpdatedAtRemoved();

        void setIsPropertyShipmentPackageUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageActiveRemoved();

        void setIsPropertyShipmentPackageActiveRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageDeletedRemoved();

        void setIsPropertyShipmentPackageDeletedRemoved(Boolean removed);

    }

	interface DeleteShipmentPackageContentMvo extends ShipmentPackageContentMvoCommand
	{
	}

}

