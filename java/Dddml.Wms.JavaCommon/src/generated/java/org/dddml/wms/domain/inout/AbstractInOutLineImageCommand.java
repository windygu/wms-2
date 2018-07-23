package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractInOutLineImageCommand extends AbstractCommand implements InOutLineImageCommand
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

    private String inOutLineLineNumber;

    public String getInOutLineLineNumber()
    {
        return this.inOutLineLineNumber;
    }

    public void setInOutLineLineNumber(String inOutLineLineNumber)
    {
        this.inOutLineLineNumber = inOutLineLineNumber;
    }


    public static abstract class AbstractCreateOrMergePatchInOutLineImage extends AbstractInOutLineImageCommand implements CreateOrMergePatchInOutLineImage
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

    public static abstract class AbstractCreateInOutLineImage extends AbstractCreateOrMergePatchInOutLineImage implements CreateInOutLineImage
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchInOutLineImage extends AbstractCreateOrMergePatchInOutLineImage implements MergePatchInOutLineImage
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

    public static class SimpleCreateInOutLineImage extends AbstractCreateInOutLineImage
    {
    }

    
    public static class SimpleMergePatchInOutLineImage extends AbstractMergePatchInOutLineImage
    {
    }

    
	public static class SimpleRemoveInOutLineImage extends AbstractInOutLineImageCommand implements RemoveInOutLineImage
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_REMOVE;
        }
	}

    

}

