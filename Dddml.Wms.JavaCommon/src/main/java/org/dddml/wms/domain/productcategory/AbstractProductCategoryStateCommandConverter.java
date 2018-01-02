package org.dddml.wms.domain.productcategory;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractProductCategoryStateCommandConverter<TCreateProductCategory extends ProductCategoryCommand.CreateProductCategory, TMergePatchProductCategory extends ProductCategoryCommand.MergePatchProductCategory, TDeleteProductCategory extends ProductCategoryCommand.DeleteProductCategory>
{
    public ProductCategoryCommand toCreateOrMergePatchProductCategory(ProductCategoryState state)
    {
        //where TCreateProductCategory : ICreateProductCategory, new()
        //where TMergePatchProductCategory : IMergePatchProductCategory, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateProductCategory(state);
        }
        else 
        {
            return toMergePatchProductCategory(state);
        }
    }

    public TDeleteProductCategory toDeleteProductCategory(ProductCategoryState state) //where TDeleteProductCategory : IDeleteProductCategory, new()
    {
        TDeleteProductCategory cmd = newDeleteProductCategory();
        cmd.setProductCategoryId(state.getProductCategoryId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchProductCategory toMergePatchProductCategory(ProductCategoryState state) //where TMergePatchProductCategory : IMergePatchProductCategory, new()
    {
        TMergePatchProductCategory cmd = newMergePatchProductCategory();

        cmd.setVersion(state.getVersion());

        cmd.setProductCategoryId(state.getProductCategoryId());
        cmd.setProductCategoryTypeId(state.getProductCategoryTypeId());
        cmd.setPrimaryParentCategoryId(state.getPrimaryParentCategoryId());
        cmd.setCategoryName(state.getCategoryName());
        cmd.setDescription(state.getDescription());
        cmd.setCategoryImageUrl(state.getCategoryImageUrl());
        cmd.setDetailScreen(state.getDetailScreen());
        cmd.setShowInSelect(state.getShowInSelect());
        cmd.setAttributeSetId(state.getAttributeSetId());
        cmd.setActive(state.getActive());
            
        if (state.getProductCategoryTypeId() == null) { cmd.setIsPropertyProductCategoryTypeIdRemoved(true); }
        if (state.getPrimaryParentCategoryId() == null) { cmd.setIsPropertyPrimaryParentCategoryIdRemoved(true); }
        if (state.getCategoryName() == null) { cmd.setIsPropertyCategoryNameRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getCategoryImageUrl() == null) { cmd.setIsPropertyCategoryImageUrlRemoved(true); }
        if (state.getDetailScreen() == null) { cmd.setIsPropertyDetailScreenRemoved(true); }
        if (state.getShowInSelect() == null) { cmd.setIsPropertyShowInSelectRemoved(true); }
        if (state.getAttributeSetId() == null) { cmd.setIsPropertyAttributeSetIdRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateProductCategory toCreateProductCategory(ProductCategoryState state) //where TCreateProductCategory : ICreateProductCategory, new()
    {
        TCreateProductCategory cmd = newCreateProductCategory();

        cmd.setVersion(state.getVersion());
        cmd.setProductCategoryId(state.getProductCategoryId());
        cmd.setProductCategoryTypeId(state.getProductCategoryTypeId());
        cmd.setPrimaryParentCategoryId(state.getPrimaryParentCategoryId());
        cmd.setCategoryName(state.getCategoryName());
        cmd.setDescription(state.getDescription());
        cmd.setCategoryImageUrl(state.getCategoryImageUrl());
        cmd.setDetailScreen(state.getDetailScreen());
        cmd.setShowInSelect(state.getShowInSelect());
        cmd.setAttributeSetId(state.getAttributeSetId());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateProductCategory newCreateProductCategory();

    protected abstract TMergePatchProductCategory newMergePatchProductCategory(); 

    protected abstract TDeleteProductCategory newDeleteProductCategory();

    public static class SimpleProductCategoryStateCommandConverter extends AbstractProductCategoryStateCommandConverter<AbstractProductCategoryCommand.SimpleCreateProductCategory, AbstractProductCategoryCommand.SimpleMergePatchProductCategory, AbstractProductCategoryCommand.SimpleDeleteProductCategory>
    {
        @Override
        protected AbstractProductCategoryCommand.SimpleCreateProductCategory newCreateProductCategory() {
            return new AbstractProductCategoryCommand.SimpleCreateProductCategory();
        }

        @Override
        protected AbstractProductCategoryCommand.SimpleMergePatchProductCategory newMergePatchProductCategory() {
            return new AbstractProductCategoryCommand.SimpleMergePatchProductCategory();
        }

        @Override
        protected AbstractProductCategoryCommand.SimpleDeleteProductCategory newDeleteProductCategory() {
            return new AbstractProductCategoryCommand.SimpleDeleteProductCategory();
        }


    }

}

