package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;


public class TeamStateDto
{

    private String teamName;

    public String getTeamName()
    {
        return this.teamName;
    }

    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
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

    private PersonalNameDto[] players;

    public PersonalNameDto[] getPlayers() {
        return this.players;
    }

    public void setPlayers(PersonalNameDto[] players) {
        this.players = players;
    }

    private String[] mascots;

    public String[] getMascots() {
        return this.mascots;
    }

    public void setMascots(String[] mascots) {
        this.mascots = mascots;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public TeamStateDto[] toTeamStateDtoArray(Iterable<TeamState> states) 
        {
            ArrayList<TeamStateDto> stateDtos = new ArrayList();
            for (TeamState s : states) {
                TeamStateDto dto = toTeamStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new TeamStateDto[0]);
        }

        public TeamStateDto toTeamStateDto(TeamState state)
        {
            TeamStateDto dto = new TeamStateDto();
            if (returnedFieldsContains("TeamName")) {
                dto.setTeamName(state.getTeamName());
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("CreatedBy")) {
                dto.setCreatedBy(state.getCreatedBy());
            }
            if (returnedFieldsContains("CreatedAt")) {
                dto.setCreatedAt(state.getCreatedAt());
            }
            if (returnedFieldsContains("UpdatedBy")) {
                dto.setUpdatedBy(state.getUpdatedBy());
            }
            if (returnedFieldsContains("UpdatedAt")) {
                dto.setUpdatedAt(state.getUpdatedAt());
            }
            if (returnedFieldsContains("Players")) {
                ArrayList<PersonalNameDto> arrayList = new ArrayList();
                if (state.getPlayers() != null) {
                    for (PersonalName s : state.getPlayers()) {
                        arrayList.add(new PersonalNameDtoWrapper(s));
                    }
                }
                dto.setPlayers(arrayList.toArray(new PersonalNameDto[0]));
            }
            if (returnedFieldsContains("Mascots")) {
                ArrayList<String> arrayList = new ArrayList();
                if (state.getMascots() != null) {
                    for (String s : state.getMascots()) {
                        arrayList.add(s);
                    }
                }
                dto.setMascots(arrayList.toArray(new String[0]));
            }
            return dto;
        }

    }
}

