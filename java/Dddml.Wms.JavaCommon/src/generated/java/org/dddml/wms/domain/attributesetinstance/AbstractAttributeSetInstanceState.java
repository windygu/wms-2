package org.dddml.wms.domain.attributesetinstance;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceEvent.*;

public abstract class AbstractAttributeSetInstanceState implements AttributeSetInstanceState.SqlAttributeSetInstanceState
{

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
    }

    private String attributeSetId;

    public String getAttributeSetId()
    {
        return this.attributeSetId;
    }

    public void setAttributeSetId(String attributeSetId)
    {
        this.attributeSetId = attributeSetId;
    }

    private String organizationId;

    public String getOrganizationId()
    {
        return this.organizationId;
    }

    public void setOrganizationId(String organizationId)
    {
        this.organizationId = organizationId;
    }

    private String referenceId;

    public String getReferenceId()
    {
        return this.referenceId;
    }

    public void setReferenceId(String referenceId)
    {
        this.referenceId = referenceId;
    }

    private String serialNumber;

    public String getSerialNumber()
    {
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    private String lotId;

    public String getLotId()
    {
        return this.lotId;
    }

    public void setLotId(String lotId)
    {
        this.lotId = lotId;
    }

    private String imageUrl;

    public String getImageUrl()
    {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private String hash;

    public String getHash()
    {
        return this.hash;
    }

    public void setHash(String hash)
    {
        this.hash = hash;
    }

    private BigDecimal widthInch;

    public BigDecimal getWidthInch()
    {
        return this.widthInch;
    }

    public void setWidthInch(BigDecimal widthInch)
    {
        this.widthInch = widthInch;
    }

    private BigDecimal diameterInch;

    public BigDecimal getDiameterInch()
    {
        return this.diameterInch;
    }

    public void setDiameterInch(BigDecimal diameterInch)
    {
        this.diameterInch = diameterInch;
    }

    private BigDecimal weightLbs;

    public BigDecimal getWeightLbs()
    {
        return this.weightLbs;
    }

    public void setWeightLbs(BigDecimal weightLbs)
    {
        this.weightLbs = weightLbs;
    }

    private BigDecimal weightKg;

    public BigDecimal getWeightKg()
    {
        return this.weightKg;
    }

    public void setWeightKg(BigDecimal weightKg)
    {
        this.weightKg = weightKg;
    }

    private BigDecimal airDryWeightLbs;

    public BigDecimal getAirDryWeightLbs()
    {
        return this.airDryWeightLbs;
    }

    public void setAirDryWeightLbs(BigDecimal airDryWeightLbs)
    {
        this.airDryWeightLbs = airDryWeightLbs;
    }

    private BigDecimal airDryWeightKg;

    public BigDecimal getAirDryWeightKg()
    {
        return this.airDryWeightKg;
    }

    public void setAirDryWeightKg(BigDecimal airDryWeightKg)
    {
        this.airDryWeightKg = airDryWeightKg;
    }

    private BigDecimal airDryMetricTon;

    public BigDecimal getAirDryMetricTon()
    {
        return this.airDryMetricTon;
    }

    public void setAirDryMetricTon(BigDecimal airDryMetricTon)
    {
        this.airDryMetricTon = airDryMetricTon;
    }

    private Integer rollCnt;

    public Integer getRollCnt()
    {
        return this.rollCnt;
    }

    public void setRollCnt(Integer rollCnt)
    {
        this.rollCnt = rollCnt;
    }

    private BigDecimal airDryPct;

    public BigDecimal getAirDryPct()
    {
        return this.airDryPct;
    }

    public void setAirDryPct(BigDecimal airDryPct)
    {
        this.airDryPct = airDryPct;
    }

    private Boolean _F_B_0_;

    public Boolean get_F_B_0_()
    {
        return this._F_B_0_;
    }

    public void set_F_B_0_(Boolean _F_B_0_)
    {
        this._F_B_0_ = _F_B_0_;
    }

    private Integer _F_I_0_;

    public Integer get_F_I_0_()
    {
        return this._F_I_0_;
    }

    public void set_F_I_0_(Integer _F_I_0_)
    {
        this._F_I_0_ = _F_I_0_;
    }

    private Long _F_L_0_;

    public Long get_F_L_0_()
    {
        return this._F_L_0_;
    }

    public void set_F_L_0_(Long _F_L_0_)
    {
        this._F_L_0_ = _F_L_0_;
    }

    private Date _F_DT_0_;

    public Date get_F_DT_0_()
    {
        return this._F_DT_0_;
    }

    public void set_F_DT_0_(Date _F_DT_0_)
    {
        this._F_DT_0_ = _F_DT_0_;
    }

    private BigDecimal _F_N_0_;

    public BigDecimal get_F_N_0_()
    {
        return this._F_N_0_;
    }

    public void set_F_N_0_(BigDecimal _F_N_0_)
    {
        this._F_N_0_ = _F_N_0_;
    }

    private String _F_C5_0_;

    public String get_F_C5_0_()
    {
        return this._F_C5_0_;
    }

    public void set_F_C5_0_(String _F_C5_0_)
    {
        this._F_C5_0_ = _F_C5_0_;
    }

    private String _F_C10_0_;

    public String get_F_C10_0_()
    {
        return this._F_C10_0_;
    }

    public void set_F_C10_0_(String _F_C10_0_)
    {
        this._F_C10_0_ = _F_C10_0_;
    }

    private String _F_C20_0_;

    public String get_F_C20_0_()
    {
        return this._F_C20_0_;
    }

    public void set_F_C20_0_(String _F_C20_0_)
    {
        this._F_C20_0_ = _F_C20_0_;
    }

    private String _F_C50_0_;

    public String get_F_C50_0_()
    {
        return this._F_C50_0_;
    }

    public void set_F_C50_0_(String _F_C50_0_)
    {
        this._F_C50_0_ = _F_C50_0_;
    }

    private String _F_C100_0_;

    public String get_F_C100_0_()
    {
        return this._F_C100_0_;
    }

    public void set_F_C100_0_(String _F_C100_0_)
    {
        this._F_C100_0_ = _F_C100_0_;
    }

    private String _F_C200_0_;

    public String get_F_C200_0_()
    {
        return this._F_C200_0_;
    }

    public void set_F_C200_0_(String _F_C200_0_)
    {
        this._F_C200_0_ = _F_C200_0_;
    }

    private String _F_C500_0_;

    public String get_F_C500_0_()
    {
        return this._F_C500_0_;
    }

    public void set_F_C500_0_(String _F_C500_0_)
    {
        this._F_C500_0_ = _F_C500_0_;
    }

    private String _F_C1000_0_;

    public String get_F_C1000_0_()
    {
        return this._F_C1000_0_;
    }

    public void set_F_C1000_0_(String _F_C1000_0_)
    {
        this._F_C1000_0_ = _F_C1000_0_;
    }

    private Boolean _F_B_1_;

    public Boolean get_F_B_1_()
    {
        return this._F_B_1_;
    }

    public void set_F_B_1_(Boolean _F_B_1_)
    {
        this._F_B_1_ = _F_B_1_;
    }

    private Integer _F_I_1_;

    public Integer get_F_I_1_()
    {
        return this._F_I_1_;
    }

    public void set_F_I_1_(Integer _F_I_1_)
    {
        this._F_I_1_ = _F_I_1_;
    }

    private Long _F_L_1_;

    public Long get_F_L_1_()
    {
        return this._F_L_1_;
    }

    public void set_F_L_1_(Long _F_L_1_)
    {
        this._F_L_1_ = _F_L_1_;
    }

    private Date _F_DT_1_;

    public Date get_F_DT_1_()
    {
        return this._F_DT_1_;
    }

    public void set_F_DT_1_(Date _F_DT_1_)
    {
        this._F_DT_1_ = _F_DT_1_;
    }

    private BigDecimal _F_N_1_;

    public BigDecimal get_F_N_1_()
    {
        return this._F_N_1_;
    }

    public void set_F_N_1_(BigDecimal _F_N_1_)
    {
        this._F_N_1_ = _F_N_1_;
    }

    private String _F_C5_1_;

    public String get_F_C5_1_()
    {
        return this._F_C5_1_;
    }

    public void set_F_C5_1_(String _F_C5_1_)
    {
        this._F_C5_1_ = _F_C5_1_;
    }

    private String _F_C10_1_;

    public String get_F_C10_1_()
    {
        return this._F_C10_1_;
    }

    public void set_F_C10_1_(String _F_C10_1_)
    {
        this._F_C10_1_ = _F_C10_1_;
    }

    private String _F_C20_1_;

    public String get_F_C20_1_()
    {
        return this._F_C20_1_;
    }

    public void set_F_C20_1_(String _F_C20_1_)
    {
        this._F_C20_1_ = _F_C20_1_;
    }

    private String _F_C50_1_;

    public String get_F_C50_1_()
    {
        return this._F_C50_1_;
    }

    public void set_F_C50_1_(String _F_C50_1_)
    {
        this._F_C50_1_ = _F_C50_1_;
    }

    private String _F_C100_1_;

    public String get_F_C100_1_()
    {
        return this._F_C100_1_;
    }

    public void set_F_C100_1_(String _F_C100_1_)
    {
        this._F_C100_1_ = _F_C100_1_;
    }

    private String _F_C200_1_;

    public String get_F_C200_1_()
    {
        return this._F_C200_1_;
    }

    public void set_F_C200_1_(String _F_C200_1_)
    {
        this._F_C200_1_ = _F_C200_1_;
    }

    private Boolean _F_B_2_;

    public Boolean get_F_B_2_()
    {
        return this._F_B_2_;
    }

    public void set_F_B_2_(Boolean _F_B_2_)
    {
        this._F_B_2_ = _F_B_2_;
    }

    private Integer _F_I_2_;

    public Integer get_F_I_2_()
    {
        return this._F_I_2_;
    }

    public void set_F_I_2_(Integer _F_I_2_)
    {
        this._F_I_2_ = _F_I_2_;
    }

    private Long _F_L_2_;

    public Long get_F_L_2_()
    {
        return this._F_L_2_;
    }

    public void set_F_L_2_(Long _F_L_2_)
    {
        this._F_L_2_ = _F_L_2_;
    }

    private Date _F_DT_2_;

    public Date get_F_DT_2_()
    {
        return this._F_DT_2_;
    }

    public void set_F_DT_2_(Date _F_DT_2_)
    {
        this._F_DT_2_ = _F_DT_2_;
    }

    private BigDecimal _F_N_2_;

    public BigDecimal get_F_N_2_()
    {
        return this._F_N_2_;
    }

    public void set_F_N_2_(BigDecimal _F_N_2_)
    {
        this._F_N_2_ = _F_N_2_;
    }

    private String _F_C5_2_;

    public String get_F_C5_2_()
    {
        return this._F_C5_2_;
    }

    public void set_F_C5_2_(String _F_C5_2_)
    {
        this._F_C5_2_ = _F_C5_2_;
    }

    private String _F_C10_2_;

    public String get_F_C10_2_()
    {
        return this._F_C10_2_;
    }

    public void set_F_C10_2_(String _F_C10_2_)
    {
        this._F_C10_2_ = _F_C10_2_;
    }

    private String _F_C20_2_;

    public String get_F_C20_2_()
    {
        return this._F_C20_2_;
    }

    public void set_F_C20_2_(String _F_C20_2_)
    {
        this._F_C20_2_ = _F_C20_2_;
    }

    private String _F_C50_2_;

    public String get_F_C50_2_()
    {
        return this._F_C50_2_;
    }

    public void set_F_C50_2_(String _F_C50_2_)
    {
        this._F_C50_2_ = _F_C50_2_;
    }

    private Boolean _F_B_3_;

    public Boolean get_F_B_3_()
    {
        return this._F_B_3_;
    }

    public void set_F_B_3_(Boolean _F_B_3_)
    {
        this._F_B_3_ = _F_B_3_;
    }

    private Integer _F_I_3_;

    public Integer get_F_I_3_()
    {
        return this._F_I_3_;
    }

    public void set_F_I_3_(Integer _F_I_3_)
    {
        this._F_I_3_ = _F_I_3_;
    }

    private Long _F_L_3_;

    public Long get_F_L_3_()
    {
        return this._F_L_3_;
    }

    public void set_F_L_3_(Long _F_L_3_)
    {
        this._F_L_3_ = _F_L_3_;
    }

    private Date _F_DT_3_;

    public Date get_F_DT_3_()
    {
        return this._F_DT_3_;
    }

    public void set_F_DT_3_(Date _F_DT_3_)
    {
        this._F_DT_3_ = _F_DT_3_;
    }

    private BigDecimal _F_N_3_;

    public BigDecimal get_F_N_3_()
    {
        return this._F_N_3_;
    }

    public void set_F_N_3_(BigDecimal _F_N_3_)
    {
        this._F_N_3_ = _F_N_3_;
    }

    private String _F_C5_3_;

    public String get_F_C5_3_()
    {
        return this._F_C5_3_;
    }

    public void set_F_C5_3_(String _F_C5_3_)
    {
        this._F_C5_3_ = _F_C5_3_;
    }

    private String _F_C10_3_;

    public String get_F_C10_3_()
    {
        return this._F_C10_3_;
    }

    public void set_F_C10_3_(String _F_C10_3_)
    {
        this._F_C10_3_ = _F_C10_3_;
    }

    private String _F_C20_3_;

    public String get_F_C20_3_()
    {
        return this._F_C20_3_;
    }

    public void set_F_C20_3_(String _F_C20_3_)
    {
        this._F_C20_3_ = _F_C20_3_;
    }

    private String _F_C50_3_;

    public String get_F_C50_3_()
    {
        return this._F_C50_3_;
    }

    public void set_F_C50_3_(String _F_C50_3_)
    {
        this._F_C50_3_ = _F_C50_3_;
    }

    private Boolean _F_B_4_;

    public Boolean get_F_B_4_()
    {
        return this._F_B_4_;
    }

    public void set_F_B_4_(Boolean _F_B_4_)
    {
        this._F_B_4_ = _F_B_4_;
    }

    private Integer _F_I_4_;

    public Integer get_F_I_4_()
    {
        return this._F_I_4_;
    }

    public void set_F_I_4_(Integer _F_I_4_)
    {
        this._F_I_4_ = _F_I_4_;
    }

    private Long _F_L_4_;

    public Long get_F_L_4_()
    {
        return this._F_L_4_;
    }

    public void set_F_L_4_(Long _F_L_4_)
    {
        this._F_L_4_ = _F_L_4_;
    }

    private Date _F_DT_4_;

    public Date get_F_DT_4_()
    {
        return this._F_DT_4_;
    }

    public void set_F_DT_4_(Date _F_DT_4_)
    {
        this._F_DT_4_ = _F_DT_4_;
    }

    private BigDecimal _F_N_4_;

    public BigDecimal get_F_N_4_()
    {
        return this._F_N_4_;
    }

    public void set_F_N_4_(BigDecimal _F_N_4_)
    {
        this._F_N_4_ = _F_N_4_;
    }

    private String _F_C5_4_;

    public String get_F_C5_4_()
    {
        return this._F_C5_4_;
    }

    public void set_F_C5_4_(String _F_C5_4_)
    {
        this._F_C5_4_ = _F_C5_4_;
    }

    private String _F_C10_4_;

    public String get_F_C10_4_()
    {
        return this._F_C10_4_;
    }

    public void set_F_C10_4_(String _F_C10_4_)
    {
        this._F_C10_4_ = _F_C10_4_;
    }

    private String _F_C20_4_;

    public String get_F_C20_4_()
    {
        return this._F_C20_4_;
    }

    public void set_F_C20_4_(String _F_C20_4_)
    {
        this._F_C20_4_ = _F_C20_4_;
    }

    private String _F_C50_4_;

    public String get_F_C50_4_()
    {
        return this._F_C50_4_;
    }

    public void set_F_C50_4_(String _F_C50_4_)
    {
        this._F_C50_4_ = _F_C50_4_;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Set<String> statusIds;

    public Set<String> getStatusIds()
    {
        return this.statusIds;
    }

    public void setStatusIds(Set<String> statusIds)
    {
        this.statusIds = statusIds;
    }

    public boolean isStateUnsaved() 
    {
        return this.getVersion() == null;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    private String commandId;

    public String getCommandId() {
        return this.commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public AbstractAttributeSetInstanceState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setAttributeSetInstanceId(((AttributeSetInstanceEvent.SqlAttributeSetInstanceEvent) events.get(0)).getAttributeSetInstanceEventId().getAttributeSetInstanceId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractAttributeSetInstanceState() {
        this(false);
    }

    public AbstractAttributeSetInstanceState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof AttributeSetInstanceStateCreated) {
            when((AttributeSetInstanceStateCreated) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(AttributeSetInstanceStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setAttributeSetId(e.getAttributeSetId());
        this.setOrganizationId(e.getOrganizationId());
        this.setReferenceId(e.getReferenceId());
        this.setSerialNumber(e.getSerialNumber());
        this.setLotId(e.getLotId());
        this.setStatusIds(e.getStatusIds());
        this.setImageUrl(e.getImageUrl());
        this.setDescription(e.getDescription());
        this.setHash(e.getHash());
        this.setWidthInch(e.getWidthInch());
        this.setDiameterInch(e.getDiameterInch());
        this.setWeightLbs(e.getWeightLbs());
        this.setWeightKg(e.getWeightKg());
        this.setAirDryWeightLbs(e.getAirDryWeightLbs());
        this.setAirDryWeightKg(e.getAirDryWeightKg());
        this.setAirDryMetricTon(e.getAirDryMetricTon());
        this.setRollCnt(e.getRollCnt());
        this.setAirDryPct(e.getAirDryPct());
        this.set_F_B_0_(e.get_F_B_0_());
        this.set_F_I_0_(e.get_F_I_0_());
        this.set_F_L_0_(e.get_F_L_0_());
        this.set_F_DT_0_(e.get_F_DT_0_());
        this.set_F_N_0_(e.get_F_N_0_());
        this.set_F_C5_0_(e.get_F_C5_0_());
        this.set_F_C10_0_(e.get_F_C10_0_());
        this.set_F_C20_0_(e.get_F_C20_0_());
        this.set_F_C50_0_(e.get_F_C50_0_());
        this.set_F_C100_0_(e.get_F_C100_0_());
        this.set_F_C200_0_(e.get_F_C200_0_());
        this.set_F_C500_0_(e.get_F_C500_0_());
        this.set_F_C1000_0_(e.get_F_C1000_0_());
        this.set_F_B_1_(e.get_F_B_1_());
        this.set_F_I_1_(e.get_F_I_1_());
        this.set_F_L_1_(e.get_F_L_1_());
        this.set_F_DT_1_(e.get_F_DT_1_());
        this.set_F_N_1_(e.get_F_N_1_());
        this.set_F_C5_1_(e.get_F_C5_1_());
        this.set_F_C10_1_(e.get_F_C10_1_());
        this.set_F_C20_1_(e.get_F_C20_1_());
        this.set_F_C50_1_(e.get_F_C50_1_());
        this.set_F_C100_1_(e.get_F_C100_1_());
        this.set_F_C200_1_(e.get_F_C200_1_());
        this.set_F_B_2_(e.get_F_B_2_());
        this.set_F_I_2_(e.get_F_I_2_());
        this.set_F_L_2_(e.get_F_L_2_());
        this.set_F_DT_2_(e.get_F_DT_2_());
        this.set_F_N_2_(e.get_F_N_2_());
        this.set_F_C5_2_(e.get_F_C5_2_());
        this.set_F_C10_2_(e.get_F_C10_2_());
        this.set_F_C20_2_(e.get_F_C20_2_());
        this.set_F_C50_2_(e.get_F_C50_2_());
        this.set_F_B_3_(e.get_F_B_3_());
        this.set_F_I_3_(e.get_F_I_3_());
        this.set_F_L_3_(e.get_F_L_3_());
        this.set_F_DT_3_(e.get_F_DT_3_());
        this.set_F_N_3_(e.get_F_N_3_());
        this.set_F_C5_3_(e.get_F_C5_3_());
        this.set_F_C10_3_(e.get_F_C10_3_());
        this.set_F_C20_3_(e.get_F_C20_3_());
        this.set_F_C50_3_(e.get_F_C50_3_());
        this.set_F_B_4_(e.get_F_B_4_());
        this.set_F_I_4_(e.get_F_I_4_());
        this.set_F_L_4_(e.get_F_L_4_());
        this.set_F_DT_4_(e.get_F_DT_4_());
        this.set_F_N_4_(e.get_F_N_4_());
        this.set_F_C5_4_(e.get_F_C5_4_());
        this.set_F_C10_4_(e.get_F_C10_4_());
        this.set_F_C20_4_(e.get_F_C20_4_());
        this.set_F_C50_4_(e.get_F_C50_4_());
        this.setActive(e.getActive());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(AttributeSetInstanceEvent event)
    {
        String stateEntityId = this.getAttributeSetInstanceId(); // Aggregate Id
        String eventEntityId = ((AttributeSetInstanceEvent.SqlAttributeSetInstanceEvent)event).getAttributeSetInstanceEventId().getAttributeSetInstanceId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = ((AttributeSetInstanceEvent.SqlAttributeSetInstanceEvent)event).getAttributeSetInstanceEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getAttributeSetInstanceEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(AttributeSetInstanceState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleAttributeSetInstanceState extends AbstractAttributeSetInstanceState
    {

        public SimpleAttributeSetInstanceState() {
        }

        public SimpleAttributeSetInstanceState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleAttributeSetInstanceState(List<Event> events) {
            super(events);
        }

    }


}

