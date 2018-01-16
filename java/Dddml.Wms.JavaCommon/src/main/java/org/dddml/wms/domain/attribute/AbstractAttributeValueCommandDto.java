package org.dddml.wms.domain.attribute;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractAttributeValueCommandDto extends AbstractCommand
{
    private String value;

    public String getValue()
    {
        return this.value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }


    public void copyTo(AbstractAttributeValueCommand command)
    {
        command.setValue(this.getValue());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
