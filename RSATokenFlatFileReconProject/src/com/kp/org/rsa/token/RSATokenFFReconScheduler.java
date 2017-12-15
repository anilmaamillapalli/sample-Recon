package com.kp.org.rsa.token;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import javax.security.auth.login.LoginException;

import Thor.API.Operations.tcITResourceInstanceOperationsIntf;
import Thor.API.Operations.tcLookupOperationsIntf;
import Thor.API.Operations.tcUserOperationsIntf;
import oracle.iam.identity.usermgmt.api.UserManager;
import oracle.iam.platform.OIMClient;
import oracle.iam.reconciliation.api.ReconOperationsService;

public class RSATokenFFReconScheduler {

	private String remoteManager;
	private String tokenReconObj;
	private String fullRecon;
	private String delimiter;
	private String subStr;	
	public HashMap configurationMap;
	public tcUserOperationsIntf tcUserOps=null;
	public ReconOperationsService reconOps;
	public UserManager userOpr;
	public tcITResourceInstanceOperationsIntf itResInstOp=null;
	public tcLookupOperationsIntf lookupOps=null;
	public OIMClient oimClient;
	
	
	public void execute(HashMap attr){
		
		
		
		remoteManager= (String) attr.get("RAS IT Resource");
		String configLookup=(String)attr.get("Config Lookup");
		tokenReconObj=(String) attr.get("Token Resource Object");
		fullRecon=(String)attr.get("Full Recon");
		String feedFile=(String)attr.get("Input Feed File");
			
		OIMClient oimClient=OIMConnection();
		reconOps=oimClient.getService(ReconOperationsService.class);
		userOpr=oimClient.getService(UserManager.class);
		
		String rsaITRes= remoteManager;
		
		try{
			if(rsaITRes != null && rsaITRes.length() > 0){
				System.out.println("Selected RSA IT Resource :"+rsaITRes);
			}
		}catch(Exception e){
			e.getMessage();
		}
		String rsaResObj_User= tokenReconObj;
		
		try{
			if(rsaResObj_User != null && rsaResObj_User.length() > 0){
				System.out.println("Selecte RSA Resource Object :"+ rsaResObj_User);
			}
		}catch(Exception e){e.getMessage();}
		
		
		
		
		
		Map<String, String> itResourceData= null;
		
		
		itResInstOp= oimClient.getService(tcITResourceInstanceOperationsIntf.class);
		lookupOps=oimClient.getService(tcLookupOperationsIntf.class);
		long itResourceKey=0;
		
		com.kp.org.rsa.token.RSAUtility rsaUtil= new RSAUtility();
		
	itResourceKey=rsaUtil.getITResourceName(itResInstOp,rsaITRes); //get IT Resource Key
	
	
	configurationMap=rsaUtil.getLookUpMap(lookupOps,configLookup);	//get key & value of lookup configuration(code and decode)
		
		
		
	delimiter =(String)configurationMap.get("Token Reconciliation Delimiter");
	
	boolean ignoreEvent =false;
	String fullIngnoreEvent="";
	String userID="";
	
	   
	HashMap tokenMapEntry = processFlatFile(feedFile, fullRecon, rsaITRes, configurationMap);
	
	Set<String> tokenKeySet = tokenMapEntry.keySet();
	
	Map<String,Object> tokenretMapEntry = new HashMap<String,Object>();
	
		
		
	for(String key: tokenKeySet){
		Object value=tokenMapEntry.get(key);
		HashMap<String, Object> innerHash = (HashMap) value;
		Set<String> innerKeySet= innerHash.keySet();
	}
	
		
	}
	
	
	
	
	private HashMap processFlatFile(String feedFile, String ignoreEvent, String rsaITRes,HashMap<String,String> configMap) throws Exception{
		
		File f = new File(feedFile);
		
		if (!f.exists()){
			throw new Exception("File not Found");
		}
		
		FileReader reader = new FileReader(feedFile);
		BufferedReader br= new BufferedReader(reader);
		String header[];
		
		RSAUtility util = new RSAUtility();
		
		tcLookupOperationsIntf lookups =oimClient.getService(tcLookupOperationsIntf.class);
		HashMap<String, String>
		
	}
	}
	
	
	
	
	
	
	
	
	
	public void getHashMap(){
		HashMap params= new HashMap();
		params.put("RAS IT Resource", "");
		params.put("Config Lookup","");
		params.put("Token Resource Object", "");
		params.put("Full Recon", "");
		params.put("Input Feed File","");
		RSATokenFFReconScheduler rTFFRS= new RSATokenFFReconScheduler();
		rTFFRS.execute(params);
	}
	
	
	private  OIMClient OIMConnection(){             //Function to Connection to OIM
        
        Hashtable<Object, Object> env = new Hashtable<Object, Object>();
        env.put(OIMClient.JAVA_NAMING_FACTORY_INITIAL, "weblogic.jndi.WLInitialContextFactory");
        env.put(OIMClient.JAVA_NAMING_PROVIDER_URL, "t3://localhost:14000");        //Update localhost with your OIM machine IP
         
        System.setProperty("java.security.auth.login.config", "E:/oimjarfiles/config/authwl.conf");   //Update path of authwl.conf file according to your environment
        System.setProperty("OIM.AppServerType", "wls");  
        System.setProperty("APPSERVER_TYPE", "wls");
        oracle.iam.platform.OIMClient oimClient = new oracle.iam.platform.OIMClient(env);
 
         try {                        
               oimClient.login("xelsysadm", "Passw0rd".toCharArray());         //Update password of Admin with your environment password
               System.out.print("Successfully Connected with OIM ");
             } catch (LoginException e) {
               System.out.print("Login Exception"+ e);
            }            
          
       return oimClient;
    }
	
	
	
	
	
}
