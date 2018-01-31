package org.dddml.wms.domain.uomconversion;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractUomConversionCommand extends AbstractCommand implements UomConversionCommand
{
    private UomConversionId uomConversionId;

    public UomConversionId getUomConversionId()
    {
        return this.uomConversionId;
    }

    public void setUomConversionId(UomConversionId uomConversionId)
    {
        this.uomConversionId = uomConversionId;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    public static abstract class AbstractCreateOrMergePatchUomConversion extends AbstractUomConversionCommand implements CreateOrMergePatchUomConversion
    {
        private Double conversionFactor;

        public Double getConversionFactor()
        {
            return this.conversionFactor;
        }

        public void setConversionFactor(Double conversionFactor)
        {
            this.conversionFactor = conversionFactor;
        }

        private String customMethodId;

        public String getCustomMethodId()
        {
            return this.customMethodId;
        }

        public void setCustomMethodId(String customMethodId)
        {
            this.customMethodId = customMethodId;
        }

        private Long decimalScale;

        public Long getDecimalScale()
        {
            return this.decimalScale;
        }

        public void setDecimalScale(Long decimalScale)
        {
            this.decimalScale = decimalScale;
        }

        private String roundingMode;

        public String getRoundingMode()
        {
            return this.roundingMode;
        }

        public void setRoundingMode(String roundingMode)
        {
            this.roundingMode = roundingMode;
        }

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

    }

    public static abstract class AbstractCreateUomConversion extends AbstractCreateOrMergePatchUomConversion implements CreateUomConversion
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchUomConversion extends AbstractCreateOrMergePatchUomConversion implements MergePatchUomConversion
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyConversionFactorRemoved;

        public Boolean getIsPropertyConversionFactorRemoved()
        {
            return this.isPropertyConversionFactorRemoved;
        }

        public void setIsPropertyConversionFactorRemoved(Boolean removed)
        {
            this.isPropertyConversionFactorRemoved = removed;
        }

        private Boolean isPropertyCustomMethodIdRemoved;

        public Boolean getIsPropertyCustomMethodIdRemoved()
        {
            return this.isPropertyCustomMethodIdRemoved;
        }

        public void setIsPropertyCustomMethodIdRemoved(Boolean removed)
        {
            this.isPropertyCustomMethodIdRemoved = removed;
        }

        private Boolean isPropertyDecimalScaleRemoved;

        public Boolean getIsPropertyDecimalScaleRemoved()
        {
            return this.isPropertyDecimalScaleRemoved;
        }

        public void setIsPropertyDecimalScaleRemoved(Boolean removed)
        {
            this.isPropertyDecimalScaleRemoved = removed;
        }

        private Boolean isPropertyRoundingModeRemoved;

        public Boolean getIsPropertyRoundingModeRemoved()
        {
            return this.isPropertyRoundingModeRemoved;
        }

        public void setIsPropertyRoundingModeRemoved(Boolean removed)
        {
            this.isPropertyRoundingModeRemoved = removed;
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

    }

    public static class SimpleCreateUomConversion extends AbstractCreateUomConversion
    {
    }

    
    public static class SimpleMergePatchUomConversion extends AbstractMergePatchUomConversion
    {
    }

    
	public static class SimpleDeleteUomConversion extends AbstractUomConversionCommand implements DeleteUomConversion
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

