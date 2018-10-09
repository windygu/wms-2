package org.dddml.wms.domain.contactmech;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractContactMechAggregate extends AbstractAggregate implements ContactMechAggregate
{
    private ContactMechState.MutableContactMechState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractContactMechAggregate(ContactMechState state)
    {
        this.state = (ContactMechState.MutableContactMechState)state;
    }

    public ContactMechState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(ContactMechCommand.CreateContactMech c)
    {
        if (c.getVersion() == null) { c.setVersion(ContactMechState.VERSION_NULL); }
        ContactMechEvent e = map(c);
        apply(e);
    }

    public void mergePatch(ContactMechCommand.MergePatchContactMech c)
    {
        ContactMechEvent e = map(c);
        apply(e);
    }

    public void delete(ContactMechCommand.DeleteContactMech c)
    {
        ContactMechEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        ContactMechCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected ContactMechEvent map(ContactMechCommand.CreateContactMech c) {
        ContactMechEventId stateEventId = new ContactMechEventId(c.getContactMechId(), c.getVersion());
        ContactMechEvent.ContactMechStateCreated e = newContactMechStateCreated(stateEventId);
        e.setContactMechTypeId(c.getContactMechTypeId());
        e.setInfoString(c.getInfoString());
        e.setToName(c.getToName());
        e.setAttnName(c.getAttnName());
        e.setAddress1(c.getAddress1());
        e.setAddress2(c.getAddress2());
        e.setDirections(c.getDirections());
        e.setCity(c.getCity());
        e.setPostalCode(c.getPostalCode());
        e.setPostalCodeExt(c.getPostalCodeExt());
        e.setCountryGeoId(c.getCountryGeoId());
        e.setStateProvinceGeoId(c.getStateProvinceGeoId());
        e.setCountyGeoId(c.getCountyGeoId());
        e.setPostalCodeGeoId(c.getPostalCodeGeoId());
        e.setGeoPointId(c.getGeoPointId());
        e.setCountryCode(c.getCountryCode());
        e.setAreaCode(c.getAreaCode());
        e.setContactNumber(c.getContactNumber());
        e.setAskForName(c.getAskForName());
        e.setActive(c.getActive());
        ((AbstractContactMechEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ContactMechEvent map(ContactMechCommand.MergePatchContactMech c) {
        ContactMechEventId stateEventId = new ContactMechEventId(c.getContactMechId(), c.getVersion());
        ContactMechEvent.ContactMechStateMergePatched e = newContactMechStateMergePatched(stateEventId);
        e.setContactMechTypeId(c.getContactMechTypeId());
        e.setInfoString(c.getInfoString());
        e.setToName(c.getToName());
        e.setAttnName(c.getAttnName());
        e.setAddress1(c.getAddress1());
        e.setAddress2(c.getAddress2());
        e.setDirections(c.getDirections());
        e.setCity(c.getCity());
        e.setPostalCode(c.getPostalCode());
        e.setPostalCodeExt(c.getPostalCodeExt());
        e.setCountryGeoId(c.getCountryGeoId());
        e.setStateProvinceGeoId(c.getStateProvinceGeoId());
        e.setCountyGeoId(c.getCountyGeoId());
        e.setPostalCodeGeoId(c.getPostalCodeGeoId());
        e.setGeoPointId(c.getGeoPointId());
        e.setCountryCode(c.getCountryCode());
        e.setAreaCode(c.getAreaCode());
        e.setContactNumber(c.getContactNumber());
        e.setAskForName(c.getAskForName());
        e.setActive(c.getActive());
        e.setIsPropertyContactMechTypeIdRemoved(c.getIsPropertyContactMechTypeIdRemoved());
        e.setIsPropertyInfoStringRemoved(c.getIsPropertyInfoStringRemoved());
        e.setIsPropertyToNameRemoved(c.getIsPropertyToNameRemoved());
        e.setIsPropertyAttnNameRemoved(c.getIsPropertyAttnNameRemoved());
        e.setIsPropertyAddress1Removed(c.getIsPropertyAddress1Removed());
        e.setIsPropertyAddress2Removed(c.getIsPropertyAddress2Removed());
        e.setIsPropertyDirectionsRemoved(c.getIsPropertyDirectionsRemoved());
        e.setIsPropertyCityRemoved(c.getIsPropertyCityRemoved());
        e.setIsPropertyPostalCodeRemoved(c.getIsPropertyPostalCodeRemoved());
        e.setIsPropertyPostalCodeExtRemoved(c.getIsPropertyPostalCodeExtRemoved());
        e.setIsPropertyCountryGeoIdRemoved(c.getIsPropertyCountryGeoIdRemoved());
        e.setIsPropertyStateProvinceGeoIdRemoved(c.getIsPropertyStateProvinceGeoIdRemoved());
        e.setIsPropertyCountyGeoIdRemoved(c.getIsPropertyCountyGeoIdRemoved());
        e.setIsPropertyPostalCodeGeoIdRemoved(c.getIsPropertyPostalCodeGeoIdRemoved());
        e.setIsPropertyGeoPointIdRemoved(c.getIsPropertyGeoPointIdRemoved());
        e.setIsPropertyCountryCodeRemoved(c.getIsPropertyCountryCodeRemoved());
        e.setIsPropertyAreaCodeRemoved(c.getIsPropertyAreaCodeRemoved());
        e.setIsPropertyContactNumberRemoved(c.getIsPropertyContactNumberRemoved());
        e.setIsPropertyAskForNameRemoved(c.getIsPropertyAskForNameRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractContactMechEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ContactMechEvent map(ContactMechCommand.DeleteContactMech c) {
        ContactMechEventId stateEventId = new ContactMechEventId(c.getContactMechId(), c.getVersion());
        ContactMechEvent.ContactMechStateDeleted e = newContactMechStateDeleted(stateEventId);
        ((AbstractContactMechEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected ContactMechEvent.ContactMechStateCreated newContactMechStateCreated(Long version, String commandId, String requesterId) {
        ContactMechEventId stateEventId = new ContactMechEventId(this.state.getContactMechId(), version);
        ContactMechEvent.ContactMechStateCreated e = newContactMechStateCreated(stateEventId);
        ((AbstractContactMechEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ContactMechEvent.ContactMechStateMergePatched newContactMechStateMergePatched(Long version, String commandId, String requesterId) {
        ContactMechEventId stateEventId = new ContactMechEventId(this.state.getContactMechId(), version);
        ContactMechEvent.ContactMechStateMergePatched e = newContactMechStateMergePatched(stateEventId);
        ((AbstractContactMechEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ContactMechEvent.ContactMechStateDeleted newContactMechStateDeleted(Long version, String commandId, String requesterId) {
        ContactMechEventId stateEventId = new ContactMechEventId(this.state.getContactMechId(), version);
        ContactMechEvent.ContactMechStateDeleted e = newContactMechStateDeleted(stateEventId);
        ((AbstractContactMechEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ContactMechEvent.ContactMechStateCreated newContactMechStateCreated(ContactMechEventId stateEventId) {
        return new AbstractContactMechEvent.SimpleContactMechStateCreated(stateEventId);
    }

    protected ContactMechEvent.ContactMechStateMergePatched newContactMechStateMergePatched(ContactMechEventId stateEventId) {
        return new AbstractContactMechEvent.SimpleContactMechStateMergePatched(stateEventId);
    }

    protected ContactMechEvent.ContactMechStateDeleted newContactMechStateDeleted(ContactMechEventId stateEventId)
    {
        return new AbstractContactMechEvent.SimpleContactMechStateDeleted(stateEventId);
    }

    public static class SimpleContactMechAggregate extends AbstractContactMechAggregate
    {
        public SimpleContactMechAggregate(ContactMechState state) {
            super(state);
        }

    }

}

