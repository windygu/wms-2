package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchYearPlanDto extends AbstractYearPlanCommandDto
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

    private CreateOrMergePatchMonthPlanDto[] monthPlans;

    public CreateOrMergePatchMonthPlanDto[] getMonthPlans()
    {
        return this.monthPlans;
    }

    public void setMonthPlans(CreateOrMergePatchMonthPlanDto[] monthPlans)
    {
        this.monthPlans = monthPlans;
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

    public void copyTo(AbstractYearPlanCommand.AbstractCreateOrMergePatchYearPlan command)
    {
        ((AbstractYearPlanCommandDto) this).copyTo(command);
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public YearPlanCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractYearPlanCommand.SimpleCreateYearPlan command = new AbstractYearPlanCommand.SimpleCreateYearPlan();
            copyTo((AbstractYearPlanCommand.AbstractCreateYearPlan) command);
            if (this.getMonthPlans() != null) {
                for (CreateOrMergePatchMonthPlanDto cmd : this.getMonthPlans()) {
                    command.getMonthPlans().add((MonthPlanCommand.CreateMonthPlan) cmd.toCommand());
                }
            }
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractYearPlanCommand.SimpleMergePatchYearPlan command = new AbstractYearPlanCommand.SimpleMergePatchYearPlan();
            copyTo((AbstractYearPlanCommand.SimpleMergePatchYearPlan) command);
            if (this.getMonthPlans() != null) {
                for (CreateOrMergePatchMonthPlanDto cmd : this.getMonthPlans()) {
                    command.getMonthPlanCommands().add(cmd.toCommand());
                }
            }
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractYearPlanCommand.SimpleRemoveYearPlan command = new AbstractYearPlanCommand.SimpleRemoveYearPlan();
            ((AbstractYearPlanCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractYearPlanCommand.AbstractCreateYearPlan command)
    {
        copyTo((AbstractYearPlanCommand.AbstractCreateOrMergePatchYearPlan) command);
    }

    public void copyTo(AbstractYearPlanCommand.AbstractMergePatchYearPlan command)
    {
        copyTo((AbstractYearPlanCommand.AbstractCreateOrMergePatchYearPlan) command);
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateYearPlanDto extends CreateOrMergePatchYearPlanDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public YearPlanCommand.CreateYearPlan toCreateYearPlan()
        {
            return (YearPlanCommand.CreateYearPlan) toCommand();
        }

    }

    public static class MergePatchYearPlanDto extends CreateOrMergePatchYearPlanDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public YearPlanCommand.MergePatchYearPlan toMergePatchYearPlan()
        {
            return (YearPlanCommand.MergePatchYearPlan) toCommand();
        }

    }

}

