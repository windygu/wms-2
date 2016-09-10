package org.dddml.wms.specialization;


import com.alibaba.fastjson.JSONObject;

public abstract class AbstractDynamicObjectMapper<TDynamicObject, TState, TCommandCreate, TCommandMergePatch> {
    public abstract JSONObject mapState(TState state, String fields);

    //public abstract TDynamicObject mapState(TState state);

    public abstract TCommandCreate toCommandCreate(TDynamicObject dynamicObject);

    public abstract TCommandMergePatch toCommandMergePatch(TDynamicObject dynamicObject);

}