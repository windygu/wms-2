package org.dddml.wms.domain.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.party.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.organizationstructure.*;

public class HibernateOrganizationTreeRepository implements OrganizationTreeRepository
{
    private OrganizationStateQueryRepository organizationStateQueryRepository;

    public OrganizationStateQueryRepository getOrganizationStateQueryRepository() {
        return this.organizationStateQueryRepository; 
    }

    public void setOrganizationStateQueryRepository(OrganizationStateQueryRepository repository) { 
        this.organizationStateQueryRepository = repository; 
    }

    private OrganizationTreeOrganizationStructureStateQueryRepository organizationStructureStateQueryRepository;

    public OrganizationTreeOrganizationStructureStateQueryRepository getOrganizationStructureStateQueryRepository() {
        return this.organizationStructureStateQueryRepository; 
    }

    public void setOrganizationStructureStateQueryRepository(OrganizationTreeOrganizationStructureStateQueryRepository repository) { 
        this.organizationStructureStateQueryRepository = repository; 
    }



    @Transactional(readOnly = true)
    public Iterable<OrganizationTreeNode> getRoots(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Iterable<OrganizationStructureState> structureStates = getOrganizationStructureStateQueryRepository().getOrganizationTreeRoots(filter, orders, firstResult, maxResults);
        return structureStatesToOrganizationTreeNodeCollection(structureStates);
    }

    @Transactional(readOnly = true)
    public Iterable<OrganizationTreeNode> getChildren(String parentId, Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Iterable<OrganizationStructureState> structureStates = getOrganizationStructureStateQueryRepository().getOrganizationTreeChildren(parentId, filter, orders, firstResult, maxResults);
        return structureStatesToOrganizationTreeNodeCollection(structureStates);
    }

    @Transactional(readOnly = true)
    public Iterable<String> getRootIds(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Iterable<OrganizationStructureState> structureStates = getOrganizationStructureStateQueryRepository().getOrganizationTreeRoots(filter, orders, firstResult, maxResults);
        return structureStatesToIdCollection(structureStates);
    }

    @Transactional(readOnly = true)
    public Iterable<String> getChildIds(String parentId, Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Iterable<OrganizationStructureState> structureStates = getOrganizationStructureStateQueryRepository().getOrganizationTreeChildren(parentId, filter, orders, firstResult, maxResults);
        return structureStatesToIdCollection(structureStates);
    }



    @Transactional(readOnly = true)
    public Iterable<OrganizationTreeNode> getRoots(org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Iterable<OrganizationStructureState> structureStates = getOrganizationStructureStateQueryRepository().getOrganizationTreeRoots(filter, orders, firstResult, maxResults);
        return structureStatesToOrganizationTreeNodeCollection(structureStates);
    }

    @Transactional(readOnly = true)
    public Iterable<OrganizationTreeNode> getChildren(String parentId, org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Iterable<OrganizationStructureState> structureStates = getOrganizationStructureStateQueryRepository().getOrganizationTreeChildren(parentId, filter, orders, firstResult, maxResults);
        return structureStatesToOrganizationTreeNodeCollection(structureStates);
    }

    @Transactional(readOnly = true)
    public Iterable<String> getRootIds(org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Iterable<OrganizationStructureState> structureStates = getOrganizationStructureStateQueryRepository().getOrganizationTreeRoots(filter, orders, firstResult, maxResults);
        return structureStatesToIdCollection(structureStates);
    }

    @Transactional(readOnly = true)
    public Iterable<String> getChildIds(String parentId, org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Iterable<OrganizationStructureState> structureStates = getOrganizationStructureStateQueryRepository().getOrganizationTreeChildren(parentId, filter, orders, firstResult, maxResults);
        return structureStatesToIdCollection(structureStates);
    }


    private Iterable<OrganizationTreeNode> contentStatesToOrganizationTreeNodeCollection(Iterable<OrganizationState> states)
    {
        List<OrganizationTreeNode> trees = new ArrayList<OrganizationTreeNode>();
        for (OrganizationState state : states)
        {
            trees.add(new AbstractOrganizationTreeApplicationService.SimpleOrganizationTreeNode(state, this));
        }
        return trees;
    }

    private Iterable<String> contentStatesToIdCollection(Iterable<OrganizationState> states)
    {
        List<String> ids = new ArrayList<String>();
        for (OrganizationState state : states)
        {
            ids.add(state.getPartyId());
        }
        return ids;
    }

    private Iterable<OrganizationTreeNode> structureStatesToOrganizationTreeNodeCollection(Iterable<OrganizationStructureState> structureStates)
    {
        List<OrganizationTreeNode> trees = new ArrayList<OrganizationTreeNode>();
        for (OrganizationStructureState ss : structureStates)
        {
            OrganizationState state = getOrganizationStateQueryRepository().get(ss.getId().getSubsidiaryId());
            AbstractOrganizationTreeApplicationService.SimpleOrganizationTreeNode node = new AbstractOrganizationTreeApplicationService.SimpleOrganizationTreeNode(state, this);
            node.setStructure(ss);
            trees.add(node);
        }
        return trees;
    }

    private Iterable<String> structureStatesToIdCollection(Iterable<OrganizationStructureState> structureStates)
    {
        List<String> ids = new ArrayList<String>();
        for (OrganizationStructureState ss : structureStates)
        {
            ids.add(ss.getId().getSubsidiaryId());
        }
        return ids;
    }



}

