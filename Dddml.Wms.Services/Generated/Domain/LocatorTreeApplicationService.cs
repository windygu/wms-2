﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextTreeApplicationServices.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Locator;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain
{

	public partial class LocatorTreeApplicationService : ILocatorTreeApplicationService
	{

        public ILocatorTreeRepository LocatorTreeRepository { get; set; }

        public virtual IEnumerable<ILocatorState> GetRoots(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var trees = LocatorTreeRepository.GetRoots(filter, orders, firstResult, maxResults);
            return ToContentCollection(trees);
        }

        public virtual IEnumerable<ILocatorState> GetChildren(string parentId, ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var trees = LocatorTreeRepository.GetChildren(parentId, filter, orders, firstResult, maxResults);
            return ToContentCollection(trees);
        }

        public virtual IEnumerable<string> GetRootIds(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var ids = LocatorTreeRepository.GetRootIds(filter, orders, firstResult, maxResults);
            return ids;
        }

        public virtual IEnumerable<string> GetChildIds(string parentId, ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var ids = LocatorTreeRepository.GetChildIds(parentId, filter, orders, firstResult, maxResults);
            return ids;
        }

        public virtual IEnumerable<ILocatorState> GetRoots(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var trees = LocatorTreeRepository.GetRoots(filter, orders, firstResult, maxResults);
            return ToContentCollection(trees);
        }

        public virtual IEnumerable<ILocatorState> GetChildren(string parentId, IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var trees = LocatorTreeRepository.GetChildren(parentId, filter, orders, firstResult, maxResults);
            return ToContentCollection(trees);
        }

        public virtual IEnumerable<string> GetRootIds(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var ids = LocatorTreeRepository.GetRootIds(filter, orders, firstResult, maxResults);
            return ids;
        }

        public virtual IEnumerable<string> GetChildIds(string parentId, IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var ids = LocatorTreeRepository.GetChildIds(parentId, filter, orders, firstResult, maxResults);
            return ids;
        }

        private static IEnumerable<ILocatorState> ToContentCollection(IEnumerable<ILocatorTreeNode> trees)
        {
            var states = new List<ILocatorState>();
            foreach (var t in trees)
            {
                states.Add(t.Content);
            }
            return states;
        }

	}

	public partial class LocatorTreeApplicationServiceFactory : ILocatorTreeApplicationServiceFactory
	{
        public virtual ILocatorTreeApplicationService LocatorTreeApplicationService 
        {
		    get
		    {
			    return ApplicationContext.Current["LocatorTreeApplicationService"] as ILocatorTreeApplicationService;
		    }
        }
	}

}

