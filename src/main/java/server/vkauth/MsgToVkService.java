package server.vkauth;

import server.msgsystem.Abonent;
import server.msgsystem.Address;
import server.msgsystem.Msg;

/**
 * Created with IntelliJ IDEA.
 * User: Антон
 * Date: 14.10.13
 * Time: 20:11
 * To change this template use File | Settings | File Templates.
 */
public abstract class MsgToVkService extends Msg {

    MsgToVkService(Address from, Address to) {
        super(from, to);
    }

    public void exec(Abonent abonent) {
        if (abonent instanceof AccountVkService) {
            exec((AccountVkService) abonent);
        }
    }

    public abstract void exec(AccountVkService accountService);
}
