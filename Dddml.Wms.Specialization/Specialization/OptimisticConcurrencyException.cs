using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Dddml.Wms.Specialization
{
    /// <summary>
    /// Thrown if there were changes since our last version.
    /// </summary>
    [Serializable]
    public class OptimisticConcurrencyException : Exception
    {
        public long ActualVersion { get; private set; }

        public long ExpectedVersion { get; private set; }

        public Object Id { get; private set; }

        OptimisticConcurrencyException(string message, long actualVersion, long expectedVersion, Object id)
            : base(message)
        {
            ActualVersion = actualVersion;
            ExpectedVersion = expectedVersion;
            Id = id;
        }

        public static OptimisticConcurrencyException Create(long actual, long expected, Object id)
        {
            var message = string.Format("Expected v{0} but found v{1}. Id: '{2}'", expected, actual, id);
            return new OptimisticConcurrencyException(message, actual, expected, id);
        }

        protected OptimisticConcurrencyException(
            SerializationInfo info,
            StreamingContext context)
            : base(info, context) { }
    }
}
