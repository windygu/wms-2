package org.dddml.wms.domain.productcategory;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.productcategory.ProductCategoryStateEvent.*;

public interface ProductCategoryState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getProductCategoryId();

    void setProductCategoryId(String productCategoryId);

    String getProductCategoryTypeId();

    void setProductCategoryTypeId(String productCategoryTypeId);

    String getPrimaryParentCategoryId();

    void setPrimaryParentCategoryId(String primaryParentCategoryId);

    String getCategoryName();

    void setCategoryName(String categoryName);

    String getDescription();

    void setDescription(String description);

    String getCategoryImageUrl();

    void setCategoryImageUrl(String categoryImageUrl);

    String getDetailScreen();

    void setDetailScreen(String detailScreen);

    Boolean getShowInSelect();

    void setShowInSelect(Boolean showInSelect);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(ProductCategoryStateEvent.ProductCategoryStateCreated e);

    void when(ProductCategoryStateEvent.ProductCategoryStateMergePatched e);

    void when(ProductCategoryStateEvent.ProductCategoryStateDeleted e);
    
}

