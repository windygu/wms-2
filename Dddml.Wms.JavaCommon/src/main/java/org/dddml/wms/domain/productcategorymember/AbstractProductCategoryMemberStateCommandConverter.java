package org.dddml.wms.domain.productcategorymember;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractProductCategoryMemberStateCommandConverter<TCreateProductCategoryMember extends ProductCategoryMemberCommand.CreateProductCategoryMember, TMergePatchProductCategoryMember extends ProductCategoryMemberCommand.MergePatchProductCategoryMember, TDeleteProductCategoryMember extends ProductCategoryMemberCommand.DeleteProductCategoryMember>
{
    public ProductCategoryMemberCommand toCreateOrMergePatchProductCategoryMember(ProductCategoryMemberState state)
    {
        //where TCreateProductCategoryMember : ICreateProductCategoryMember, new()
        //where TMergePatchProductCategoryMember : IMergePatchProductCategoryMember, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateProductCategoryMember(state);
        }
        else 
        {
            return toMergePatchProductCategoryMember(state);
        }
    }

    public TDeleteProductCategoryMember toDeleteProductCategoryMember(ProductCategoryMemberState state) //where TDeleteProductCategoryMember : IDeleteProductCategoryMember, new()
    {
        TDeleteProductCategoryMember cmd = newDeleteProductCategoryMember();
        cmd.setProductCategoryMemberId(state.getProductCategoryMemberId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchProductCategoryMember toMergePatchProductCategoryMember(ProductCategoryMemberState state) //where TMergePatchProductCategoryMember : IMergePatchProductCategoryMember, new()
    {
        TMergePatchProductCategoryMember cmd = newMergePatchProductCategoryMember();

        cmd.setVersion(state.getVersion());

        cmd.setProductCategoryMemberId(state.getProductCategoryMemberId());
        cmd.setThruDate(state.getThruDate());
        cmd.setComments(state.getComments());
        cmd.setSequenceNum(state.getSequenceNum());
        cmd.setQuantity(state.getQuantity());
        cmd.setActive(state.getActive());
            
        if (state.getThruDate() == null) { cmd.setIsPropertyThruDateRemoved(true); }
        if (state.getComments() == null) { cmd.setIsPropertyCommentsRemoved(true); }
        if (state.getSequenceNum() == null) { cmd.setIsPropertySequenceNumRemoved(true); }
        if (state.getQuantity() == null) { cmd.setIsPropertyQuantityRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateProductCategoryMember toCreateProductCategoryMember(ProductCategoryMemberState state) //where TCreateProductCategoryMember : ICreateProductCategoryMember, new()
    {
        TCreateProductCategoryMember cmd = newCreateProductCategoryMember();

        cmd.setVersion(state.getVersion());
        cmd.setProductCategoryMemberId(state.getProductCategoryMemberId());
        cmd.setThruDate(state.getThruDate());
        cmd.setComments(state.getComments());
        cmd.setSequenceNum(state.getSequenceNum());
        cmd.setQuantity(state.getQuantity());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateProductCategoryMember newCreateProductCategoryMember();

    protected abstract TMergePatchProductCategoryMember newMergePatchProductCategoryMember(); 

    protected abstract TDeleteProductCategoryMember newDeleteProductCategoryMember();

    public static class SimpleProductCategoryMemberStateCommandConverter extends AbstractProductCategoryMemberStateCommandConverter<AbstractProductCategoryMemberCommand.SimpleCreateProductCategoryMember, AbstractProductCategoryMemberCommand.SimpleMergePatchProductCategoryMember, AbstractProductCategoryMemberCommand.SimpleDeleteProductCategoryMember>
    {
        @Override
        protected AbstractProductCategoryMemberCommand.SimpleCreateProductCategoryMember newCreateProductCategoryMember() {
            return new AbstractProductCategoryMemberCommand.SimpleCreateProductCategoryMember();
        }

        @Override
        protected AbstractProductCategoryMemberCommand.SimpleMergePatchProductCategoryMember newMergePatchProductCategoryMember() {
            return new AbstractProductCategoryMemberCommand.SimpleMergePatchProductCategoryMember();
        }

        @Override
        protected AbstractProductCategoryMemberCommand.SimpleDeleteProductCategoryMember newDeleteProductCategoryMember() {
            return new AbstractProductCategoryMemberCommand.SimpleDeleteProductCategoryMember();
        }


    }

}

