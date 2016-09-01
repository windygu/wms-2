package org.dddml.wms.domain;


public class DeletePersonDto extends AbstractPersonCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public PersonCommand.DeletePerson toDeletePerson()
    {
        AbstractPersonCommand.SimpleDeletePerson command = new AbstractPersonCommand.SimpleDeletePerson();
        ((AbstractPersonCommandDto)this).copyTo(command);
        return command;
    }

}

