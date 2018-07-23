package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractInOutLineImageStateCommandConverter<TCreateInOutLineImage extends InOutLineImageCommand.CreateInOutLineImage, TMergePatchInOutLineImage extends InOutLineImageCommand.MergePatchInOutLineImage, TRemoveInOutLineImage extends InOutLineImageCommand.RemoveInOutLineImage>
{
    public InOutLineImageCommand toCreateOrMergePatchInOutLineImage(InOutLineImageState state)
    {
        //where TCreateInOutLineImage : ICreateInOutLineImage, new()
        //where TMergePatchInOutLineImage : IMergePatchInOutLineImage, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateInOutLineImage(state);
        }
        else 
        {
            return toMergePatchInOutLineImage(state);
        }
    }

    public TRemoveInOutLineImage toRemoveInOutLineImage(InOutLineImageState state) //where TRemoveInOutLineImage : IRemoveInOutLineImage, new()
    {
        TRemoveInOutLineImage cmd = newRemoveInOutLineImage();
        cmd.setSequenceId(state.getSequenceId());
        return cmd;
    }

    public TMergePatchInOutLineImage toMergePatchInOutLineImage(InOutLineImageState state) //where TMergePatchInOutLineImage : IMergePatchInOutLineImage, new()
    {
        TMergePatchInOutLineImage cmd = newMergePatchInOutLineImage();

        cmd.setSequenceId(state.getSequenceId());
        cmd.setUrl(state.getUrl());
        cmd.setActive(state.getActive());
        cmd.setInOutDocumentNumber(state.getInOutDocumentNumber());
        cmd.setInOutLineLineNumber(state.getInOutLineLineNumber());
            
        if (state.getUrl() == null) { cmd.setIsPropertyUrlRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateInOutLineImage toCreateInOutLineImage(InOutLineImageState state) //where TCreateInOutLineImage : ICreateInOutLineImage, new()
    {
        TCreateInOutLineImage cmd = newCreateInOutLineImage();

        cmd.setSequenceId(state.getSequenceId());
        cmd.setUrl(state.getUrl());
        cmd.setActive(state.getActive());
        cmd.setInOutDocumentNumber(state.getInOutDocumentNumber());
        cmd.setInOutLineLineNumber(state.getInOutLineLineNumber());
        return cmd;
    }

    protected abstract TCreateInOutLineImage newCreateInOutLineImage();

    protected abstract TMergePatchInOutLineImage newMergePatchInOutLineImage(); 

    protected abstract TRemoveInOutLineImage newRemoveInOutLineImage();

    public static class SimpleInOutLineImageStateCommandConverter extends AbstractInOutLineImageStateCommandConverter<AbstractInOutLineImageCommand.SimpleCreateInOutLineImage, AbstractInOutLineImageCommand.SimpleMergePatchInOutLineImage, AbstractInOutLineImageCommand.SimpleRemoveInOutLineImage>
    {
        @Override
        protected AbstractInOutLineImageCommand.SimpleCreateInOutLineImage newCreateInOutLineImage() {
            return new AbstractInOutLineImageCommand.SimpleCreateInOutLineImage();
        }

        @Override
        protected AbstractInOutLineImageCommand.SimpleMergePatchInOutLineImage newMergePatchInOutLineImage() {
            return new AbstractInOutLineImageCommand.SimpleMergePatchInOutLineImage();
        }

        @Override
        protected AbstractInOutLineImageCommand.SimpleRemoveInOutLineImage newRemoveInOutLineImage() {
            return new AbstractInOutLineImageCommand.SimpleRemoveInOutLineImage();
        }


    }

}

