using System;


namespace Dddml.Wms.Specialization
{
    public interface IPropertyCommand<TContent, TState>
    {
        /// <summary>
        /// Content(Value) of the command.
        /// </summary>
        TContent Content { get; set; }

        Func<TState> GetState { get; set; }

        Action<TState> SetState { get; set; }

        string OuterCommandType { get; set; }

        object Context { get; set; }
    }
}
