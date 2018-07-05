package org.dddml.wms.domain.documenttype;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchDocumentTypeDto extends AbstractDocumentTypeCommandDto
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

    public static class CreateDocumentTypeDto extends CreateOrMergePatchDocumentTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchDocumentTypeDto extends CreateOrMergePatchDocumentTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

