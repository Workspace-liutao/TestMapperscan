package mapperscan.service.Impl;

import mapperscan.annotation.MyTestAnntation;
import mapperscan.service.Product2Service;
import org.springframework.stereotype.Component;

@Component("telephone2ProductImpl")
public class Telephone2ProductImpl implements Product2Service {
    @MyTestAnntation()
    @Override
    public void downProduct() {
        System.out.println("出售手机");
    }
}
