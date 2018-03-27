package org.dddml.wms.domain.shipmentmethodtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractShipmentMethodTypeCommand extends AbstractCommand implements ShipmentMethodTypeCommand
{
    private String shipmentMethodTypeId;

    public String getShipmentMethodTypeId()
    {
        return this.shipmentMethodTypeId;
    }

    public void setShipmentMethodTypeId(String shipmentMethodTypeId)
    {
        this.shipmentMethodTypeId = shipmentMethodTypeId;
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


    public static abstract class AbstractCreateOrMergePatchShipmentMethodType extends AbstractShipmentMethodTypeCommand implements CreateOrMergePatchShipmentMethodType
    {
        private String description;

        public String getDescription()
        {
            return this.description;
        }

        public void setDescription(String description)
        {
            this.description = description;
        }

        private Long sequenceNum;

        public Long getSequenceNum()
        {
            return this.sequenceNum;
        }

        public void setSequenceNum(Long sequenceNum)
        {
            this.sequenceNum = sequenceNum;
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

    public static abstract class AbstractCreateShipmentMethodType extends AbstractCreateOrMergePatchShipmentMethodType implements CreateShipmentMethodType
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchShipmentMethodType extends AbstractCreateOrMergePatchShipmentMethodType implements MergePatchShipmentMethodType
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved()
        {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed)
        {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertySequenceNumRemoved;

        public Boolean getIsPropertySequenceNumRemoved()
        {
            return this.isPropertySequenceNumRemoved;
        }

        public void setIsPropertySequenceNumRemoved(Boolean removed)
        {
            this.isPropertySequenceNumRemoved = removed;
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

    public static class SimpleCreateShipmentMethodType extends AbstractCreateShipmentMethodType
    {
    }

    
    public static class SimpleMergePatchShipmentMethodType extends AbstractMergePatchShipmentMethodType
    {
    }

    
	public static class SimpleDeleteShipmentMethodType extends AbstractShipmentMethodTypeCommand implements DeleteShipmentMethodType
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

