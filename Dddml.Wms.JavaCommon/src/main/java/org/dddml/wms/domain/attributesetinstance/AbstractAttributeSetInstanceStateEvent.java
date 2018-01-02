package org.dddml.wms.domain.attributesetinstance;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractAttributeSetInstanceStateEvent extends AbstractStateEvent implements AttributeSetInstanceStateEvent 
{
    private AttributeSetInstanceState state;

    public AttributeSetInstanceState getAttributeSetInstanceState() {
        return state;
    }

    public AttributeSetInstanceStateEventId getStateEventId() {
        AttributeSetInstanceStateEventId eventId = new AttributeSetInstanceStateEventId(state.getAttributeSetInstanceId(), AttributeSetInstanceState.VERSION_NULL);
        return eventId;
    }

    public void setStateEventId(AttributeSetInstanceStateEventId stateEventId) {
        this.state.setAttributeSetInstanceId(stateEventId.getAttributeSetInstanceId());
    }

    public String getAttributeSetInstanceId() {
        return getStateEventId().getAttributeSetInstanceId();
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId) {
        getStateEventId().setAttributeSetInstanceId(attributeSetInstanceId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    public String getAttributeSetId()
    {
        return this.state.getAttributeSetId();
    }

    public void setAttributeSetId(String attributeSetId)
    {
        this.state.setAttributeSetId(attributeSetId);
    }

    public String getOrganizationId()
    {
        return this.state.getOrganizationId();
    }

    public void setOrganizationId(String organizationId)
    {
        this.state.setOrganizationId(organizationId);
    }

    public String getReferenceId()
    {
        return this.state.getReferenceId();
    }

    public void setReferenceId(String referenceId)
    {
        this.state.setReferenceId(referenceId);
    }

    public String getSerialNumber()
    {
        return this.state.getSerialNumber();
    }

    public void setSerialNumber(String serialNumber)
    {
        this.state.setSerialNumber(serialNumber);
    }

    public String getLotId()
    {
        return this.state.getLotId();
    }

    public void setLotId(String lotId)
    {
        this.state.setLotId(lotId);
    }

    public String getDescription()
    {
        return this.state.getDescription();
    }

    public void setDescription(String description)
    {
        this.state.setDescription(description);
    }

    public String getHash()
    {
        return this.state.getHash();
    }

    public void setHash(String hash)
    {
        this.state.setHash(hash);
    }

    public BigDecimal getWidthInch()
    {
        return this.state.getWidthInch();
    }

    public void setWidthInch(BigDecimal widthInch)
    {
        this.state.setWidthInch(widthInch);
    }

    public BigDecimal getDiameterInch()
    {
        return this.state.getDiameterInch();
    }

    public void setDiameterInch(BigDecimal diameterInch)
    {
        this.state.setDiameterInch(diameterInch);
    }

    public BigDecimal getWeightLbs()
    {
        return this.state.getWeightLbs();
    }

    public void setWeightLbs(BigDecimal weightLbs)
    {
        this.state.setWeightLbs(weightLbs);
    }

    public BigDecimal getWeightKg()
    {
        return this.state.getWeightKg();
    }

    public void setWeightKg(BigDecimal weightKg)
    {
        this.state.setWeightKg(weightKg);
    }

    public BigDecimal getAirDryWeightLbs()
    {
        return this.state.getAirDryWeightLbs();
    }

    public void setAirDryWeightLbs(BigDecimal airDryWeightLbs)
    {
        this.state.setAirDryWeightLbs(airDryWeightLbs);
    }

    public BigDecimal getAirDryWeightKg()
    {
        return this.state.getAirDryWeightKg();
    }

    public void setAirDryWeightKg(BigDecimal airDryWeightKg)
    {
        this.state.setAirDryWeightKg(airDryWeightKg);
    }

    public BigDecimal getAirDryMetricTon()
    {
        return this.state.getAirDryMetricTon();
    }

    public void setAirDryMetricTon(BigDecimal airDryMetricTon)
    {
        this.state.setAirDryMetricTon(airDryMetricTon);
    }

    public Integer getPackageCount()
    {
        return this.state.getPackageCount();
    }

    public void setPackageCount(Integer packageCount)
    {
        this.state.setPackageCount(packageCount);
    }

    public BigDecimal getAirDryPct()
    {
        return this.state.getAirDryPct();
    }

    public void setAirDryPct(BigDecimal airDryPct)
    {
        this.state.setAirDryPct(airDryPct);
    }

    public Boolean get_F_B_0_()
    {
        return this.state.get_F_B_0_();
    }

    public void set_F_B_0_(Boolean _F_B_0_)
    {
        this.state.set_F_B_0_(_F_B_0_);
    }

    public Integer get_F_I_0_()
    {
        return this.state.get_F_I_0_();
    }

    public void set_F_I_0_(Integer _F_I_0_)
    {
        this.state.set_F_I_0_(_F_I_0_);
    }

    public Long get_F_L_0_()
    {
        return this.state.get_F_L_0_();
    }

    public void set_F_L_0_(Long _F_L_0_)
    {
        this.state.set_F_L_0_(_F_L_0_);
    }

    public Date get_F_DT_0_()
    {
        return this.state.get_F_DT_0_();
    }

    public void set_F_DT_0_(Date _F_DT_0_)
    {
        this.state.set_F_DT_0_(_F_DT_0_);
    }

    public BigDecimal get_F_N_0_()
    {
        return this.state.get_F_N_0_();
    }

    public void set_F_N_0_(BigDecimal _F_N_0_)
    {
        this.state.set_F_N_0_(_F_N_0_);
    }

    public String get_F_C5_0_()
    {
        return this.state.get_F_C5_0_();
    }

    public void set_F_C5_0_(String _F_C5_0_)
    {
        this.state.set_F_C5_0_(_F_C5_0_);
    }

    public String get_F_C10_0_()
    {
        return this.state.get_F_C10_0_();
    }

    public void set_F_C10_0_(String _F_C10_0_)
    {
        this.state.set_F_C10_0_(_F_C10_0_);
    }

    public String get_F_C20_0_()
    {
        return this.state.get_F_C20_0_();
    }

    public void set_F_C20_0_(String _F_C20_0_)
    {
        this.state.set_F_C20_0_(_F_C20_0_);
    }

    public String get_F_C50_0_()
    {
        return this.state.get_F_C50_0_();
    }

    public void set_F_C50_0_(String _F_C50_0_)
    {
        this.state.set_F_C50_0_(_F_C50_0_);
    }

    public String get_F_C100_0_()
    {
        return this.state.get_F_C100_0_();
    }

    public void set_F_C100_0_(String _F_C100_0_)
    {
        this.state.set_F_C100_0_(_F_C100_0_);
    }

    public String get_F_C200_0_()
    {
        return this.state.get_F_C200_0_();
    }

    public void set_F_C200_0_(String _F_C200_0_)
    {
        this.state.set_F_C200_0_(_F_C200_0_);
    }

    public String get_F_C500_0_()
    {
        return this.state.get_F_C500_0_();
    }

    public void set_F_C500_0_(String _F_C500_0_)
    {
        this.state.set_F_C500_0_(_F_C500_0_);
    }

    public String get_F_C1000_0_()
    {
        return this.state.get_F_C1000_0_();
    }

    public void set_F_C1000_0_(String _F_C1000_0_)
    {
        this.state.set_F_C1000_0_(_F_C1000_0_);
    }

    public Boolean get_F_B_1_()
    {
        return this.state.get_F_B_1_();
    }

    public void set_F_B_1_(Boolean _F_B_1_)
    {
        this.state.set_F_B_1_(_F_B_1_);
    }

    public Integer get_F_I_1_()
    {
        return this.state.get_F_I_1_();
    }

    public void set_F_I_1_(Integer _F_I_1_)
    {
        this.state.set_F_I_1_(_F_I_1_);
    }

    public Long get_F_L_1_()
    {
        return this.state.get_F_L_1_();
    }

    public void set_F_L_1_(Long _F_L_1_)
    {
        this.state.set_F_L_1_(_F_L_1_);
    }

    public Date get_F_DT_1_()
    {
        return this.state.get_F_DT_1_();
    }

    public void set_F_DT_1_(Date _F_DT_1_)
    {
        this.state.set_F_DT_1_(_F_DT_1_);
    }

    public BigDecimal get_F_N_1_()
    {
        return this.state.get_F_N_1_();
    }

    public void set_F_N_1_(BigDecimal _F_N_1_)
    {
        this.state.set_F_N_1_(_F_N_1_);
    }

    public String get_F_C5_1_()
    {
        return this.state.get_F_C5_1_();
    }

    public void set_F_C5_1_(String _F_C5_1_)
    {
        this.state.set_F_C5_1_(_F_C5_1_);
    }

    public String get_F_C10_1_()
    {
        return this.state.get_F_C10_1_();
    }

    public void set_F_C10_1_(String _F_C10_1_)
    {
        this.state.set_F_C10_1_(_F_C10_1_);
    }

    public String get_F_C20_1_()
    {
        return this.state.get_F_C20_1_();
    }

    public void set_F_C20_1_(String _F_C20_1_)
    {
        this.state.set_F_C20_1_(_F_C20_1_);
    }

    public String get_F_C50_1_()
    {
        return this.state.get_F_C50_1_();
    }

    public void set_F_C50_1_(String _F_C50_1_)
    {
        this.state.set_F_C50_1_(_F_C50_1_);
    }

    public String get_F_C100_1_()
    {
        return this.state.get_F_C100_1_();
    }

    public void set_F_C100_1_(String _F_C100_1_)
    {
        this.state.set_F_C100_1_(_F_C100_1_);
    }

    public String get_F_C200_1_()
    {
        return this.state.get_F_C200_1_();
    }

    public void set_F_C200_1_(String _F_C200_1_)
    {
        this.state.set_F_C200_1_(_F_C200_1_);
    }

    public Boolean get_F_B_2_()
    {
        return this.state.get_F_B_2_();
    }

    public void set_F_B_2_(Boolean _F_B_2_)
    {
        this.state.set_F_B_2_(_F_B_2_);
    }

    public Integer get_F_I_2_()
    {
        return this.state.get_F_I_2_();
    }

    public void set_F_I_2_(Integer _F_I_2_)
    {
        this.state.set_F_I_2_(_F_I_2_);
    }

    public Long get_F_L_2_()
    {
        return this.state.get_F_L_2_();
    }

    public void set_F_L_2_(Long _F_L_2_)
    {
        this.state.set_F_L_2_(_F_L_2_);
    }

    public Date get_F_DT_2_()
    {
        return this.state.get_F_DT_2_();
    }

    public void set_F_DT_2_(Date _F_DT_2_)
    {
        this.state.set_F_DT_2_(_F_DT_2_);
    }

    public BigDecimal get_F_N_2_()
    {
        return this.state.get_F_N_2_();
    }

    public void set_F_N_2_(BigDecimal _F_N_2_)
    {
        this.state.set_F_N_2_(_F_N_2_);
    }

    public String get_F_C5_2_()
    {
        return this.state.get_F_C5_2_();
    }

    public void set_F_C5_2_(String _F_C5_2_)
    {
        this.state.set_F_C5_2_(_F_C5_2_);
    }

    public String get_F_C10_2_()
    {
        return this.state.get_F_C10_2_();
    }

    public void set_F_C10_2_(String _F_C10_2_)
    {
        this.state.set_F_C10_2_(_F_C10_2_);
    }

    public String get_F_C20_2_()
    {
        return this.state.get_F_C20_2_();
    }

    public void set_F_C20_2_(String _F_C20_2_)
    {
        this.state.set_F_C20_2_(_F_C20_2_);
    }

    public String get_F_C50_2_()
    {
        return this.state.get_F_C50_2_();
    }

    public void set_F_C50_2_(String _F_C50_2_)
    {
        this.state.set_F_C50_2_(_F_C50_2_);
    }

    public Boolean get_F_B_3_()
    {
        return this.state.get_F_B_3_();
    }

    public void set_F_B_3_(Boolean _F_B_3_)
    {
        this.state.set_F_B_3_(_F_B_3_);
    }

    public Integer get_F_I_3_()
    {
        return this.state.get_F_I_3_();
    }

    public void set_F_I_3_(Integer _F_I_3_)
    {
        this.state.set_F_I_3_(_F_I_3_);
    }

    public Long get_F_L_3_()
    {
        return this.state.get_F_L_3_();
    }

    public void set_F_L_3_(Long _F_L_3_)
    {
        this.state.set_F_L_3_(_F_L_3_);
    }

    public Date get_F_DT_3_()
    {
        return this.state.get_F_DT_3_();
    }

    public void set_F_DT_3_(Date _F_DT_3_)
    {
        this.state.set_F_DT_3_(_F_DT_3_);
    }

    public BigDecimal get_F_N_3_()
    {
        return this.state.get_F_N_3_();
    }

    public void set_F_N_3_(BigDecimal _F_N_3_)
    {
        this.state.set_F_N_3_(_F_N_3_);
    }

    public String get_F_C5_3_()
    {
        return this.state.get_F_C5_3_();
    }

    public void set_F_C5_3_(String _F_C5_3_)
    {
        this.state.set_F_C5_3_(_F_C5_3_);
    }

    public String get_F_C10_3_()
    {
        return this.state.get_F_C10_3_();
    }

    public void set_F_C10_3_(String _F_C10_3_)
    {
        this.state.set_F_C10_3_(_F_C10_3_);
    }

    public String get_F_C20_3_()
    {
        return this.state.get_F_C20_3_();
    }

    public void set_F_C20_3_(String _F_C20_3_)
    {
        this.state.set_F_C20_3_(_F_C20_3_);
    }

    public String get_F_C50_3_()
    {
        return this.state.get_F_C50_3_();
    }

    public void set_F_C50_3_(String _F_C50_3_)
    {
        this.state.set_F_C50_3_(_F_C50_3_);
    }

    public Boolean get_F_B_4_()
    {
        return this.state.get_F_B_4_();
    }

    public void set_F_B_4_(Boolean _F_B_4_)
    {
        this.state.set_F_B_4_(_F_B_4_);
    }

    public Integer get_F_I_4_()
    {
        return this.state.get_F_I_4_();
    }

    public void set_F_I_4_(Integer _F_I_4_)
    {
        this.state.set_F_I_4_(_F_I_4_);
    }

    public Long get_F_L_4_()
    {
        return this.state.get_F_L_4_();
    }

    public void set_F_L_4_(Long _F_L_4_)
    {
        this.state.set_F_L_4_(_F_L_4_);
    }

    public Date get_F_DT_4_()
    {
        return this.state.get_F_DT_4_();
    }

    public void set_F_DT_4_(Date _F_DT_4_)
    {
        this.state.set_F_DT_4_(_F_DT_4_);
    }

    public BigDecimal get_F_N_4_()
    {
        return this.state.get_F_N_4_();
    }

    public void set_F_N_4_(BigDecimal _F_N_4_)
    {
        this.state.set_F_N_4_(_F_N_4_);
    }

    public String get_F_C5_4_()
    {
        return this.state.get_F_C5_4_();
    }

    public void set_F_C5_4_(String _F_C5_4_)
    {
        this.state.set_F_C5_4_(_F_C5_4_);
    }

    public String get_F_C10_4_()
    {
        return this.state.get_F_C10_4_();
    }

    public void set_F_C10_4_(String _F_C10_4_)
    {
        this.state.set_F_C10_4_(_F_C10_4_);
    }

    public String get_F_C20_4_()
    {
        return this.state.get_F_C20_4_();
    }

    public void set_F_C20_4_(String _F_C20_4_)
    {
        this.state.set_F_C20_4_(_F_C20_4_);
    }

    public String get_F_C50_4_()
    {
        return this.state.get_F_C50_4_();
    }

    public void set_F_C50_4_(String _F_C50_4_)
    {
        this.state.set_F_C50_4_(_F_C50_4_);
    }

    public String getCreatedBy()
    {
        return this.state.getCreatedBy();
    }

    public void setCreatedBy(String createdBy)
    {
        this.state.setCreatedBy(createdBy);
    }

    public Date getCreatedAt()
    {
        return this.state.getCreatedAt();
    }

    public void setCreatedAt(Date createdAt)
    {
        this.state.setCreatedAt(createdAt);
    }

    public Boolean getActive()
    {
        return this.state.getActive();
    }

    public void setActive(Boolean active)
    {
        this.state.setActive(active);
    }


    public String getCommandId() {
        return this.state.getCommandId();
    }

    public void setCommandId(String commandId) {
        this.state.setCommandId(commandId);
    }

    protected AbstractAttributeSetInstanceStateEvent() {
        this(new AbstractAttributeSetInstanceState.SimpleAttributeSetInstanceState());
    }

    protected AbstractAttributeSetInstanceStateEvent(AttributeSetInstanceStateEventId stateEventId) {
        this(new AbstractAttributeSetInstanceState.SimpleAttributeSetInstanceState());
        setStateEventId(stateEventId);
    }

    protected AbstractAttributeSetInstanceStateEvent(AttributeSetInstanceState s) {
        if (s == null) { throw new IllegalArgumentException(); }
        this.state = s;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractAttributeSetInstanceStateCreated extends AbstractAttributeSetInstanceStateEvent implements AttributeSetInstanceStateEvent.AttributeSetInstanceStateCreated
    {
        public AbstractAttributeSetInstanceStateCreated() {
            this(new AttributeSetInstanceStateEventId());
        }

        public AbstractAttributeSetInstanceStateCreated(AttributeSetInstanceStateEventId stateEventId) {
            super(stateEventId);
        }

        public AbstractAttributeSetInstanceStateCreated(AttributeSetInstanceState s) {
            super(s);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static class SimpleAttributeSetInstanceStateCreated extends AbstractAttributeSetInstanceStateCreated
    {
        public SimpleAttributeSetInstanceStateCreated() {
        }

        public SimpleAttributeSetInstanceStateCreated(AttributeSetInstanceStateEventId stateEventId) {
            super(stateEventId);
        }

        public SimpleAttributeSetInstanceStateCreated(AttributeSetInstanceState s) {
            super(s);
        }
    }

}

