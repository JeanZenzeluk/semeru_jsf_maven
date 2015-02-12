package br.com.semeru.util;

import javax.faces.context.FacesContext;
import org.hibernate.Session;

public class FacesContextUtil {

    private static final String HIBERNAte_SESSION = "hibernate_session";

    public static void setRequestSession(Session session){
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBERNAte_SESSION, session);
    }
    
    public static Session getRequestSession() {
        return (Session)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(HIBERNAte_SESSION);
    }
    
}
