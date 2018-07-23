package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractInOutImageStateCommandConverter<TCreateInOutImage extends InOutImageCommand.CreateInOutImage, TMergePatchInOutImage extends InOutImageCommand.MergePatchInOutImage, TRemoveInOutImage extends InOutImageCommand.RemoveInOutImage>
{
    public InOutImageCommand toCreateOrMergePatchInOutImage(InOutImageState state)
    {
        //where TCreateInOutImage : ICreateInOutImage, new()
        //where TMergePatchInOutImage : IMergePatchInOutImage, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateInOutImage(state);
        }
        else 
        {
            return toMergePatchInOutImage(state);
        }
    }

    public TRemoveInOutImage toRemoveInOutImage(InOutImageState state) //where TRemoveInOutImage : IRemoveInOutImage, new()
    {
        TRemoveInOutImage cmd = newRemoveInOutImage();
        cmd.setSequenceId(state.getSequenceId());
        return cmd;
    }

    public TMergePatchInOutImage toMergePatchInOutImage(InOutImageState state) //where TMergePatchInOutImage : IMergePatchInOutImage, new()
    {
        TMergePatchInOutImage cmd = newMergePatchInOutImage();

        cmd.setSequenceId(state.getSequenceId());
        cmd.setUrl(state.getUrl());
        cmd.setActive(state.getActive());
        cmd.setInOutDocumentNumber(state.getInOutDocumentNumber());
            
        if (state.getUrl() == null) { cmd.setIsPropertyUrlRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateInOutImage toCreateInOutImage(InOutImageState state) //where TCreateInOutImage : ICreateInOutImage, new()
    {
        TCreateInOutImage cmd = newCreateInOutImage();

        cmd.setSequenceId(state.getSequenceId());
        cmd.setUrl(state.getUrl());
        cmd.setActive(state.getActive());
        cmd.setInOutDocumentNumber(state.getInOutDocumentNumber());
        return cmd;
    }

    protected abstract TCreateInOutImage newCreateInOutImage();

    protected abstract TMergePatchInOutImage newMergePatchInOutImage(); 

    protected abstract TRemoveInOutImage newRemoveInOutImage();

    public static class SimpleInOutImageStateCommandConverter extends AbstractInOutImageStateCommandConverter<AbstractInOutImageCommand.SimpleCreateInOutImage, AbstractInOutImageCommand.SimpleMergePatchInOutImage, AbstractInOutImageCommand.SimpleRemoveInOutImage>
    {
        @Override
        protected AbstractInOutImageCommand.SimpleCreateInOutImage newCreateInOutImage() {
            return new AbstractInOutImageCommand.SimpleCreateInOutImage();
        }

        @Override
        protected AbstractInOutImageCommand.SimpleMergePatchInOutImage newMergePatchInOutImage() {
            return new AbstractInOutImageCommand.SimpleMergePatchInOutImage();
        }

        @Override
        protected AbstractInOutImageCommand.SimpleRemoveInOutImage newRemoveInOutImage() {
            return new AbstractInOutImageCommand.SimpleRemoveInOutImage();
        }


    }

}

