package com.jersuen.im.service;

import android.os.RemoteException;
import com.jersuen.im.IMService;
import com.jersuen.im.service.aidl.IXmppBinder;
import com.jersuen.im.service.aidl.IXmppManager;

/**
 * Created by JerSuen on 14-5-18.
 */
public class XmppBinder extends IXmppBinder.Stub{

    private IMService service;

    public XmppBinder(IMService service) {
        this.service = service;
    }

    public IXmppManager createConnection() throws RemoteException {
        return service.createConnection();
    }
}
