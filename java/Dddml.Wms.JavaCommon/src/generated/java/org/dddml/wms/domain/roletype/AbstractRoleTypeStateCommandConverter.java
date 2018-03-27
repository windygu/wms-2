package org.dddml.wms.domain.roletype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractRoleTypeStateCommandConverter<TCreateRoleType extends RoleTypeCommand.CreateRoleType, TMergePatchRoleType extends RoleTypeCommand.MergePatchRoleType, TDeleteRoleType extends RoleTypeCommand.DeleteRoleType>
{
    public RoleTypeCommand toCreateOrMergePatchRoleType(RoleTypeState state)
    {
        //where TCreateRoleType : ICreateRoleType, new()
        //where TMergePatchRoleType : IMergePatchRoleType, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateRoleType(state);
        }
        else 
        {
            return toMergePatchRoleType(state);
        }
    }

    public TDeleteRoleType toDeleteRoleType(RoleTypeState state) //where TDeleteRoleType : IDeleteRoleType, new()
    {
        TDeleteRoleType cmd = newDeleteRoleType();
        cmd.setRoleTypeId(state.getRoleTypeId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchRoleType toMergePatchRoleType(RoleTypeState state) //where TMergePatchRoleType : IMergePatchRoleType, new()
    {
        TMergePatchRoleType cmd = newMergePatchRoleType();

        cmd.setVersion(state.getVersion());

        cmd.setRoleTypeId(state.getRoleTypeId());
        cmd.setParentTypeId(state.getParentTypeId());
        cmd.setHasTable(state.getHasTable());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
            
        if (state.getParentTypeId() == null) { cmd.setIsPropertyParentTypeIdRemoved(true); }
        if (state.getHasTable() == null) { cmd.setIsPropertyHasTableRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateRoleType toCreateRoleType(RoleTypeState state) //where TCreateRoleType : ICreateRoleType, new()
    {
        TCreateRoleType cmd = newCreateRoleType();

        cmd.setVersion(state.getVersion());
        cmd.setRoleTypeId(state.getRoleTypeId());
        cmd.setParentTypeId(state.getParentTypeId());
        cmd.setHasTable(state.getHasTable());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateRoleType newCreateRoleType();

    protected abstract TMergePatchRoleType newMergePatchRoleType(); 

    protected abstract TDeleteRoleType newDeleteRoleType();

    public static class SimpleRoleTypeStateCommandConverter extends AbstractRoleTypeStateCommandConverter<AbstractRoleTypeCommand.SimpleCreateRoleType, AbstractRoleTypeCommand.SimpleMergePatchRoleType, AbstractRoleTypeCommand.SimpleDeleteRoleType>
    {
        @Override
        protected AbstractRoleTypeCommand.SimpleCreateRoleType newCreateRoleType() {
            return new AbstractRoleTypeCommand.SimpleCreateRoleType();
        }

        @Override
        protected AbstractRoleTypeCommand.SimpleMergePatchRoleType newMergePatchRoleType() {
            return new AbstractRoleTypeCommand.SimpleMergePatchRoleType();
        }

        @Override
        protected AbstractRoleTypeCommand.SimpleDeleteRoleType newDeleteRoleType() {
            return new AbstractRoleTypeCommand.SimpleDeleteRoleType();
        }


    }

}

