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

    public String getLot()
    {
        return this.state.getLot();
    }

    public void setLot(String lot)
    {
        this.state.setLot(lot);
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

    public String get_F_C500_1_()
    {
        return this.state.get_F_C500_1_();
    }

    public void set_F_C500_1_(String _F_C500_1_)
    {
        this.state.set_F_C500_1_(_F_C500_1_);
    }

    public String get_F_C1000_1_()
    {
        return this.state.get_F_C1000_1_();
    }

    public void set_F_C1000_1_(String _F_C1000_1_)
    {
        this.state.set_F_C1000_1_(_F_C1000_1_);
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

    public String get_F_C100_2_()
    {
        return this.state.get_F_C100_2_();
    }

    public void set_F_C100_2_(String _F_C100_2_)
    {
        this.state.set_F_C100_2_(_F_C100_2_);
    }

    public String get_F_C200_2_()
    {
        return this.state.get_F_C200_2_();
    }

    public void set_F_C200_2_(String _F_C200_2_)
    {
        this.state.set_F_C200_2_(_F_C200_2_);
    }

    public String get_F_C500_2_()
    {
        return this.state.get_F_C500_2_();
    }

    public void set_F_C500_2_(String _F_C500_2_)
    {
        this.state.set_F_C500_2_(_F_C500_2_);
    }

    public String get_F_C1000_2_()
    {
        return this.state.get_F_C1000_2_();
    }

    public void set_F_C1000_2_(String _F_C1000_2_)
    {
        this.state.set_F_C1000_2_(_F_C1000_2_);
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

    public String get_F_C100_3_()
    {
        return this.state.get_F_C100_3_();
    }

    public void set_F_C100_3_(String _F_C100_3_)
    {
        this.state.set_F_C100_3_(_F_C100_3_);
    }

    public String get_F_C200_3_()
    {
        return this.state.get_F_C200_3_();
    }

    public void set_F_C200_3_(String _F_C200_3_)
    {
        this.state.set_F_C200_3_(_F_C200_3_);
    }

    public String get_F_C500_3_()
    {
        return this.state.get_F_C500_3_();
    }

    public void set_F_C500_3_(String _F_C500_3_)
    {
        this.state.set_F_C500_3_(_F_C500_3_);
    }

    public String get_F_C1000_3_()
    {
        return this.state.get_F_C1000_3_();
    }

    public void set_F_C1000_3_(String _F_C1000_3_)
    {
        this.state.set_F_C1000_3_(_F_C1000_3_);
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

    public String get_F_C100_4_()
    {
        return this.state.get_F_C100_4_();
    }

    public void set_F_C100_4_(String _F_C100_4_)
    {
        this.state.set_F_C100_4_(_F_C100_4_);
    }

    public String get_F_C200_4_()
    {
        return this.state.get_F_C200_4_();
    }

    public void set_F_C200_4_(String _F_C200_4_)
    {
        this.state.set_F_C200_4_(_F_C200_4_);
    }

    public String get_F_C500_4_()
    {
        return this.state.get_F_C500_4_();
    }

    public void set_F_C500_4_(String _F_C500_4_)
    {
        this.state.set_F_C500_4_(_F_C500_4_);
    }

    public String get_F_C1000_4_()
    {
        return this.state.get_F_C1000_4_();
    }

    public void set_F_C1000_4_(String _F_C1000_4_)
    {
        this.state.set_F_C1000_4_(_F_C1000_4_);
    }

    public Boolean get_F_B_5_()
    {
        return this.state.get_F_B_5_();
    }

    public void set_F_B_5_(Boolean _F_B_5_)
    {
        this.state.set_F_B_5_(_F_B_5_);
    }

    public Integer get_F_I_5_()
    {
        return this.state.get_F_I_5_();
    }

    public void set_F_I_5_(Integer _F_I_5_)
    {
        this.state.set_F_I_5_(_F_I_5_);
    }

    public Long get_F_L_5_()
    {
        return this.state.get_F_L_5_();
    }

    public void set_F_L_5_(Long _F_L_5_)
    {
        this.state.set_F_L_5_(_F_L_5_);
    }

    public Date get_F_DT_5_()
    {
        return this.state.get_F_DT_5_();
    }

    public void set_F_DT_5_(Date _F_DT_5_)
    {
        this.state.set_F_DT_5_(_F_DT_5_);
    }

    public BigDecimal get_F_N_5_()
    {
        return this.state.get_F_N_5_();
    }

    public void set_F_N_5_(BigDecimal _F_N_5_)
    {
        this.state.set_F_N_5_(_F_N_5_);
    }

    public String get_F_C5_5_()
    {
        return this.state.get_F_C5_5_();
    }

    public void set_F_C5_5_(String _F_C5_5_)
    {
        this.state.set_F_C5_5_(_F_C5_5_);
    }

    public String get_F_C10_5_()
    {
        return this.state.get_F_C10_5_();
    }

    public void set_F_C10_5_(String _F_C10_5_)
    {
        this.state.set_F_C10_5_(_F_C10_5_);
    }

    public String get_F_C20_5_()
    {
        return this.state.get_F_C20_5_();
    }

    public void set_F_C20_5_(String _F_C20_5_)
    {
        this.state.set_F_C20_5_(_F_C20_5_);
    }

    public String get_F_C50_5_()
    {
        return this.state.get_F_C50_5_();
    }

    public void set_F_C50_5_(String _F_C50_5_)
    {
        this.state.set_F_C50_5_(_F_C50_5_);
    }

    public String get_F_C100_5_()
    {
        return this.state.get_F_C100_5_();
    }

    public void set_F_C100_5_(String _F_C100_5_)
    {
        this.state.set_F_C100_5_(_F_C100_5_);
    }

    public String get_F_C200_5_()
    {
        return this.state.get_F_C200_5_();
    }

    public void set_F_C200_5_(String _F_C200_5_)
    {
        this.state.set_F_C200_5_(_F_C200_5_);
    }

    public String get_F_C500_5_()
    {
        return this.state.get_F_C500_5_();
    }

    public void set_F_C500_5_(String _F_C500_5_)
    {
        this.state.set_F_C500_5_(_F_C500_5_);
    }

    public Boolean get_F_B_6_()
    {
        return this.state.get_F_B_6_();
    }

    public void set_F_B_6_(Boolean _F_B_6_)
    {
        this.state.set_F_B_6_(_F_B_6_);
    }

    public Integer get_F_I_6_()
    {
        return this.state.get_F_I_6_();
    }

    public void set_F_I_6_(Integer _F_I_6_)
    {
        this.state.set_F_I_6_(_F_I_6_);
    }

    public Long get_F_L_6_()
    {
        return this.state.get_F_L_6_();
    }

    public void set_F_L_6_(Long _F_L_6_)
    {
        this.state.set_F_L_6_(_F_L_6_);
    }

    public Date get_F_DT_6_()
    {
        return this.state.get_F_DT_6_();
    }

    public void set_F_DT_6_(Date _F_DT_6_)
    {
        this.state.set_F_DT_6_(_F_DT_6_);
    }

    public BigDecimal get_F_N_6_()
    {
        return this.state.get_F_N_6_();
    }

    public void set_F_N_6_(BigDecimal _F_N_6_)
    {
        this.state.set_F_N_6_(_F_N_6_);
    }

    public String get_F_C5_6_()
    {
        return this.state.get_F_C5_6_();
    }

    public void set_F_C5_6_(String _F_C5_6_)
    {
        this.state.set_F_C5_6_(_F_C5_6_);
    }

    public String get_F_C10_6_()
    {
        return this.state.get_F_C10_6_();
    }

    public void set_F_C10_6_(String _F_C10_6_)
    {
        this.state.set_F_C10_6_(_F_C10_6_);
    }

    public String get_F_C20_6_()
    {
        return this.state.get_F_C20_6_();
    }

    public void set_F_C20_6_(String _F_C20_6_)
    {
        this.state.set_F_C20_6_(_F_C20_6_);
    }

    public String get_F_C50_6_()
    {
        return this.state.get_F_C50_6_();
    }

    public void set_F_C50_6_(String _F_C50_6_)
    {
        this.state.set_F_C50_6_(_F_C50_6_);
    }

    public String get_F_C100_6_()
    {
        return this.state.get_F_C100_6_();
    }

    public void set_F_C100_6_(String _F_C100_6_)
    {
        this.state.set_F_C100_6_(_F_C100_6_);
    }

    public String get_F_C200_6_()
    {
        return this.state.get_F_C200_6_();
    }

    public void set_F_C200_6_(String _F_C200_6_)
    {
        this.state.set_F_C200_6_(_F_C200_6_);
    }

    public String get_F_C500_6_()
    {
        return this.state.get_F_C500_6_();
    }

    public void set_F_C500_6_(String _F_C500_6_)
    {
        this.state.set_F_C500_6_(_F_C500_6_);
    }

    public Boolean get_F_B_7_()
    {
        return this.state.get_F_B_7_();
    }

    public void set_F_B_7_(Boolean _F_B_7_)
    {
        this.state.set_F_B_7_(_F_B_7_);
    }

    public Integer get_F_I_7_()
    {
        return this.state.get_F_I_7_();
    }

    public void set_F_I_7_(Integer _F_I_7_)
    {
        this.state.set_F_I_7_(_F_I_7_);
    }

    public Long get_F_L_7_()
    {
        return this.state.get_F_L_7_();
    }

    public void set_F_L_7_(Long _F_L_7_)
    {
        this.state.set_F_L_7_(_F_L_7_);
    }

    public Date get_F_DT_7_()
    {
        return this.state.get_F_DT_7_();
    }

    public void set_F_DT_7_(Date _F_DT_7_)
    {
        this.state.set_F_DT_7_(_F_DT_7_);
    }

    public BigDecimal get_F_N_7_()
    {
        return this.state.get_F_N_7_();
    }

    public void set_F_N_7_(BigDecimal _F_N_7_)
    {
        this.state.set_F_N_7_(_F_N_7_);
    }

    public String get_F_C5_7_()
    {
        return this.state.get_F_C5_7_();
    }

    public void set_F_C5_7_(String _F_C5_7_)
    {
        this.state.set_F_C5_7_(_F_C5_7_);
    }

    public String get_F_C10_7_()
    {
        return this.state.get_F_C10_7_();
    }

    public void set_F_C10_7_(String _F_C10_7_)
    {
        this.state.set_F_C10_7_(_F_C10_7_);
    }

    public String get_F_C20_7_()
    {
        return this.state.get_F_C20_7_();
    }

    public void set_F_C20_7_(String _F_C20_7_)
    {
        this.state.set_F_C20_7_(_F_C20_7_);
    }

    public String get_F_C50_7_()
    {
        return this.state.get_F_C50_7_();
    }

    public void set_F_C50_7_(String _F_C50_7_)
    {
        this.state.set_F_C50_7_(_F_C50_7_);
    }

    public String get_F_C100_7_()
    {
        return this.state.get_F_C100_7_();
    }

    public void set_F_C100_7_(String _F_C100_7_)
    {
        this.state.set_F_C100_7_(_F_C100_7_);
    }

    public String get_F_C200_7_()
    {
        return this.state.get_F_C200_7_();
    }

    public void set_F_C200_7_(String _F_C200_7_)
    {
        this.state.set_F_C200_7_(_F_C200_7_);
    }

    public String get_F_C500_7_()
    {
        return this.state.get_F_C500_7_();
    }

    public void set_F_C500_7_(String _F_C500_7_)
    {
        this.state.set_F_C500_7_(_F_C500_7_);
    }

    public Boolean get_F_B_8_()
    {
        return this.state.get_F_B_8_();
    }

    public void set_F_B_8_(Boolean _F_B_8_)
    {
        this.state.set_F_B_8_(_F_B_8_);
    }

    public Integer get_F_I_8_()
    {
        return this.state.get_F_I_8_();
    }

    public void set_F_I_8_(Integer _F_I_8_)
    {
        this.state.set_F_I_8_(_F_I_8_);
    }

    public Long get_F_L_8_()
    {
        return this.state.get_F_L_8_();
    }

    public void set_F_L_8_(Long _F_L_8_)
    {
        this.state.set_F_L_8_(_F_L_8_);
    }

    public Date get_F_DT_8_()
    {
        return this.state.get_F_DT_8_();
    }

    public void set_F_DT_8_(Date _F_DT_8_)
    {
        this.state.set_F_DT_8_(_F_DT_8_);
    }

    public BigDecimal get_F_N_8_()
    {
        return this.state.get_F_N_8_();
    }

    public void set_F_N_8_(BigDecimal _F_N_8_)
    {
        this.state.set_F_N_8_(_F_N_8_);
    }

    public String get_F_C5_8_()
    {
        return this.state.get_F_C5_8_();
    }

    public void set_F_C5_8_(String _F_C5_8_)
    {
        this.state.set_F_C5_8_(_F_C5_8_);
    }

    public String get_F_C10_8_()
    {
        return this.state.get_F_C10_8_();
    }

    public void set_F_C10_8_(String _F_C10_8_)
    {
        this.state.set_F_C10_8_(_F_C10_8_);
    }

    public String get_F_C20_8_()
    {
        return this.state.get_F_C20_8_();
    }

    public void set_F_C20_8_(String _F_C20_8_)
    {
        this.state.set_F_C20_8_(_F_C20_8_);
    }

    public String get_F_C50_8_()
    {
        return this.state.get_F_C50_8_();
    }

    public void set_F_C50_8_(String _F_C50_8_)
    {
        this.state.set_F_C50_8_(_F_C50_8_);
    }

    public String get_F_C100_8_()
    {
        return this.state.get_F_C100_8_();
    }

    public void set_F_C100_8_(String _F_C100_8_)
    {
        this.state.set_F_C100_8_(_F_C100_8_);
    }

    public String get_F_C200_8_()
    {
        return this.state.get_F_C200_8_();
    }

    public void set_F_C200_8_(String _F_C200_8_)
    {
        this.state.set_F_C200_8_(_F_C200_8_);
    }

    public String get_F_C500_8_()
    {
        return this.state.get_F_C500_8_();
    }

    public void set_F_C500_8_(String _F_C500_8_)
    {
        this.state.set_F_C500_8_(_F_C500_8_);
    }

    public Boolean get_F_B_9_()
    {
        return this.state.get_F_B_9_();
    }

    public void set_F_B_9_(Boolean _F_B_9_)
    {
        this.state.set_F_B_9_(_F_B_9_);
    }

    public Integer get_F_I_9_()
    {
        return this.state.get_F_I_9_();
    }

    public void set_F_I_9_(Integer _F_I_9_)
    {
        this.state.set_F_I_9_(_F_I_9_);
    }

    public Long get_F_L_9_()
    {
        return this.state.get_F_L_9_();
    }

    public void set_F_L_9_(Long _F_L_9_)
    {
        this.state.set_F_L_9_(_F_L_9_);
    }

    public Date get_F_DT_9_()
    {
        return this.state.get_F_DT_9_();
    }

    public void set_F_DT_9_(Date _F_DT_9_)
    {
        this.state.set_F_DT_9_(_F_DT_9_);
    }

    public BigDecimal get_F_N_9_()
    {
        return this.state.get_F_N_9_();
    }

    public void set_F_N_9_(BigDecimal _F_N_9_)
    {
        this.state.set_F_N_9_(_F_N_9_);
    }

    public String get_F_C5_9_()
    {
        return this.state.get_F_C5_9_();
    }

    public void set_F_C5_9_(String _F_C5_9_)
    {
        this.state.set_F_C5_9_(_F_C5_9_);
    }

    public String get_F_C10_9_()
    {
        return this.state.get_F_C10_9_();
    }

    public void set_F_C10_9_(String _F_C10_9_)
    {
        this.state.set_F_C10_9_(_F_C10_9_);
    }

    public String get_F_C20_9_()
    {
        return this.state.get_F_C20_9_();
    }

    public void set_F_C20_9_(String _F_C20_9_)
    {
        this.state.set_F_C20_9_(_F_C20_9_);
    }

    public String get_F_C50_9_()
    {
        return this.state.get_F_C50_9_();
    }

    public void set_F_C50_9_(String _F_C50_9_)
    {
        this.state.set_F_C50_9_(_F_C50_9_);
    }

    public String get_F_C100_9_()
    {
        return this.state.get_F_C100_9_();
    }

    public void set_F_C100_9_(String _F_C100_9_)
    {
        this.state.set_F_C100_9_(_F_C100_9_);
    }

    public String get_F_C200_9_()
    {
        return this.state.get_F_C200_9_();
    }

    public void set_F_C200_9_(String _F_C200_9_)
    {
        this.state.set_F_C200_9_(_F_C200_9_);
    }

    public String get_F_C500_9_()
    {
        return this.state.get_F_C500_9_();
    }

    public void set_F_C500_9_(String _F_C500_9_)
    {
        this.state.set_F_C500_9_(_F_C500_9_);
    }

    public Boolean get_F_B_10_()
    {
        return this.state.get_F_B_10_();
    }

    public void set_F_B_10_(Boolean _F_B_10_)
    {
        this.state.set_F_B_10_(_F_B_10_);
    }

    public Integer get_F_I_10_()
    {
        return this.state.get_F_I_10_();
    }

    public void set_F_I_10_(Integer _F_I_10_)
    {
        this.state.set_F_I_10_(_F_I_10_);
    }

    public Long get_F_L_10_()
    {
        return this.state.get_F_L_10_();
    }

    public void set_F_L_10_(Long _F_L_10_)
    {
        this.state.set_F_L_10_(_F_L_10_);
    }

    public Date get_F_DT_10_()
    {
        return this.state.get_F_DT_10_();
    }

    public void set_F_DT_10_(Date _F_DT_10_)
    {
        this.state.set_F_DT_10_(_F_DT_10_);
    }

    public BigDecimal get_F_N_10_()
    {
        return this.state.get_F_N_10_();
    }

    public void set_F_N_10_(BigDecimal _F_N_10_)
    {
        this.state.set_F_N_10_(_F_N_10_);
    }

    public String get_F_C5_10_()
    {
        return this.state.get_F_C5_10_();
    }

    public void set_F_C5_10_(String _F_C5_10_)
    {
        this.state.set_F_C5_10_(_F_C5_10_);
    }

    public String get_F_C10_10_()
    {
        return this.state.get_F_C10_10_();
    }

    public void set_F_C10_10_(String _F_C10_10_)
    {
        this.state.set_F_C10_10_(_F_C10_10_);
    }

    public String get_F_C20_10_()
    {
        return this.state.get_F_C20_10_();
    }

    public void set_F_C20_10_(String _F_C20_10_)
    {
        this.state.set_F_C20_10_(_F_C20_10_);
    }

    public String get_F_C50_10_()
    {
        return this.state.get_F_C50_10_();
    }

    public void set_F_C50_10_(String _F_C50_10_)
    {
        this.state.set_F_C50_10_(_F_C50_10_);
    }

    public String get_F_C100_10_()
    {
        return this.state.get_F_C100_10_();
    }

    public void set_F_C100_10_(String _F_C100_10_)
    {
        this.state.set_F_C100_10_(_F_C100_10_);
    }

    public String get_F_C200_10_()
    {
        return this.state.get_F_C200_10_();
    }

    public void set_F_C200_10_(String _F_C200_10_)
    {
        this.state.set_F_C200_10_(_F_C200_10_);
    }

    public Boolean get_F_B_11_()
    {
        return this.state.get_F_B_11_();
    }

    public void set_F_B_11_(Boolean _F_B_11_)
    {
        this.state.set_F_B_11_(_F_B_11_);
    }

    public Integer get_F_I_11_()
    {
        return this.state.get_F_I_11_();
    }

    public void set_F_I_11_(Integer _F_I_11_)
    {
        this.state.set_F_I_11_(_F_I_11_);
    }

    public Long get_F_L_11_()
    {
        return this.state.get_F_L_11_();
    }

    public void set_F_L_11_(Long _F_L_11_)
    {
        this.state.set_F_L_11_(_F_L_11_);
    }

    public Date get_F_DT_11_()
    {
        return this.state.get_F_DT_11_();
    }

    public void set_F_DT_11_(Date _F_DT_11_)
    {
        this.state.set_F_DT_11_(_F_DT_11_);
    }

    public BigDecimal get_F_N_11_()
    {
        return this.state.get_F_N_11_();
    }

    public void set_F_N_11_(BigDecimal _F_N_11_)
    {
        this.state.set_F_N_11_(_F_N_11_);
    }

    public String get_F_C5_11_()
    {
        return this.state.get_F_C5_11_();
    }

    public void set_F_C5_11_(String _F_C5_11_)
    {
        this.state.set_F_C5_11_(_F_C5_11_);
    }

    public String get_F_C10_11_()
    {
        return this.state.get_F_C10_11_();
    }

    public void set_F_C10_11_(String _F_C10_11_)
    {
        this.state.set_F_C10_11_(_F_C10_11_);
    }

    public String get_F_C20_11_()
    {
        return this.state.get_F_C20_11_();
    }

    public void set_F_C20_11_(String _F_C20_11_)
    {
        this.state.set_F_C20_11_(_F_C20_11_);
    }

    public String get_F_C50_11_()
    {
        return this.state.get_F_C50_11_();
    }

    public void set_F_C50_11_(String _F_C50_11_)
    {
        this.state.set_F_C50_11_(_F_C50_11_);
    }

    public String get_F_C100_11_()
    {
        return this.state.get_F_C100_11_();
    }

    public void set_F_C100_11_(String _F_C100_11_)
    {
        this.state.set_F_C100_11_(_F_C100_11_);
    }

    public String get_F_C200_11_()
    {
        return this.state.get_F_C200_11_();
    }

    public void set_F_C200_11_(String _F_C200_11_)
    {
        this.state.set_F_C200_11_(_F_C200_11_);
    }

    public Boolean get_F_B_12_()
    {
        return this.state.get_F_B_12_();
    }

    public void set_F_B_12_(Boolean _F_B_12_)
    {
        this.state.set_F_B_12_(_F_B_12_);
    }

    public Integer get_F_I_12_()
    {
        return this.state.get_F_I_12_();
    }

    public void set_F_I_12_(Integer _F_I_12_)
    {
        this.state.set_F_I_12_(_F_I_12_);
    }

    public Long get_F_L_12_()
    {
        return this.state.get_F_L_12_();
    }

    public void set_F_L_12_(Long _F_L_12_)
    {
        this.state.set_F_L_12_(_F_L_12_);
    }

    public Date get_F_DT_12_()
    {
        return this.state.get_F_DT_12_();
    }

    public void set_F_DT_12_(Date _F_DT_12_)
    {
        this.state.set_F_DT_12_(_F_DT_12_);
    }

    public BigDecimal get_F_N_12_()
    {
        return this.state.get_F_N_12_();
    }

    public void set_F_N_12_(BigDecimal _F_N_12_)
    {
        this.state.set_F_N_12_(_F_N_12_);
    }

    public String get_F_C5_12_()
    {
        return this.state.get_F_C5_12_();
    }

    public void set_F_C5_12_(String _F_C5_12_)
    {
        this.state.set_F_C5_12_(_F_C5_12_);
    }

    public String get_F_C10_12_()
    {
        return this.state.get_F_C10_12_();
    }

    public void set_F_C10_12_(String _F_C10_12_)
    {
        this.state.set_F_C10_12_(_F_C10_12_);
    }

    public String get_F_C20_12_()
    {
        return this.state.get_F_C20_12_();
    }

    public void set_F_C20_12_(String _F_C20_12_)
    {
        this.state.set_F_C20_12_(_F_C20_12_);
    }

    public String get_F_C50_12_()
    {
        return this.state.get_F_C50_12_();
    }

    public void set_F_C50_12_(String _F_C50_12_)
    {
        this.state.set_F_C50_12_(_F_C50_12_);
    }

    public String get_F_C100_12_()
    {
        return this.state.get_F_C100_12_();
    }

    public void set_F_C100_12_(String _F_C100_12_)
    {
        this.state.set_F_C100_12_(_F_C100_12_);
    }

    public String get_F_C200_12_()
    {
        return this.state.get_F_C200_12_();
    }

    public void set_F_C200_12_(String _F_C200_12_)
    {
        this.state.set_F_C200_12_(_F_C200_12_);
    }

    public Boolean get_F_B_13_()
    {
        return this.state.get_F_B_13_();
    }

    public void set_F_B_13_(Boolean _F_B_13_)
    {
        this.state.set_F_B_13_(_F_B_13_);
    }

    public Integer get_F_I_13_()
    {
        return this.state.get_F_I_13_();
    }

    public void set_F_I_13_(Integer _F_I_13_)
    {
        this.state.set_F_I_13_(_F_I_13_);
    }

    public Long get_F_L_13_()
    {
        return this.state.get_F_L_13_();
    }

    public void set_F_L_13_(Long _F_L_13_)
    {
        this.state.set_F_L_13_(_F_L_13_);
    }

    public Date get_F_DT_13_()
    {
        return this.state.get_F_DT_13_();
    }

    public void set_F_DT_13_(Date _F_DT_13_)
    {
        this.state.set_F_DT_13_(_F_DT_13_);
    }

    public BigDecimal get_F_N_13_()
    {
        return this.state.get_F_N_13_();
    }

    public void set_F_N_13_(BigDecimal _F_N_13_)
    {
        this.state.set_F_N_13_(_F_N_13_);
    }

    public String get_F_C5_13_()
    {
        return this.state.get_F_C5_13_();
    }

    public void set_F_C5_13_(String _F_C5_13_)
    {
        this.state.set_F_C5_13_(_F_C5_13_);
    }

    public String get_F_C10_13_()
    {
        return this.state.get_F_C10_13_();
    }

    public void set_F_C10_13_(String _F_C10_13_)
    {
        this.state.set_F_C10_13_(_F_C10_13_);
    }

    public String get_F_C20_13_()
    {
        return this.state.get_F_C20_13_();
    }

    public void set_F_C20_13_(String _F_C20_13_)
    {
        this.state.set_F_C20_13_(_F_C20_13_);
    }

    public String get_F_C50_13_()
    {
        return this.state.get_F_C50_13_();
    }

    public void set_F_C50_13_(String _F_C50_13_)
    {
        this.state.set_F_C50_13_(_F_C50_13_);
    }

    public String get_F_C100_13_()
    {
        return this.state.get_F_C100_13_();
    }

    public void set_F_C100_13_(String _F_C100_13_)
    {
        this.state.set_F_C100_13_(_F_C100_13_);
    }

    public String get_F_C200_13_()
    {
        return this.state.get_F_C200_13_();
    }

    public void set_F_C200_13_(String _F_C200_13_)
    {
        this.state.set_F_C200_13_(_F_C200_13_);
    }

    public Boolean get_F_B_14_()
    {
        return this.state.get_F_B_14_();
    }

    public void set_F_B_14_(Boolean _F_B_14_)
    {
        this.state.set_F_B_14_(_F_B_14_);
    }

    public Integer get_F_I_14_()
    {
        return this.state.get_F_I_14_();
    }

    public void set_F_I_14_(Integer _F_I_14_)
    {
        this.state.set_F_I_14_(_F_I_14_);
    }

    public Long get_F_L_14_()
    {
        return this.state.get_F_L_14_();
    }

    public void set_F_L_14_(Long _F_L_14_)
    {
        this.state.set_F_L_14_(_F_L_14_);
    }

    public Date get_F_DT_14_()
    {
        return this.state.get_F_DT_14_();
    }

    public void set_F_DT_14_(Date _F_DT_14_)
    {
        this.state.set_F_DT_14_(_F_DT_14_);
    }

    public BigDecimal get_F_N_14_()
    {
        return this.state.get_F_N_14_();
    }

    public void set_F_N_14_(BigDecimal _F_N_14_)
    {
        this.state.set_F_N_14_(_F_N_14_);
    }

    public String get_F_C5_14_()
    {
        return this.state.get_F_C5_14_();
    }

    public void set_F_C5_14_(String _F_C5_14_)
    {
        this.state.set_F_C5_14_(_F_C5_14_);
    }

    public String get_F_C10_14_()
    {
        return this.state.get_F_C10_14_();
    }

    public void set_F_C10_14_(String _F_C10_14_)
    {
        this.state.set_F_C10_14_(_F_C10_14_);
    }

    public String get_F_C20_14_()
    {
        return this.state.get_F_C20_14_();
    }

    public void set_F_C20_14_(String _F_C20_14_)
    {
        this.state.set_F_C20_14_(_F_C20_14_);
    }

    public String get_F_C50_14_()
    {
        return this.state.get_F_C50_14_();
    }

    public void set_F_C50_14_(String _F_C50_14_)
    {
        this.state.set_F_C50_14_(_F_C50_14_);
    }

    public String get_F_C100_14_()
    {
        return this.state.get_F_C100_14_();
    }

    public void set_F_C100_14_(String _F_C100_14_)
    {
        this.state.set_F_C100_14_(_F_C100_14_);
    }

    public String get_F_C200_14_()
    {
        return this.state.get_F_C200_14_();
    }

    public void set_F_C200_14_(String _F_C200_14_)
    {
        this.state.set_F_C200_14_(_F_C200_14_);
    }

    public Boolean get_F_B_15_()
    {
        return this.state.get_F_B_15_();
    }

    public void set_F_B_15_(Boolean _F_B_15_)
    {
        this.state.set_F_B_15_(_F_B_15_);
    }

    public Integer get_F_I_15_()
    {
        return this.state.get_F_I_15_();
    }

    public void set_F_I_15_(Integer _F_I_15_)
    {
        this.state.set_F_I_15_(_F_I_15_);
    }

    public Long get_F_L_15_()
    {
        return this.state.get_F_L_15_();
    }

    public void set_F_L_15_(Long _F_L_15_)
    {
        this.state.set_F_L_15_(_F_L_15_);
    }

    public Date get_F_DT_15_()
    {
        return this.state.get_F_DT_15_();
    }

    public void set_F_DT_15_(Date _F_DT_15_)
    {
        this.state.set_F_DT_15_(_F_DT_15_);
    }

    public BigDecimal get_F_N_15_()
    {
        return this.state.get_F_N_15_();
    }

    public void set_F_N_15_(BigDecimal _F_N_15_)
    {
        this.state.set_F_N_15_(_F_N_15_);
    }

    public String get_F_C5_15_()
    {
        return this.state.get_F_C5_15_();
    }

    public void set_F_C5_15_(String _F_C5_15_)
    {
        this.state.set_F_C5_15_(_F_C5_15_);
    }

    public String get_F_C10_15_()
    {
        return this.state.get_F_C10_15_();
    }

    public void set_F_C10_15_(String _F_C10_15_)
    {
        this.state.set_F_C10_15_(_F_C10_15_);
    }

    public String get_F_C20_15_()
    {
        return this.state.get_F_C20_15_();
    }

    public void set_F_C20_15_(String _F_C20_15_)
    {
        this.state.set_F_C20_15_(_F_C20_15_);
    }

    public String get_F_C50_15_()
    {
        return this.state.get_F_C50_15_();
    }

    public void set_F_C50_15_(String _F_C50_15_)
    {
        this.state.set_F_C50_15_(_F_C50_15_);
    }

    public String get_F_C100_15_()
    {
        return this.state.get_F_C100_15_();
    }

    public void set_F_C100_15_(String _F_C100_15_)
    {
        this.state.set_F_C100_15_(_F_C100_15_);
    }

    public String get_F_C200_15_()
    {
        return this.state.get_F_C200_15_();
    }

    public void set_F_C200_15_(String _F_C200_15_)
    {
        this.state.set_F_C200_15_(_F_C200_15_);
    }

    public Boolean get_F_B_16_()
    {
        return this.state.get_F_B_16_();
    }

    public void set_F_B_16_(Boolean _F_B_16_)
    {
        this.state.set_F_B_16_(_F_B_16_);
    }

    public Integer get_F_I_16_()
    {
        return this.state.get_F_I_16_();
    }

    public void set_F_I_16_(Integer _F_I_16_)
    {
        this.state.set_F_I_16_(_F_I_16_);
    }

    public Long get_F_L_16_()
    {
        return this.state.get_F_L_16_();
    }

    public void set_F_L_16_(Long _F_L_16_)
    {
        this.state.set_F_L_16_(_F_L_16_);
    }

    public Date get_F_DT_16_()
    {
        return this.state.get_F_DT_16_();
    }

    public void set_F_DT_16_(Date _F_DT_16_)
    {
        this.state.set_F_DT_16_(_F_DT_16_);
    }

    public BigDecimal get_F_N_16_()
    {
        return this.state.get_F_N_16_();
    }

    public void set_F_N_16_(BigDecimal _F_N_16_)
    {
        this.state.set_F_N_16_(_F_N_16_);
    }

    public String get_F_C5_16_()
    {
        return this.state.get_F_C5_16_();
    }

    public void set_F_C5_16_(String _F_C5_16_)
    {
        this.state.set_F_C5_16_(_F_C5_16_);
    }

    public String get_F_C10_16_()
    {
        return this.state.get_F_C10_16_();
    }

    public void set_F_C10_16_(String _F_C10_16_)
    {
        this.state.set_F_C10_16_(_F_C10_16_);
    }

    public String get_F_C20_16_()
    {
        return this.state.get_F_C20_16_();
    }

    public void set_F_C20_16_(String _F_C20_16_)
    {
        this.state.set_F_C20_16_(_F_C20_16_);
    }

    public String get_F_C50_16_()
    {
        return this.state.get_F_C50_16_();
    }

    public void set_F_C50_16_(String _F_C50_16_)
    {
        this.state.set_F_C50_16_(_F_C50_16_);
    }

    public String get_F_C100_16_()
    {
        return this.state.get_F_C100_16_();
    }

    public void set_F_C100_16_(String _F_C100_16_)
    {
        this.state.set_F_C100_16_(_F_C100_16_);
    }

    public String get_F_C200_16_()
    {
        return this.state.get_F_C200_16_();
    }

    public void set_F_C200_16_(String _F_C200_16_)
    {
        this.state.set_F_C200_16_(_F_C200_16_);
    }

    public Boolean get_F_B_17_()
    {
        return this.state.get_F_B_17_();
    }

    public void set_F_B_17_(Boolean _F_B_17_)
    {
        this.state.set_F_B_17_(_F_B_17_);
    }

    public Integer get_F_I_17_()
    {
        return this.state.get_F_I_17_();
    }

    public void set_F_I_17_(Integer _F_I_17_)
    {
        this.state.set_F_I_17_(_F_I_17_);
    }

    public Long get_F_L_17_()
    {
        return this.state.get_F_L_17_();
    }

    public void set_F_L_17_(Long _F_L_17_)
    {
        this.state.set_F_L_17_(_F_L_17_);
    }

    public Date get_F_DT_17_()
    {
        return this.state.get_F_DT_17_();
    }

    public void set_F_DT_17_(Date _F_DT_17_)
    {
        this.state.set_F_DT_17_(_F_DT_17_);
    }

    public BigDecimal get_F_N_17_()
    {
        return this.state.get_F_N_17_();
    }

    public void set_F_N_17_(BigDecimal _F_N_17_)
    {
        this.state.set_F_N_17_(_F_N_17_);
    }

    public String get_F_C5_17_()
    {
        return this.state.get_F_C5_17_();
    }

    public void set_F_C5_17_(String _F_C5_17_)
    {
        this.state.set_F_C5_17_(_F_C5_17_);
    }

    public String get_F_C10_17_()
    {
        return this.state.get_F_C10_17_();
    }

    public void set_F_C10_17_(String _F_C10_17_)
    {
        this.state.set_F_C10_17_(_F_C10_17_);
    }

    public String get_F_C20_17_()
    {
        return this.state.get_F_C20_17_();
    }

    public void set_F_C20_17_(String _F_C20_17_)
    {
        this.state.set_F_C20_17_(_F_C20_17_);
    }

    public String get_F_C50_17_()
    {
        return this.state.get_F_C50_17_();
    }

    public void set_F_C50_17_(String _F_C50_17_)
    {
        this.state.set_F_C50_17_(_F_C50_17_);
    }

    public String get_F_C100_17_()
    {
        return this.state.get_F_C100_17_();
    }

    public void set_F_C100_17_(String _F_C100_17_)
    {
        this.state.set_F_C100_17_(_F_C100_17_);
    }

    public String get_F_C200_17_()
    {
        return this.state.get_F_C200_17_();
    }

    public void set_F_C200_17_(String _F_C200_17_)
    {
        this.state.set_F_C200_17_(_F_C200_17_);
    }

    public Boolean get_F_B_18_()
    {
        return this.state.get_F_B_18_();
    }

    public void set_F_B_18_(Boolean _F_B_18_)
    {
        this.state.set_F_B_18_(_F_B_18_);
    }

    public Integer get_F_I_18_()
    {
        return this.state.get_F_I_18_();
    }

    public void set_F_I_18_(Integer _F_I_18_)
    {
        this.state.set_F_I_18_(_F_I_18_);
    }

    public Long get_F_L_18_()
    {
        return this.state.get_F_L_18_();
    }

    public void set_F_L_18_(Long _F_L_18_)
    {
        this.state.set_F_L_18_(_F_L_18_);
    }

    public Date get_F_DT_18_()
    {
        return this.state.get_F_DT_18_();
    }

    public void set_F_DT_18_(Date _F_DT_18_)
    {
        this.state.set_F_DT_18_(_F_DT_18_);
    }

    public BigDecimal get_F_N_18_()
    {
        return this.state.get_F_N_18_();
    }

    public void set_F_N_18_(BigDecimal _F_N_18_)
    {
        this.state.set_F_N_18_(_F_N_18_);
    }

    public String get_F_C5_18_()
    {
        return this.state.get_F_C5_18_();
    }

    public void set_F_C5_18_(String _F_C5_18_)
    {
        this.state.set_F_C5_18_(_F_C5_18_);
    }

    public String get_F_C10_18_()
    {
        return this.state.get_F_C10_18_();
    }

    public void set_F_C10_18_(String _F_C10_18_)
    {
        this.state.set_F_C10_18_(_F_C10_18_);
    }

    public String get_F_C20_18_()
    {
        return this.state.get_F_C20_18_();
    }

    public void set_F_C20_18_(String _F_C20_18_)
    {
        this.state.set_F_C20_18_(_F_C20_18_);
    }

    public String get_F_C50_18_()
    {
        return this.state.get_F_C50_18_();
    }

    public void set_F_C50_18_(String _F_C50_18_)
    {
        this.state.set_F_C50_18_(_F_C50_18_);
    }

    public String get_F_C100_18_()
    {
        return this.state.get_F_C100_18_();
    }

    public void set_F_C100_18_(String _F_C100_18_)
    {
        this.state.set_F_C100_18_(_F_C100_18_);
    }

    public String get_F_C200_18_()
    {
        return this.state.get_F_C200_18_();
    }

    public void set_F_C200_18_(String _F_C200_18_)
    {
        this.state.set_F_C200_18_(_F_C200_18_);
    }

    public Boolean get_F_B_19_()
    {
        return this.state.get_F_B_19_();
    }

    public void set_F_B_19_(Boolean _F_B_19_)
    {
        this.state.set_F_B_19_(_F_B_19_);
    }

    public Integer get_F_I_19_()
    {
        return this.state.get_F_I_19_();
    }

    public void set_F_I_19_(Integer _F_I_19_)
    {
        this.state.set_F_I_19_(_F_I_19_);
    }

    public Long get_F_L_19_()
    {
        return this.state.get_F_L_19_();
    }

    public void set_F_L_19_(Long _F_L_19_)
    {
        this.state.set_F_L_19_(_F_L_19_);
    }

    public Date get_F_DT_19_()
    {
        return this.state.get_F_DT_19_();
    }

    public void set_F_DT_19_(Date _F_DT_19_)
    {
        this.state.set_F_DT_19_(_F_DT_19_);
    }

    public BigDecimal get_F_N_19_()
    {
        return this.state.get_F_N_19_();
    }

    public void set_F_N_19_(BigDecimal _F_N_19_)
    {
        this.state.set_F_N_19_(_F_N_19_);
    }

    public String get_F_C5_19_()
    {
        return this.state.get_F_C5_19_();
    }

    public void set_F_C5_19_(String _F_C5_19_)
    {
        this.state.set_F_C5_19_(_F_C5_19_);
    }

    public String get_F_C10_19_()
    {
        return this.state.get_F_C10_19_();
    }

    public void set_F_C10_19_(String _F_C10_19_)
    {
        this.state.set_F_C10_19_(_F_C10_19_);
    }

    public String get_F_C20_19_()
    {
        return this.state.get_F_C20_19_();
    }

    public void set_F_C20_19_(String _F_C20_19_)
    {
        this.state.set_F_C20_19_(_F_C20_19_);
    }

    public String get_F_C50_19_()
    {
        return this.state.get_F_C50_19_();
    }

    public void set_F_C50_19_(String _F_C50_19_)
    {
        this.state.set_F_C50_19_(_F_C50_19_);
    }

    public String get_F_C100_19_()
    {
        return this.state.get_F_C100_19_();
    }

    public void set_F_C100_19_(String _F_C100_19_)
    {
        this.state.set_F_C100_19_(_F_C100_19_);
    }

    public String get_F_C200_19_()
    {
        return this.state.get_F_C200_19_();
    }

    public void set_F_C200_19_(String _F_C200_19_)
    {
        this.state.set_F_C200_19_(_F_C200_19_);
    }

    public Boolean get_F_B_20_()
    {
        return this.state.get_F_B_20_();
    }

    public void set_F_B_20_(Boolean _F_B_20_)
    {
        this.state.set_F_B_20_(_F_B_20_);
    }

    public Integer get_F_I_20_()
    {
        return this.state.get_F_I_20_();
    }

    public void set_F_I_20_(Integer _F_I_20_)
    {
        this.state.set_F_I_20_(_F_I_20_);
    }

    public Long get_F_L_20_()
    {
        return this.state.get_F_L_20_();
    }

    public void set_F_L_20_(Long _F_L_20_)
    {
        this.state.set_F_L_20_(_F_L_20_);
    }

    public BigDecimal get_F_N_20_()
    {
        return this.state.get_F_N_20_();
    }

    public void set_F_N_20_(BigDecimal _F_N_20_)
    {
        this.state.set_F_N_20_(_F_N_20_);
    }

    public String get_F_C5_20_()
    {
        return this.state.get_F_C5_20_();
    }

    public void set_F_C5_20_(String _F_C5_20_)
    {
        this.state.set_F_C5_20_(_F_C5_20_);
    }

    public String get_F_C10_20_()
    {
        return this.state.get_F_C10_20_();
    }

    public void set_F_C10_20_(String _F_C10_20_)
    {
        this.state.set_F_C10_20_(_F_C10_20_);
    }

    public String get_F_C20_20_()
    {
        return this.state.get_F_C20_20_();
    }

    public void set_F_C20_20_(String _F_C20_20_)
    {
        this.state.set_F_C20_20_(_F_C20_20_);
    }

    public String get_F_C50_20_()
    {
        return this.state.get_F_C50_20_();
    }

    public void set_F_C50_20_(String _F_C50_20_)
    {
        this.state.set_F_C50_20_(_F_C50_20_);
    }

    public Boolean get_F_B_21_()
    {
        return this.state.get_F_B_21_();
    }

    public void set_F_B_21_(Boolean _F_B_21_)
    {
        this.state.set_F_B_21_(_F_B_21_);
    }

    public Integer get_F_I_21_()
    {
        return this.state.get_F_I_21_();
    }

    public void set_F_I_21_(Integer _F_I_21_)
    {
        this.state.set_F_I_21_(_F_I_21_);
    }

    public Long get_F_L_21_()
    {
        return this.state.get_F_L_21_();
    }

    public void set_F_L_21_(Long _F_L_21_)
    {
        this.state.set_F_L_21_(_F_L_21_);
    }

    public BigDecimal get_F_N_21_()
    {
        return this.state.get_F_N_21_();
    }

    public void set_F_N_21_(BigDecimal _F_N_21_)
    {
        this.state.set_F_N_21_(_F_N_21_);
    }

    public String get_F_C5_21_()
    {
        return this.state.get_F_C5_21_();
    }

    public void set_F_C5_21_(String _F_C5_21_)
    {
        this.state.set_F_C5_21_(_F_C5_21_);
    }

    public String get_F_C10_21_()
    {
        return this.state.get_F_C10_21_();
    }

    public void set_F_C10_21_(String _F_C10_21_)
    {
        this.state.set_F_C10_21_(_F_C10_21_);
    }

    public String get_F_C20_21_()
    {
        return this.state.get_F_C20_21_();
    }

    public void set_F_C20_21_(String _F_C20_21_)
    {
        this.state.set_F_C20_21_(_F_C20_21_);
    }

    public String get_F_C50_21_()
    {
        return this.state.get_F_C50_21_();
    }

    public void set_F_C50_21_(String _F_C50_21_)
    {
        this.state.set_F_C50_21_(_F_C50_21_);
    }

    public Boolean get_F_B_22_()
    {
        return this.state.get_F_B_22_();
    }

    public void set_F_B_22_(Boolean _F_B_22_)
    {
        this.state.set_F_B_22_(_F_B_22_);
    }

    public Integer get_F_I_22_()
    {
        return this.state.get_F_I_22_();
    }

    public void set_F_I_22_(Integer _F_I_22_)
    {
        this.state.set_F_I_22_(_F_I_22_);
    }

    public Long get_F_L_22_()
    {
        return this.state.get_F_L_22_();
    }

    public void set_F_L_22_(Long _F_L_22_)
    {
        this.state.set_F_L_22_(_F_L_22_);
    }

    public BigDecimal get_F_N_22_()
    {
        return this.state.get_F_N_22_();
    }

    public void set_F_N_22_(BigDecimal _F_N_22_)
    {
        this.state.set_F_N_22_(_F_N_22_);
    }

    public String get_F_C5_22_()
    {
        return this.state.get_F_C5_22_();
    }

    public void set_F_C5_22_(String _F_C5_22_)
    {
        this.state.set_F_C5_22_(_F_C5_22_);
    }

    public String get_F_C10_22_()
    {
        return this.state.get_F_C10_22_();
    }

    public void set_F_C10_22_(String _F_C10_22_)
    {
        this.state.set_F_C10_22_(_F_C10_22_);
    }

    public String get_F_C20_22_()
    {
        return this.state.get_F_C20_22_();
    }

    public void set_F_C20_22_(String _F_C20_22_)
    {
        this.state.set_F_C20_22_(_F_C20_22_);
    }

    public String get_F_C50_22_()
    {
        return this.state.get_F_C50_22_();
    }

    public void set_F_C50_22_(String _F_C50_22_)
    {
        this.state.set_F_C50_22_(_F_C50_22_);
    }

    public Boolean get_F_B_23_()
    {
        return this.state.get_F_B_23_();
    }

    public void set_F_B_23_(Boolean _F_B_23_)
    {
        this.state.set_F_B_23_(_F_B_23_);
    }

    public Integer get_F_I_23_()
    {
        return this.state.get_F_I_23_();
    }

    public void set_F_I_23_(Integer _F_I_23_)
    {
        this.state.set_F_I_23_(_F_I_23_);
    }

    public Long get_F_L_23_()
    {
        return this.state.get_F_L_23_();
    }

    public void set_F_L_23_(Long _F_L_23_)
    {
        this.state.set_F_L_23_(_F_L_23_);
    }

    public BigDecimal get_F_N_23_()
    {
        return this.state.get_F_N_23_();
    }

    public void set_F_N_23_(BigDecimal _F_N_23_)
    {
        this.state.set_F_N_23_(_F_N_23_);
    }

    public String get_F_C5_23_()
    {
        return this.state.get_F_C5_23_();
    }

    public void set_F_C5_23_(String _F_C5_23_)
    {
        this.state.set_F_C5_23_(_F_C5_23_);
    }

    public String get_F_C10_23_()
    {
        return this.state.get_F_C10_23_();
    }

    public void set_F_C10_23_(String _F_C10_23_)
    {
        this.state.set_F_C10_23_(_F_C10_23_);
    }

    public String get_F_C20_23_()
    {
        return this.state.get_F_C20_23_();
    }

    public void set_F_C20_23_(String _F_C20_23_)
    {
        this.state.set_F_C20_23_(_F_C20_23_);
    }

    public String get_F_C50_23_()
    {
        return this.state.get_F_C50_23_();
    }

    public void set_F_C50_23_(String _F_C50_23_)
    {
        this.state.set_F_C50_23_(_F_C50_23_);
    }

    public Boolean get_F_B_24_()
    {
        return this.state.get_F_B_24_();
    }

    public void set_F_B_24_(Boolean _F_B_24_)
    {
        this.state.set_F_B_24_(_F_B_24_);
    }

    public Integer get_F_I_24_()
    {
        return this.state.get_F_I_24_();
    }

    public void set_F_I_24_(Integer _F_I_24_)
    {
        this.state.set_F_I_24_(_F_I_24_);
    }

    public Long get_F_L_24_()
    {
        return this.state.get_F_L_24_();
    }

    public void set_F_L_24_(Long _F_L_24_)
    {
        this.state.set_F_L_24_(_F_L_24_);
    }

    public BigDecimal get_F_N_24_()
    {
        return this.state.get_F_N_24_();
    }

    public void set_F_N_24_(BigDecimal _F_N_24_)
    {
        this.state.set_F_N_24_(_F_N_24_);
    }

    public String get_F_C5_24_()
    {
        return this.state.get_F_C5_24_();
    }

    public void set_F_C5_24_(String _F_C5_24_)
    {
        this.state.set_F_C5_24_(_F_C5_24_);
    }

    public String get_F_C10_24_()
    {
        return this.state.get_F_C10_24_();
    }

    public void set_F_C10_24_(String _F_C10_24_)
    {
        this.state.set_F_C10_24_(_F_C10_24_);
    }

    public String get_F_C20_24_()
    {
        return this.state.get_F_C20_24_();
    }

    public void set_F_C20_24_(String _F_C20_24_)
    {
        this.state.set_F_C20_24_(_F_C20_24_);
    }

    public String get_F_C50_24_()
    {
        return this.state.get_F_C50_24_();
    }

    public void set_F_C50_24_(String _F_C50_24_)
    {
        this.state.set_F_C50_24_(_F_C50_24_);
    }

    public Boolean get_F_B_25_()
    {
        return this.state.get_F_B_25_();
    }

    public void set_F_B_25_(Boolean _F_B_25_)
    {
        this.state.set_F_B_25_(_F_B_25_);
    }

    public Integer get_F_I_25_()
    {
        return this.state.get_F_I_25_();
    }

    public void set_F_I_25_(Integer _F_I_25_)
    {
        this.state.set_F_I_25_(_F_I_25_);
    }

    public Long get_F_L_25_()
    {
        return this.state.get_F_L_25_();
    }

    public void set_F_L_25_(Long _F_L_25_)
    {
        this.state.set_F_L_25_(_F_L_25_);
    }

    public BigDecimal get_F_N_25_()
    {
        return this.state.get_F_N_25_();
    }

    public void set_F_N_25_(BigDecimal _F_N_25_)
    {
        this.state.set_F_N_25_(_F_N_25_);
    }

    public String get_F_C5_25_()
    {
        return this.state.get_F_C5_25_();
    }

    public void set_F_C5_25_(String _F_C5_25_)
    {
        this.state.set_F_C5_25_(_F_C5_25_);
    }

    public String get_F_C10_25_()
    {
        return this.state.get_F_C10_25_();
    }

    public void set_F_C10_25_(String _F_C10_25_)
    {
        this.state.set_F_C10_25_(_F_C10_25_);
    }

    public String get_F_C20_25_()
    {
        return this.state.get_F_C20_25_();
    }

    public void set_F_C20_25_(String _F_C20_25_)
    {
        this.state.set_F_C20_25_(_F_C20_25_);
    }

    public String get_F_C50_25_()
    {
        return this.state.get_F_C50_25_();
    }

    public void set_F_C50_25_(String _F_C50_25_)
    {
        this.state.set_F_C50_25_(_F_C50_25_);
    }

    public Boolean get_F_B_26_()
    {
        return this.state.get_F_B_26_();
    }

    public void set_F_B_26_(Boolean _F_B_26_)
    {
        this.state.set_F_B_26_(_F_B_26_);
    }

    public Integer get_F_I_26_()
    {
        return this.state.get_F_I_26_();
    }

    public void set_F_I_26_(Integer _F_I_26_)
    {
        this.state.set_F_I_26_(_F_I_26_);
    }

    public Long get_F_L_26_()
    {
        return this.state.get_F_L_26_();
    }

    public void set_F_L_26_(Long _F_L_26_)
    {
        this.state.set_F_L_26_(_F_L_26_);
    }

    public BigDecimal get_F_N_26_()
    {
        return this.state.get_F_N_26_();
    }

    public void set_F_N_26_(BigDecimal _F_N_26_)
    {
        this.state.set_F_N_26_(_F_N_26_);
    }

    public String get_F_C5_26_()
    {
        return this.state.get_F_C5_26_();
    }

    public void set_F_C5_26_(String _F_C5_26_)
    {
        this.state.set_F_C5_26_(_F_C5_26_);
    }

    public String get_F_C10_26_()
    {
        return this.state.get_F_C10_26_();
    }

    public void set_F_C10_26_(String _F_C10_26_)
    {
        this.state.set_F_C10_26_(_F_C10_26_);
    }

    public String get_F_C20_26_()
    {
        return this.state.get_F_C20_26_();
    }

    public void set_F_C20_26_(String _F_C20_26_)
    {
        this.state.set_F_C20_26_(_F_C20_26_);
    }

    public String get_F_C50_26_()
    {
        return this.state.get_F_C50_26_();
    }

    public void set_F_C50_26_(String _F_C50_26_)
    {
        this.state.set_F_C50_26_(_F_C50_26_);
    }

    public Boolean get_F_B_27_()
    {
        return this.state.get_F_B_27_();
    }

    public void set_F_B_27_(Boolean _F_B_27_)
    {
        this.state.set_F_B_27_(_F_B_27_);
    }

    public Integer get_F_I_27_()
    {
        return this.state.get_F_I_27_();
    }

    public void set_F_I_27_(Integer _F_I_27_)
    {
        this.state.set_F_I_27_(_F_I_27_);
    }

    public Long get_F_L_27_()
    {
        return this.state.get_F_L_27_();
    }

    public void set_F_L_27_(Long _F_L_27_)
    {
        this.state.set_F_L_27_(_F_L_27_);
    }

    public BigDecimal get_F_N_27_()
    {
        return this.state.get_F_N_27_();
    }

    public void set_F_N_27_(BigDecimal _F_N_27_)
    {
        this.state.set_F_N_27_(_F_N_27_);
    }

    public String get_F_C5_27_()
    {
        return this.state.get_F_C5_27_();
    }

    public void set_F_C5_27_(String _F_C5_27_)
    {
        this.state.set_F_C5_27_(_F_C5_27_);
    }

    public String get_F_C10_27_()
    {
        return this.state.get_F_C10_27_();
    }

    public void set_F_C10_27_(String _F_C10_27_)
    {
        this.state.set_F_C10_27_(_F_C10_27_);
    }

    public String get_F_C20_27_()
    {
        return this.state.get_F_C20_27_();
    }

    public void set_F_C20_27_(String _F_C20_27_)
    {
        this.state.set_F_C20_27_(_F_C20_27_);
    }

    public String get_F_C50_27_()
    {
        return this.state.get_F_C50_27_();
    }

    public void set_F_C50_27_(String _F_C50_27_)
    {
        this.state.set_F_C50_27_(_F_C50_27_);
    }

    public Boolean get_F_B_28_()
    {
        return this.state.get_F_B_28_();
    }

    public void set_F_B_28_(Boolean _F_B_28_)
    {
        this.state.set_F_B_28_(_F_B_28_);
    }

    public Integer get_F_I_28_()
    {
        return this.state.get_F_I_28_();
    }

    public void set_F_I_28_(Integer _F_I_28_)
    {
        this.state.set_F_I_28_(_F_I_28_);
    }

    public Long get_F_L_28_()
    {
        return this.state.get_F_L_28_();
    }

    public void set_F_L_28_(Long _F_L_28_)
    {
        this.state.set_F_L_28_(_F_L_28_);
    }

    public BigDecimal get_F_N_28_()
    {
        return this.state.get_F_N_28_();
    }

    public void set_F_N_28_(BigDecimal _F_N_28_)
    {
        this.state.set_F_N_28_(_F_N_28_);
    }

    public String get_F_C5_28_()
    {
        return this.state.get_F_C5_28_();
    }

    public void set_F_C5_28_(String _F_C5_28_)
    {
        this.state.set_F_C5_28_(_F_C5_28_);
    }

    public String get_F_C10_28_()
    {
        return this.state.get_F_C10_28_();
    }

    public void set_F_C10_28_(String _F_C10_28_)
    {
        this.state.set_F_C10_28_(_F_C10_28_);
    }

    public String get_F_C20_28_()
    {
        return this.state.get_F_C20_28_();
    }

    public void set_F_C20_28_(String _F_C20_28_)
    {
        this.state.set_F_C20_28_(_F_C20_28_);
    }

    public String get_F_C50_28_()
    {
        return this.state.get_F_C50_28_();
    }

    public void set_F_C50_28_(String _F_C50_28_)
    {
        this.state.set_F_C50_28_(_F_C50_28_);
    }

    public Boolean get_F_B_29_()
    {
        return this.state.get_F_B_29_();
    }

    public void set_F_B_29_(Boolean _F_B_29_)
    {
        this.state.set_F_B_29_(_F_B_29_);
    }

    public Integer get_F_I_29_()
    {
        return this.state.get_F_I_29_();
    }

    public void set_F_I_29_(Integer _F_I_29_)
    {
        this.state.set_F_I_29_(_F_I_29_);
    }

    public Long get_F_L_29_()
    {
        return this.state.get_F_L_29_();
    }

    public void set_F_L_29_(Long _F_L_29_)
    {
        this.state.set_F_L_29_(_F_L_29_);
    }

    public BigDecimal get_F_N_29_()
    {
        return this.state.get_F_N_29_();
    }

    public void set_F_N_29_(BigDecimal _F_N_29_)
    {
        this.state.set_F_N_29_(_F_N_29_);
    }

    public String get_F_C5_29_()
    {
        return this.state.get_F_C5_29_();
    }

    public void set_F_C5_29_(String _F_C5_29_)
    {
        this.state.set_F_C5_29_(_F_C5_29_);
    }

    public String get_F_C10_29_()
    {
        return this.state.get_F_C10_29_();
    }

    public void set_F_C10_29_(String _F_C10_29_)
    {
        this.state.set_F_C10_29_(_F_C10_29_);
    }

    public String get_F_C20_29_()
    {
        return this.state.get_F_C20_29_();
    }

    public void set_F_C20_29_(String _F_C20_29_)
    {
        this.state.set_F_C20_29_(_F_C20_29_);
    }

    public String get_F_C50_29_()
    {
        return this.state.get_F_C50_29_();
    }

    public void set_F_C50_29_(String _F_C50_29_)
    {
        this.state.set_F_C50_29_(_F_C50_29_);
    }

    public Boolean get_F_B_30_()
    {
        return this.state.get_F_B_30_();
    }

    public void set_F_B_30_(Boolean _F_B_30_)
    {
        this.state.set_F_B_30_(_F_B_30_);
    }

    public Integer get_F_I_30_()
    {
        return this.state.get_F_I_30_();
    }

    public void set_F_I_30_(Integer _F_I_30_)
    {
        this.state.set_F_I_30_(_F_I_30_);
    }

    public BigDecimal get_F_N_30_()
    {
        return this.state.get_F_N_30_();
    }

    public void set_F_N_30_(BigDecimal _F_N_30_)
    {
        this.state.set_F_N_30_(_F_N_30_);
    }

    public String get_F_C5_30_()
    {
        return this.state.get_F_C5_30_();
    }

    public void set_F_C5_30_(String _F_C5_30_)
    {
        this.state.set_F_C5_30_(_F_C5_30_);
    }

    public String get_F_C10_30_()
    {
        return this.state.get_F_C10_30_();
    }

    public void set_F_C10_30_(String _F_C10_30_)
    {
        this.state.set_F_C10_30_(_F_C10_30_);
    }

    public String get_F_C20_30_()
    {
        return this.state.get_F_C20_30_();
    }

    public void set_F_C20_30_(String _F_C20_30_)
    {
        this.state.set_F_C20_30_(_F_C20_30_);
    }

    public String get_F_C50_30_()
    {
        return this.state.get_F_C50_30_();
    }

    public void set_F_C50_30_(String _F_C50_30_)
    {
        this.state.set_F_C50_30_(_F_C50_30_);
    }

    public Boolean get_F_B_31_()
    {
        return this.state.get_F_B_31_();
    }

    public void set_F_B_31_(Boolean _F_B_31_)
    {
        this.state.set_F_B_31_(_F_B_31_);
    }

    public Integer get_F_I_31_()
    {
        return this.state.get_F_I_31_();
    }

    public void set_F_I_31_(Integer _F_I_31_)
    {
        this.state.set_F_I_31_(_F_I_31_);
    }

    public BigDecimal get_F_N_31_()
    {
        return this.state.get_F_N_31_();
    }

    public void set_F_N_31_(BigDecimal _F_N_31_)
    {
        this.state.set_F_N_31_(_F_N_31_);
    }

    public String get_F_C5_31_()
    {
        return this.state.get_F_C5_31_();
    }

    public void set_F_C5_31_(String _F_C5_31_)
    {
        this.state.set_F_C5_31_(_F_C5_31_);
    }

    public String get_F_C10_31_()
    {
        return this.state.get_F_C10_31_();
    }

    public void set_F_C10_31_(String _F_C10_31_)
    {
        this.state.set_F_C10_31_(_F_C10_31_);
    }

    public String get_F_C20_31_()
    {
        return this.state.get_F_C20_31_();
    }

    public void set_F_C20_31_(String _F_C20_31_)
    {
        this.state.set_F_C20_31_(_F_C20_31_);
    }

    public String get_F_C50_31_()
    {
        return this.state.get_F_C50_31_();
    }

    public void set_F_C50_31_(String _F_C50_31_)
    {
        this.state.set_F_C50_31_(_F_C50_31_);
    }

    public Boolean get_F_B_32_()
    {
        return this.state.get_F_B_32_();
    }

    public void set_F_B_32_(Boolean _F_B_32_)
    {
        this.state.set_F_B_32_(_F_B_32_);
    }

    public Integer get_F_I_32_()
    {
        return this.state.get_F_I_32_();
    }

    public void set_F_I_32_(Integer _F_I_32_)
    {
        this.state.set_F_I_32_(_F_I_32_);
    }

    public BigDecimal get_F_N_32_()
    {
        return this.state.get_F_N_32_();
    }

    public void set_F_N_32_(BigDecimal _F_N_32_)
    {
        this.state.set_F_N_32_(_F_N_32_);
    }

    public String get_F_C5_32_()
    {
        return this.state.get_F_C5_32_();
    }

    public void set_F_C5_32_(String _F_C5_32_)
    {
        this.state.set_F_C5_32_(_F_C5_32_);
    }

    public String get_F_C10_32_()
    {
        return this.state.get_F_C10_32_();
    }

    public void set_F_C10_32_(String _F_C10_32_)
    {
        this.state.set_F_C10_32_(_F_C10_32_);
    }

    public String get_F_C20_32_()
    {
        return this.state.get_F_C20_32_();
    }

    public void set_F_C20_32_(String _F_C20_32_)
    {
        this.state.set_F_C20_32_(_F_C20_32_);
    }

    public String get_F_C50_32_()
    {
        return this.state.get_F_C50_32_();
    }

    public void set_F_C50_32_(String _F_C50_32_)
    {
        this.state.set_F_C50_32_(_F_C50_32_);
    }

    public Boolean get_F_B_33_()
    {
        return this.state.get_F_B_33_();
    }

    public void set_F_B_33_(Boolean _F_B_33_)
    {
        this.state.set_F_B_33_(_F_B_33_);
    }

    public Integer get_F_I_33_()
    {
        return this.state.get_F_I_33_();
    }

    public void set_F_I_33_(Integer _F_I_33_)
    {
        this.state.set_F_I_33_(_F_I_33_);
    }

    public BigDecimal get_F_N_33_()
    {
        return this.state.get_F_N_33_();
    }

    public void set_F_N_33_(BigDecimal _F_N_33_)
    {
        this.state.set_F_N_33_(_F_N_33_);
    }

    public String get_F_C5_33_()
    {
        return this.state.get_F_C5_33_();
    }

    public void set_F_C5_33_(String _F_C5_33_)
    {
        this.state.set_F_C5_33_(_F_C5_33_);
    }

    public String get_F_C10_33_()
    {
        return this.state.get_F_C10_33_();
    }

    public void set_F_C10_33_(String _F_C10_33_)
    {
        this.state.set_F_C10_33_(_F_C10_33_);
    }

    public String get_F_C20_33_()
    {
        return this.state.get_F_C20_33_();
    }

    public void set_F_C20_33_(String _F_C20_33_)
    {
        this.state.set_F_C20_33_(_F_C20_33_);
    }

    public String get_F_C50_33_()
    {
        return this.state.get_F_C50_33_();
    }

    public void set_F_C50_33_(String _F_C50_33_)
    {
        this.state.set_F_C50_33_(_F_C50_33_);
    }

    public Boolean get_F_B_34_()
    {
        return this.state.get_F_B_34_();
    }

    public void set_F_B_34_(Boolean _F_B_34_)
    {
        this.state.set_F_B_34_(_F_B_34_);
    }

    public Integer get_F_I_34_()
    {
        return this.state.get_F_I_34_();
    }

    public void set_F_I_34_(Integer _F_I_34_)
    {
        this.state.set_F_I_34_(_F_I_34_);
    }

    public BigDecimal get_F_N_34_()
    {
        return this.state.get_F_N_34_();
    }

    public void set_F_N_34_(BigDecimal _F_N_34_)
    {
        this.state.set_F_N_34_(_F_N_34_);
    }

    public String get_F_C5_34_()
    {
        return this.state.get_F_C5_34_();
    }

    public void set_F_C5_34_(String _F_C5_34_)
    {
        this.state.set_F_C5_34_(_F_C5_34_);
    }

    public String get_F_C10_34_()
    {
        return this.state.get_F_C10_34_();
    }

    public void set_F_C10_34_(String _F_C10_34_)
    {
        this.state.set_F_C10_34_(_F_C10_34_);
    }

    public String get_F_C20_34_()
    {
        return this.state.get_F_C20_34_();
    }

    public void set_F_C20_34_(String _F_C20_34_)
    {
        this.state.set_F_C20_34_(_F_C20_34_);
    }

    public String get_F_C50_34_()
    {
        return this.state.get_F_C50_34_();
    }

    public void set_F_C50_34_(String _F_C50_34_)
    {
        this.state.set_F_C50_34_(_F_C50_34_);
    }

    public Boolean get_F_B_35_()
    {
        return this.state.get_F_B_35_();
    }

    public void set_F_B_35_(Boolean _F_B_35_)
    {
        this.state.set_F_B_35_(_F_B_35_);
    }

    public Integer get_F_I_35_()
    {
        return this.state.get_F_I_35_();
    }

    public void set_F_I_35_(Integer _F_I_35_)
    {
        this.state.set_F_I_35_(_F_I_35_);
    }

    public BigDecimal get_F_N_35_()
    {
        return this.state.get_F_N_35_();
    }

    public void set_F_N_35_(BigDecimal _F_N_35_)
    {
        this.state.set_F_N_35_(_F_N_35_);
    }

    public String get_F_C5_35_()
    {
        return this.state.get_F_C5_35_();
    }

    public void set_F_C5_35_(String _F_C5_35_)
    {
        this.state.set_F_C5_35_(_F_C5_35_);
    }

    public String get_F_C10_35_()
    {
        return this.state.get_F_C10_35_();
    }

    public void set_F_C10_35_(String _F_C10_35_)
    {
        this.state.set_F_C10_35_(_F_C10_35_);
    }

    public String get_F_C20_35_()
    {
        return this.state.get_F_C20_35_();
    }

    public void set_F_C20_35_(String _F_C20_35_)
    {
        this.state.set_F_C20_35_(_F_C20_35_);
    }

    public String get_F_C50_35_()
    {
        return this.state.get_F_C50_35_();
    }

    public void set_F_C50_35_(String _F_C50_35_)
    {
        this.state.set_F_C50_35_(_F_C50_35_);
    }

    public Boolean get_F_B_36_()
    {
        return this.state.get_F_B_36_();
    }

    public void set_F_B_36_(Boolean _F_B_36_)
    {
        this.state.set_F_B_36_(_F_B_36_);
    }

    public Integer get_F_I_36_()
    {
        return this.state.get_F_I_36_();
    }

    public void set_F_I_36_(Integer _F_I_36_)
    {
        this.state.set_F_I_36_(_F_I_36_);
    }

    public BigDecimal get_F_N_36_()
    {
        return this.state.get_F_N_36_();
    }

    public void set_F_N_36_(BigDecimal _F_N_36_)
    {
        this.state.set_F_N_36_(_F_N_36_);
    }

    public String get_F_C5_36_()
    {
        return this.state.get_F_C5_36_();
    }

    public void set_F_C5_36_(String _F_C5_36_)
    {
        this.state.set_F_C5_36_(_F_C5_36_);
    }

    public String get_F_C10_36_()
    {
        return this.state.get_F_C10_36_();
    }

    public void set_F_C10_36_(String _F_C10_36_)
    {
        this.state.set_F_C10_36_(_F_C10_36_);
    }

    public String get_F_C20_36_()
    {
        return this.state.get_F_C20_36_();
    }

    public void set_F_C20_36_(String _F_C20_36_)
    {
        this.state.set_F_C20_36_(_F_C20_36_);
    }

    public String get_F_C50_36_()
    {
        return this.state.get_F_C50_36_();
    }

    public void set_F_C50_36_(String _F_C50_36_)
    {
        this.state.set_F_C50_36_(_F_C50_36_);
    }

    public Boolean get_F_B_37_()
    {
        return this.state.get_F_B_37_();
    }

    public void set_F_B_37_(Boolean _F_B_37_)
    {
        this.state.set_F_B_37_(_F_B_37_);
    }

    public Integer get_F_I_37_()
    {
        return this.state.get_F_I_37_();
    }

    public void set_F_I_37_(Integer _F_I_37_)
    {
        this.state.set_F_I_37_(_F_I_37_);
    }

    public BigDecimal get_F_N_37_()
    {
        return this.state.get_F_N_37_();
    }

    public void set_F_N_37_(BigDecimal _F_N_37_)
    {
        this.state.set_F_N_37_(_F_N_37_);
    }

    public String get_F_C5_37_()
    {
        return this.state.get_F_C5_37_();
    }

    public void set_F_C5_37_(String _F_C5_37_)
    {
        this.state.set_F_C5_37_(_F_C5_37_);
    }

    public String get_F_C10_37_()
    {
        return this.state.get_F_C10_37_();
    }

    public void set_F_C10_37_(String _F_C10_37_)
    {
        this.state.set_F_C10_37_(_F_C10_37_);
    }

    public String get_F_C20_37_()
    {
        return this.state.get_F_C20_37_();
    }

    public void set_F_C20_37_(String _F_C20_37_)
    {
        this.state.set_F_C20_37_(_F_C20_37_);
    }

    public String get_F_C50_37_()
    {
        return this.state.get_F_C50_37_();
    }

    public void set_F_C50_37_(String _F_C50_37_)
    {
        this.state.set_F_C50_37_(_F_C50_37_);
    }

    public Boolean get_F_B_38_()
    {
        return this.state.get_F_B_38_();
    }

    public void set_F_B_38_(Boolean _F_B_38_)
    {
        this.state.set_F_B_38_(_F_B_38_);
    }

    public Integer get_F_I_38_()
    {
        return this.state.get_F_I_38_();
    }

    public void set_F_I_38_(Integer _F_I_38_)
    {
        this.state.set_F_I_38_(_F_I_38_);
    }

    public BigDecimal get_F_N_38_()
    {
        return this.state.get_F_N_38_();
    }

    public void set_F_N_38_(BigDecimal _F_N_38_)
    {
        this.state.set_F_N_38_(_F_N_38_);
    }

    public String get_F_C5_38_()
    {
        return this.state.get_F_C5_38_();
    }

    public void set_F_C5_38_(String _F_C5_38_)
    {
        this.state.set_F_C5_38_(_F_C5_38_);
    }

    public String get_F_C10_38_()
    {
        return this.state.get_F_C10_38_();
    }

    public void set_F_C10_38_(String _F_C10_38_)
    {
        this.state.set_F_C10_38_(_F_C10_38_);
    }

    public String get_F_C20_38_()
    {
        return this.state.get_F_C20_38_();
    }

    public void set_F_C20_38_(String _F_C20_38_)
    {
        this.state.set_F_C20_38_(_F_C20_38_);
    }

    public String get_F_C50_38_()
    {
        return this.state.get_F_C50_38_();
    }

    public void set_F_C50_38_(String _F_C50_38_)
    {
        this.state.set_F_C50_38_(_F_C50_38_);
    }

    public Boolean get_F_B_39_()
    {
        return this.state.get_F_B_39_();
    }

    public void set_F_B_39_(Boolean _F_B_39_)
    {
        this.state.set_F_B_39_(_F_B_39_);
    }

    public Integer get_F_I_39_()
    {
        return this.state.get_F_I_39_();
    }

    public void set_F_I_39_(Integer _F_I_39_)
    {
        this.state.set_F_I_39_(_F_I_39_);
    }

    public BigDecimal get_F_N_39_()
    {
        return this.state.get_F_N_39_();
    }

    public void set_F_N_39_(BigDecimal _F_N_39_)
    {
        this.state.set_F_N_39_(_F_N_39_);
    }

    public String get_F_C5_39_()
    {
        return this.state.get_F_C5_39_();
    }

    public void set_F_C5_39_(String _F_C5_39_)
    {
        this.state.set_F_C5_39_(_F_C5_39_);
    }

    public String get_F_C10_39_()
    {
        return this.state.get_F_C10_39_();
    }

    public void set_F_C10_39_(String _F_C10_39_)
    {
        this.state.set_F_C10_39_(_F_C10_39_);
    }

    public String get_F_C20_39_()
    {
        return this.state.get_F_C20_39_();
    }

    public void set_F_C20_39_(String _F_C20_39_)
    {
        this.state.set_F_C20_39_(_F_C20_39_);
    }

    public String get_F_C50_39_()
    {
        return this.state.get_F_C50_39_();
    }

    public void set_F_C50_39_(String _F_C50_39_)
    {
        this.state.set_F_C50_39_(_F_C50_39_);
    }

    public Boolean get_F_B_40_()
    {
        return this.state.get_F_B_40_();
    }

    public void set_F_B_40_(Boolean _F_B_40_)
    {
        this.state.set_F_B_40_(_F_B_40_);
    }

    public Integer get_F_I_40_()
    {
        return this.state.get_F_I_40_();
    }

    public void set_F_I_40_(Integer _F_I_40_)
    {
        this.state.set_F_I_40_(_F_I_40_);
    }

    public BigDecimal get_F_N_40_()
    {
        return this.state.get_F_N_40_();
    }

    public void set_F_N_40_(BigDecimal _F_N_40_)
    {
        this.state.set_F_N_40_(_F_N_40_);
    }

    public String get_F_C5_40_()
    {
        return this.state.get_F_C5_40_();
    }

    public void set_F_C5_40_(String _F_C5_40_)
    {
        this.state.set_F_C5_40_(_F_C5_40_);
    }

    public String get_F_C10_40_()
    {
        return this.state.get_F_C10_40_();
    }

    public void set_F_C10_40_(String _F_C10_40_)
    {
        this.state.set_F_C10_40_(_F_C10_40_);
    }

    public String get_F_C20_40_()
    {
        return this.state.get_F_C20_40_();
    }

    public void set_F_C20_40_(String _F_C20_40_)
    {
        this.state.set_F_C20_40_(_F_C20_40_);
    }

    public String get_F_C50_40_()
    {
        return this.state.get_F_C50_40_();
    }

    public void set_F_C50_40_(String _F_C50_40_)
    {
        this.state.set_F_C50_40_(_F_C50_40_);
    }

    public Boolean get_F_B_41_()
    {
        return this.state.get_F_B_41_();
    }

    public void set_F_B_41_(Boolean _F_B_41_)
    {
        this.state.set_F_B_41_(_F_B_41_);
    }

    public Integer get_F_I_41_()
    {
        return this.state.get_F_I_41_();
    }

    public void set_F_I_41_(Integer _F_I_41_)
    {
        this.state.set_F_I_41_(_F_I_41_);
    }

    public BigDecimal get_F_N_41_()
    {
        return this.state.get_F_N_41_();
    }

    public void set_F_N_41_(BigDecimal _F_N_41_)
    {
        this.state.set_F_N_41_(_F_N_41_);
    }

    public String get_F_C5_41_()
    {
        return this.state.get_F_C5_41_();
    }

    public void set_F_C5_41_(String _F_C5_41_)
    {
        this.state.set_F_C5_41_(_F_C5_41_);
    }

    public String get_F_C10_41_()
    {
        return this.state.get_F_C10_41_();
    }

    public void set_F_C10_41_(String _F_C10_41_)
    {
        this.state.set_F_C10_41_(_F_C10_41_);
    }

    public String get_F_C20_41_()
    {
        return this.state.get_F_C20_41_();
    }

    public void set_F_C20_41_(String _F_C20_41_)
    {
        this.state.set_F_C20_41_(_F_C20_41_);
    }

    public String get_F_C50_41_()
    {
        return this.state.get_F_C50_41_();
    }

    public void set_F_C50_41_(String _F_C50_41_)
    {
        this.state.set_F_C50_41_(_F_C50_41_);
    }

    public Boolean get_F_B_42_()
    {
        return this.state.get_F_B_42_();
    }

    public void set_F_B_42_(Boolean _F_B_42_)
    {
        this.state.set_F_B_42_(_F_B_42_);
    }

    public Integer get_F_I_42_()
    {
        return this.state.get_F_I_42_();
    }

    public void set_F_I_42_(Integer _F_I_42_)
    {
        this.state.set_F_I_42_(_F_I_42_);
    }

    public BigDecimal get_F_N_42_()
    {
        return this.state.get_F_N_42_();
    }

    public void set_F_N_42_(BigDecimal _F_N_42_)
    {
        this.state.set_F_N_42_(_F_N_42_);
    }

    public String get_F_C5_42_()
    {
        return this.state.get_F_C5_42_();
    }

    public void set_F_C5_42_(String _F_C5_42_)
    {
        this.state.set_F_C5_42_(_F_C5_42_);
    }

    public String get_F_C10_42_()
    {
        return this.state.get_F_C10_42_();
    }

    public void set_F_C10_42_(String _F_C10_42_)
    {
        this.state.set_F_C10_42_(_F_C10_42_);
    }

    public String get_F_C20_42_()
    {
        return this.state.get_F_C20_42_();
    }

    public void set_F_C20_42_(String _F_C20_42_)
    {
        this.state.set_F_C20_42_(_F_C20_42_);
    }

    public String get_F_C50_42_()
    {
        return this.state.get_F_C50_42_();
    }

    public void set_F_C50_42_(String _F_C50_42_)
    {
        this.state.set_F_C50_42_(_F_C50_42_);
    }

    public Boolean get_F_B_43_()
    {
        return this.state.get_F_B_43_();
    }

    public void set_F_B_43_(Boolean _F_B_43_)
    {
        this.state.set_F_B_43_(_F_B_43_);
    }

    public Integer get_F_I_43_()
    {
        return this.state.get_F_I_43_();
    }

    public void set_F_I_43_(Integer _F_I_43_)
    {
        this.state.set_F_I_43_(_F_I_43_);
    }

    public BigDecimal get_F_N_43_()
    {
        return this.state.get_F_N_43_();
    }

    public void set_F_N_43_(BigDecimal _F_N_43_)
    {
        this.state.set_F_N_43_(_F_N_43_);
    }

    public String get_F_C5_43_()
    {
        return this.state.get_F_C5_43_();
    }

    public void set_F_C5_43_(String _F_C5_43_)
    {
        this.state.set_F_C5_43_(_F_C5_43_);
    }

    public String get_F_C10_43_()
    {
        return this.state.get_F_C10_43_();
    }

    public void set_F_C10_43_(String _F_C10_43_)
    {
        this.state.set_F_C10_43_(_F_C10_43_);
    }

    public String get_F_C20_43_()
    {
        return this.state.get_F_C20_43_();
    }

    public void set_F_C20_43_(String _F_C20_43_)
    {
        this.state.set_F_C20_43_(_F_C20_43_);
    }

    public String get_F_C50_43_()
    {
        return this.state.get_F_C50_43_();
    }

    public void set_F_C50_43_(String _F_C50_43_)
    {
        this.state.set_F_C50_43_(_F_C50_43_);
    }

    public Boolean get_F_B_44_()
    {
        return this.state.get_F_B_44_();
    }

    public void set_F_B_44_(Boolean _F_B_44_)
    {
        this.state.set_F_B_44_(_F_B_44_);
    }

    public Integer get_F_I_44_()
    {
        return this.state.get_F_I_44_();
    }

    public void set_F_I_44_(Integer _F_I_44_)
    {
        this.state.set_F_I_44_(_F_I_44_);
    }

    public BigDecimal get_F_N_44_()
    {
        return this.state.get_F_N_44_();
    }

    public void set_F_N_44_(BigDecimal _F_N_44_)
    {
        this.state.set_F_N_44_(_F_N_44_);
    }

    public String get_F_C5_44_()
    {
        return this.state.get_F_C5_44_();
    }

    public void set_F_C5_44_(String _F_C5_44_)
    {
        this.state.set_F_C5_44_(_F_C5_44_);
    }

    public String get_F_C10_44_()
    {
        return this.state.get_F_C10_44_();
    }

    public void set_F_C10_44_(String _F_C10_44_)
    {
        this.state.set_F_C10_44_(_F_C10_44_);
    }

    public String get_F_C20_44_()
    {
        return this.state.get_F_C20_44_();
    }

    public void set_F_C20_44_(String _F_C20_44_)
    {
        this.state.set_F_C20_44_(_F_C20_44_);
    }

    public String get_F_C50_44_()
    {
        return this.state.get_F_C50_44_();
    }

    public void set_F_C50_44_(String _F_C50_44_)
    {
        this.state.set_F_C50_44_(_F_C50_44_);
    }

    public Boolean get_F_B_45_()
    {
        return this.state.get_F_B_45_();
    }

    public void set_F_B_45_(Boolean _F_B_45_)
    {
        this.state.set_F_B_45_(_F_B_45_);
    }

    public Integer get_F_I_45_()
    {
        return this.state.get_F_I_45_();
    }

    public void set_F_I_45_(Integer _F_I_45_)
    {
        this.state.set_F_I_45_(_F_I_45_);
    }

    public BigDecimal get_F_N_45_()
    {
        return this.state.get_F_N_45_();
    }

    public void set_F_N_45_(BigDecimal _F_N_45_)
    {
        this.state.set_F_N_45_(_F_N_45_);
    }

    public String get_F_C5_45_()
    {
        return this.state.get_F_C5_45_();
    }

    public void set_F_C5_45_(String _F_C5_45_)
    {
        this.state.set_F_C5_45_(_F_C5_45_);
    }

    public String get_F_C10_45_()
    {
        return this.state.get_F_C10_45_();
    }

    public void set_F_C10_45_(String _F_C10_45_)
    {
        this.state.set_F_C10_45_(_F_C10_45_);
    }

    public String get_F_C20_45_()
    {
        return this.state.get_F_C20_45_();
    }

    public void set_F_C20_45_(String _F_C20_45_)
    {
        this.state.set_F_C20_45_(_F_C20_45_);
    }

    public String get_F_C50_45_()
    {
        return this.state.get_F_C50_45_();
    }

    public void set_F_C50_45_(String _F_C50_45_)
    {
        this.state.set_F_C50_45_(_F_C50_45_);
    }

    public Boolean get_F_B_46_()
    {
        return this.state.get_F_B_46_();
    }

    public void set_F_B_46_(Boolean _F_B_46_)
    {
        this.state.set_F_B_46_(_F_B_46_);
    }

    public Integer get_F_I_46_()
    {
        return this.state.get_F_I_46_();
    }

    public void set_F_I_46_(Integer _F_I_46_)
    {
        this.state.set_F_I_46_(_F_I_46_);
    }

    public BigDecimal get_F_N_46_()
    {
        return this.state.get_F_N_46_();
    }

    public void set_F_N_46_(BigDecimal _F_N_46_)
    {
        this.state.set_F_N_46_(_F_N_46_);
    }

    public String get_F_C5_46_()
    {
        return this.state.get_F_C5_46_();
    }

    public void set_F_C5_46_(String _F_C5_46_)
    {
        this.state.set_F_C5_46_(_F_C5_46_);
    }

    public String get_F_C10_46_()
    {
        return this.state.get_F_C10_46_();
    }

    public void set_F_C10_46_(String _F_C10_46_)
    {
        this.state.set_F_C10_46_(_F_C10_46_);
    }

    public String get_F_C20_46_()
    {
        return this.state.get_F_C20_46_();
    }

    public void set_F_C20_46_(String _F_C20_46_)
    {
        this.state.set_F_C20_46_(_F_C20_46_);
    }

    public String get_F_C50_46_()
    {
        return this.state.get_F_C50_46_();
    }

    public void set_F_C50_46_(String _F_C50_46_)
    {
        this.state.set_F_C50_46_(_F_C50_46_);
    }

    public Boolean get_F_B_47_()
    {
        return this.state.get_F_B_47_();
    }

    public void set_F_B_47_(Boolean _F_B_47_)
    {
        this.state.set_F_B_47_(_F_B_47_);
    }

    public Integer get_F_I_47_()
    {
        return this.state.get_F_I_47_();
    }

    public void set_F_I_47_(Integer _F_I_47_)
    {
        this.state.set_F_I_47_(_F_I_47_);
    }

    public BigDecimal get_F_N_47_()
    {
        return this.state.get_F_N_47_();
    }

    public void set_F_N_47_(BigDecimal _F_N_47_)
    {
        this.state.set_F_N_47_(_F_N_47_);
    }

    public String get_F_C5_47_()
    {
        return this.state.get_F_C5_47_();
    }

    public void set_F_C5_47_(String _F_C5_47_)
    {
        this.state.set_F_C5_47_(_F_C5_47_);
    }

    public String get_F_C10_47_()
    {
        return this.state.get_F_C10_47_();
    }

    public void set_F_C10_47_(String _F_C10_47_)
    {
        this.state.set_F_C10_47_(_F_C10_47_);
    }

    public String get_F_C20_47_()
    {
        return this.state.get_F_C20_47_();
    }

    public void set_F_C20_47_(String _F_C20_47_)
    {
        this.state.set_F_C20_47_(_F_C20_47_);
    }

    public String get_F_C50_47_()
    {
        return this.state.get_F_C50_47_();
    }

    public void set_F_C50_47_(String _F_C50_47_)
    {
        this.state.set_F_C50_47_(_F_C50_47_);
    }

    public Boolean get_F_B_48_()
    {
        return this.state.get_F_B_48_();
    }

    public void set_F_B_48_(Boolean _F_B_48_)
    {
        this.state.set_F_B_48_(_F_B_48_);
    }

    public Integer get_F_I_48_()
    {
        return this.state.get_F_I_48_();
    }

    public void set_F_I_48_(Integer _F_I_48_)
    {
        this.state.set_F_I_48_(_F_I_48_);
    }

    public BigDecimal get_F_N_48_()
    {
        return this.state.get_F_N_48_();
    }

    public void set_F_N_48_(BigDecimal _F_N_48_)
    {
        this.state.set_F_N_48_(_F_N_48_);
    }

    public String get_F_C5_48_()
    {
        return this.state.get_F_C5_48_();
    }

    public void set_F_C5_48_(String _F_C5_48_)
    {
        this.state.set_F_C5_48_(_F_C5_48_);
    }

    public String get_F_C10_48_()
    {
        return this.state.get_F_C10_48_();
    }

    public void set_F_C10_48_(String _F_C10_48_)
    {
        this.state.set_F_C10_48_(_F_C10_48_);
    }

    public String get_F_C20_48_()
    {
        return this.state.get_F_C20_48_();
    }

    public void set_F_C20_48_(String _F_C20_48_)
    {
        this.state.set_F_C20_48_(_F_C20_48_);
    }

    public String get_F_C50_48_()
    {
        return this.state.get_F_C50_48_();
    }

    public void set_F_C50_48_(String _F_C50_48_)
    {
        this.state.set_F_C50_48_(_F_C50_48_);
    }

    public Boolean get_F_B_49_()
    {
        return this.state.get_F_B_49_();
    }

    public void set_F_B_49_(Boolean _F_B_49_)
    {
        this.state.set_F_B_49_(_F_B_49_);
    }

    public Integer get_F_I_49_()
    {
        return this.state.get_F_I_49_();
    }

    public void set_F_I_49_(Integer _F_I_49_)
    {
        this.state.set_F_I_49_(_F_I_49_);
    }

    public BigDecimal get_F_N_49_()
    {
        return this.state.get_F_N_49_();
    }

    public void set_F_N_49_(BigDecimal _F_N_49_)
    {
        this.state.set_F_N_49_(_F_N_49_);
    }

    public String get_F_C5_49_()
    {
        return this.state.get_F_C5_49_();
    }

    public void set_F_C5_49_(String _F_C5_49_)
    {
        this.state.set_F_C5_49_(_F_C5_49_);
    }

    public String get_F_C10_49_()
    {
        return this.state.get_F_C10_49_();
    }

    public void set_F_C10_49_(String _F_C10_49_)
    {
        this.state.set_F_C10_49_(_F_C10_49_);
    }

    public String get_F_C20_49_()
    {
        return this.state.get_F_C20_49_();
    }

    public void set_F_C20_49_(String _F_C20_49_)
    {
        this.state.set_F_C20_49_(_F_C20_49_);
    }

    public String get_F_C50_49_()
    {
        return this.state.get_F_C50_49_();
    }

    public void set_F_C50_49_(String _F_C50_49_)
    {
        this.state.set_F_C50_49_(_F_C50_49_);
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

