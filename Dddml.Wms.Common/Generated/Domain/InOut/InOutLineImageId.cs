﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInOutDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InOut;

namespace Dddml.Wms.Domain.InOut
{

	public class InOutLineImageId
	{

		private string _inOutDocumentNumber;

		public virtual string InOutDocumentNumber { 
			get { return this._inOutDocumentNumber; } 
			set { _inOutDocumentNumber = value; } 
		}

		private string _inOutLineLineNumber;

		public virtual string InOutLineLineNumber { 
			get { return this._inOutLineLineNumber; } 
			set { _inOutLineLineNumber = value; } 
		}

		private string _sequenceId;

		public virtual string SequenceId { 
			get { return this._sequenceId; } 
			set { _sequenceId = value; } 
		}


        #region  Flattened Properties


        #endregion

		public InOutLineImageId ()
		{
		}

		public InOutLineImageId (string inOutDocumentNumber, string inOutLineLineNumber, string sequenceId)
		{
			this._inOutDocumentNumber = inOutDocumentNumber;
			this._inOutLineLineNumber = inOutLineLineNumber;
			this._sequenceId = sequenceId;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			InOutLineImageId other = obj as InOutLineImageId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.InOutDocumentNumber, other.InOutDocumentNumber)
				&& Object.Equals (this.InOutLineLineNumber, other.InOutLineLineNumber)
				&& Object.Equals (this.SequenceId, other.SequenceId)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.InOutDocumentNumber != null) {
				hash += 13 * this.InOutDocumentNumber.GetHashCode ();
			}
			if (this.InOutLineLineNumber != null) {
				hash += 13 * this.InOutLineLineNumber.GetHashCode ();
			}
			if (this.SequenceId != null) {
				hash += 13 * this.SequenceId.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(InOutLineImageId obj1, InOutLineImageId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(InOutLineImageId obj1, InOutLineImageId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

        public override string ToString()
        {
            return String.Empty
                + "InOutDocumentNumber: " + this.InOutDocumentNumber + ", "
                + "InOutLineLineNumber: " + this.InOutLineLineNumber + ", "
                + "SequenceId: " + this.SequenceId + ", "
                ;
        }

        protected internal static readonly string[] FlattenedPropertyNames = new string[] { "InOutDocumentNumber", "InOutLineLineNumber", "SequenceId" };

        protected internal static readonly Type[] FlattenedPropertyTypes = new Type[] { typeof(string), typeof(string), typeof(string) };

        protected internal static readonly IDictionary<string, Type> FlattenedPropertyTypeDictionary;

        static InOutLineImageId()
        {
            var dict = new Dictionary<string, Type>();
            for (int i = 0; i < FlattenedPropertyNames.Length; i++)
            {
                dict.Add(FlattenedPropertyNames[i], FlattenedPropertyTypes[i]);
            }
            FlattenedPropertyTypeDictionary = dict;
        }

        protected internal void ForEachFlattenedProperty(Action<string, object> act)
        {
            for (int i = 0; i < FlattenedPropertyNames.Length; i++)
            {
                string pn = FlattenedPropertyNames[i];
                if (Char.IsLower(pn[0])) { pn = Char.ToUpper(pn[0]) + pn.Substring(1); }
                var m = this.GetType().GetProperty(pn, System.Reflection.BindingFlags.Public | System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Instance);
                object pv = m.GetValue(this);
                act(pn, pv);
            }
        }

        protected internal void SetFlattenedPropertyValues(params object[] values)
        {
            for (int i = 0; i < FlattenedPropertyNames.Length; i++)
            {
                string pn = FlattenedPropertyNames[i];
                if (Char.IsLower(pn[0])) { pn = Char.ToUpper(pn[0]) + pn.Substring(1); }
                var v = values[i];
                var m = this.GetType().GetProperty(pn, System.Reflection.BindingFlags.Public | System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Instance);
                m.SetValue(this, v);
            }
        }
	}

}


