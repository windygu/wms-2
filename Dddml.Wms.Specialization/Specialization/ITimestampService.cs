using System;

namespace Dddml.Wms.Specialization
{
    public interface ITimestampService
    {
        T Now<T>();

    }
}
