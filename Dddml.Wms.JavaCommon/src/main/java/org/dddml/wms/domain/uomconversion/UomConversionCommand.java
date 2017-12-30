package org.dddml.wms.domain.uomconversion;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface UomConversionCommand extends Command
{
    UomConversionId getUomConversionId();

    void setUomConversionId(UomConversionId uomConversionId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(UomConversionState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((UomConversionCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((UomConversionCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(UomConversionCommand c) {
        return ((c instanceof UomConversionCommand.CreateUomConversion) 
            && c.getVersion().equals(UomConversionState.VERSION_NULL));
    }

    interface CreateOrMergePatchUomConversion extends UomConversionCommand
    {
        Double getConversionFactor();

        void setConversionFactor(Double conversionFactor);

        String getCustomMethodId();

        void setCustomMethodId(String customMethodId);

        Long getDecimalScale();

        void setDecimalScale(Long decimalScale);

        String getRoundingMode();

        void setRoundingMode(String roundingMode);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateUomConversion extends CreateOrMergePatchUomConversion
    {
    }

    interface MergePatchUomConversion extends CreateOrMergePatchUomConversion
    {
        Boolean getIsPropertyConversionFactorRemoved();

        void setIsPropertyConversionFactorRemoved(Boolean removed);

        Boolean getIsPropertyCustomMethodIdRemoved();

        void setIsPropertyCustomMethodIdRemoved(Boolean removed);

        Boolean getIsPropertyDecimalScaleRemoved();

        void setIsPropertyDecimalScaleRemoved(Boolean removed);

        Boolean getIsPropertyRoundingModeRemoved();

        void setIsPropertyRoundingModeRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteUomConversion extends UomConversionCommand
	{
	}

}

