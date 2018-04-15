package org.dddml.wms.domain.partyrole;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface PartyRoleApplicationService
{
    void when(PartyRoleCommand.CreatePartyRole c);

    void when(PartyRoleCommand.MergePatchPartyRole c);

    void when(PartyRoleCommand.DeletePartyRole c);

    PartyRoleState get(PartyRoleId id);

    Iterable<PartyRoleState> getAll(Integer firstResult, Integer maxResults);

    Iterable<PartyRoleState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PartyRoleState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PartyRoleState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    PartyRoleEvent getEvent(PartyRoleId partyRoleId, long version);

    PartyRoleState getHistoryState(PartyRoleId partyRoleId, long version);

}

