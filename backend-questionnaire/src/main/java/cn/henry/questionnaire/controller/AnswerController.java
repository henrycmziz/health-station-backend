package cn.henry.questionnaire.controller;

import cn.henry.common.annotation.Log;
import cn.henry.common.annotation.RepeatSubmit;
import cn.henry.common.core.controller.BaseController;
import cn.henry.common.core.domain.Response;
import cn.henry.common.enums.BusinessType;
import cn.henry.common.utils.poi.ExcelUtil;
import cn.henry.questionnaire.domain.Answer;
import cn.henry.questionnaire.domain.dto.SubmitAnswerDto;
import cn.henry.questionnaire.service.IAnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 问卷答案Controller
 *
 * @author henry
 * @date 2022-03-28
 */
@Api(tags = "问卷答案")
@RestController
@RequestMapping("/questionnaire/answer")
public class AnswerController extends BaseController {
    @Autowired
    private IAnswerService answerService;

    /**
     * 提交答案
     */
    @ApiOperation(value = "提交答案")
    @RepeatSubmit
    @PostMapping("/submit")
    public Response<Integer> submitAnswer(@RequestBody SubmitAnswerDto dto) {
        return toResponse(answerService.submitAnswer(dto));
    }

    /**
     * 问题答案分析
     */
    @ApiOperation(value = "答案分析")
    @PreAuthorize("@ss.hasPermi('questionnaire:answer:list')")
    @GetMapping("/analysis")
    public Response<Map<String, String>> analysis(Answer answer) {
        Map<String, String> map = answerService.analysis(answer);
        return Response.success(map);
    }

    /**
     * 问题答案分析
     */
    @ApiOperation(value = "列表")
    @PreAuthorize("@ss.hasPermi('questionnaire:answer:list')")
    @GetMapping("/list")
    public Response<List<Answer>> list(Answer answer) {
        List<Answer> list = answerService.selectAnswerList(answer);
        return Response.success(list);
    }

    /**
     * 导出问卷答案列表
     */
    @ApiOperation(value = "导出列表")
    @PreAuthorize("@ss.hasPermi('questionnaire:answer:export')")
    @Log(title = "问卷答案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Answer answer) {
        List<Answer> list = answerService.selectAnswerList(answer);
        ExcelUtil<Answer> util = new ExcelUtil<Answer>(Answer.class);
        util.exportExcel(response, list, "问卷答案数据");
    }

    /**
     * 获取问卷答案详细信息
     */
    @ApiOperation(value = "详细信息")
    @PreAuthorize("@ss.hasPermi('questionnaire:answer:query')")
    @GetMapping(value = "/{answerId}")
    public Response<Answer> getInfo(@PathVariable("answerId") Long answerId) {
        return Response.success(answerService.selectAnswerByAnswerId(answerId));
    }

    /**
     * 新增问卷答案
     */
    @ApiOperation(value = "新增")
    @PreAuthorize("@ss.hasPermi('questionnaire:answer:add')")
    @Log(title = "问卷答案", businessType = BusinessType.INSERT)
    @PostMapping
    public Response<Integer> add(@RequestBody Answer answer) {
        return toResponse(answerService.insertAnswer(answer));
    }

    /**
     * 修改问卷答案
     */
    @ApiOperation(value = "修改")
    @PreAuthorize("@ss.hasPermi('questionnaire:answer:edit')")
    @Log(title = "问卷答案", businessType = BusinessType.UPDATE)
    @PutMapping
    public Response<Integer> edit(@RequestBody Answer answer) {
        return toResponse(answerService.updateAnswer(answer));
    }

    /**
     * 删除问卷答案
     */
    @ApiOperation(value = "删除")
    @PreAuthorize("@ss.hasPermi('questionnaire:answer:remove')")
    @Log(title = "问卷答案", businessType = BusinessType.DELETE)
    @DeleteMapping("/{answerIds}")
    public Response<Integer> remove(@PathVariable Long[] answerIds) {
        return toResponse(answerService.deleteAnswerByAnswerIds(answerIds));
    }
}
