package org.dddml.wms.domain.documenttype;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchDocumentTypeDto extends AbstractDocumentTypeCommandDto
{
    /**
     * Description
     */
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Parent Document Type Id
     */
    private String parentDocumentTypeId;

    public String getParentDocumentTypeId()
    {
        return this.parentDocumentTypeId;
    }

    public void setParentDocumentTypeId(String parentDocumentTypeId)
    {
        this.parentDocumentTypeId = parentDocumentTypeId;
    }

    /**
     * Active
     */
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
        public CreateDocumentTypeDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchDocumentTypeDto extends CreateOrMergePatchDocumentTypeDto
    {
        public MergePatchDocumentTypeDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

