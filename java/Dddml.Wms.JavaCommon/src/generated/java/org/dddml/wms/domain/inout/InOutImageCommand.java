package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface InOutImageCommand extends Command
{
    String getSequenceId();

    void setSequenceId(String sequenceId);

    String getInOutDocumentNumber();

    void setInOutDocumentNumber(String inOutDocumentNumber);

    interface CreateOrMergePatchInOutImage extends InOutImageCommand
    {
        String getUrl();

        void setUrl(String url);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateInOutImage extends CreateOrMergePatchInOutImage
    {
    }

    interface MergePatchInOutImage extends CreateOrMergePatchInOutImage
    {
        Boolean getIsPropertyUrlRemoved();

        void setIsPropertyUrlRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveInOutImage extends InOutImageCommand
	{
	}

}

