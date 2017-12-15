package com.kp.org.rsa.token;

import java.util.HashMap;
import java.util.Hashtable;

import oracle.iam.platform.OIMClient;

public class ReconciliationEventsTestDriver {

	public static final String OIM_HOSTNAME="localhost";
	public static final String OIM_PORT="14000";
	public static final String OIM_PROVIDER_URL="t3://"+OIM_HOSTNAME +":"+OIM_PORT;
	public static final String AUTHWL_PATH="lib/config/authwl.conf";
	public static final String APPSERVER_TYPE="wls";
	public static final String FACTORY_INITIAL_TYPE="weblogic.jndi.WLInitialContextFactory";
	public static final String OIM_ADMIN_USERNAME="xelsysadm";
	public static final String OIM_ADMIN_PASSWORD="Password1";
	
	
	public static final String INPUT_RESOURCE_OBJECT="DBAT User";
	public static final String INPUT_IT_RESOURCE="DBAT";
	
	public static void main(String[] args){
		OIMClient oimClient =null;
		
		try{
			System.setProperty("java.security.auth.login.config", AUTHWL_PATH);
			System.setProperty("APPSERVER_TYPE", APPSERVER_TYPE);
			
			Hashtable<String,String> env= new Hashtable<String,String>();
			env.put(oimClient.JAVA_NAMING_FACTORY_INITIAL,FACTORY_INITIAL_TYPE);
			env.put(oimClient.JAVA_NAMING_PROVIDER_URL,OIM_PROVIDER_URL);
			
			oimClient= new OIMClient(env);
			
			oimClient.login(OIM_ADMIN_USERNAME, OIM_ADMIN_PASSWORD.toCharArray());
			
			ReconciliationEvents reconEvtUtil = new ReconciliationEvents(oimClient);
			
			
			HashMap<String,Object> reconData = new HashMap<String,Object>();
			
			
			
			
			
		}
	}
	
	
	
}
