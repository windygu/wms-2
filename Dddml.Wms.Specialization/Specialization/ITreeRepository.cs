﻿using Dddml.Support.Criterion;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Specialization
{
    public interface ITreeRepository<TNode, TId>
    {
        IEnumerable<TNode> GetRoots(ICriterion filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<TNode> GetChildren(TId parentId, ICriterion filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<TId> GetRootIds(ICriterion filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<TId> GetChildIds(TId parentId, ICriterion filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<TNode> GetRoots(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<TNode> GetChildren(TId parentId, IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<TId> GetRootIds(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<TId> GetChildIds(TId parentId, IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue);

    }
}
