using System;

namespace Dddml.Wms.Specialization
{
    public interface IAggregateVersioned<T>
    {
        T AggregateVersion { get; }
    }

    public interface IEntityVersioned<T>
    {
        T EntityVersion { get; }
    }
}

