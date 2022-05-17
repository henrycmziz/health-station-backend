package cn.henry.patient.service.impl;

import cn.henry.common.utils.DateUtils;
import cn.henry.common.utils.StringUtils;
import cn.henry.common.utils.uuid.IdUtils;
import cn.henry.patient.domain.Patient;
import cn.henry.patient.domain.PatientClockIn;
import cn.henry.patient.domain.PatientClockInDetail;
import cn.henry.patient.domain.vo.PatientClockInPlanVo;
import cn.henry.patient.mapper.PatientClockInMapper;
import cn.henry.patient.mapper.PatientMapper;
import cn.henry.patient.service.IPatientClockInService;
import cn.henry.patient.utils.DateUtil;
import cn.henry.resource.mapper.VideoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 患者打卡计划Service业务层处理
 *
 * @author henry
 * @date 2022-04-25
 */
@Service
public class PatientClockInServiceImpl implements IPatientClockInService {
    @Resource
    private PatientClockInMapper patientClockInMapper;

    @Resource
    private PatientMapper patientMapper;

    @Resource
    private VideoMapper videoMapper;

    /**
     * 新增患者打卡计划
     *
     * @param patientClockIn 患者打卡计划
     * @return 结果
     */
    @Transactional
    @Override
    public int addPatientClockIn(PatientClockIn patientClockIn) {
        patientClockIn.setId(IdUtils.fastSimpleUUID());
        patientClockIn.setCreateTime(DateUtils.getNowDate());
        int rows = patientClockInMapper.insertPatientClockIn(patientClockIn);
        insertPatientClockInDetail(patientClockIn);
        patientMapper.updatePatientExpand(
                Patient.builder().mainUserId(patientClockIn.getPatientId()).isClockIn((byte) 1).build());
        return rows;
    }

    /**
     * 查询患者打卡计划与详情列表
     *
     * @param patientId 患者ID
     * @return 列表
     */
    @Override
    public List<PatientClockIn> selectPatientClockInListByPatientId(Long patientId) {
        return patientClockInMapper.selectPatientClockInListByPatientId(patientId);
    }

    /**
     * app-查询患者打卡详情列表
     *
     * @param patientId 患者ID
     * @return List<PatientClockInDetail>
     */
    @Override
    public List<PatientClockInDetail> selectDetailListByPatientId(Long patientId) {
        return patientClockInMapper.selectDetailListByPatientId(patientId);
    }

    /**
     * app-查询患者打卡计划
     *
     * @param id          打卡计划ID
     * @param clockInTime 打卡日期
     * @return 患者打卡计划
     */
    @Override
    public PatientClockInPlanVo selectPatientClockInById(String id, String clockInTime) {
        PatientClockInPlanVo vo = patientClockInMapper.selectPatientClockInById(id, clockInTime);
        String[] ids = vo.getModelVideoIds().split(",");
        if (ids.length > 0) {
            vo.setVideoInfos(videoMapper.selectVideoByIds(StringUtils.StringArray2LongArray(ids)));
        }
        return vo;
    }

    /**
     * app-打卡
     *
     * @param pid    患者ID
     * @param detail detail
     * @return 结果
     */
    @Transactional
    @Override
    public int finishClockInTask(Long pid, PatientClockInDetail detail) {
        int row = patientClockInMapper.finishClockInTask(detail);
        if (patientClockInMapper.selectIsHaveMoreClockInTask(pid) == 0) {
            patientMapper.updatePatientExpand(Patient.builder().mainUserId(pid).isClockIn((byte) 0).build());
        }
        return row;
    }

    /**
     * 查询患者打卡计划
     *
     * @param id 患者打卡计划主键
     * @return 患者打卡计划
     */
    @Override
    public PatientClockIn selectPatientClockInWithDetailById(String id) {
        return patientClockInMapper.selectPatientClockInWithDetailById(id);
    }

    /**
     * 查询患者打卡计划列表
     *
     * @param patientClockIn 患者打卡计划
     * @return 患者打卡计划
     */
    @Override
    public List<PatientClockIn> selectPatientClockInList(PatientClockIn patientClockIn) {
        return patientClockInMapper.selectPatientClockInList(patientClockIn);
    }

    /**
     * 新增患者打卡计划
     *
     * @param patientClockIn 患者打卡计划
     * @return 结果
     */
    @Transactional
    @Override
    public int insertPatientClockIn(PatientClockIn patientClockIn) {
        patientClockIn.setCreateTime(DateUtils.getNowDate());
        int rows = patientClockInMapper.insertPatientClockIn(patientClockIn);
        insertPatientClockInDetail(patientClockIn);
        return rows;
    }

    /**
     * 修改患者打卡计划
     *
     * @param patientClockIn 患者打卡计划
     * @return 结果
     */
    @Transactional
    @Override
    public int updatePatientClockIn(PatientClockIn patientClockIn) {
        patientClockIn.setUpdateTime(DateUtils.getNowDate());
        patientClockInMapper.deletePatientClockInDetailByClockInId(patientClockIn.getId());
        insertPatientClockInDetail(patientClockIn);
        return patientClockInMapper.updatePatientClockIn(patientClockIn);
    }

    /**
     * 批量删除患者打卡计划
     *
     * @param ids 需要删除的患者打卡计划主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deletePatientClockInByIds(String[] ids) {
        patientClockInMapper.deletePatientClockInDetailByClockInIds(ids);
        return patientClockInMapper.deletePatientClockInByIds(ids);
    }

    /**
     * 删除患者打卡计划信息
     *
     * @param id 患者打卡计划主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deletePatientClockInById(String id) {
        patientClockInMapper.deletePatientClockInDetailByClockInId(id);
        return patientClockInMapper.deletePatientClockInById(id);
    }

    /**
     * 新增患者打卡详情信息
     *
     * @param patientClockIn 患者打卡计划对象
     */
    public void insertPatientClockInDetail(PatientClockIn patientClockIn) {
        List<PatientClockInDetail> detailList = new ArrayList<>();
        List<Date> dateList = DateUtil.genDates(patientClockIn.getStartTime(), patientClockIn.getEndTime());
        for (Date date : dateList) {
            detailList.add(new PatientClockInDetail(IdUtils.fastSimpleUUID(), patientClockIn.getId(), date));
        }
        if (!detailList.isEmpty()) {
            patientClockInMapper.batchPatientClockInDetail(detailList);
        }
    }
}
