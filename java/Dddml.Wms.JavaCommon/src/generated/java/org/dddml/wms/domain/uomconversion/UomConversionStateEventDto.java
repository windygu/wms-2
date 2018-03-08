package org.dddml.wms.domain.uomconversion;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class UomConversionStateEventDto extends AbstractStateEvent
{

    private UomConversionEventId stateEventId;

    UomConversionEventId getStateEventId() {
        if (stateEventId == null) { stateEventId = new UomConversionEventId(); }
        return stateEventId;
    }

    void setStateEventId(UomConversionEventId eventId) {
        this.stateEventId = eventId;
    }

    public UomConversionId getUomConversionId() {
        return getStateEventId().getUomConversionId();
    }

    public void setUomConversionId(UomConversionId uomConversionId) {
        getStateEventId().setUomConversionId(uomConversionId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private Double conversionFactor;

    public Double getConversionFactor() {
        return this.conversionFactor;
    }

    public void setConversionFactor(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    private String customMethodId;

    public String getCustomMethodId() {
        return this.customMethodId;
    }

    public void setCustomMethodId(String customMethodId) {
        this.customMethodId = customMethodId;
    }

    private Long decimalScale;

    public Long getDecimalScale() {
        return this.decimalScale;
    }

    public void setDecimalScale(Long decimalScale) {
        this.decimalScale = decimalScale;
    }

    private String roundingMode;

    public String getRoundingMode() {
        return this.roundingMode;
    }

    public void setRoundingMode(String roundingMode) {
        this.roundingMode = roundingMode;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private Boolean isPropertyConversionFactorRemoved;

    public Boolean getIsPropertyConversionFactorRemoved() {
        return this.isPropertyConversionFactorRemoved;
    }

    public void setIsPropertyConversionFactorRemoved(Boolean removed) {
        this.isPropertyConversionFactorRemoved = removed;
    }

    private Boolean isPropertyCustomMethodIdRemoved;

    public Boolean getIsPropertyCustomMethodIdRemoved() {
        return this.isPropertyCustomMethodIdRemoved;
    }

    public void setIsPropertyCustomMethodIdRemoved(Boolean removed) {
        this.isPropertyCustomMethodIdRemoved = removed;
    }

    private Boolean isPropertyDecimalScaleRemoved;

    public Boolean getIsPropertyDecimalScaleRemoved() {
        return this.isPropertyDecimalScaleRemoved;
    }

    public void setIsPropertyDecimalScaleRemoved(Boolean removed) {
        this.isPropertyDecimalScaleRemoved = removed;
    }

    private Boolean isPropertyRoundingModeRemoved;

    public Boolean getIsPropertyRoundingModeRemoved() {
        return this.isPropertyRoundingModeRemoved;
    }

    public void setIsPropertyRoundingModeRemoved(Boolean removed) {
        this.isPropertyRoundingModeRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class UomConversionStateCreatedDto extends UomConversionStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class UomConversionStateMergePatchedDto extends UomConversionStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class UomConversionStateDeletedDto extends UomConversionStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

