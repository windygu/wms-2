package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchMonthPlanDto extends AbstractMonthPlanCommandDto
{
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    private CreateOrMergePatchDayPlanDto[] dayPlans;

    public CreateOrMergePatchDayPlanDto[] getDayPlans()
    {
        return this.dayPlans;
    }

    public void setDayPlans(CreateOrMergePatchDayPlanDto[] dayPlans)
    {
        this.dayPlans = dayPlans;
    }

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved()
    {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed)
    {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }


    public void copyTo(AbstractMonthPlanCommand.AbstractCreateOrMergePatchMonthPlan command)
    {
        ((AbstractMonthPlanCommandDto) this).copyTo(command);
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public MonthPlanCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractMonthPlanCommand.SimpleCreateMonthPlan command = new AbstractMonthPlanCommand.SimpleCreateMonthPlan();
            copyTo((AbstractMonthPlanCommand.AbstractCreateMonthPlan) command);
            if (this.getDayPlans() != null) {
                for (CreateOrMergePatchDayPlanDto cmd : this.getDayPlans()) {
                    command.getDayPlans().add((DayPlanCommand.CreateDayPlan) cmd.toCommand());
                }
            }
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractMonthPlanCommand.SimpleMergePatchMonthPlan command = new AbstractMonthPlanCommand.SimpleMergePatchMonthPlan();
            copyTo((AbstractMonthPlanCommand.SimpleMergePatchMonthPlan) command);
            if (this.getDayPlans() != null) {
                for (CreateOrMergePatchDayPlanDto cmd : this.getDayPlans()) {
                    command.getDayPlanCommands().add(cmd.toCommand());
                }
            }
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractMonthPlanCommand.SimpleRemoveMonthPlan command = new AbstractMonthPlanCommand.SimpleRemoveMonthPlan();
            ((AbstractMonthPlanCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractMonthPlanCommand.AbstractCreateMonthPlan command)
    {
        copyTo((AbstractMonthPlanCommand.AbstractCreateOrMergePatchMonthPlan) command);
    }

    public void copyTo(AbstractMonthPlanCommand.AbstractMergePatchMonthPlan command)
    {
        copyTo((AbstractMonthPlanCommand.AbstractCreateOrMergePatchMonthPlan) command);
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateMonthPlanDto extends CreateOrMergePatchMonthPlanDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        public MonthPlanCommand.CreateMonthPlan toCreateMonthPlan()
        {
            return (MonthPlanCommand.CreateMonthPlan) toCommand();
        }

    }

    public static class MergePatchMonthPlanDto extends CreateOrMergePatchMonthPlanDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        public MonthPlanCommand.MergePatchMonthPlan toMergePatchMonthPlan()
        {
            return (MonthPlanCommand.MergePatchMonthPlan) toCommand();
        }

    }

}

