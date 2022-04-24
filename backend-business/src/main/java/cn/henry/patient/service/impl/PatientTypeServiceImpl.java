package cn.henry.patient.service.impl;

import cn.henry.common.constant.UserConstants;
import cn.henry.common.core.text.Convert;
import cn.henry.common.exception.ServiceException;
import cn.henry.common.utils.StringUtils;
import cn.henry.patient.domain.PatientType;
import cn.henry.patient.mapper.PatientTypeMapper;
import cn.henry.patient.service.PatientTypeService;
import cn.henry.patient.utils.TreeSelect;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 针对表【biz_patient_type(患者类型表)】的数据库操作Service实现
 *
 * @author henry
 */
@Service
public class PatientTypeServiceImpl implements PatientTypeService {
    @Resource
    private PatientTypeMapper typeMapper;

    /**
     * 查询类型管理数据
     *
     * @param type 类型信息
     * @return 类型信息集合
     */
    @Override
    public List<PatientType> selectTypeList(PatientType type) {
        return typeMapper.selectTypeList(type);
    }

    /**
     * 构建前端所需要树结构
     *
     * @param types 类型列表
     * @return 树结构列表
     */
    @Override
    public List<PatientType> buildTypeTree(List<PatientType> types) {
        List<PatientType> returnList = new ArrayList<>();
        List<Long> tempList = new ArrayList<>();
        for (PatientType type : types) {
            tempList.add(type.getTypeId());
        }
        for (PatientType type : types) {
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(type.getParentId())) {
                recursionFn(types, type);
                returnList.add(type);
            }
        }
        if (returnList.isEmpty()) {
            returnList = types;
        }
        return returnList;
    }

    /**
     * 构建前端所需要下拉树结构
     *
     * @param types 类型列表
     * @return 下拉树结构列表
     */
    @Override
    public List<TreeSelect> buildTypeTreeSelect(List<PatientType> types) {
        List<PatientType> typeTrees = buildTypeTree(types);
        return typeTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    /**
     * 根据角色ID查询类型树信息
     *
     * @param roleId 角色ID
     * @return 选中类型列表
     */
    @Override
    public List<Long> selectTypeListByRoleId(Long roleId) {
        //SysRole role = roleMapper.selectRoleById(roleId);
        //return typeMapper.selectTypeListByRoleId(roleId, role.isTypeCheckStrictly());
        return null;
    }

    /**
     * 根据类型ID查询信息
     *
     * @param typeId 类型ID
     * @return 类型信息
     */
    @Override
    public PatientType selectTypeById(Long typeId) {
        return typeMapper.selectTypeById(typeId);
    }

    /**
     * 根据ID查询所有子类型（正常状态）
     *
     * @param typeId 类型ID
     * @return 子类型数
     */
    @Override
    public int selectNormalChildrenTypeById(Long typeId) {
        return typeMapper.selectNormalChildrenTypeById(typeId);
    }

    /**
     * 是否存在子节点
     *
     * @param typeId 类型ID
     * @return 结果
     */
    @Override
    public boolean hasChildByTypeId(Long typeId) {
        int result = typeMapper.hasChildByTypeId(typeId);
        return result > 0;
    }

    /**
     * 查询类型是否存在用户
     *
     * @param typeId 类型ID
     * @return 结果 true 存在 false 不存在
     */
    @Override
    public boolean checkTypeExistUser(Long typeId) {
        int result = typeMapper.checkTypeExistUser(typeId);
        return result > 0;
    }

    /**
     * 校验类型名称是否唯一
     *
     * @param type 类型信息
     * @return 结果
     */
    @Override
    public String checkTypeNameUnique(PatientType type) {
        long typeId = StringUtils.isNull(type.getTypeId()) ? -1L : type.getTypeId();
        PatientType info = typeMapper.checkTypeNameUnique(type.getTypeName(), type.getParentId());
        if (StringUtils.isNotNull(info) && info.getTypeId() != typeId) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验类型是否有数据权限
     *
     * @param typeId 类型id
     */
    @Override
    public void checkTypeDataScope(Long typeId) {
        //if (!SysUser.isAdmin(SecurityUtils.getUserId())) {
        //    PatientType type = new PatientType();
        //    type.setTypeId(typeId);
        //    List<PatientType> types = SpringUtils.getAopProxy(this).selectTypeList(type);
        //    if (StringUtils.isEmpty(types)) {
        //        throw new ServiceException("没有权限访问类型数据！");
        //    }
        //}
    }

    /**
     * 新增保存类型信息
     *
     * @param type 类型信息
     * @return 结果
     */
    @Override
    public int insertType(PatientType type) {
        PatientType info = typeMapper.selectTypeById(type.getParentId());
        // 如果父节点不为正常状态,则不允许新增子节点
        if (!UserConstants.DEPT_NORMAL.equals(info.getStatus())) {
            throw new ServiceException("类型停用，不允许新增");
        }
        type.setAncestors(info.getAncestors() + "," + type.getParentId());
        return typeMapper.insertType(type);
    }

    /**
     * 修改保存类型信息
     *
     * @param type 类型信息
     * @return 结果
     */
    @Override
    public int updateType(PatientType type) {
        PatientType newParentType = typeMapper.selectTypeById(type.getParentId());
        PatientType oldType = typeMapper.selectTypeById(type.getTypeId());
        if (StringUtils.isNotNull(newParentType) && StringUtils.isNotNull(oldType)) {
            String newAncestors = newParentType.getAncestors() + "," + newParentType.getTypeId();
            String oldAncestors = oldType.getAncestors();
            type.setAncestors(newAncestors);
            updateTypeChildren(type.getTypeId(), newAncestors, oldAncestors);
        }
        int result = typeMapper.updateType(type);
        if (UserConstants.DEPT_NORMAL.equals(type.getStatus()) && StringUtils.isNotEmpty(type.getAncestors())
                && !StringUtils.equals("0", type.getAncestors())) {
            // 如果该类型是启用状态，则启用该类型的所有上级类型
            updateParentTypeStatusNormal(type);
        }
        return result;
    }

    /**
     * 修改该类型的父级类型状态
     *
     * @param type 当前类型
     */
    private void updateParentTypeStatusNormal(PatientType type) {
        String ancestors = type.getAncestors();
        Long[] typeIds = Convert.toLongArray(ancestors);
        typeMapper.updateTypeStatusNormal(typeIds);
    }

    /**
     * 修改子元素关系
     *
     * @param typeId       被修改的类型ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    public void updateTypeChildren(Long typeId, String newAncestors, String oldAncestors) {
        List<PatientType> children = typeMapper.selectChildrenTypeById(typeId);
        for (PatientType child : children) {
            child.setAncestors(child.getAncestors().replaceFirst(oldAncestors, newAncestors));
        }
        if (!children.isEmpty()) {
            typeMapper.updateTypeChildren(children);
        }
    }

    /**
     * 删除类型管理信息
     *
     * @param typeId 类型ID
     * @return 结果
     */
    @Override
    public int deleteTypeById(Long typeId) {
        return typeMapper.deleteTypeById(typeId);
    }

    /**
     * 递归列表
     */
    private void recursionFn(List<PatientType> list, PatientType t) {
        // 得到子节点列表
        List<PatientType> childList = getChildList(list, t);
        t.setChildren(childList);
        for (PatientType tChild : childList) {
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<PatientType> getChildList(List<PatientType> list, PatientType t) {
        List<PatientType> childList = new ArrayList<>();
        for (PatientType n : list) {
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getTypeId().longValue()) {
                childList.add(n);
            }
        }
        return childList;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<PatientType> list, PatientType t) {
        return !getChildList(list, t).isEmpty();
    }
}
