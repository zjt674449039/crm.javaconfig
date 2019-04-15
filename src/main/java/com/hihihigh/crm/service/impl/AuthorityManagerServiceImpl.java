package com.hihihigh.crm.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hihihigh.crm.dao.AuthorityMapper;
import com.hihihigh.crm.dao.PositionMapper;
import com.hihihigh.crm.model.autogenerator.Authority;
import com.hihihigh.crm.model.autogenerator.AuthorityExample;
import com.hihihigh.crm.model.autogenerator.Position;
import com.hihihigh.crm.service.AuthorityManagerService;

@Service
@Transactional
public class AuthorityManagerServiceImpl implements AuthorityManagerService{
	private static final String SUCCESS = "0";
	private static final String FAILED = "1";
	
	@Autowired
	PositionMapper positionMapper;
	
	@Autowired
	AuthorityMapper authorityMapper;
	
	@Transactional
	@Override
	public String addPosition(Position position, Integer[] authorityNameAuthorityIds) {
		Integer i = 0;
		String result = FAILED;
		//position表插入新数据(position,departmentId)
		i += positionMapper.insertSelective(position);
		/*在authority表中,用新插入数据自动生成的id,作为authority_position_id,
		和authoritiesId[]插入多条数据*/
		for (Integer authorityNameAuthorityId : authorityNameAuthorityIds) {
			i += authorityMapper.insertSelective(new Authority(position.getId(),
					authorityNameAuthorityId));
		}
		if (i == authorityNameAuthorityIds.length+1) {
			result = SUCCESS;
		}
		return result;
	}

	@Transactional
	@Override
	public String alterAuthority(Integer positionId, List<Integer> authorityIds) {
		String result = FAILED;
		int i = 0;
		List<Integer> oldAuthorityIds = new ArrayList<>();
		//authority表,根据posionId查询对应的authorityIds
		AuthorityExample example = new AuthorityExample();
		AuthorityExample.Criteria criteria = example.createCriteria();
		criteria.andAuthorityPositionIdEqualTo(positionId);
		List<Authority> authorities = authorityMapper.selectByExample(example);
		for (Authority authority : authorities) {
			oldAuthorityIds.add(
					authority.getAuthorityNameAuthorityId());
		}
		//反射新对象,保存原始数据
		List<Integer> tempAuthorityIds = new ArrayList<>(oldAuthorityIds);
		oldAuthorityIds.removeAll(authorityIds);//需要删除的
		for (Integer deleteAuthorityId : oldAuthorityIds) {
			example.clear();
			criteria = example.createCriteria();
			criteria.andAuthorityPositionIdEqualTo(positionId)
			.andAuthorityNameAuthorityIdEqualTo(deleteAuthorityId);
			i += authorityMapper.deleteByExample(example);
		}
		authorityIds.removeAll(tempAuthorityIds);// 需要增加的
		for (Integer addAuthorityId : authorityIds) {
			i += authorityMapper.insertSelective(
					new Authority(positionId,addAuthorityId));
		}
		if (i==oldAuthorityIds.size()+authorityIds.size()) {
			result = SUCCESS;
		}
		return result;
	}

	@Override
	public String deleteAuthority(Integer positionId, List<Integer> authorityIds) {
		String result = FAILED;
		int i = 0;
		AuthorityExample example = new AuthorityExample();
		AuthorityExample.Criteria criteria = example.createCriteria();
		for (Integer deleteAuthorityId : authorityIds) {
			example.clear();
			criteria = example.createCriteria();
			criteria.andAuthorityPositionIdEqualTo(positionId)
			.andAuthorityNameAuthorityIdEqualTo(deleteAuthorityId);
			i += authorityMapper.deleteByExample(example);
		}
		if (i == authorityIds.size()) {
			result = SUCCESS;
		}
		return result;
	}

}
