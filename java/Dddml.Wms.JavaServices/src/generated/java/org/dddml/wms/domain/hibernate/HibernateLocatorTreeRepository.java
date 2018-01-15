package org.dddml.wms.domain.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.locator.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateLocatorTreeRepository implements LocatorTreeRepository
{
    private LocatorTreeLocatorStateQueryRepository locatorStateQueryRepository;

    public LocatorTreeLocatorStateQueryRepository getLocatorStateQueryRepository() {
        return this.locatorStateQueryRepository; 
    }

    public void setLocatorStateQueryRepository(LocatorTreeLocatorStateQueryRepository repository) { 
        this.locatorStateQueryRepository = repository; 
    }



    @Transactional(readOnly = true)
    public Iterable<LocatorTreeNode> getRoots(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Iterable<LocatorState> states = getLocatorStateQueryRepository().getLocatorTreeRoots(filter, orders, firstResult, maxResults);
        return contentStatesToLocatorTreeNodeCollection(states);
    }

    @Transactional(readOnly = true)
    public Iterable<LocatorTreeNode> getChildren(String parentId, Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Iterable<LocatorState> states = getLocatorStateQueryRepository().getLocatorTreeChildren(parentId, filter, orders, firstResult, maxResults);
        return contentStatesToLocatorTreeNodeCollection(states);
    }

    @Transactional(readOnly = true)
    public Iterable<String> getRootIds(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Iterable<LocatorState> states = getLocatorStateQueryRepository().getLocatorTreeRoots(filter, orders, firstResult, maxResults);
        return contentStatesToIdCollection(states);
    }

    @Transactional(readOnly = true)
    public Iterable<String> getChildIds(String parentId, Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Iterable<LocatorState> states = getLocatorStateQueryRepository().getLocatorTreeChildren(parentId, filter, orders, firstResult, maxResults);
        return contentStatesToIdCollection(states);
    }



    @Transactional(readOnly = true)
    public Iterable<LocatorTreeNode> getRoots(org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Iterable<LocatorState> states = getLocatorStateQueryRepository().getLocatorTreeRoots(filter, orders, firstResult, maxResults);
        return contentStatesToLocatorTreeNodeCollection(states);
    }

    @Transactional(readOnly = true)
    public Iterable<LocatorTreeNode> getChildren(String parentId, org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Iterable<LocatorState> states = getLocatorStateQueryRepository().getLocatorTreeChildren(parentId, filter, orders, firstResult, maxResults);
        return contentStatesToLocatorTreeNodeCollection(states);
    }

    @Transactional(readOnly = true)
    public Iterable<String> getRootIds(org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Iterable<LocatorState> states = getLocatorStateQueryRepository().getLocatorTreeRoots(filter, orders, firstResult, maxResults);
        return contentStatesToIdCollection(states);
    }

    @Transactional(readOnly = true)
    public Iterable<String> getChildIds(String parentId, org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Iterable<LocatorState> states = getLocatorStateQueryRepository().getLocatorTreeChildren(parentId, filter, orders, firstResult, maxResults);
        return contentStatesToIdCollection(states);
    }


    private Iterable<LocatorTreeNode> contentStatesToLocatorTreeNodeCollection(Iterable<LocatorState> states)
    {
        List<LocatorTreeNode> trees = new ArrayList<LocatorTreeNode>();
        for (LocatorState state : states)
        {
            trees.add(new AbstractLocatorTreeApplicationService.SimpleLocatorTreeNode(state, this));
        }
        return trees;
    }

    private Iterable<String> contentStatesToIdCollection(Iterable<LocatorState> states)
    {
        List<String> ids = new ArrayList<String>();
        for (LocatorState state : states)
        {
            ids.add(state.getLocatorId());
        }
        return ids;
    }



}

