package cn.henry.patient.service;

import cn.henry.patient.domain.PatientType;
import cn.henry.patient.utils.TreeSelect;

import java.util.List;

/**
 * 针对表【biz_patient_type(患者类型表)】的数据库操作Service
 *
 * @author henry
 */
public interface PatientTypeService {
    /**
     * 查询类型管理数据
     *
     * @param type 类型信息
     * @return 类型信息集合
     */
    List<PatientType> selectTypeList(PatientType type);

    /**
     * 构建前端所需要树结构
     *
     * @param types 类型列表
     * @return 树结构列表
     */
    List<PatientType> buildTypeTree(List<PatientType> types);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param types 类型列表
     * @return 下拉树结构列表
     */
    List<TreeSelect> buildTypeTreeSelect(List<PatientType> types);

    /**
     * 根据角色ID查询类型树信息
     *
     * @param roleId 角色ID
     * @return 选中类型列表
     */
    List<Long> selectTypeListByRoleId(Long roleId);

    /**
     * 根据类型ID查询信息
     *
     * @param typeId 类型ID
     * @return 类型信息
     */
    PatientType selectTypeById(Long typeId);

    /**
     * 根据ID查询所有子类型（正常状态）
     *
     * @param typeId 类型ID
     * @return 子类型数
     */
    int selectNormalChildrenTypeById(Long typeId);

    /**
     * 是否存在类型子节点
     *
     * @param typeId 类型ID
     * @return 结果
     */
    boolean hasChildByTypeId(Long typeId);

    /**
     * 查询类型是否存在用户
     *
     * @param typeId 类型ID
     * @return 结果 true 存在 false 不存在
     */
    boolean checkTypeExistUser(Long typeId);

    /**
     * 校验类型名称是否唯一
     *
     * @param type 类型信息
     * @return 结果
     */
    String checkTypeNameUnique(PatientType type);

    /**
     * 校验类型是否有数据权限
     *
     * @param typeId 类型id
     */
    void checkTypeDataScope(Long typeId);

    /**
     * 新增保存类型信息
     *
     * @param type 类型信息
     * @return 结果
     */
    int insertType(PatientType type);

    /**
     * 修改保存类型信息
     *
     * @param type 类型信息
     * @return 结果
     */
    int updateType(PatientType type);

    /**
     * 删除类型管理信息
     *
     * @param typeId 类型ID
     * @return 结果
     */
    int deleteTypeById(Long typeId);
}
