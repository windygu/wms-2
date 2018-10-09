package org.dddml.wms.domain.uomconversion;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.uomconversion.UomConversionEvent.*;

public interface UomConversionState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    UomConversionId getUomConversionId();

    Double getConversionFactor();

    String getCustomMethodId();

    Long getDecimalScale();

    String getRoundingMode();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableUomConversionState extends UomConversionState {
        void setUomConversionId(UomConversionId uomConversionId);

        void setConversionFactor(Double conversionFactor);

        void setCustomMethodId(String customMethodId);

        void setDecimalScale(Long decimalScale);

        void setRoundingMode(String roundingMode);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(UomConversionEvent.UomConversionStateCreated e);

        void when(UomConversionEvent.UomConversionStateMergePatched e);

        void when(UomConversionEvent.UomConversionStateDeleted e);
    }

    interface SqlUomConversionState extends MutableUomConversionState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

