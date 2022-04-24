package cn.henry.patient.mapper;

import cn.henry.patient.domain.PatientType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 针对表【biz_patient_type(患者类型表)】的数据库操作Mapper
 *
 * @author henry
 */
public interface PatientTypeMapper {
    /**
     * 查询类型管理数据
     *
     * @param type 类型信息
     * @return 类型信息集合
     */
    List<PatientType> selectTypeList(PatientType type);

    /**
     * 根据角色ID查询类型树信息
     *
     * @param roleId            角色ID
     * @param typeCheckStrictly 类型树选择项是否关联显示
     * @return 选中类型列表
     */
    List<Long> selectTypeListByRoleId(@Param("roleId") Long roleId, @Param("typeCheckStrictly") boolean typeCheckStrictly);

    /**
     * 根据类型ID查询信息
     *
     * @param typeId 类型ID
     * @return 类型信息
     */
    PatientType selectTypeById(Long typeId);

    /**
     * 根据ID查询所有子类型
     *
     * @param typeId 类型ID
     * @return 类型列表
     */
    List<PatientType> selectChildrenTypeById(Long typeId);

    /**
     * 根据ID查询所有子类型（正常状态）
     *
     * @param typeId 类型ID
     * @return 子类型数
     */
    int selectNormalChildrenTypeById(Long typeId);

    /**
     * 是否存在子节点
     *
     * @param typeId 类型ID
     * @return 结果
     */
    int hasChildByTypeId(Long typeId);

    /**
     * 查询类型是否存在用户
     *
     * @param typeId 类型ID
     * @return 结果
     */
    int checkTypeExistUser(Long typeId);

    /**
     * 校验类型名称是否唯一
     *
     * @param typeName 类型名称
     * @param parentId 父类型ID
     * @return 结果
     */
    PatientType checkTypeNameUnique(@Param("typeName") String typeName, @Param("parentId") Long parentId);

    /**
     * 新增类型信息
     *
     * @param type 类型信息
     * @return 结果
     */
    int insertType(PatientType type);

    /**
     * 修改类型信息
     *
     * @param type 类型信息
     * @return 结果
     */
    int updateType(PatientType type);

    /**
     * 修改所在类型正常状态
     *
     * @param typeIds 类型ID组
     */
    void updateTypeStatusNormal(Long[] typeIds);

    /**
     * 修改子元素关系
     *
     * @param types 子元素
     * @return 结果
     */
    int updateTypeChildren(@Param("types") List<PatientType> types);

    /**
     * 删除类型管理信息
     *
     * @param typeId 类型ID
     * @return 结果
     */
    int deleteTypeById(Long typeId);
}
