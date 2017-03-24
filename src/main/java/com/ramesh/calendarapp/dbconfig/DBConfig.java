package com.ramesh.calendarapp.dbconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@Configuration
@AutoConfigureBefore(value = { DBConnection.class })
@PropertySources( {@PropertySource(value = { "classpath:/application.properties" })} )
public class DBConfig {

    @Value("${db.user}")
    String  USER;
    
    @Value("${db.password}")
    String  PASSWORD;
    
    @Value("${db.url}")
    String  URL;
   
    @Value("${db.driver}")
    String  DRIVER;
    

    public String getUSER() {
        return USER;
    }
    
    public void setUSER(String uSER) {
        USER = uSER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String pASSWORD) {
        PASSWORD = pASSWORD;
    }

    public String getURL() {
        return URL;
    }
    
    public void setURL(String uRL) {
        URL = uRL;
    }

    public String getDRIVER() {
        return DRIVER;
    }

    public void setDRIVER(String dRIVER) {
        DRIVER = dRIVER;
    }  
    
}
