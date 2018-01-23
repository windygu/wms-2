package org.dddml.wms.domain;

import org.dddml.wms.domain.organizationstructure.OrganizationStructureState;
import org.dddml.wms.domain.party.OrganizationState;
import org.dddml.wms.specialization.TreeNode;

public interface OrganizationTreeNode extends TreeNode<OrganizationState> {
    //Iterable<OrganizationTree> getOrganizationTreeChildren();

    OrganizationStructureState getStructure(); //inbound edge
}

