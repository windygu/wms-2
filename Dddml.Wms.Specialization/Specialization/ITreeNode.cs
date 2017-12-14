using System;
using System.Collections.Generic;

namespace Dddml.Wms.Specialization
{
    public interface ITreeNode<T>
    {
        T Content { get; }

        IEnumerable<ITreeNode<T>> Children { get; }
    }
}
