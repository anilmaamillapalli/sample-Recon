package identity.dbconnector;

import org.identityconnectors.framework.spi.AbstractConfiguration;
import org.identityconnectors.framework.spi.ConfigurationProperty;

public class DataBaseIdentityConfig  extends AbstractConfiguration{

    private String driver;
    private String url;
    private String userName;
    private String password;
    private String environment;
    
	
	
	public String getDriver() {
		return driver;
	}


    @ConfigurationProperty(order=1,displayMessageKey="driver_display",helpMessageKey="dirver_help",required=true)
	public void setDriver(String driver) {
		this.driver = driver;
	}



	public String getUrl() {
		return url;
	}


	@ConfigurationProperty(order=2,displayMessageKey="url_dispaly",helpMessageKey="url_help",required=true)
	public void setUrl(String url) {
		this.url = url;
	}



	public String getUserName() {
		return userName;
	}


	@ConfigurationProperty(order=3,displayMessageKey="userName_display",helpMessageKey="userName_help",required=true)
	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}


	@ConfigurationProperty(order=4,displayMessageKey="password_display",helpMessageKey="password_help",required=true,confidential=true)
	public void setPassword(String password) {
		this.password = password;
	}



	public String getEnvironment() {
		return environment;
	}


	@ConfigurationProperty(order=5,displayMessageKey="environemnt_display",helpMessageKey="environment_help",required=true,confidential=true)
	public void setEnvironment(String environment) {
		this.environment = environment;
	}



	@Override
	public void validate() {
		
		if(DataBaseIdentityUtil.isEmpty(driver))
		
	}
	
	
	

}
