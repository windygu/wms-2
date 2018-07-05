package org.dddml.wms.rest.client;

import org.dddml.wms.domain.party.PartyStateDto;

/**
 * Created by yangjiefeng on 2018/5/17.
 */
public class TestMain {

    public static void main(String[] args) {
        PartyStateDto party = new PartyStateDto();
        System.out.println(party.getPartyId());
    }
}
