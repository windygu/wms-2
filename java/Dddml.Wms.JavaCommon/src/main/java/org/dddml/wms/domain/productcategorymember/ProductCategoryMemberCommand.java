package org.dddml.wms.domain.productcategorymember;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface ProductCategoryMemberCommand extends Command
{
    ProductCategoryMemberId getProductCategoryMemberId();

    void setProductCategoryMemberId(ProductCategoryMemberId productCategoryMemberId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(ProductCategoryMemberState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((ProductCategoryMemberCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((ProductCategoryMemberCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(ProductCategoryMemberCommand c) {
        return ((c instanceof ProductCategoryMemberCommand.CreateProductCategoryMember) 
            && c.getVersion().equals(ProductCategoryMemberState.VERSION_NULL));
    }

    interface CreateOrMergePatchProductCategoryMember extends ProductCategoryMemberCommand
    {
        java.sql.Timestamp getThruDate();

        void setThruDate(java.sql.Timestamp thruDate);

        String getComments();

        void setComments(String comments);

        Long getSequenceNum();

        void setSequenceNum(Long sequenceNum);

        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateProductCategoryMember extends CreateOrMergePatchProductCategoryMember
    {
    }

    interface MergePatchProductCategoryMember extends CreateOrMergePatchProductCategoryMember
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

	interface DeleteProductCategoryMember extends ProductCategoryMemberCommand
	{
	}

}

