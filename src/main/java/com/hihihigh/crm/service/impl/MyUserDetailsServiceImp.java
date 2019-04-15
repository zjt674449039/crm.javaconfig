package com.hihihigh.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hihihigh.crm.dao.AccountMapper;
import com.hihihigh.crm.dao.AuthorityMapper;
import com.hihihigh.crm.dao.EmployeeMapper;
import com.hihihigh.crm.dao.MyUserDetailsDao;
import com.hihihigh.crm.dao.NameAuthorityMapper;
import com.hihihigh.crm.dao.PositionMapper;
import com.hihihigh.crm.model.MyAuthorities;
import com.hihihigh.crm.model.MyUserDetails;
import com.hihihigh.crm.model.autogenerator.Account;
import com.hihihigh.crm.model.autogenerator.AccountExample;
import com.hihihigh.crm.model.autogenerator.Authority;
import com.hihihigh.crm.model.autogenerator.AuthorityExample;
import com.hihihigh.crm.model.autogenerator.Employee;
import com.hihihigh.crm.model.autogenerator.NameAuthority;
import com.hihihigh.crm.model.autogenerator.NameAuthorityExample;
import com.hihihigh.crm.model.autogenerator.Position;
import com.hihihigh.crm.model.autogenerator.PositionExample;
import com.hihihigh.crm.model.autogenerator.AuthorityExample.Criteria;

@Service
public class MyUserDetailsServiceImp implements UserDetailsService{
	@Autowired
	MyUserDetailsDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		MyUserDetails myUserDetails = userDao.selectUserByUsername(username);
		
		List<Integer> nameAuthorityIds = selectNameAuthorityIdByUsername(username);
		List<MyAuthorities> authorities = new ArrayList<>();
		for (Integer nameAuthorityId : nameAuthorityIds) {
			authorities.add(MyAuthorities.asList().get(nameAuthorityId));
		}
		if (myUserDetails!=null) {
			return new User(myUserDetails.getUsername(),
					myUserDetails.getPassword(), authorities);
		}
		throw new UsernameNotFoundException("User '"+username+"' not found");
	}
	
	@Autowired
	AccountMapper accountMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	PositionMapper positionMapper;
	
	@Autowired
	AuthorityMapper authorityMapper;


	private List<Integer> selectNameAuthorityIdByUsername(String username){
		//account表,根据username查accountEmployeeId(单);
		AccountExample accountExample = new AccountExample();
		AccountExample.Criteria accountCriteria = accountExample.createCriteria();
		accountCriteria.andUsernameEqualTo(username);
		List<Account> accounts = accountMapper.selectByExample(accountExample);
		//employee表,根据accountEmployeeId,查employeePositionName;
		Employee employeeObject = employeeMapper.selectByPrimaryKey(
				accounts.get(0).getAccountEmployeeId());
		//position表,根据employeePositionName,查询id;
		PositionExample positionExample = new PositionExample();
		PositionExample.Criteria positionCriteria = 
				positionExample.createCriteria();
		positionCriteria.andPositionNameEqualTo(
				employeeObject.getEmployeePositionName());
		List<Position> positions = positionMapper.selectByExample(positionExample);
		//authority表,根据posotionId查authorityId(多);
		List<Authority> authorities = new ArrayList<>();
		AuthorityExample authorityExample = new AuthorityExample();
		for (Position position : positions) {
			Criteria authorityCriteria = 
					authorityExample.createCriteria();
			authorityCriteria.andAuthorityPositionIdEqualTo(position.getId());
			List<Authority> tempAuthorities = 
					authorityMapper.selectByExample(authorityExample);
			authorities.addAll(tempAuthorities);
		}
		List<Integer> nameAuthorityIds = new ArrayList<>();
		for (Authority authority : authorities) {
			nameAuthorityIds.add(authority.getAuthorityNameAuthorityId()-1);
		}
		return nameAuthorityIds;
	}

	@Autowired
	NameAuthorityMapper nameAuthorityMapper;
	
	public List<NameAuthority> selectNameAccountsByUsername(String username) {
		List<Integer> nameAuthorityIds = 
				selectNameAuthorityIdByUsername(username);
		for(int i=0;i<nameAuthorityIds.size();i++){
			nameAuthorityIds.set(i, nameAuthorityIds.get(i)+1);
		}
		NameAuthorityExample example = new NameAuthorityExample();
		NameAuthorityExample.Criteria criteria = 
				example.createCriteria();
		criteria.andIdIn(nameAuthorityIds);
		return nameAuthorityMapper.selectByExample(example);
	}
	
}
