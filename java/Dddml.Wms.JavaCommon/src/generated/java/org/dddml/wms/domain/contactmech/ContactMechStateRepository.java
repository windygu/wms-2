package org.dddml.wms.domain.contactmech;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ContactMechStateRepository
{
    ContactMechState get(String id, boolean nullAllowed);

    void save(ContactMechState state);

}

