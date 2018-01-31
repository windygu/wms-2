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

    public PartyCommand.DeleteParty toDeleteParty()
    {
        AbstractPartyCommand.SimpleDeleteParty command = new AbstractPartyCommand.SimpleDeleteParty();
        ((AbstractPartyCommandDto)this).copyTo(command);
        command.setPartyTypeId(this.getPartyTypeId());
        return command;
    }
}

