// <autogenerated>
//   This file was generated by T4 code generator GenerateOrganizationStructureDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.wms.domain.organizationstructure;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.specialization.*;

public interface OrganizationTreeOrganizationStructureStateQueryRepository extends OrganizationStructureStateQueryRepository
{
    Iterable<org.dddml.wms.domain.party.OrganizationState> getOrganizationTreeRootOrganizations(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrganizationStructureState> getOrganizationTreeChildren(String parentId, Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<org.dddml.wms.domain.party.OrganizationState> getOrganizationTreeRootOrganizations(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrganizationStructureState> getOrganizationTreeChildren(String parentId, Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

}

