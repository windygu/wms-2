package org.dddml.wms.domain.documenttype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractDocumentTypeCommand extends AbstractCommand implements DocumentTypeCommand
{
    private String documentTypeId;

    public String getDocumentTypeId()
    {
        return this.documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId)
    {
        this.documentTypeId = documentTypeId;
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


    public static abstract class AbstractCreateOrMergePatchDocumentType extends AbstractDocumentTypeCommand implements CreateOrMergePatchDocumentType
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

        private String parentDocumentTypeId;

        public String getParentDocumentTypeId()
        {
            return this.parentDocumentTypeId;
        }

        public void setParentDocumentTypeId(String parentDocumentTypeId)
        {
            this.parentDocumentTypeId = parentDocumentTypeId;
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

    public static abstract class AbstractCreateDocumentType extends AbstractCreateOrMergePatchDocumentType implements CreateDocumentType
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchDocumentType extends AbstractCreateOrMergePatchDocumentType implements MergePatchDocumentType
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

        private Boolean isPropertyParentDocumentTypeIdRemoved;

        public Boolean getIsPropertyParentDocumentTypeIdRemoved()
        {
            return this.isPropertyParentDocumentTypeIdRemoved;
        }

        public void setIsPropertyParentDocumentTypeIdRemoved(Boolean removed)
        {
            this.isPropertyParentDocumentTypeIdRemoved = removed;
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

    public static class SimpleCreateDocumentType extends AbstractCreateDocumentType
    {
    }

    
    public static class SimpleMergePatchDocumentType extends AbstractMergePatchDocumentType
    {
    }

    
	public static class SimpleDeleteDocumentType extends AbstractDocumentTypeCommand implements DeleteDocumentType
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

