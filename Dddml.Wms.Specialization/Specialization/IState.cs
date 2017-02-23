using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Specialization
{
    public interface IState
    {
        bool ReadOnly { get; set; }
    }
}
