using System;
using System.Collections.Generic;


namespace Dddml.Wms.Specialization
{

    public interface IIdFlattenedDtoFormatter<TDto> : ITextFormatter<TDto> where TDto : IIdFlattenedDto
    {
    }

}
