package com.icbc.service.impl;

import com.icbc.entity.Card;
import com.icbc.mapper.CardMapper;
import com.icbc.service.CardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kingvern
 * @since 2020-08-19
 */
@Service
public class CardServiceImpl extends ServiceImpl<CardMapper, Card> implements CardService {

}
