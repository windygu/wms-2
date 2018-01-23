package org.dddml.wms.domain;

import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.locator.LocatorState;
import org.dddml.wms.specialization.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractLocatorTreeApplicationService implements LocatorTreeApplicationService {
    private LocatorTreeRepository locatorTreeRepository;

    public LocatorTreeRepository getLocatorTreeRepository() {
        return this.locatorTreeRepository;
    }

    public void setLocatorTreeRepository(LocatorTreeRepository locatorTreeRepository) {
        this.locatorTreeRepository = locatorTreeRepository;
    }

    public Iterable<LocatorState> getRoots(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return toContentCollection(getLocatorTreeRepository().getRoots(filter, orders, firstResult, maxResults));
    }

    public Iterable<LocatorState> getChildren(String parentId, Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return toContentCollection(getLocatorTreeRepository().getChildren(parentId, filter, orders, firstResult, maxResults));
    }

    public Iterable<String> getRootIds(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getLocatorTreeRepository().getRootIds(filter, orders, firstResult, maxResults);
    }

    public Iterable<String> getChildIds(String parentId, Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getLocatorTreeRepository().getChildIds(parentId, filter, orders, firstResult, maxResults);
    }

    public Iterable<LocatorState> getRoots(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return toContentCollection(getLocatorTreeRepository().getRoots(filter, orders, firstResult, maxResults));
    }

    public Iterable<LocatorState> getChildren(String parentId, Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return toContentCollection(getLocatorTreeRepository().getChildren(parentId, filter, orders, firstResult, maxResults));
    }

    public Iterable<String> getRootIds(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getLocatorTreeRepository().getRootIds(filter, orders, firstResult, maxResults);
    }

    public Iterable<String> getChildIds(String parentId, Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getLocatorTreeRepository().getChildIds(parentId, filter, orders, firstResult, maxResults);
    }

    private static Iterable<LocatorState> toContentCollection(Iterable<LocatorTreeNode> trees) {
        List<LocatorState> states = new ArrayList<LocatorState>();
        for (LocatorTreeNode t : trees) {
            states.add(t.getContent());
        }
        return states;
    }

    public static class SimpleLocatorTreeApplicationService extends AbstractLocatorTreeApplicationService {
    }


    public static class SimpleLocatorTreeNode implements LocatorTreeNode {
        private LocatorState state;

        private LocatorTreeRepository repository;

        public SimpleLocatorTreeNode(LocatorState state, LocatorTreeRepository repository) {
            this.state = state;
            this.repository = repository;
        }

        //@Override
        //public Iterable<LocatorTreeNode> getLocatorTreeChildren()
        //{
        //}

        @Override
        public Iterable<TreeNode<LocatorState>> getChildren() {
            return (Iterable) repository.getChildren(this.state.getLocatorId(), (Iterable<Map.Entry<String, Object>>) null, null, null, null);
        }

        @Override
        public LocatorState getContent() {
            return state;
        }

    }
}


