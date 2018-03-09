using System;

namespace Dddml.Wms.Specialization
{
    public interface ITextFormatter<T>
    {
        T Parse(string text);

        string ToString(T value);
    }
}
