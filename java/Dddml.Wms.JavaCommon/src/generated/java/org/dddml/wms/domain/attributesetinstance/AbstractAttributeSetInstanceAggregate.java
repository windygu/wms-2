package org.dddml.wms.domain.attributesetinstance;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeSetInstanceAggregate extends AbstractAggregate implements AttributeSetInstanceAggregate
{
    private AttributeSetInstanceState.MutableAttributeSetInstanceState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractAttributeSetInstanceAggregate(AttributeSetInstanceState state)
    {
        this.state = (AttributeSetInstanceState.MutableAttributeSetInstanceState)state;
    }

    public AttributeSetInstanceState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(AttributeSetInstanceCommand.CreateAttributeSetInstance c)
    {
        if (c.getVersion() == null) { c.setVersion(AttributeSetInstanceState.VERSION_NULL); }
        AttributeSetInstanceEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        AttributeSetInstanceCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected AttributeSetInstanceEvent map(AttributeSetInstanceCommand.CreateAttributeSetInstance c) {
        AttributeSetInstanceEventId stateEventId = new AttributeSetInstanceEventId(c.getAttributeSetInstanceId(), c.getVersion());
        AttributeSetInstanceEvent.AttributeSetInstanceStateCreated e = newAttributeSetInstanceStateCreated(stateEventId);
        e.setAttributeSetId(c.getAttributeSetId());
        e.setOrganizationId(c.getOrganizationId());
        e.setReferenceId(c.getReferenceId());
        e.setSerialNumber(c.getSerialNumber());
        e.setLotId(c.getLotId());
        e.setStatusIds(c.getStatusIds());
        e.setImageUrl(c.getImageUrl());
        e.setDescription(c.getDescription());
        e.setHash(c.getHash());
        e.setWidthInch(c.getWidthInch());
        e.setDiameterInch(c.getDiameterInch());
        e.setWeightLbs(c.getWeightLbs());
        e.setWeightKg(c.getWeightKg());
        e.setAirDryWeightLbs(c.getAirDryWeightLbs());
        e.setAirDryWeightKg(c.getAirDryWeightKg());
        e.setAirDryMetricTon(c.getAirDryMetricTon());
        e.setRollCnt(c.getRollCnt());
        e.setAirDryPct(c.getAirDryPct());
        e.set_F_B_0_(c.get_F_B_0_());
        e.set_F_I_0_(c.get_F_I_0_());
        e.set_F_L_0_(c.get_F_L_0_());
        e.set_F_DT_0_(c.get_F_DT_0_());
        e.set_F_N_0_(c.get_F_N_0_());
        e.set_F_C5_0_(c.get_F_C5_0_());
        e.set_F_C10_0_(c.get_F_C10_0_());
        e.set_F_C20_0_(c.get_F_C20_0_());
        e.set_F_C50_0_(c.get_F_C50_0_());
        e.set_F_C100_0_(c.get_F_C100_0_());
        e.set_F_C200_0_(c.get_F_C200_0_());
        e.set_F_C500_0_(c.get_F_C500_0_());
        e.set_F_C1000_0_(c.get_F_C1000_0_());
        e.set_F_B_1_(c.get_F_B_1_());
        e.set_F_I_1_(c.get_F_I_1_());
        e.set_F_L_1_(c.get_F_L_1_());
        e.set_F_DT_1_(c.get_F_DT_1_());
        e.set_F_N_1_(c.get_F_N_1_());
        e.set_F_C5_1_(c.get_F_C5_1_());
        e.set_F_C10_1_(c.get_F_C10_1_());
        e.set_F_C20_1_(c.get_F_C20_1_());
        e.set_F_C50_1_(c.get_F_C50_1_());
        e.set_F_C100_1_(c.get_F_C100_1_());
        e.set_F_C200_1_(c.get_F_C200_1_());
        e.set_F_B_2_(c.get_F_B_2_());
        e.set_F_I_2_(c.get_F_I_2_());
        e.set_F_L_2_(c.get_F_L_2_());
        e.set_F_DT_2_(c.get_F_DT_2_());
        e.set_F_N_2_(c.get_F_N_2_());
        e.set_F_C5_2_(c.get_F_C5_2_());
        e.set_F_C10_2_(c.get_F_C10_2_());
        e.set_F_C20_2_(c.get_F_C20_2_());
        e.set_F_C50_2_(c.get_F_C50_2_());
        e.set_F_B_3_(c.get_F_B_3_());
        e.set_F_I_3_(c.get_F_I_3_());
        e.set_F_L_3_(c.get_F_L_3_());
        e.set_F_DT_3_(c.get_F_DT_3_());
        e.set_F_N_3_(c.get_F_N_3_());
        e.set_F_C5_3_(c.get_F_C5_3_());
        e.set_F_C10_3_(c.get_F_C10_3_());
        e.set_F_C20_3_(c.get_F_C20_3_());
        e.set_F_C50_3_(c.get_F_C50_3_());
        e.set_F_B_4_(c.get_F_B_4_());
        e.set_F_I_4_(c.get_F_I_4_());
        e.set_F_L_4_(c.get_F_L_4_());
        e.set_F_DT_4_(c.get_F_DT_4_());
        e.set_F_N_4_(c.get_F_N_4_());
        e.set_F_C5_4_(c.get_F_C5_4_());
        e.set_F_C10_4_(c.get_F_C10_4_());
        e.set_F_C20_4_(c.get_F_C20_4_());
        e.set_F_C50_4_(c.get_F_C50_4_());
        e.setActive(c.getActive());
        ((AbstractAttributeSetInstanceEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected AttributeSetInstanceEvent.AttributeSetInstanceStateCreated newAttributeSetInstanceStateCreated(Long version, String commandId, String requesterId) {
        AttributeSetInstanceEventId stateEventId = new AttributeSetInstanceEventId(this.state.getAttributeSetInstanceId(), version);
        AttributeSetInstanceEvent.AttributeSetInstanceStateCreated e = newAttributeSetInstanceStateCreated(stateEventId);
        ((AbstractAttributeSetInstanceEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceEvent.AttributeSetInstanceStateCreated newAttributeSetInstanceStateCreated(AttributeSetInstanceEventId stateEventId) {
        return new AbstractAttributeSetInstanceEvent.SimpleAttributeSetInstanceStateCreated(stateEventId);
    }

    public static class SimpleAttributeSetInstanceAggregate extends AbstractAttributeSetInstanceAggregate
    {
        public SimpleAttributeSetInstanceAggregate(AttributeSetInstanceState state) {
            super(state);
        }

    }

}

