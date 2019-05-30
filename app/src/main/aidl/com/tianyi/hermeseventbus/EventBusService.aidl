// EventBusService.aidl
package com.tianyi.hermeseventbus;

// Declare any non-default types here with import statements

import com.tianyi.hermeseventbus.Request;
import com.tianyi.hermeseventbus.Response;
interface EventBusService {
    Response send(in Request request);
}
