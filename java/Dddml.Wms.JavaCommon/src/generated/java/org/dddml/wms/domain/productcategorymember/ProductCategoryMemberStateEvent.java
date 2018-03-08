package org.dddml.wms.domain.productcategorymember;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ProductCategoryMemberStateEvent extends Event
{
    ProductCategoryMemberEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    java.sql.Timestamp getThruDate();

    void setThruDate(java.sql.Timestamp thruDate);

    String getComments();

    void setComments(String comments);

    Long getSequenceNum();

    void setSequenceNum(Long sequenceNum);

    java.math.BigDecimal getQuantity();

    void setQuantity(java.math.BigDecimal quantity);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface ProductCategoryMemberStateCreated extends ProductCategoryMemberStateEvent
    {
    
    }


    interface ProductCategoryMemberStateMergePatched extends ProductCategoryMemberStateEvent
    {
        Boolean getIsPropertyThruDateRemoved();

        void setIsPropertyThruDateRemoved(Boolean removed);

        Boolean getIsPropertyCommentsRemoved();

        void setIsPropertyCommentsRemoved(Boolean removed);

        Boolean getIsPropertySequenceNumRemoved();

        void setIsPropertySequenceNumRemoved(Boolean removed);

        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }


}

