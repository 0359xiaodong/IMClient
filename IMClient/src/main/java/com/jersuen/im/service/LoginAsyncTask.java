package com.jersuen.im.service;

import android.os.AsyncTask;
import android.os.RemoteException;
import com.jersuen.im.service.aidl.IXmppBinder;
import com.jersuen.im.service.aidl.IXmppManager;

/**
 * Created by JerSuen on 14-5-18.
 */
public class LoginAsyncTask extends AsyncTask<IXmppBinder, Void, Integer> {

    public static final int LOGIN_OK = 1;
    public static final int LOGIN_ERROR = 2;
    public static final int CONNECTION_ERROR = 3;

    protected Integer doInBackground(IXmppBinder... xmppBinders) {
        try {
            IXmppManager connection = xmppBinders[0].createConnection();
            // 连接成功
            if (connection.connect()) {
                // 登陆成功
                if (connection.login()) {
                    return LOGIN_OK;
                // 登陆失败
                } else {
                    return LOGIN_ERROR;
                }
            // 连接失败
            } else {
                return CONNECTION_ERROR;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
