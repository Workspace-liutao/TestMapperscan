package mapperscan.service.Impl;

import mapperscan.annotation.MyTestAnntation;
import mapperscan.service.BaseService;

@MyTestAnntation
public class BaseITestI implements BaseService {
    public void getInfo(){
        System.out.println("Hello,BaseITestI");
    }
}

