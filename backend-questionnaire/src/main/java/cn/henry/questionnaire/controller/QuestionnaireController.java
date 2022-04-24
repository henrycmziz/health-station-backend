package cn.henry.questionnaire.controller;

import cn.henry.common.annotation.Log;
import cn.henry.common.core.controller.BaseController;
import cn.henry.common.core.domain.Response;
import cn.henry.common.core.page.ResponsePageInfo;
import cn.henry.common.enums.BusinessType;
import cn.henry.common.utils.poi.ExcelUtil;
import cn.henry.questionnaire.domain.Questionnaire;
import cn.henry.questionnaire.domain.dto.QuestionnaireDto;
import cn.henry.questionnaire.service.IQuestionnaireService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 问卷Controller
 *
 * @author henry
 * @date 2022-03-28
 */
@Api(tags = "问卷")
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController extends BaseController {
    @Autowired
    private IQuestionnaireService questionnaireService;

    /**
     * 保存问卷
     */
    @ApiOperation(value = "保存问卷概要+问题")
    @PostMapping("/save")
    public Response<Integer> saveQuestionnaire(@RequestBody QuestionnaireDto dto) {
        return Response.success(questionnaireService.saveQuestionnaire(dto));
    }

    /**
     * 查询问卷列表
     */
    @ApiOperation(value = "列表")
    @PreAuthorize("@ss.hasPermi('questionnaire:questionnaire:list')")
    @GetMapping("/list")
    public ResponsePageInfo<Questionnaire> list(Questionnaire questionnaire) {
        startPage();
        List<Questionnaire> list = questionnaireService.selectQuestionnaireList(questionnaire);
        return toResponsePageInfo(list);
    }

    /**
     * 导出问卷列表
     */
    @ApiOperation(value = "导出列表")
    @PreAuthorize("@ss.hasPermi('questionnaire:questionnaire:export')")
    @Log(title = "问卷", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Questionnaire questionnaire) {
        List<Questionnaire> list = questionnaireService.selectQuestionnaireList(questionnaire);
        ExcelUtil<Questionnaire> util = new ExcelUtil<Questionnaire>(Questionnaire.class);
        util.exportExcel(response, list, "问卷数据");
    }

    /**
     * 获取问卷详细信息
     */
    @ApiOperation(value = "详细信息")
    //@PreAuthorize("@ss.hasPermi('questionnaire:questionnaire:query')")
    @GetMapping(value = "/{questionnaireId}/info")
    public Response<Questionnaire> getInfo(@PathVariable("questionnaireId") Long questionnaireId) {
        return Response.success(questionnaireService.selectQuestionnaireByQuestionnaireId(questionnaireId));
    }

    /**
     * 新增问卷
     */
    @ApiOperation(value = "新增")
    @PreAuthorize("@ss.hasPermi('questionnaire:questionnaire:add')")
    @PostMapping
    public Response<Long> add() {
        return Response.success(questionnaireService.insertQuestionnaire(getUsername()));
    }

    /**
     * 修改问卷
     */
    @ApiOperation(value = "修改")
    @PreAuthorize("@ss.hasPermi('questionnaire:questionnaire:edit')")
    @PutMapping
    public Response<Integer> edit(@RequestBody Questionnaire questionnaire) {
        return toResponse(questionnaireService.updateQuestionnaire(questionnaire));
    }

    /**
     * 删除问卷
     */
    @ApiOperation(value = "删除")
    @PreAuthorize("@ss.hasPermi('questionnaire:questionnaire:remove')")
    @DeleteMapping("/{questionnaireId}")
    public Response<Integer> remove(@PathVariable Long questionnaireId) {
        return toResponse(questionnaireService.deleteQuestionnaireByQuestionnaireId(questionnaireId));
    }
}
