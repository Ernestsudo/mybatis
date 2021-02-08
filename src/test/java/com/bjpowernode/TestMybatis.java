package com.bjpowernode;
import java.util.Date;
import com.bjpowernode.dao.OrderDao;
import com.bjpowernode.daomain.OrderDetail;
import com.bjpowernode.daomain.OrderMessage;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
   /* 测试获取客户订单信息*/
    @Test
    public void selectOrderMessage(){
        OrderMessage orderMessage = new OrderMessage();
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        orderMessage.setCustomName("学");
        List<OrderMessage> orderList = orderDao.selectOrderMessage(orderMessage.getCustomName());
        for (OrderMessage om:orderList) {
            System.out.println("订单编号: "+ om.getId());
            System.out.println("顾客姓名: " + om.getCustomName());
            System.out.println("顾客地址: " + om.getCustomAddress());
            System.out.println("创建时间：" + om.getCreateTime());
            System.out.println("总价" + om.getTotalPrice());
        }
        sqlSession.close();
    }


    /* 测试获取商品信息*/

 @Test
    public void selectOrderDetail(){
        OrderDetail orderDetail = new OrderDetail();
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        orderDetail.setOrderId(1);
        List<OrderDetail> orderDetailList = orderDao.selectOrderDetail(orderDetail.getProductName());
        for (OrderDetail od : orderDetailList) {
            System.out.println("商品编号: "+ od.getId());
            System.out.println("产品名称: " + od.getProductName());
            System.out.println("产品种类: " + od.getProductType());
            System.out.println("产品价格：" + od.getPrice());
            System.out.println("数量" + od.getCount());
        }
        sqlSession.close();
    }


    /* 测试添加订单信息*/
  @Test
    public void insertOrderMessage(){
        int result = 0;
        OrderMessage orderMessage = new OrderMessage();
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        orderMessage.setId(1);
        orderMessage.setCustomName("杜宏波");
        orderMessage.setCustomAddress("成都");
        orderMessage.setCreateTime("2020-12-12");
        orderMessage.setTotalPrice(200);
        result = orderDao.insertOrderMessage(orderMessage);
        sqlSession.commit();
        System.out.println(result == 1 ? "添加成功！" : "添加失败！" );
        sqlSession.close();

    }

    /* 测试添加商品信息*/
  @Test
    public void insertOrderDetail(){
        int result = 0;
        OrderDetail orderDetail = new OrderDetail();
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        orderDetail.setId(2);
        orderDetail.setOrderId(1);
        orderDetail.setProductName("ipone 7");
        orderDetail.setProductType("手机");
        orderDetail.setPrice(7900);
        orderDetail.setCount(1);
        orderDao.insertOrderDetail(orderDetail);
        sqlSession.commit();
        System.out.println(result == 1 ? "添加成功！" : "添加失败！" );
        sqlSession.close();

    }

  /* 测试删除订单信息*/
  @Test
    public void deleteOrderMessage(){
        int result = 0;
        OrderMessage orderMessage = new OrderMessage();
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        orderMessage.setId(2);
        result = orderDao.deleteOrderMessage(orderMessage.getId());
        System.out.println(result == 1 ? "删除成功！" : "删除失败！" );
        sqlSession.commit();
        sqlSession.close();

    }

    /* 测试删除商品信息*/
   @Test
    public void deleteOrderDetail(){
        int result = 0;
        OrderDetail orderDetail = new OrderDetail();
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        orderDetail.setId(3);
        result = orderDao.deleteOrderDetail(orderDetail.getId());
        System.out.println(result == 1 ? "删除成功！" : "删除失败！" );
        sqlSession.commit();
        sqlSession.close();

    }

}
