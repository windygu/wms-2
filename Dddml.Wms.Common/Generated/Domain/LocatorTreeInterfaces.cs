﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Locator;

namespace Dddml.Wms.Domain
{
    public partial interface ILocatorTreeNode : ITreeNode<ILocatorState>
    {
        new IEnumerable<ILocatorTreeNode> Children { get; }
    }

    public partial interface ILocatorTreeRepository// : ITreeRepository<ILocatorTreeNode, string>
    {

        IEnumerable<ILocatorTreeNode> GetRoots(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue);
        IEnumerable<ILocatorTreeNode> GetChildren(string parentId, IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue);
        IEnumerable<string> GetRootIds(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue);
        IEnumerable<string> GetChildIds(string parentId, IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<ILocatorTreeNode> GetRoots(Dddml.Support.Criterion.ICriterion filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue);
        IEnumerable<ILocatorTreeNode> GetChildren(string parentId, Dddml.Support.Criterion.ICriterion filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue);
        IEnumerable<string> GetRootIds(Dddml.Support.Criterion.ICriterion filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue);
        IEnumerable<string> GetChildIds(string parentId, Dddml.Support.Criterion.ICriterion filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue);


    }

}

