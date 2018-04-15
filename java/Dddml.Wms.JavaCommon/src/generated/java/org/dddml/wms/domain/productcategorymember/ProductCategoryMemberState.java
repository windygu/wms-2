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

    void setProductCategoryMemberId(ProductCategoryMemberId productCategoryMemberId);

    java.sql.Timestamp getThruDate();

    void setThruDate(java.sql.Timestamp thruDate);

    String getComments();

    void setComments(String comments);

    Long getSequenceNum();

    void setSequenceNum(Long sequenceNum);

    java.math.BigDecimal getQuantity();

    void setQuantity(java.math.BigDecimal quantity);

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


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(ProductCategoryMemberEvent.ProductCategoryMemberStateCreated e);

    void when(ProductCategoryMemberEvent.ProductCategoryMemberStateMergePatched e);

    
}

