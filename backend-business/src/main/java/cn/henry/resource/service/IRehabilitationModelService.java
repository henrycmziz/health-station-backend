package cn.henry.resource.service;

import cn.henry.resource.domain.RehabilitationModel;

import java.util.List;

/**
 * 患者康复模型Service接口
 *
 * @author henry
 * @date 2022-04-25
 */
public interface IRehabilitationModelService {
    /**
     * 查询患者康复模型
     *
     * @param id 患者康复模型主键
     * @return 患者康复模型
     */
    RehabilitationModel selectRehabilitationModelById(Long id);

    /**
     * 查询患者康复模型列表
     *
     * @param rehabilitationModel 患者康复模型
     * @return 患者康复模型集合
     */
    List<RehabilitationModel> selectRehabilitationModelList(RehabilitationModel rehabilitationModel);

    /**
     * 新增患者康复模型
     *
     * @param rehabilitationModel 患者康复模型
     * @return 结果
     */
    int insertRehabilitationModel(RehabilitationModel rehabilitationModel);

    /**
     * 修改患者康复模型
     *
     * @param rehabilitationModel 患者康复模型
     * @return 结果
     */
    int updateRehabilitationModel(RehabilitationModel rehabilitationModel);

    /**
     * 批量删除患者康复模型
     *
     * @param ids 需要删除的患者康复模型主键集合
     * @return 结果
     */
    int deleteRehabilitationModelByIds(Long[] ids);

    /**
     * 删除患者康复模型信息
     *
     * @param id 患者康复模型主键
     * @return 结果
     */
    int deleteRehabilitationModelById(Long id);
}
