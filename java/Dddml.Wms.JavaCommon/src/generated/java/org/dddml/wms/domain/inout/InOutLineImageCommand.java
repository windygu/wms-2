package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface InOutLineImageCommand extends Command
{
    String getSequenceId();

    void setSequenceId(String sequenceId);

    String getInOutDocumentNumber();

    void setInOutDocumentNumber(String inOutDocumentNumber);

    String getInOutLineLineNumber();

    void setInOutLineLineNumber(String inOutLineLineNumber);

    interface CreateOrMergePatchInOutLineImage extends InOutLineImageCommand
    {
        String getUrl();

        void setUrl(String url);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateInOutLineImage extends CreateOrMergePatchInOutLineImage
    {
    }

    interface MergePatchInOutLineImage extends CreateOrMergePatchInOutLineImage
    {
        Boolean getIsPropertyUrlRemoved();

        void setIsPropertyUrlRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveInOutLineImage extends InOutLineImageCommand
	{
	}

}

