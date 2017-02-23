using System;

namespace Dddml.Wms.Specialization
{
	public interface IUpdated<TUserId>
	{
        TUserId UpdatedBy { get; set; }

        DateTime UpdatedAt { get; set; }
	}
}

