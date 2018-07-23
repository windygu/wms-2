package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractInOutImageCommand extends AbstractCommand implements InOutImageCommand
{
    private String sequenceId;

    public String getSequenceId()
    {
        return this.sequenceId;
    }

    public void setSequenceId(String sequenceId)
    {
        this.sequenceId = sequenceId;
    }

    private String inOutDocumentNumber;

    public String getInOutDocumentNumber()
    {
        return this.inOutDocumentNumber;
    }

    public void setInOutDocumentNumber(String inOutDocumentNumber)
    {
        this.inOutDocumentNumber = inOutDocumentNumber;
    }


    public static abstract class AbstractCreateOrMergePatchInOutImage extends AbstractInOutImageCommand implements CreateOrMergePatchInOutImage
    {
        private String url;

        public String getUrl()
        {
            return this.url;
        }

        public void setUrl(String url)
        {
            this.url = url;
        }

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

    }

    public static abstract class AbstractCreateInOutImage extends AbstractCreateOrMergePatchInOutImage implements CreateInOutImage
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchInOutImage extends AbstractCreateOrMergePatchInOutImage implements MergePatchInOutImage
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyUrlRemoved;

        public Boolean getIsPropertyUrlRemoved()
        {
            return this.isPropertyUrlRemoved;
        }

        public void setIsPropertyUrlRemoved(Boolean removed)
        {
            this.isPropertyUrlRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved()
        {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed)
        {
            this.isPropertyActiveRemoved = removed;
        }

    }

    public static class SimpleCreateInOutImage extends AbstractCreateInOutImage
    {
    }

    
    public static class SimpleMergePatchInOutImage extends AbstractMergePatchInOutImage
    {
    }

    
	public static class SimpleRemoveInOutImage extends AbstractInOutImageCommand implements RemoveInOutImage
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_REMOVE;
        }
	}

    

}

