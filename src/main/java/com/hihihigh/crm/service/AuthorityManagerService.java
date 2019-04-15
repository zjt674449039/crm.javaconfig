package com.hihihigh.crm.service;

import java.util.List;

import com.hihihigh.crm.model.autogenerator.Position;

public interface AuthorityManagerService {
	/**
	 * 增加新职位,并绑定权限和部门
	 * @param position 职位
	 * @param authorities 权限Id(多)
	 * @return 0 添加成功 1 添加失败
	 */
	String addPosition(Position position, Integer[] authorityNameAuthorityIds);

	/**
	 * 修改职位权限
	 * @param positionId 职位
	 * @param authorityIds 权限(多)
	 * @return 0 添加成功 1 添加失败
	 */
	String alterAuthority(Integer positionId, List<Integer> authorityIds);
	
	/**
	 * 删除职位权限
	 * @param positionId 职位
	 * @param authorityIds 权限(多)
	 * @return 0 操作成功 1 操作失败
	 */
	String deleteAuthority(Integer positionId, List<Integer> authorityIds);

}
