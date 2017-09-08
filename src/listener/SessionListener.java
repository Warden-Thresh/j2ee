package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionListener implements HttpSessionListener{

    // Public constructor is required by servlet spec
    public SessionListener() {
    }


    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("监听到 session 创建, sessionid 是： " + se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("监听到 session 销毁, sessionid 是： " + se.getSession().getId());
    }
}
