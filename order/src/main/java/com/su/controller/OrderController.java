package com.su.controller;

import com.su.DAO.OrderDAO;
import com.su.entity.Order;
import com.su.entity.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderDAO orderDAO;

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        orderDAO.save(order);
    }

    @GetMapping("/findAllByUid/{uid}/{page}/{limit}")
    public OrderVO findAllByUid(@PathVariable("uid") long uid,
                                @PathVariable("page") int page,
                                @PathVariable("limit") int limit){
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderDAO.countByUid(uid));
        orderVO.setData(orderDAO.findAllByUid(uid, (page - 1) * limit, limit));
        return orderVO;
    }

    @DeleteMapping("/deleteById/{mid}")
    public void deleteByMid(@PathVariable("mid") long mid){
        orderDAO.deleteByMid(mid);
    }

    @DeleteMapping("/deleteByUid/{uid}")
    public void deleteByUid(@PathVariable("uid") long uid){
        orderDAO.deleteByUid(uid);
    }

    @GetMapping("/findAllByState/{state}/{page}/{limit}")
    public OrderVO findAllByState(@PathVariable("state") int state,
                                  @PathVariable("page") int page,
                                  @PathVariable("limit") int limit){
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderDAO.countByState(state));
        orderVO.setData(orderDAO.findAllByState(state, (page - 1) * limit, limit));
        return orderVO;
    }

    @PutMapping("/updateState/{id}/{state}/{aid}")
    public void updateState(@PathVariable("id") long id,
                            @PathVariable("aid") long aid,
                            @PathVariable("state") int state){
        orderDAO.updateState(id, aid, state);
    }
}
