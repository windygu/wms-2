﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateControllers.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.ComponentModel;
using System.Net.Http;
using System.Web.Http;
using Dddml.Wms.Domain;

using Dddml.Wms.Specialization;
using Newtonsoft.Json.Linq;
using Dddml.Wms.Domain.Metadata;


namespace Dddml.Wms.HttpServices.ApiControllers
{

    public partial class AttributeSetInstancesController : ApiController
    {

        IIdGenerator<string, ICreateAttributeSetInstance> _attributeSetInstanceIdGenerator = ApplicationContext.Current["AttributeSetInstanceIdGenerator"] as IIdGenerator<string, ICreateAttributeSetInstance>;

        DynamicObjectMapperBase<JObject, AttributeSetInstanceStateDto, CreateAttributeSetInstanceDto, MergePatchAttributeSetInstanceDto> _attributeSetInstanceDtoJObjectMapper = ApplicationContext.Current["AttributeSetInstanceDtoJObjectMapper"] as DynamicObjectMapperBase<JObject, AttributeSetInstanceStateDto, CreateAttributeSetInstanceDto, MergePatchAttributeSetInstanceDto>;

        IAttributeSetInstanceApplicationService _attributeSetInstanceApplicationService = ApplicationContext.Current["AttributeSetInstanceApplicationService"] as IAttributeSetInstanceApplicationService;

        [HttpGet]
        public JArray GetAll(string sort = null, string fields = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var states = _attributeSetInstanceApplicationService.Get(GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs())
                , GetQueryOrders(sort), firstResult, maxResults);
            JArray dynamicArray = new JArray(); 
            foreach (var s in states)
            {
                var dto = new AttributeSetInstanceStateDto((AttributeSetInstanceState)s);
                if (String.IsNullOrWhiteSpace(fields))
                {
                    dto.AllFieldsReturned = true;
                }
                else
                {
                    dto.ReturnedFieldsString = fields;
                }
                dynamicArray.Add(_attributeSetInstanceDtoJObjectMapper.MapState(dto));
            }
            return dynamicArray; 
        }

        [HttpGet]
        public JObject Get(string id, string fields = null)
        {
            var idObj = id;
            var state = (AttributeSetInstanceState)_attributeSetInstanceApplicationService.Get(idObj);
            var stateDto = new AttributeSetInstanceStateDto(state);
            if (String.IsNullOrWhiteSpace(fields))
            {
                stateDto.AllFieldsReturned = true;
            }
            else
            {
                stateDto.ReturnedFieldsString = fields;
            }
            return _attributeSetInstanceDtoJObjectMapper.MapState(stateDto);
        }

        [HttpPost]
        public void Post([FromBody]JObject dynamicObject)
        {
            CreateAttributeSetInstanceDto value = _attributeSetInstanceDtoJObjectMapper.ToCommandCreate(dynamicObject);
            string idObj = _attributeSetInstanceIdGenerator.GenerateId(value); 
            (value as IAttributeSetInstanceStateProperties).AttributeSetInstanceId = idObj;
            _attributeSetInstanceApplicationService.When(value.ToCommand() as ICreateAttributeSetInstance);
        }

        [HttpPut]
        public void Put(string id, [FromBody]JObject dynamicObject)
        {
            CreateAttributeSetInstanceDto value = _attributeSetInstanceDtoJObjectMapper.ToCommandCreate(dynamicObject);
            SetNullIdOrThrowOnInconsistentIds(id, value);
            _attributeSetInstanceApplicationService.When(value.ToCommand() as ICreateAttributeSetInstance);
        }

        [HttpPatch]
        public void Patch(string id, [FromBody]JObject dynamicObject)
        {
            MergePatchAttributeSetInstanceDto value = _attributeSetInstanceDtoJObjectMapper.ToCommandMergePatch(dynamicObject);
            SetNullIdOrThrowOnInconsistentIds(id, value);
            _attributeSetInstanceApplicationService.When(value.ToCommand() as IMergePatchAttributeSetInstance);
        }

        [HttpDelete]
        public void Delete(string id, string commandId, string requesterId = default(string))
        {
            var value = new DeleteAttributeSetInstanceDto();
            value.CommandId = commandId;
            value.RequesterId = requesterId;
            SetNullIdOrThrowOnInconsistentIds(id, value);
            _attributeSetInstanceApplicationService.When(value.ToCommand() as IDeleteAttributeSetInstance);
        }

		// /////////////////////////////////////////////////

