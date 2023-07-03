package com.example.service.service.design.strategydesign;

import com.example.service.service.design.strategydesign.model.SendPriceDTO;

/**
 * 策略模式：https://mp.weixin.qq.com/s/EL-RGcPTMW7qIjoahEOcsA
 *  关于策略模式在Spring中使用比较简单, 从本质来说就是一个接口有多个实现类，每个实现类处理具体的情况
 *  如下例：support判断当前类是否满足, 如果满足调用该类下面的sendPrice方法逻辑。
 *  每个实现中, 我们只需要在support()方法中通过参数来控制当前request是否是当前实例能够处理的类型,
 *  如果是, 则外层的控制逻辑就会将request交给当前实例处理。
 *  关于类的设计, 一下几点需要注意:
 *      1: 使用@Component注解对当前类进行标注, 将其声明为Spring容器所管理的一个bean;
 *      2: 声明一个返回boolean值的类似于support()的方法, 通过这个方法来控制当前实例是否为处理目标request的实例。
 *      3: 声明一个类似于sendPrize()的方法用于处理业务逻辑, 当然根据各个业务的不同声明的方法名肯定是不同的, 这里只是一个对统一的业务处理的抽象;
 *      4: 无论是support()方法还是sendPrize()方法, 都需要传一个对象进行, 而不是简简单单的基本类型的变量, 这样做的好处是后续如果要在Request中新增字段, 那么就不需要修改接口的定义和已经实现的各个子类的逻辑;
 */
public interface IPriceSenderService {

    boolean support(SendPriceDTO dto);

    void sendPrice(SendPriceDTO dto);
}
