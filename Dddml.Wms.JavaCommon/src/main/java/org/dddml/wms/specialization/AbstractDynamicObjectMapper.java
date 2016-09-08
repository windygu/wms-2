package org.dddml.wms.specialization;

public abstract class AbstractDynamicObjectMapper<TDynamicObject, TState, TCommandCreate, TCommandMergePatch>
{
    public abstract TDynamicObject MapState(TState state);

    public abstract TCommandCreate ToCommandCreate(TDynamicObject dynamicObject);

    public abstract TCommandMergePatch ToCommandMergePatch(TDynamicObject dynamicObject);

}