package org.dddml.wms.domain;

import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.organizationstructure.OrganizationStructureState;
import org.dddml.wms.domain.party.OrganizationState;
import org.dddml.wms.specialization.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractOrganizationTreeApplicationService implements OrganizationTreeApplicationService {
    private OrganizationTreeRepository organizationTreeRepository;

    public OrganizationTreeRepository getOrganizationTreeRepository() {
        return this.organizationTreeRepository;
    }

    public void setOrganizationTreeRepository(OrganizationTreeRepository organizationTreeRepository) {
        this.organizationTreeRepository = organizationTreeRepository;
    }

    public Iterable<OrganizationState> getRoots(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return toContentCollection(getOrganizationTreeRepository().getRoots(filter, orders, firstResult, maxResults));
    }

    public Iterable<OrganizationState> getChildren(String parentId, Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return toContentCollection(getOrganizationTreeRepository().getChildren(parentId, filter, orders, firstResult, maxResults));
    }

    public Iterable<String> getRootIds(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getOrganizationTreeRepository().getRootIds(filter, orders, firstResult, maxResults);
    }

    public Iterable<String> getChildIds(String parentId, Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getOrganizationTreeRepository().getChildIds(parentId, filter, orders, firstResult, maxResults);
    }

    public Iterable<OrganizationState> getRoots(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return toContentCollection(getOrganizationTreeRepository().getRoots(filter, orders, firstResult, maxResults));
    }

    public Iterable<OrganizationState> getChildren(String parentId, Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return toContentCollection(getOrganizationTreeRepository().getChildren(parentId, filter, orders, firstResult, maxResults));
    }

    public Iterable<String> getRootIds(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getOrganizationTreeRepository().getRootIds(filter, orders, firstResult, maxResults);
    }

    public Iterable<String> getChildIds(String parentId, Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getOrganizationTreeRepository().getChildIds(parentId, filter, orders, firstResult, maxResults);
    }

    private static Iterable<OrganizationState> toContentCollection(Iterable<OrganizationTreeNode> trees) {
        List<OrganizationState> states = new ArrayList<OrganizationState>();
        for (OrganizationTreeNode t : trees) {
            states.add(t.getContent());
        }
        return states;
    }

    public static class SimpleOrganizationTreeApplicationService extends AbstractOrganizationTreeApplicationService {
    }


    public static class SimpleOrganizationTreeNode implements OrganizationTreeNode {
        private OrganizationState state;

        private OrganizationTreeRepository repository;

        public SimpleOrganizationTreeNode(OrganizationState state, OrganizationTreeRepository repository) {
            this.state = state;
            this.repository = repository;
        }

        //@Override
        //public Iterable<OrganizationTreeNode> getOrganizationTreeChildren()
        //{
        //}

        @Override
        public Iterable<TreeNode<OrganizationState>> getChildren() {
            return (Iterable) repository.getChildren(this.state.getPartyId(), (Iterable<Map.Entry<String, Object>>) null, null, null, null);
        }

        @Override
        public OrganizationState getContent() {
            return state;
        }

        private OrganizationStructureState structure;

        public void setStructure(OrganizationStructureState s) {
            this.structure = s;
        }

        @Override
        public OrganizationStructureState getStructure() {
            return this.structure;
        }
    }
}


