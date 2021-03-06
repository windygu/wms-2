package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.party.*;
import org.dddml.wms.domain.organizationstructure.*;

public interface OrganizationTreeNode extends TreeNode<OrganizationState>
{
    //Iterable<OrganizationTree> getOrganizationTreeChildren();

    OrganizationStructureState getStructure(); //inbound edge
}

