package org.dddml.wms.domain.product;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractGoodIdentificationCommand extends AbstractCommand implements GoodIdentificationCommand
{
    private String goodIdentificationTypeId;

    public String getGoodIdentificationTypeId()
    {
        return this.goodIdentificationTypeId;
    }

    public void setGoodIdentificationTypeId(String goodIdentificationTypeId)
    {
        this.goodIdentificationTypeId = goodIdentificationTypeId;
    }

    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }


    public static abstract class AbstractCreateOrMergePatchGoodIdentification extends AbstractGoodIdentificationCommand implements CreateOrMergePatchGoodIdentification
    {
        private String idValue;

        public String getIdValue()
        {
            return this.idValue;
        }

        public void setIdValue(String idValue)
        {
            this.idValue = idValue;
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

    public static abstract class AbstractCreateGoodIdentification extends AbstractCreateOrMergePatchGoodIdentification implements CreateGoodIdentification
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchGoodIdentification extends AbstractCreateOrMergePatchGoodIdentification implements MergePatchGoodIdentification
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyIdValueRemoved;

        public Boolean getIsPropertyIdValueRemoved()
        {
            return this.isPropertyIdValueRemoved;
        }

        public void setIsPropertyIdValueRemoved(Boolean removed)
        {
            this.isPropertyIdValueRemoved = removed;
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

    public static class SimpleCreateGoodIdentification extends AbstractCreateGoodIdentification
    {
    }

    
    public static class SimpleMergePatchGoodIdentification extends AbstractMergePatchGoodIdentification
    {
    }

    
	public static class SimpleRemoveGoodIdentification extends AbstractGoodIdentificationCommand implements RemoveGoodIdentification
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_REMOVE;
        }
	}

    

}

