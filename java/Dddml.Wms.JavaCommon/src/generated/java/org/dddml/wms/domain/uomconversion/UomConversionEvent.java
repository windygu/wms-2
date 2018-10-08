package org.dddml.wms.domain.uomconversion;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface UomConversionEvent extends Event {

    interface SqlUomConversionEvent extends UomConversionEvent {
        UomConversionEventId getUomConversionEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    UomConversionId getUomConversionId();

    //void setUomConversionId(UomConversionId uomConversionId);

    Long getVersion();
    
    //void getVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface UomConversionStateEvent extends UomConversionEvent {
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

    interface UomConversionStateCreated extends UomConversionStateEvent
    {
    
    }


    interface UomConversionStateMergePatched extends UomConversionStateEvent
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

    interface UomConversionStateDeleted extends UomConversionStateEvent
    {
    }


}

