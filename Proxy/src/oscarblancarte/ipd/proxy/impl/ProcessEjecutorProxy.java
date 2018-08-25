package oscarblancarte.ipd.proxy.impl;

import oscarblancarte.ipd.proxy.services.AuditService;
import oscarblancarte.ipd.proxy.services.SecurityService;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class ProcessEjecutorProxy implements IProcessEjecutor {

    @Override
    public void ejecuteProcess(int idProcess,String user,String password) 
            throws Exception {
        SecurityService securityService = new SecurityService();
        if(!securityService.authorization(user, password)){
            throw new Exception("The user '"+user
                    +"' does not have privileges to execute the process");
        }
        
        DefaultProcessEjecutor ejecutorProcess = new DefaultProcessEjecutor();
        ejecutorProcess.ejecuteProcess(idProcess, user, password);
        
        AuditService audit = new AuditService();
        audit.auditServiceUsed(user, DefaultProcessEjecutor.class.getName());
    }
}