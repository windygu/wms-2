package org.dddml.wms.domain;


public class DeleteMonthPlanMvoDto extends AbstractMonthPlanMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public MonthPlanMvoCommand.DeleteMonthPlanMvo toDeleteMonthPlanMvo()
    {
        AbstractMonthPlanMvoCommand.SimpleDeleteMonthPlanMvo command = new AbstractMonthPlanMvoCommand.SimpleDeleteMonthPlanMvo();
        ((AbstractMonthPlanMvoCommandDto)this).copyTo(command);
        return command;
    }

}

