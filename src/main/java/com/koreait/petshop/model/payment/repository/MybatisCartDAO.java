package com.koreait.petshop.model.payment.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.petshop.exception.CartException;
import com.koreait.petshop.model.domain.Cart;
import com.koreait.petshop.model.domain.Member;

@Repository
public class MybatisCartDAO implements CartDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectAll(int member_id) {
		return sqlSessionTemplate.selectList("Cart.selectAll", member_id);
	}

	@Override
	public Cart select(int cart_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void duplicateCheck(Cart cart) throws CartException{
		List list = sqlSessionTemplate.selectList("Cart.duplicateCheck", cart);
		
		if(list.size()>0) { //?īëŊ? ?īęēĻė§ ???ī ??Ī? ?ëŊ?...
			throw new CartException("?Ĩë°ęĩŽ?? ?īëŊ? ?īęēĻė§ ?????Ī");
		}
	}
	
	@Override
	public void insert(Cart cart) throws CartException{
		int result=sqlSessionTemplate.insert("Cart.insert", cart);
		if(result==0) {
			throw new CartException("?Ĩë°ęĩŽ?? ?īė§? ëŠŧí?ĩ??Ī.");
		}
	}

	@Override
	public void update(Cart cart) throws CartException{
		int result = sqlSessionTemplate.update("Cart.update", cart);
		if(result==0) {
			throw new CartException("?Ĩë°ęĩŽ? ??  ?Ī?Ļ");
		}
		
	}

	@Override
	public void delete(Cart cart) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Member member) throws CartException{
		int result=sqlSessionTemplate.delete("Cart.delete", member.getMember_id());
		if(result==0) {
			throw new CartException("?Ĩë°ęĩŽ? ?­?  ?Ī?Ļ");
		}
	}

	
}





