package org.dddml.wms.domain.organizationstructure;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.*;
import java.util.Date;

public interface OrganizationStructureStateRepository
{
    OrganizationStructureState get(OrganizationStructureId id, boolean nullAllowed);

    void save(OrganizationStructureState state);

}

