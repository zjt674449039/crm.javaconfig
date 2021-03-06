package com.hihihigh.crm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.hihihigh.crm.model.autogenerator.NameAuthority;
import com.hihihigh.crm.model.autogenerator.NameAuthorityExample;

public interface NameAuthorityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table name_authority
     *
     * @mbggenerated
     */
    int countByExample(NameAuthorityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table name_authority
     *
     * @mbggenerated
     */
    int deleteByExample(NameAuthorityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table name_authority
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table name_authority
     *
     * @mbggenerated
     */
    int insert(NameAuthority record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table name_authority
     *
     * @mbggenerated
     */
    int insertSelective(NameAuthority record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table name_authority
     *
     * @mbggenerated
     */
    List<NameAuthority> selectByExample(NameAuthorityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table name_authority
     *
     * @mbggenerated
     */
    NameAuthority selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table name_authority
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") NameAuthority record, @Param("example") NameAuthorityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table name_authority
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") NameAuthority record, @Param("example") NameAuthorityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table name_authority
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(NameAuthority record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table name_authority
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(NameAuthority record);
}