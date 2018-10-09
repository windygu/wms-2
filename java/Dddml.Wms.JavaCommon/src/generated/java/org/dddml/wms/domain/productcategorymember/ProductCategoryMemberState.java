package org.dddml.wms.domain.productcategorymember;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.productcategorymember.ProductCategoryMemberEvent.*;

public interface ProductCategoryMemberState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    ProductCategoryMemberId getProductCategoryMemberId();

    java.sql.Timestamp getThruDate();

    String getComments();

    Long getSequenceNum();

    java.math.BigDecimal getQuantity();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    interface MutableProductCategoryMemberState extends ProductCategoryMemberState {
        void setProductCategoryMemberId(ProductCategoryMemberId productCategoryMemberId);

        void setThruDate(java.sql.Timestamp thruDate);

        void setComments(String comments);

        void setSequenceNum(Long sequenceNum);

        void setQuantity(java.math.BigDecimal quantity);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);


        void mutate(Event e);

        void when(ProductCategoryMemberEvent.ProductCategoryMemberStateCreated e);

        void when(ProductCategoryMemberEvent.ProductCategoryMemberStateMergePatched e);

    }

    interface SqlProductCategoryMemberState extends MutableProductCategoryMemberState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

