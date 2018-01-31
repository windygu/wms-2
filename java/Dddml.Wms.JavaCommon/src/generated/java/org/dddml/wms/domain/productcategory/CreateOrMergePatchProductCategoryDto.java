package org.dddml.wms.domain.productcategory;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchProductCategoryDto extends AbstractProductCategoryCommandDto
{
    private String productCategoryTypeId;

    public String getProductCategoryTypeId()
    {
        return this.productCategoryTypeId;
    }

    public void setProductCategoryTypeId(String productCategoryTypeId)
    {
        this.productCategoryTypeId = productCategoryTypeId;
    }

    private String primaryParentCategoryId;

    public String getPrimaryParentCategoryId()
    {
        return this.primaryParentCategoryId;
    }

    public void setPrimaryParentCategoryId(String primaryParentCategoryId)
    {
        this.primaryParentCategoryId = primaryParentCategoryId;
    }

    private String categoryName;

    public String getCategoryName()
    {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private String categoryImageUrl;

    public String getCategoryImageUrl()
    {
        return this.categoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl)
    {
        this.categoryImageUrl = categoryImageUrl;
    }

    private String detailScreen;

    public String getDetailScreen()
    {
        return this.detailScreen;
    }

    public void setDetailScreen(String detailScreen)
    {
        this.detailScreen = detailScreen;
    }

    private Boolean showInSelect;

    public Boolean getShowInSelect()
    {
        return this.showInSelect;
    }

    public void setShowInSelect(Boolean showInSelect)
    {
        this.showInSelect = showInSelect;
    }

    private String attributeSetId;

    public String getAttributeSetId()
    {
        return this.attributeSetId;
    }

    public void setAttributeSetId(String attributeSetId)
    {
        this.attributeSetId = attributeSetId;
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

    private Boolean isPropertyProductCategoryTypeIdRemoved;

    public Boolean getIsPropertyProductCategoryTypeIdRemoved()
    {
        return this.isPropertyProductCategoryTypeIdRemoved;
    }

    public void setIsPropertyProductCategoryTypeIdRemoved(Boolean removed)
    {
        this.isPropertyProductCategoryTypeIdRemoved = removed;
    }

    private Boolean isPropertyPrimaryParentCategoryIdRemoved;

    public Boolean getIsPropertyPrimaryParentCategoryIdRemoved()
    {
        return this.isPropertyPrimaryParentCategoryIdRemoved;
    }

    public void setIsPropertyPrimaryParentCategoryIdRemoved(Boolean removed)
    {
        this.isPropertyPrimaryParentCategoryIdRemoved = removed;
    }

    private Boolean isPropertyCategoryNameRemoved;

    public Boolean getIsPropertyCategoryNameRemoved()
    {
        return this.isPropertyCategoryNameRemoved;
    }

    public void setIsPropertyCategoryNameRemoved(Boolean removed)
    {
        this.isPropertyCategoryNameRemoved = removed;
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

    private Boolean isPropertyCategoryImageUrlRemoved;

    public Boolean getIsPropertyCategoryImageUrlRemoved()
    {
        return this.isPropertyCategoryImageUrlRemoved;
    }

    public void setIsPropertyCategoryImageUrlRemoved(Boolean removed)
    {
        this.isPropertyCategoryImageUrlRemoved = removed;
    }

    private Boolean isPropertyDetailScreenRemoved;

    public Boolean getIsPropertyDetailScreenRemoved()
    {
        return this.isPropertyDetailScreenRemoved;
    }

    public void setIsPropertyDetailScreenRemoved(Boolean removed)
    {
        this.isPropertyDetailScreenRemoved = removed;
    }

    private Boolean isPropertyShowInSelectRemoved;

    public Boolean getIsPropertyShowInSelectRemoved()
    {
        return this.isPropertyShowInSelectRemoved;
    }

    public void setIsPropertyShowInSelectRemoved(Boolean removed)
    {
        this.isPropertyShowInSelectRemoved = removed;
    }

    private Boolean isPropertyAttributeSetIdRemoved;

    public Boolean getIsPropertyAttributeSetIdRemoved()
    {
        return this.isPropertyAttributeSetIdRemoved;
    }

    public void setIsPropertyAttributeSetIdRemoved(Boolean removed)
    {
        this.isPropertyAttributeSetIdRemoved = removed;
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

    public void copyTo(AbstractProductCategoryCommand.AbstractCreateOrMergePatchProductCategory command)
    {
        ((AbstractProductCategoryCommandDto) this).copyTo(command);
        command.setProductCategoryTypeId(this.getProductCategoryTypeId());
        command.setPrimaryParentCategoryId(this.getPrimaryParentCategoryId());
        command.setCategoryName(this.getCategoryName());
        command.setDescription(this.getDescription());
        command.setCategoryImageUrl(this.getCategoryImageUrl());
        command.setDetailScreen(this.getDetailScreen());
        command.setShowInSelect(this.getShowInSelect());
        command.setAttributeSetId(this.getAttributeSetId());
        command.setActive(this.getActive());
    }

    public ProductCategoryCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractProductCategoryCommand.SimpleCreateProductCategory command = new AbstractProductCategoryCommand.SimpleCreateProductCategory();
            copyTo((AbstractProductCategoryCommand.AbstractCreateProductCategory) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractProductCategoryCommand.SimpleMergePatchProductCategory command = new AbstractProductCategoryCommand.SimpleMergePatchProductCategory();
            copyTo((AbstractProductCategoryCommand.SimpleMergePatchProductCategory) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractProductCategoryCommand.AbstractCreateProductCategory command)
    {
        copyTo((AbstractProductCategoryCommand.AbstractCreateOrMergePatchProductCategory) command);
    }

    public void copyTo(AbstractProductCategoryCommand.AbstractMergePatchProductCategory command)
    {
        copyTo((AbstractProductCategoryCommand.AbstractCreateOrMergePatchProductCategory) command);
        command.setIsPropertyProductCategoryTypeIdRemoved(this.getIsPropertyProductCategoryTypeIdRemoved());
        command.setIsPropertyPrimaryParentCategoryIdRemoved(this.getIsPropertyPrimaryParentCategoryIdRemoved());
        command.setIsPropertyCategoryNameRemoved(this.getIsPropertyCategoryNameRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyCategoryImageUrlRemoved(this.getIsPropertyCategoryImageUrlRemoved());
        command.setIsPropertyDetailScreenRemoved(this.getIsPropertyDetailScreenRemoved());
        command.setIsPropertyShowInSelectRemoved(this.getIsPropertyShowInSelectRemoved());
        command.setIsPropertyAttributeSetIdRemoved(this.getIsPropertyAttributeSetIdRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateProductCategoryDto extends CreateOrMergePatchProductCategoryDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public ProductCategoryCommand.CreateProductCategory toCreateProductCategory()
        {
            return (ProductCategoryCommand.CreateProductCategory) toCommand();
        }

    }

    public static class MergePatchProductCategoryDto extends CreateOrMergePatchProductCategoryDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public ProductCategoryCommand.MergePatchProductCategory toMergePatchProductCategory()
        {
            return (ProductCategoryCommand.MergePatchProductCategory) toCommand();
        }

    }

}

