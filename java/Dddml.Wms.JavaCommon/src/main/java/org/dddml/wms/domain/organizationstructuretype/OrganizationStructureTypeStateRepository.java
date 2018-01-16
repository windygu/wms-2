package org.dddml.wms.domain.organizationstructuretype;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrganizationStructureTypeStateRepository
{
    OrganizationStructureTypeState get(String id, boolean nullAllowed);

    void save(OrganizationStructureTypeState state);

}

