package mapperscan.service.Impl;


import mapperscan.service.FactoryService;
import mapperscan.service.Product2Service;
import mapperscan.service.ProductsService;

public class TelephoneFactoryImpl implements FactoryService {
    @Override
    public ProductsService createProduct() {
        return new TelephoneProductImpl();
    }

    @Override
    public Product2Service createProduct2() {
        return new Telephone2ProductImpl();
    }
}
