package org.dddml.wms.domain.productcategory;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ProductCategoryEvent extends Event {

    interface SqlProductCategoryEvent extends ProductCategoryEvent {
        ProductCategoryEventId getProductCategoryEventId();
    }

    String getProductCategoryId();

    //void setProductCategoryId(String productCategoryId);

    Long getVersion();
    
    //void getVersion(Long version);

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface ProductCategoryStateEvent extends ProductCategoryEvent {
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

        String getAttributeSetId();

        void setAttributeSetId(String attributeSetId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface ProductCategoryStateCreated extends ProductCategoryStateEvent
    {
    
    }


    interface ProductCategoryStateMergePatched extends ProductCategoryStateEvent
    {
        Boolean getIsPropertyProductCategoryTypeIdRemoved();

        void setIsPropertyProductCategoryTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyPrimaryParentCategoryIdRemoved();

        void setIsPropertyPrimaryParentCategoryIdRemoved(Boolean removed);

        Boolean getIsPropertyCategoryNameRemoved();

        void setIsPropertyCategoryNameRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyCategoryImageUrlRemoved();

        void setIsPropertyCategoryImageUrlRemoved(Boolean removed);

        Boolean getIsPropertyDetailScreenRemoved();

        void setIsPropertyDetailScreenRemoved(Boolean removed);

        Boolean getIsPropertyShowInSelectRemoved();

        void setIsPropertyShowInSelectRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetIdRemoved();

        void setIsPropertyAttributeSetIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface ProductCategoryStateDeleted extends ProductCategoryStateEvent
    {
    }


}

