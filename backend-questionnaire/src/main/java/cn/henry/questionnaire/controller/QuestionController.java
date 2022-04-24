package cn.henry.questionnaire.controller;

import cn.henry.common.core.controller.BaseController;
import cn.henry.common.core.domain.Response;
import cn.henry.questionnaire.domain.Question;
import cn.henry.questionnaire.domain.dto.QuestionDto;
import cn.henry.questionnaire.domain.vo.QuestionVo;
import cn.henry.questionnaire.service.IQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 问卷问题Controller
 *
 * @author henry
 * @date 2022-03-28
 */
@Api(tags = "问卷问题")
@RestController
@RequestMapping("/questionnaire/{questionnaireId}/questions")
public class QuestionController extends BaseController {
    @Resource
    private IQuestionService questionService;

    /**
     * 查询问卷问题列表
     */
    @ApiOperation(value = "列表")
    @GetMapping
    public Response<List<QuestionVo>> list(@PathVariable("questionnaireId") Long questionnaireId) {
        List<QuestionVo> list = questionService.selectQuestionList(questionnaireId);
        return Response.success(list);
    }

    /**
     * 获取问卷问题详细信息
     */
    @ApiOperation(value = "详细信息")
    @GetMapping(value = "/{questionId}")
    public Response<Question> getInfo(@PathVariable("questionId") Long questionId) {
        return Response.success(questionService.selectQuestionByQuestionId(questionId));
    }

    /**
     * 新增/更新 问题
     */
    @ApiOperation(value = "新增/更新")
    @PostMapping
    public Response<Integer> saveQuestion(@RequestBody @Valid QuestionDto dto) {
        return toResponse(questionService.saveQuestion(dto));
    }

    /**
     * 修改问卷问题
     */
    @ApiOperation(value = "修改")
    @PutMapping("/{questionId}")
    public Response<Integer> edit(@RequestBody Question question) {
        return toResponse(questionService.updateQuestion(question));
    }

    /**
     * 删除问卷问题
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/{questionIds}")
    public Response<Integer> remove(@PathVariable Long[] questionIds) {
        return toResponse(questionService.deleteQuestionByQuestionIds(questionIds));
    }
}
