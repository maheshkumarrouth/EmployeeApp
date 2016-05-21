package de.employeeapp.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringProfilesTest {
    @Autowired
    DatasourceConfig datasourceConfig;
 
    public void setupDatasource() {
        datasourceConfig.setup();
    }
}
