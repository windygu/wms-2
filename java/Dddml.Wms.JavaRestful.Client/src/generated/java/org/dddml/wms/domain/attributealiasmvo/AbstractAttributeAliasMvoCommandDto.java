package org.dddml.wms.domain.attributealiasmvo;

import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractAttributeAliasMvoCommandDto extends AbstractCommand
{
    private AttributeAliasId attributeAliasId;

    public AttributeAliasId getAttributeAliasId()
    {
        return this.attributeAliasId;
    }

    public void setAttributeAliasId(AttributeAliasId attributeAliasId)
    {
        this.attributeAliasId = attributeAliasId;
    }

    private Long attributeVersion;

    public Long getAttributeVersion()
    {
        return this.attributeVersion;
    }

    public void setAttributeVersion(Long attributeVersion)
    {
        this.attributeVersion = attributeVersion;
    }


}
