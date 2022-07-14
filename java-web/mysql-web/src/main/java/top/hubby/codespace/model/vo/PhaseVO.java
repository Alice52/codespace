package top.hubby.codespace.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.hubby.codespace.constants.enums.PhaseStatusEnum;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zack <br>
 * @create 2021-04-09 10:15 <br>
 * @project integration <br>
 */
@Data
@NoArgsConstructor
public class PhaseVO implements Serializable {
  private Long id;

  @ApiModelProperty("阶段 Code")
  private String phaseCode;

  @ApiModelProperty("阶段名称")
  private String phaseName;

  private LocalDateTime startTime;

  private LocalDateTime endTime;

  private String type;

  private PhaseStatusEnum status;

  private Boolean isDeleted;

  private LocalDateTime insertedTime;

  private LocalDateTime updatedTime;

  private Long insertedBy;

  private Long updatedBy;

  public PhaseVO(String phaseCode, String phaseName) {
    this.phaseCode = phaseCode;
    this.phaseName = phaseName;
  }
}
