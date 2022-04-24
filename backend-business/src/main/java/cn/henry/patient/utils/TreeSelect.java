package cn.henry.patient.utils;

import cn.henry.patient.domain.PatientType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Treeselect树结构实体类
 *
 * @author ruoyi
 */
@Data
public class TreeSelect implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 节点ID
     */
    private Long id;

    /**
     * 节点名称
     */
    private String label;

    /**
     * 子节点
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TreeSelect> children;

    public TreeSelect() {
    }

    public TreeSelect(PatientType patientType) {
        this.id = patientType.getTypeId();
        this.label = patientType.getTypeName();
        this.children = patientType.getChildren().stream().map(TreeSelect::new).collect(Collectors.toList());
    }
}
