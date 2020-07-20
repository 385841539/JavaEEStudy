package com.itheimaioc.proxy.impl;

import com.itheimaioc.proxy.IProducer;

public class ProducerImpl implements IProducer {
    public void saleProduct(float money) {


        System.out.println("---销售--money:"+money);

    }

    public void serviceProduct(float money) {
        System.out.println("---服务--money:"+money);

    }
}
