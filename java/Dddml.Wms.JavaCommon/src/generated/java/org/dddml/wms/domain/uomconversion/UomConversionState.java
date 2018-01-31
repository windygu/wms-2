package org.dddml.wms.domain.uomconversion;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.uomconversion.UomConversionStateEvent.*;

public interface UomConversionState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    UomConversionId getUomConversionId();

    void setUomConversionId(UomConversionId uomConversionId);

    Double getConversionFactor();

    void setConversionFactor(Double conversionFactor);

    String getCustomMethodId();

    void setCustomMethodId(String customMethodId);

    Long getDecimalScale();

    void setDecimalScale(Long decimalScale);

    String getRoundingMode();

    void setRoundingMode(String roundingMode);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(UomConversionStateEvent.UomConversionStateCreated e);

    void when(UomConversionStateEvent.UomConversionStateMergePatched e);

    void when(UomConversionStateEvent.UomConversionStateDeleted e);
    
}

