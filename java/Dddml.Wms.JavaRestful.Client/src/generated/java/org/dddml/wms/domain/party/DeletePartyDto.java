package org.dddml.wms.domain.party;


public class DeletePartyDto extends AbstractPartyCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    private String partyTypeId;

    public String getPartyTypeId() {
        return this.partyTypeId;
    }

    public void setPartyTypeId(String partyTypeId) {
        this.partyTypeId = partyTypeId;
    }

}

