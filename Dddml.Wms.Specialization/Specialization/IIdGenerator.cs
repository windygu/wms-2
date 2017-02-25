using System;


namespace Dddml.Wms.Specialization
{
    public interface IIdGenerator<TId, TCommand, TState>
    {
        TId GenerateId(TCommand command);

        TId GetNextId();

        bool Equals(TCommand command, TState state);

        bool IsSurrogateIdEnabled();
    }

}
