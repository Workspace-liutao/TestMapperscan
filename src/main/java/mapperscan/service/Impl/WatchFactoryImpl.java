package mapperscan.service.Impl;

import mapperscan.service.FactoryService;
import mapperscan.service.Product2Service;
import mapperscan.service.ProductsService;

public class WatchFactoryImpl implements FactoryService {

    @Override
    public ProductsService createProduct() {
        return new WatchProductImpl();
    }

    @Override
    public Product2Service createProduct2() {
        return new Watch2ProductImpl();
    }
}