        protected static void SetNullIdOrThrowOnInconsistentIds(string id, CreateOrMergePatchOrDeleteAttributeSetInstanceDto value)
        {
            var idObj = id;
            if (value.AttributeSetInstanceId == null)
            {
                value.AttributeSetInstanceId = idObj;
            }
            else if (!(value as IAttributeSetInstanceStateProperties).AttributeSetInstanceId.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, value.AttributeSetInstanceId);
            }
        }


        protected virtual string GetFilterPropertyName(string fieldName)
        {
            if (String.Equals(fieldName, "sort", StringComparison.InvariantCultureIgnoreCase)
                || String.Equals(fieldName, "firstResult", StringComparison.InvariantCultureIgnoreCase)
                || String.Equals(fieldName, "maxResults", StringComparison.InvariantCultureIgnoreCase)
                || String.Equals(fieldName, "fields", StringComparison.InvariantCultureIgnoreCase))
            {
                return null;
            }
            if (AttributeSetInstanceMetadata.Instance.PropertyMetadataDictionary.ContainsKey(fieldName))
            {
                var p = AttributeSetInstanceMetadata.Instance.PropertyMetadataDictionary[fieldName];
                if (!p.IsCollectionProperty && !p.IsTransient && p.IsBasicType)
                {
                    var propertyName = fieldName;
                    if (p.IsDerived)
                    {
                        propertyName = p.DerivedFrom;
                    }
                    return propertyName;
                }
            }
            return null;
        }

        protected virtual Type GetFilterPropertyType(string propertyName)
        {
            if (AttributeSetInstanceMetadata.Instance.PropertyMetadataDictionary.ContainsKey(propertyName))
            {
                return AttributeSetInstanceMetadata.Instance.PropertyMetadataDictionary[propertyName].Type;
            }
            return typeof(string);
        }

        private IDictionary<string, object> GetQueryFilterDictionary(IEnumerable<KeyValuePair<string, string>> queryNameValuePairs)
        {
            var filter = new Dictionary<string, object>();
            foreach (var p in queryNameValuePairs)
            {
                var pName = GetFilterPropertyName(p.Key);
                if (!String.IsNullOrWhiteSpace(pName))
                {
                    Type type = GetFilterPropertyType(pName);
                    var converter = TypeDescriptor.GetConverter(type);
                    var pValue = converter.ConvertFromString(p.Value);
                    filter.Add(pName, pValue);
                }
            }
            return filter;
        }

        private IList<string> GetQueryOrders(string str)
        {
            if (String.IsNullOrWhiteSpace(str))
            {
                return new string[0];
            }
            var arr = str.Split(new string[] { QueryOrderSeparator }, StringSplitOptions.RemoveEmptyEntries);
            var orders = new List<string>();
            foreach (var a in arr)
            {
                orders.Add(a.Trim());
            }
            return orders;
        }

        protected virtual string QueryOrderSeparator
        {
            get { return ","; }
        }


    }


    public abstract partial class AttributeSetInstanceDtoJObjectMapperBase : DynamicObjectMapperBase<JObject, AttributeSetInstanceStateDto, CreateAttributeSetInstanceDto, MergePatchAttributeSetInstanceDto>
    {
        public override JObject MapState(AttributeSetInstanceStateDto state)
        {
            var dynamicObject = NewJObject(state);
            MapExtensionProperties(state, dynamicObject);
            return dynamicObject;
        }

        public override CreateAttributeSetInstanceDto ToCommandCreate(JObject dynamicObject)
        {
            CreateAttributeSetInstanceDto command = NewCreateAttributeSetInstanceDto(dynamicObject);
            MapExtensionProperties(dynamicObject, command);
            return command;
        }

        public override MergePatchAttributeSetInstanceDto ToCommandMergePatch(JObject dynamicObject)
        {
            MergePatchAttributeSetInstanceDto command = NewMergePatchAttributeSetInstanceDto(dynamicObject);
            MapExtensionProperties(dynamicObject, command);
            return command;
        }

        protected virtual CreateAttributeSetInstanceDto NewCreateAttributeSetInstanceDto(JObject dynamicObject)
        {
            CreateAttributeSetInstanceDto command = dynamicObject.ToObject<CreateAttributeSetInstanceDto>();
            return command;
        }

        protected virtual MergePatchAttributeSetInstanceDto NewMergePatchAttributeSetInstanceDto(JObject dynamicObject)
        {
            MergePatchAttributeSetInstanceDto command = dynamicObject.ToObject<MergePatchAttributeSetInstanceDto>();
            return command;
        }

        protected virtual JObject NewJObject(AttributeSetInstanceStateDto state)
        {
            var dynamicObject = JObject.FromObject(state);
            return dynamicObject;
        }

        protected abstract void MapExtensionProperties(AttributeSetInstanceStateDto state, JObject dynamicObject);

        protected abstract void MapExtensionProperties(JObject dynamicObject, CreateAttributeSetInstanceDto command);

        protected abstract void MapExtensionProperties(JObject dynamicObject, MergePatchAttributeSetInstanceDto command);


    }



}

