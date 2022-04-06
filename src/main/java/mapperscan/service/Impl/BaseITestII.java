package mapperscan.service.Impl;

import mapperscan.annotation.MyTestAnntation;
import mapperscan.service.BaseService;

@MyTestAnntation
public class BaseITestII implements BaseService {
    public void getInfo(){
        System.out.println("Hello,BaseITestII");
    }
}

