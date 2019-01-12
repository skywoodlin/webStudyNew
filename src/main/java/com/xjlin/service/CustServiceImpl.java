package com.xjlin.service;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.xjlin.dao.CustDao;
import com.xjlin.domain.Cust;
import com.xjlin.domain.Page;
import com.xjlin.factory.BasicFactory;
import com.xjlin.util.DaoUtils;


public class CustServiceImpl implements CustService {
	CustDao dao = BasicFactory.getFactory().getInstance(CustDao.class);
	public void addCust(Cust cust) {
		//1.检查用户名是否已经存在
		if(dao.findUserByName(cust.getName())!=null){
			throw new RuntimeException("用户名已经存在!!");
		}
		//2.调用dao中的方法增加用户
		dao.addCust(cust);
	}
	public List<Cust> getAllCust() {
		return dao.getAllCust();
	}
	public Cust findCustById(String id) {
		return dao.findUserById(id);
	}
	public void updateCust(Cust cust) {
		dao.updateCust(cust);
	}
	public void delCustByID(String id) {
		dao.delCustByID(id);
	}
	public void batchDel(String[] ids) {
		Connection conn = DaoUtils.getConn();
		try{
			conn.setAutoCommit(false);
			for(String id : ids){
				dao.delCustByIDWithTrans(conn,id);
			}
			DbUtils.commitAndCloseQuietly(conn);
		}catch (Exception e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public List<Cust> findCustByCond(Cust cust) {
		return dao.findCustByCond(cust);
	}
	public Page pageCust(int thispage, int rowperpage) {
		Page page = new Page();
		//--当前页
		page.setThispage(thispage);
		//--每页记录数
		page.setRowperpage(rowperpage);
		//--共有多少行
		int countrow = dao.getCountRow();
		page.setCountrow(countrow);
		//--共有多少页
		int countpage = countrow/rowperpage+(countrow%rowperpage==0?0:1);
		page.setCountpage(countpage);
		//--首页
		page.setFirstpage(1);
		//--尾页
		page.setLastpage(countpage);
		//--上一页
		page.setPrepage(thispage==1?1:thispage-1);
		//--下一页
		page.setNextpage(thispage == countpage ? countpage : thispage+1);
		//--当前页数据
		List<Cust> list = dao.getCustByPage((thispage-1)*rowperpage,rowperpage);
		page.setList(list);
		
		return page;
	}
}
