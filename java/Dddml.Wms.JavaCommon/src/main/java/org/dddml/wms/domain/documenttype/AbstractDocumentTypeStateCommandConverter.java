package org.dddml.wms.domain.documenttype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractDocumentTypeStateCommandConverter<TCreateDocumentType extends DocumentTypeCommand.CreateDocumentType, TMergePatchDocumentType extends DocumentTypeCommand.MergePatchDocumentType, TDeleteDocumentType extends DocumentTypeCommand.DeleteDocumentType>
{
    public DocumentTypeCommand toCreateOrMergePatchDocumentType(DocumentTypeState state)
    {
        //where TCreateDocumentType : ICreateDocumentType, new()
        //where TMergePatchDocumentType : IMergePatchDocumentType, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateDocumentType(state);
        }
        else 
        {
            return toMergePatchDocumentType(state);
        }
    }

    public TDeleteDocumentType toDeleteDocumentType(DocumentTypeState state) //where TDeleteDocumentType : IDeleteDocumentType, new()
    {
        TDeleteDocumentType cmd = newDeleteDocumentType();
        cmd.setDocumentTypeId(state.getDocumentTypeId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchDocumentType toMergePatchDocumentType(DocumentTypeState state) //where TMergePatchDocumentType : IMergePatchDocumentType, new()
    {
        TMergePatchDocumentType cmd = newMergePatchDocumentType();

        cmd.setVersion(state.getVersion());

        cmd.setDocumentTypeId(state.getDocumentTypeId());
        cmd.setDescription(state.getDescription());
        cmd.setParentDocumentTypeId(state.getParentDocumentTypeId());
        cmd.setActive(state.getActive());
            
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getParentDocumentTypeId() == null) { cmd.setIsPropertyParentDocumentTypeIdRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateDocumentType toCreateDocumentType(DocumentTypeState state) //where TCreateDocumentType : ICreateDocumentType, new()
    {
        TCreateDocumentType cmd = newCreateDocumentType();

        cmd.setVersion(state.getVersion());
        cmd.setDocumentTypeId(state.getDocumentTypeId());
        cmd.setDescription(state.getDescription());
        cmd.setParentDocumentTypeId(state.getParentDocumentTypeId());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateDocumentType newCreateDocumentType();

    protected abstract TMergePatchDocumentType newMergePatchDocumentType(); 

    protected abstract TDeleteDocumentType newDeleteDocumentType();

    public static class SimpleDocumentTypeStateCommandConverter extends AbstractDocumentTypeStateCommandConverter<AbstractDocumentTypeCommand.SimpleCreateDocumentType, AbstractDocumentTypeCommand.SimpleMergePatchDocumentType, AbstractDocumentTypeCommand.SimpleDeleteDocumentType>
    {
        @Override
        protected AbstractDocumentTypeCommand.SimpleCreateDocumentType newCreateDocumentType() {
            return new AbstractDocumentTypeCommand.SimpleCreateDocumentType();
        }

        @Override
        protected AbstractDocumentTypeCommand.SimpleMergePatchDocumentType newMergePatchDocumentType() {
            return new AbstractDocumentTypeCommand.SimpleMergePatchDocumentType();
        }

        @Override
        protected AbstractDocumentTypeCommand.SimpleDeleteDocumentType newDeleteDocumentType() {
            return new AbstractDocumentTypeCommand.SimpleDeleteDocumentType();
        }


    }

}

