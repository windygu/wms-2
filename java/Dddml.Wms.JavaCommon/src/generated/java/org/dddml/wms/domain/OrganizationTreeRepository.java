package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public interface OrganizationTreeRepository {// extends TreeRepository<OrganizationTreeNode, String>

    Iterable<OrganizationTreeNode> getRoots(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrganizationTreeNode> getChildren(String parentId, Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<String> getRootIds(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<String> getChildIds(String parentId, Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrganizationTreeNode> getRoots(org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<OrganizationTreeNode> getChildren(String parentId, org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<String> getRootIds(org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<String> getChildIds(String parentId, org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

}

