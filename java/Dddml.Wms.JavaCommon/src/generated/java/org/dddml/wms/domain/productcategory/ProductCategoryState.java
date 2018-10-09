package org.dddml.wms.domain.productcategory;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.productcategory.ProductCategoryEvent.*;

public interface ProductCategoryState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getProductCategoryId();

    String getProductCategoryTypeId();

    String getPrimaryParentCategoryId();

    String getCategoryName();

    String getDescription();

    String getCategoryImageUrl();

    String getDetailScreen();

    Boolean getShowInSelect();

    String getAttributeSetId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableProductCategoryState extends ProductCategoryState {
        void setProductCategoryId(String productCategoryId);

        void setProductCategoryTypeId(String productCategoryTypeId);

        void setPrimaryParentCategoryId(String primaryParentCategoryId);

        void setCategoryName(String categoryName);

        void setDescription(String description);

        void setCategoryImageUrl(String categoryImageUrl);

        void setDetailScreen(String detailScreen);

        void setShowInSelect(Boolean showInSelect);

        void setAttributeSetId(String attributeSetId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(ProductCategoryEvent.ProductCategoryStateCreated e);

        void when(ProductCategoryEvent.ProductCategoryStateMergePatched e);

        void when(ProductCategoryEvent.ProductCategoryStateDeleted e);
    }

    interface SqlProductCategoryState extends MutableProductCategoryState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

