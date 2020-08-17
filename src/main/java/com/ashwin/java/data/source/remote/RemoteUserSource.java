package com.ashwin.java.data.source.remote;

import com.ashwin.java.data.source.UserSource;
import com.ashwin.java.domain.model.User;

import javax.ws.rs.NotSupportedException;
import java.util.List;

public class RemoteUserSource  implements UserSource {
    @Override
    public List<User> get() {
        throw new NotSupportedException("Feature not yet supported");
    }
}
