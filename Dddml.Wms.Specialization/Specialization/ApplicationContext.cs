using System;


namespace Dddml.Wms.Specialization
{
    public abstract class ApplicationContext : IApplicationContext
    {

        private static volatile ApplicationContext _current;

        public static ApplicationContext Current
        {
            get
            {
                return _current;
            }
            set
            {
                _current = value;
            }
        }

        private ITypeConverter _typeConverter = new DefaultTypeConverter();

        public virtual ITypeConverter TypeConverter
        {
            get { return _typeConverter; }
            set { _typeConverter = value; }
        }

        public abstract object this[string name]
        {
            get;
        }

        public virtual IClobConverter ClobConverter
        {
            get
            {
                return (IClobConverter)this["ClobConverter"];
            }
        }

        public virtual ITimestampService TimestampService
        {
            get { return new DefaultTimestampService(); }
        }

        public class DefaultTimestampService : ITimestampService
        {
            public T Now<T>()
            {
                if (typeof(T).Equals(typeof(DateTime)))
                {
                    return (T)(object)DateTime.Now;
                }
                else if (typeof(T).Equals(typeof(long)))
                {
                    return (T)(object)DateTime.Now.Ticks;
                }
                else if (typeof(T).Equals(typeof(DateTime?)))
                {
                    return (T)(object)new DateTime?(DateTime.Now);
                }
                else if (typeof(T).Equals(typeof(long?)))
                {
                    return (T)(object)new long?(DateTime.Now.Ticks);
                }

                throw new ArgumentException("Unknown type: " + typeof(T));
            }

        }

    }
}

