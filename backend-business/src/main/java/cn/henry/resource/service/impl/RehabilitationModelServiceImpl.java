package cn.henry.resource.service.impl;

import cn.henry.resource.domain.RehabilitationModel;
import cn.henry.resource.mapper.RehabilitationModelMapper;
import cn.henry.resource.service.IRehabilitationModelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 患者康复模型Service业务层处理
 *
 * @author henry
 * @date 2022-04-25
 */
@Service
public class RehabilitationModelServiceImpl implements IRehabilitationModelService {
    @Resource
    private RehabilitationModelMapper rehabilitationModelMapper;

    /**
     * 查询患者康复模型
     *
     * @param id 患者康复模型主键
     * @return 患者康复模型
     */
    @Override
    public RehabilitationModel selectRehabilitationModelById(Long id) {
        return rehabilitationModelMapper.selectRehabilitationModelById(id);
    }

    /**
     * 查询患者康复模型列表
     *
     * @param rehabilitationModel 患者康复模型
     * @return 患者康复模型
     */
    @Override
    public List<RehabilitationModel> selectRehabilitationModelList(RehabilitationModel rehabilitationModel) {
        return rehabilitationModelMapper.selectRehabilitationModelList(rehabilitationModel);
    }

    /**
     * 新增患者康复模型
     *
     * @param rehabilitationModel 患者康复模型
     * @return 结果
     */
    @Override
    public int insertRehabilitationModel(RehabilitationModel rehabilitationModel) {
        return rehabilitationModelMapper.insertRehabilitationModel(rehabilitationModel);
    }

    /**
     * 修改患者康复模型
     *
     * @param rehabilitationModel 患者康复模型
     * @return 结果
     */
    @Override
    public int updateRehabilitationModel(RehabilitationModel rehabilitationModel) {
        return rehabilitationModelMapper.updateRehabilitationModel(rehabilitationModel);
    }

    /**
     * 批量删除患者康复模型
     *
     * @param ids 需要删除的患者康复模型主键
     * @return 结果
     */
    @Override
    public int deleteRehabilitationModelByIds(Long[] ids) {
        return rehabilitationModelMapper.deleteRehabilitationModelByIds(ids);
    }

    /**
     * 删除患者康复模型信息
     *
     * @param id 患者康复模型主键
     * @return 结果
     */
    @Override
    public int deleteRehabilitationModelById(Long id) {
        return rehabilitationModelMapper.deleteRehabilitationModelById(id);
    }
}
